package com.tencent.mobileqq.webview.sonic;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicDiffDataCallback;

class SonicJsPlugin$1
  implements SonicDiffDataCallback
{
  SonicJsPlugin$1(SonicJsPlugin paramSonicJsPlugin, CustomWebView paramCustomWebView, String paramString) {}
  
  public void callback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "getDiffData callback updated data: " + paramString.toString());
    }
    this.val$webView.callJs(this.val$callbackId, new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */