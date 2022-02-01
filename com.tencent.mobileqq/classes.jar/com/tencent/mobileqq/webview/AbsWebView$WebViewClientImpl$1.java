package com.tencent.mobileqq.webview;

import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

class AbsWebView$WebViewClientImpl$1
  implements Runnable
{
  AbsWebView$WebViewClientImpl$1(AbsWebView.WebViewClientImpl paramWebViewClientImpl, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    WebViewPluginEngine localWebViewPluginEngine = this.a;
    if (localWebViewPluginEngine != null) {
      localWebViewPluginEngine.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.1
 * JD-Core Version:    0.7.0.1
 */