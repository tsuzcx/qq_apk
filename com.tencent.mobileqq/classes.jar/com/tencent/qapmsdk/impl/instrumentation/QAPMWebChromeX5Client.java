package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.TargetApi;
import android.webkit.WebView;

public class QAPMWebChromeX5Client
{
  private static int injectMax = 0;
  
  public static void addWebViewBridge(WebView paramWebView) {}
  
  public static void initJSMonitorX5(WebView paramWebView, int paramInt) {}
  
  @TargetApi(19)
  private static void injectScriptFile(WebView paramWebView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMWebChromeX5Client
 * JD-Core Version:    0.7.0.1
 */