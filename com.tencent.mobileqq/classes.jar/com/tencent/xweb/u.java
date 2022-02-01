package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.internal.e;

public class u
{
  e b;
  
  public void a() {}
  
  public void a(Bitmap paramBitmap)
  {
    e locale = this.b;
    if (locale != null) {
      locale.a(paramBitmap);
    }
  }
  
  public void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    paramValueCallback.onReceiveValue((Uri)null);
  }
  
  public void a(WebView paramWebView) {}
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public final void a(e parame)
  {
    this.b = parame;
  }
  
  public void a(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    paramCallback.invoke(paramString, true, true);
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    return true;
  }
  
  public boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    e locale = this.b;
    if (locale != null) {
      return locale.b(paramView, paramCustomViewCallback);
    }
    return false;
  }
  
  public boolean a(ConsoleMessage paramConsoleMessage)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, u.a parama)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, l paraml)
  {
    e locale = this.b;
    if (locale != null) {
      return locale.a(paramWebView, paramString1, paramString2, paramString3, paraml);
    }
    return false;
  }
  
  public boolean a(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return true;
  }
  
  public void b(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    e locale = this.b;
    if (locale != null) {
      locale.a(paramView, paramCustomViewCallback);
    }
  }
  
  public void b(WebView paramWebView, int paramInt) {}
  
  public void c()
  {
    e locale = this.b;
    if (locale != null) {
      locale.a();
    }
  }
  
  public boolean c(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    e locale = this.b;
    if (locale != null) {
      return locale.a(paramWebView, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public View d()
  {
    return null;
  }
  
  public boolean d(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    e locale = this.b;
    if (locale != null) {
      return locale.b(paramWebView, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public boolean o_()
  {
    e locale = this.b;
    if (locale != null) {
      return locale.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.u
 * JD-Core Version:    0.7.0.1
 */