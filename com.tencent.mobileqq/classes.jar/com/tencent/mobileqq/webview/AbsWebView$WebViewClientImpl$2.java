package com.tencent.mobileqq.webview;

import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

class AbsWebView$WebViewClientImpl$2
  implements Runnable
{
  AbsWebView$WebViewClientImpl$2(AbsWebView.WebViewClientImpl paramWebViewClientImpl, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
    if (localWebViewPluginEngine != null) {
      localWebViewPluginEngine.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.2
 * JD-Core Version:    0.7.0.1
 */