package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;

class WebViewWrapper$WebViewClientImpl$2
  implements Runnable
{
  WebViewWrapper$WebViewClientImpl$2(WebViewWrapper.WebViewClientImpl paramWebViewClientImpl, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    boolean bool = this.a.a(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "post intercept:", Boolean.valueOf(bool), " ", SwiftWebViewUtils.a(this.b) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.2
 * JD-Core Version:    0.7.0.1
 */