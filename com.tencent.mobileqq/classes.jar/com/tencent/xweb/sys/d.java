package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebViewClient;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.l;

public class d
  implements e
{
  WebViewClient a;
  WebChromeClient b;
  android.webkit.WebView c;
  
  public d(android.webkit.WebView paramWebView)
  {
    this.c = paramWebView;
    this.a = new WebViewClient();
    this.b = new WebChromeClient();
  }
  
  public void a() {}
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void a(WebChromeClient paramWebChromeClient) {}
  
  public void a(WebViewClient paramWebViewClient) {}
  
  public void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.onPageStarted(this.c, paramString, paramBitmap);
  }
  
  public boolean a(com.tencent.xweb.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public boolean a(com.tencent.xweb.WebView paramWebView, String paramString1, String paramString2, String paramString3, l paraml)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    return false;
  }
  
  public boolean b(com.tencent.xweb.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.d
 * JD-Core Version:    0.7.0.1
 */