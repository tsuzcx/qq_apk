package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public abstract interface IWebViewWrapperInjector
{
  public abstract WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void a(Bundle paramBundle, WebView paramWebView, String paramString);
  
  public abstract void a(TouchWebView paramTouchWebView, Intent paramIntent, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(WebView paramWebView, String paramString, Intent paramIntent);
  
  public abstract boolean a(String paramString);
  
  public abstract void b(WebView paramWebView, String paramString, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.IWebViewWrapperInjector
 * JD-Core Version:    0.7.0.1
 */