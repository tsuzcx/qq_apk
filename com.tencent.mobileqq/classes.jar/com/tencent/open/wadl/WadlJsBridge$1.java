package com.tencent.open.wadl;

import android.text.TextUtils;
import bjqp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class WadlJsBridge$1
  implements Runnable
{
  WadlJsBridge$1(WadlJsBridge paramWadlJsBridge, String paramString) {}
  
  public void run()
  {
    try
    {
      WebView localWebView = this.this$0.getWebview();
      if ((localWebView != null) && (!TextUtils.isEmpty(this.a)))
      {
        if (QLog.isColorLevel()) {
          bjqp.c("WadlJsBridge", "##@WadlJavaScript:" + this.a);
        }
        localWebView.loadUrl(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      bjqp.a("WadlJsBridge", "webview loadUrl jsCallBack()>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridge.1
 * JD-Core Version:    0.7.0.1
 */