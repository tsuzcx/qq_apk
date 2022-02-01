package com.tencent.xweb.internal;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;

public abstract interface e
{
  public abstract void a();
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void a(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, l paraml);
  
  public abstract boolean b();
  
  public abstract boolean b(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.e
 * JD-Core Version:    0.7.0.1
 */