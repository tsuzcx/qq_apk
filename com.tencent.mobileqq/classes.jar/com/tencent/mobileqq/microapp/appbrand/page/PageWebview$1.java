package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;

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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview.1
 * JD-Core Version:    0.7.0.1
 */