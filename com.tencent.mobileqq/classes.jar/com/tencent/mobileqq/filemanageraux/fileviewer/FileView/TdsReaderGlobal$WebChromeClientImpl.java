package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

final class TdsReaderGlobal$WebChromeClientImpl
  extends WebChromeClient
{
  private final IHostInterface.IWebClient a;
  
  private TdsReaderGlobal$WebChromeClientImpl(IHostInterface.IWebClient paramIWebClient)
  {
    this.a = paramIWebClient;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    IHostInterface.IWebClient localIWebClient = this.a;
    if ((localIWebClient != null) && (localIWebClient.onConsoleMessage(paramConsoleMessage.message(), paramConsoleMessage.lineNumber(), paramConsoleMessage.sourceId()))) {
      return true;
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    IHostInterface.IWebClient localIWebClient = this.a;
    if ((localIWebClient != null) && (localIWebClient.onJsPrompt(paramWebView, paramString1, paramString2, paramString3)))
    {
      if (paramJsPromptResult != null) {
        paramJsPromptResult.cancel();
      }
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
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.WebChromeClientImpl
 * JD-Core Version:    0.7.0.1
 */