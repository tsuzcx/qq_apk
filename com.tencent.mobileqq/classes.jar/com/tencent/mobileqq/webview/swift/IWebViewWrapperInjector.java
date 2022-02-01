package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public abstract interface IWebViewWrapperInjector
{
  public abstract WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void a(Bundle paramBundle, WebView paramWebView, String paramString);
  
  public abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.IWebViewWrapperInjector
 * JD-Core Version:    0.7.0.1
 */