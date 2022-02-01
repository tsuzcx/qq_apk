package com.tencent.timi.game.web.business.impl.common;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;
import com.tencent.timi.game.utils.Logger;

class TimiBrowserFragment$1
  extends WebKernelCallBackProxy
{
  TimiBrowserFragment$1(TimiBrowserFragment paramTimiBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void loadUrlFinish()
  {
    super.loadUrlFinish();
    Logger.b("TimiBrowserFragment_", "onPageFinished ");
    this.a.getUIStyleHandler().f.y = true;
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    super.onInitUIContent(paramBundle);
    TimiBrowserFragment.a(this.a);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    Logger.b("TimiBrowserFragment_", "onReceivedError ");
    TimiBrowserFragment.b(this.a);
    TimiBrowserFragment.c(this.a);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    Logger.b("TimiBrowserFragment_", "onReceivedError ");
    TimiBrowserFragment.c(this.a);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslError);
    Logger.b("TimiBrowserFragment_", "onReceivedError ");
    TimiBrowserFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.common.TimiBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */