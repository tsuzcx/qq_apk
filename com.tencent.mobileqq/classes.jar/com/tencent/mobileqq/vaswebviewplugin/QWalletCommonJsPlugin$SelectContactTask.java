package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import org.json.JSONObject;

class QWalletCommonJsPlugin$SelectContactTask
  extends AsyncTask<String, Void, String>
{
  QWalletCommonJsPlugin$SelectContactTask(QWalletCommonJsPlugin paramQWalletCommonJsPlugin) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    paramVarArgs = QWalletCommonJsPlugin.access$300(this.this$0, paramVarArgs);
    if (paramVarArgs != null) {
      return paramVarArgs.toString();
    }
    return null;
  }
  
  protected void onPostExecute(String paramString)
  {
    QWalletCommonJsPlugin.access$400(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.SelectContactTask
 * JD-Core Version:    0.7.0.1
 */