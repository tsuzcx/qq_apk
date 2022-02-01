package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.n;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient
  extends android.webkit.WebViewClient
{
  private static String c = null;
  private WebViewClient a;
  private WebView b;
  
  SystemWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.b = paramWebView;
    this.a = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.b.a(paramWebView);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.b.a(paramWebView);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    this.b.a(paramWebView);
    this.a.onLoadResource(this.b, paramString);
  }
  
  public void onPageCommitVisible(android.webkit.WebView paramWebView, String paramString)
  {
    this.b.a(paramWebView);
    this.a.onPageCommitVisible(this.b, paramString);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    if (c == null)
    {
      localObject = n.a();
      if (localObject != null)
      {
        ((n)localObject).a(true);
        c = Boolean.toString(true);
      }
    }
    this.b.a(paramWebView);
    Object localObject = this.b;
    ((WebView)localObject).a += 1;
    this.a.onPageFinished(this.b, paramString);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      this.b.a(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.d();
    if ((!TbsShareManager.mHasQueryed) && (this.b.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.b.getContext())))
    {
      TbsShareManager.mHasQueryed = true;
      new Thread(new SystemWebViewClient.1(this)).start();
    }
    if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
    {
      TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
      TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    this.b.a(paramWebView);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.a(paramWebView);
      paramWebView = new SystemWebViewClient.a(paramClientCertRequest);
      this.a.onReceivedClientCertRequest(this.b, paramWebView);
    }
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.b.a(paramWebView);
    this.a.onReceivedError(this.b, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    this.b.a(paramWebView);
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new SystemWebViewClient.f(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new SystemWebViewClient.2(this, paramWebResourceError);
      }
      this.a.onReceivedError(this.b, paramWebView, paramWebResourceRequest);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.b.a(paramWebView);
    this.a.onReceivedHttpAuthRequest(this.b, new SystemWebViewClient.b(paramHttpAuthHandler), paramString1, paramString2);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.b.a(paramWebView);
    paramWebView = new SystemWebViewClient.f(paramWebResourceRequest);
    paramWebResourceRequest = new SystemWebViewClient.g(paramWebResourceResponse);
    this.a.onReceivedHttpError(this.b, paramWebView, paramWebResourceRequest);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.b.a(paramWebView);
      this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
    }
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.b.a(paramWebView);
      this.a.onReceivedSslError(this.b, new SystemWebViewClient.c(paramSslErrorHandler), new SystemWebViewClient.d(paramSslError));
    }
  }
  
  public boolean onRenderProcessGone(android.webkit.WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    this.b.a(paramWebView);
    return this.a.onRenderProcessGone(this.b, new SystemWebViewClient.3(this, paramRenderProcessGoneDetail));
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.b.a(paramWebView);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.b.a(paramWebView);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.b.a(paramWebView);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
  }
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramWebView = null;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramWebView;
        if (paramWebResourceRequest == null) {
          return null;
        }
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          paramWebView = i.a(paramWebResourceRequest, "isRedirect");
          bool1 = bool2;
          if ((paramWebView instanceof Boolean)) {
            bool1 = ((Boolean)paramWebView).booleanValue();
          }
        }
        paramWebView = new SystemWebViewClient.e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
        paramWebView = this.a.shouldInterceptRequest(this.b, paramWebView);
        if (paramWebView == null) {
          return null;
        }
        paramWebResourceRequest = new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
        paramWebResourceRequest.setResponseHeaders(paramWebView.getResponseHeaders());
        i = paramWebView.getStatusCode();
        str = paramWebView.getReasonPhrase();
        if (i != paramWebResourceRequest.getStatusCode()) {
          break;
        }
        paramWebView = paramWebResourceRequest;
      } while (str == null);
      paramWebView = paramWebResourceRequest;
    } while (str.equals(paramWebResourceRequest.getReasonPhrase()));
    paramWebResourceRequest.setStatusCodeAndReasonPhrase(i, str);
    return paramWebResourceRequest;
  }
  
  @TargetApi(11)
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return null;
      paramWebView = this.a.shouldInterceptRequest(this.b, paramString);
    } while (paramWebView == null);
    return new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.b.a(paramWebView);
    return this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWebResourceRequest != null)
    {
      localObject1 = localObject2;
      if (paramWebResourceRequest.getUrl() != null) {
        localObject1 = paramWebResourceRequest.getUrl().toString();
      }
    }
    if ((localObject1 == null) || (this.b.showDebugView((String)localObject1))) {
      return true;
    }
    this.b.a(paramWebView);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = i.a(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new SystemWebViewClient.e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    return this.a.shouldOverrideUrlLoading(this.b, paramWebView);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    if ((paramString == null) || (this.b.showDebugView(paramString))) {
      return true;
    }
    this.b.a(paramWebView);
    return this.a.shouldOverrideUrlLoading(this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient
 * JD-Core Version:    0.7.0.1
 */