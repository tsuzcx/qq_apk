package com.tencent.mobileqq.webview.swift.injector;

import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import mqq.app.AppRuntime;

public abstract interface ISwiftBrowserStatisticInjector
{
  public abstract String a(AppRuntime paramAppRuntime);
  
  public abstract void a(Intent paramIntent, String paramString);
  
  public abstract void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(TouchWebView paramTouchWebView, String paramString, boolean paramBoolean, int paramInt, long paramLong);
  
  public abstract void a(WebViewProvider paramWebViewProvider, String paramString1, long paramLong, AppRuntime paramAppRuntime, String paramString2);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, long paramLong);
  
  public abstract void a(String paramString1, long paramLong, String paramString2, String paramString3);
  
  public abstract void a(boolean paramBoolean, String paramString);
  
  public abstract void a(boolean paramBoolean, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserStatisticInjector
 * JD-Core Version:    0.7.0.1
 */