package com.tencent.qqlive.module.videoreport.inject.webview;

import android.support.annotation.RequiresApi;

public class WebViewCompatHelper
{
  public static void loadUrl(Object paramObject, String paramString)
  {
    if ((paramObject instanceof android.webkit.WebView)) {
      ((android.webkit.WebView)paramObject).loadUrl(paramString);
    }
    while (!(paramObject instanceof com.tencent.smtt.sdk.WebView)) {
      return;
    }
    ((com.tencent.smtt.sdk.WebView)paramObject).loadUrl(paramString);
  }
  
  @RequiresApi(api=19)
  public static void onEvaluateJavascript(Object paramObject, String paramString)
  {
    if ((paramObject instanceof android.webkit.WebView)) {
      ((android.webkit.WebView)paramObject).evaluateJavascript(paramString, null);
    }
    while (!(paramObject instanceof com.tencent.smtt.sdk.WebView)) {
      return;
    }
    ((com.tencent.smtt.sdk.WebView)paramObject).evaluateJavascript(paramString, null);
  }
  
  public static void onJsConfirmResult(Object paramObject, String paramString)
  {
    if ((paramObject instanceof android.webkit.JsPromptResult)) {
      ((android.webkit.JsPromptResult)paramObject).confirm(paramString);
    }
    while (!(paramObject instanceof com.tencent.smtt.export.external.interfaces.JsPromptResult)) {
      return;
    }
    ((com.tencent.smtt.export.external.interfaces.JsPromptResult)paramObject).confirm(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper
 * JD-Core Version:    0.7.0.1
 */