package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;

class SmttWebChromeClient$1
  implements Runnable
{
  SmttWebChromeClient$1(SmttWebChromeClient paramSmttWebChromeClient, WebView.WebViewTransport paramWebViewTransport, Message paramMessage) {}
  
  public void run()
  {
    WebView localWebView = this.val$transport.getWebView();
    if (localWebView != null) {
      ((IX5WebViewBase.WebViewTransport)this.val$resultMsg.obj).setWebView(localWebView.getX5WebView());
    }
    this.val$resultMsg.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebChromeClient.1
 * JD-Core Version:    0.7.0.1
 */