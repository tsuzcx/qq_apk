package com.tencent.mobileqq.webview.swift.injector;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;

public abstract interface IWebViewSurfaceInjector
{
  public abstract void a(WebViewProvider paramWebViewProvider);
  
  public abstract void a(WebViewProvider paramWebViewProvider, Bundle paramBundle);
  
  public abstract void a(WebViewProvider paramWebViewProvider, Bundle paramBundle, TouchWebView paramTouchWebView);
  
  public abstract void a(WebViewProvider paramWebViewProvider, View paramView);
  
  public abstract void a(WebViewProvider paramWebViewProvider, WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(WebViewProvider paramWebViewProvider, WebView paramWebView, SslError paramSslError);
  
  public abstract void a(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString);
  
  public abstract void a(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void a(WebViewProvider paramWebViewProvider, String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback);
  
  public abstract boolean a(WebViewProvider paramWebViewProvider, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean a(WebViewProvider paramWebViewProvider, int paramInt, Intent paramIntent);
  
  public abstract boolean a(WebViewProvider paramWebViewProvider, Intent paramIntent);
  
  public abstract void b(WebViewProvider paramWebViewProvider);
  
  public abstract void b(WebViewProvider paramWebViewProvider, Bundle paramBundle);
  
  public abstract void b(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract boolean b(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString);
  
  public abstract void c(WebViewProvider paramWebViewProvider);
  
  public abstract void c(WebViewProvider paramWebViewProvider, Bundle paramBundle);
  
  public abstract boolean c(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString);
  
  public abstract void d(WebViewProvider paramWebViewProvider, Bundle paramBundle);
  
  public abstract void e(WebViewProvider paramWebViewProvider);
  
  public abstract void e(WebViewProvider paramWebViewProvider, Bundle paramBundle);
  
  public abstract void f(WebViewProvider paramWebViewProvider);
  
  public abstract boolean g(WebViewProvider paramWebViewProvider);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.injector.IWebViewSurfaceInjector
 * JD-Core Version:    0.7.0.1
 */