package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class PageWebview$1
  extends WebChromeClient
{
  PageWebview$1(PageWebview paramPageWebview) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("chromium", 2, paramConsoleMessage.message());
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview.1
 * JD-Core Version:    0.7.0.1
 */