package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class AppBrandWebviewService$1
  extends WebChromeClient
{
  AppBrandWebviewService$1(AppBrandWebviewService paramAppBrandWebviewService) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppBrandWebviewService.access$000(this.this$0, paramConsoleMessage);
    if (paramConsoleMessage != null)
    {
      StringBuilder localStringBuilder;
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("consoleMessage.message() ");
        localStringBuilder.append(paramConsoleMessage.message());
        localStringBuilder.append(" line:");
        localStringBuilder.append(paramConsoleMessage.lineNumber());
        QMLog.e("AppBrandWebviewService", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("consoleMessage.message() ");
        localStringBuilder.append(paramConsoleMessage.message());
        QMLog.i("AppBrandWebviewService", localStringBuilder.toString());
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.1
 * JD-Core Version:    0.7.0.1
 */