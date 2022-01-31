package com.tencent.smtt.sdk;

import android.os.Message;

class SystemWebChromeClient$2
  implements Runnable
{
  SystemWebChromeClient$2(SystemWebChromeClient paramSystemWebChromeClient, WebView.WebViewTransport paramWebViewTransport, Message paramMessage) {}
  
  public void run()
  {
    WebView localWebView = this.val$transport.getWebView();
    if (localWebView != null) {
      ((android.webkit.WebView.WebViewTransport)this.val$resultMsg.obj).setWebView(localWebView.getSysWebView());
    }
    this.val$resultMsg.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.2
 * JD-Core Version:    0.7.0.1
 */