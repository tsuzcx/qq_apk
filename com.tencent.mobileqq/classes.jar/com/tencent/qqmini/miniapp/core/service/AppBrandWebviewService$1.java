package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
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
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label73;
      }
      QMLog.e("AppBrandWebviewService", "consoleMessage.message() " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber());
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label73:
      QMLog.i("AppBrandWebviewService", "consoleMessage.message() " + paramConsoleMessage.message());
    }
  }
  
  @Override
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.1
 * JD-Core Version:    0.7.0.1
 */