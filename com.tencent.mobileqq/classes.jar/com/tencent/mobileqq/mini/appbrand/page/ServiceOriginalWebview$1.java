package com.tencent.mobileqq.mini.appbrand.page;

import Override;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsConsoleMessageListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.JsErrorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class ServiceOriginalWebview$1
  extends WebChromeClient
{
  ServiceOriginalWebview$1(ServiceOriginalWebview paramServiceOriginalWebview) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (this.this$0.mJsConsoleMessageListener != null) {
      this.this$0.mJsConsoleMessageListener.onConsoleMessage(paramConsoleMessage);
    }
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label111;
      }
      if (this.this$0.mJsErrorListener != null) {
        this.this$0.mJsErrorListener.onJsError();
      }
      QLog.e("miniapp-chromium", 1, "ServiceOriginalWebview: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber());
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label111:
      QLog.i("miniapp-chromium", 2, "ServiceOriginalWebview: " + paramConsoleMessage.message());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview.1
 * JD-Core Version:    0.7.0.1
 */