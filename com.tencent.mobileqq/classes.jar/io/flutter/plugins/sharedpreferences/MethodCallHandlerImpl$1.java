package io.flutter.plugins.sharedpreferences;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import io.flutter.plugin.common.MethodChannel.Result;

class MethodCallHandlerImpl$1
  extends AsyncTask<Void, Void, Boolean>
{
  MethodCallHandlerImpl$1(MethodCallHandlerImpl paramMethodCallHandlerImpl, SharedPreferences.Editor paramEditor, MethodChannel.Result paramResult) {}
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    return Boolean.valueOf(this.val$editor.commit());
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    this.val$result.success(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */