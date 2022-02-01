package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.xweb.internal.e;

public class y
{
  e c;
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    return null;
  }
  
  public WebResourceResponse a(WebView paramWebView, String paramString)
  {
    return null;
  }
  
  public void a(WebView paramWebView, float paramFloat1, float paramFloat2) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {}
  
  public void a(WebView paramWebView, h paramh, String paramString1, String paramString2)
  {
    paramh.a();
  }
  
  public void a(WebView paramWebView, o paramo, SslError paramSslError)
  {
    if (paramo != null) {
      paramo.b();
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    e locale = this.c;
    if (locale == null) {
      return;
    }
    locale.a(paramWebView, paramString, paramBitmap);
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public final void a(e parame)
  {
    this.c = parame;
  }
  
  public boolean a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.a() != null)) {
      return b(paramWebView, paramWebResourceRequest.a().toString());
    }
    return false;
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return null;
  }
  
  public boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void c(WebView paramWebView, String paramString) {}
  
  public void d(WebView paramWebView, String paramString) {}
  
  public void e(WebView paramWebView, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */