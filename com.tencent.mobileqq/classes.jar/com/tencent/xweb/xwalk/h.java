package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.l;
import org.xwalk.core.XWalkView;

public class h
  implements e
{
  m a;
  o b;
  XWalkView c;
  
  public h(XWalkView paramXWalkView)
  {
    this.c = paramXWalkView;
    this.a = new m(paramXWalkView);
    this.b = new o(paramXWalkView);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if ((paramCustomViewCallback instanceof g.a)) {
      this.a.a(paramView, ((g.a)paramCustomViewCallback).a());
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.a(this.c, paramString);
  }
  
  public void a(m paramm)
  {
    this.a = paramm;
  }
  
  public void a(o paramo)
  {
    this.b = paramo;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if ((paramJsResult instanceof g.c)) {
      return this.a.b(this.c, paramString1, paramString2, ((g.c)paramJsResult).a());
    }
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, l paraml)
  {
    if ((paraml instanceof g.e)) {
      return this.a.a(this.c, paramString1, paramString2, paramString3, ((g.e)paraml).a());
    }
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
  
  public boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if ((paramJsResult instanceof g.c)) {
      return this.a.a(this.c, paramString1, paramString2, ((g.c)paramJsResult).a());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h
 * JD-Core Version:    0.7.0.1
 */