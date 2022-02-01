package com.tencent.qqmini.minigame.utils;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class VConsoleLogManager$2
  extends WebViewClient
{
  VConsoleLogManager$2(VConsoleLogManager paramVConsoleLogManager) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    VConsoleLogManager.access$100(this.this$0, true);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.VConsoleLogManager.2
 * JD-Core Version:    0.7.0.1
 */