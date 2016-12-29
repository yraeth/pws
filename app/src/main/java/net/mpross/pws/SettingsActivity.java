package net.mpross.pws;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import java.io.*;
import android.content.*;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final EditText editText = (EditText) findViewById(R.id.station);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {

                    String string = editText.getText().toString();

                    try {
                        FileOutputStream fos = openFileOutput("station_file", Context.MODE_PRIVATE);
                        fos.write(string.getBytes());
                        fos.close();
                    }
                    catch (IOException e){

                    }

                    handled = true;
                }
                return handled;
            }
        });
    }

}