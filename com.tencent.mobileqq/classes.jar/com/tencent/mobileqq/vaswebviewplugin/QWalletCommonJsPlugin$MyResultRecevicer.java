package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import bjco;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletCommonJsPlugin$MyResultRecevicer
  extends ResultReceiver
{
  protected QWalletCommonJsPlugin mJsPlugin;
  
  public QWalletCommonJsPlugin$MyResultRecevicer(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.mJsPlugin == null) || (paramBundle == null)) {
      return;
    }
    String str2 = paramBundle.getString("detail");
    if ((TextUtils.isEmpty(QWalletCommonJsPlugin.mParamForGarpHb)) && (!TextUtils.isEmpty(QWalletCommonJsPlugin.mListid))) {
      QWalletCommonJsPlugin.mParamForGarpHb = bjco.a().b(QWalletCommonJsPlugin.mListid);
    }
    str1 = "";
    paramBundle = str1;
    if (paramInt == 0) {
      paramBundle = new JSONObject();
    }
    try
    {
      if (!TextUtils.isEmpty(QWalletCommonJsPlugin.mParamForGarpHb)) {
        paramBundle.put("param", QWalletCommonJsPlugin.mParamForGarpHb);
      }
      if (!TextUtils.isEmpty(str2)) {
        paramBundle.put("detail", str2);
      }
      paramBundle = paramBundle.toString();
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        paramBundle = str1;
      }
    }
    QWalletCommonJsPlugin.access$400(this.mJsPlugin, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.MyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */