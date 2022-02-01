package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.xwalk.d;
import com.tencent.xweb.y;
import org.xwalk.core.Log;

class e$3
  extends WebViewClient
{
  e$3(e parame) {}
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if (this.a.c != null)
    {
      this.a.c.a(this.a.a, paramString, paramBoolean);
      return;
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    if (this.a.c != null)
    {
      this.a.c.e(this.a.a, paramString);
      return;
    }
    super.onLoadResource(paramWebView, paramString);
  }
  
  @TargetApi(23)
  public void onPageCommitVisible(android.webkit.WebView paramWebView, String paramString)
  {
    paramWebView = new StringBuilder();
    paramWebView.append("onPageCommitVisible s = ");
    paramWebView.append(paramString);
    Log.i("SysWebView", paramWebView.toString());
    if (this.a.c != null) {
      this.a.c.d(this.a.a, paramString);
    }
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageFinished ");
    ((StringBuilder)localObject).append(paramString);
    Log.i("SysWebView", ((StringBuilder)localObject).toString());
    if (e.a(this.a) != null)
    {
      localObject = e.a(this.a);
      boolean bool;
      if (this.a.a.getFullscreenVideoKind() == WebView.a.c) {
        bool = true;
      } else {
        bool = false;
      }
      ((b)localObject).a(false, bool);
    }
    if (this.a.c != null) {
      this.a.c.c(this.a.a, paramString);
    } else {
      super.onPageFinished(paramWebView, paramString);
    }
    com.tencent.xweb.util.h.a(System.currentTimeMillis() - this.a.g);
    d.a(this.a.a);
    com.tencent.xweb.util.h.b(System.currentTimeMillis() - this.a.g);
    com.tencent.xweb.internal.h.a().i();
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageStarted ");
    localStringBuilder.append(paramString);
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.c != null) {
      this.a.c.a(this.a.a, paramString, paramBitmap);
    } else {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    this.a.g = System.currentTimeMillis();
    com.tencent.xweb.util.h.b(paramString);
    com.tencent.xweb.util.h.i();
    if (e.a(this.a) != null)
    {
      paramWebView = e.a(this.a);
      boolean bool;
      if (this.a.a.getFullscreenVideoKind() == WebView.a.c) {
        bool = true;
      } else {
        bool = false;
      }
      paramWebView.a(true, bool);
    }
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.a.c != null) {
      this.a.c.a(this.a.a, paramInt, paramString1, paramString2);
    } else {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    com.tencent.xweb.util.h.h();
    com.tencent.xweb.util.h.j();
    com.tencent.xweb.internal.h.a().j();
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedHttpAuthRequest host:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", realm:");
    localStringBuilder.append(paramString2);
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.c != null)
    {
      this.a.c.a(this.a.a, new c.b(paramHttpAuthHandler), paramString1, paramString2);
      return;
    }
    super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    String str;
    if (Build.VERSION.SDK_INT >= 21) {
      str = String.valueOf(paramWebResourceResponse.getStatusCode());
    } else {
      str = "Invalid";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedHttpError code:");
    localStringBuilder.append(str);
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.c != null)
    {
      this.a.c.a(this.a.a, new c.f(paramWebResourceRequest), c.a(paramWebResourceResponse));
      return;
    }
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedSslError ");
    localStringBuilder.append(paramSslError.getPrimaryError());
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.c != null)
    {
      this.a.c.a(this.a.a, new c.a(paramSslErrorHandler), paramSslError);
      return;
    }
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    if (this.a.c != null)
    {
      this.a.c.a(this.a.a, paramFloat1, paramFloat2);
      return;
    }
    super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }
  
  public WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (this.a.c != null)
    {
      paramWebView = null;
      c.f localf = new c.f(paramWebResourceRequest);
      paramWebResourceRequest = localf.e();
      if (paramWebResourceRequest != null) {
        paramWebView = this.a.c.a(this.a.a, localf, paramWebResourceRequest);
      }
      paramWebResourceRequest = paramWebView;
      if (paramWebView == null) {
        paramWebResourceRequest = this.a.c.b(this.a.a, localf);
      }
      return c.a(paramWebResourceRequest);
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    if (this.a.c != null) {
      return c.a(this.a.c.a(this.a.a, paramString));
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  @TargetApi(21)
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldOverrideUrlLoading ");
    localStringBuilder.append(paramWebResourceRequest.getUrl().toString());
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.c != null)
    {
      paramWebView = new c.f(paramWebResourceRequest);
      return this.a.c.a(this.a.a, paramWebView);
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    if (d.b(paramString)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldOverrideUrlLoading ");
    localStringBuilder.append(paramString);
    Log.i("SysWebView", localStringBuilder.toString());
    if (this.a.c != null) {
      return this.a.c.b(this.a.a, paramString);
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.e.3
 * JD-Core Version:    0.7.0.1
 */