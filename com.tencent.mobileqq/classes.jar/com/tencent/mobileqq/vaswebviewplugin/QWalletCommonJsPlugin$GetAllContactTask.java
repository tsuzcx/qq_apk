package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import org.json.JSONObject;

class QWalletCommonJsPlugin$GetAllContactTask
  extends AsyncTask
{
  QWalletCommonJsPlugin$GetAllContactTask(QWalletCommonJsPlugin paramQWalletCommonJsPlugin) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = QWalletCommonJsPlugin.access$500(this.this$0);
    if (paramVarArgs != null) {
      return paramVarArgs.toString();
    }
    return null;
  }
  
  protected void onPostExecute(String paramString)
  {
    QWalletCommonJsPlugin.access$000(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.GetAllContactTask
 * JD-Core Version:    0.7.0.1
 */