package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class QQGameHelperImpl$1$1
  extends WebChromeClient
{
  QQGameHelperImpl$1$1(QQGameHelperImpl.1 param1) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGamePub_QQGameHelper", 2, paramConsoleMessage.message());
    }
    return true;
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.1.1
 * JD-Core Version:    0.7.0.1
 */