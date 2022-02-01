package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import org.json.JSONObject;

class QWalletCommonJsPlugin$GetAllContactTask
  extends AsyncTask<Void, Void, String>
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
    QWalletCommonJsPlugin.access$400(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.GetAllContactTask
 * JD-Core Version:    0.7.0.1
 */