package com.tencent.mobileqq.webview.sonic;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicDiffDataCallback;
import org.json.JSONObject;

class SonicJsPlugin$2
  implements SonicDiffDataCallback
{
  SonicJsPlugin$2(SonicJsPlugin paramSonicJsPlugin, boolean paramBoolean, CustomWebView paramCustomWebView, String paramString) {}
  
  public void callback(String paramString)
  {
    str = "";
    try
    {
      paramString = new JSONObject(paramString);
      if (!this.val$isNeedData) {
        paramString.remove("result");
      }
      paramString = paramString.toString();
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "reloadHttpData error!", paramString);
        paramString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "reloadHttpData , notify data: " + paramString);
    }
    this.val$webView.callJs(this.val$ReloadCallbackId, new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */