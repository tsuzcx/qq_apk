package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.io.IOException;

class ShadowWebView$WarpWebViewClient
  extends WebViewClient
{
  private Context mContext;
  private WebViewClient mWebViewClient;
  
  public ShadowWebView$WarpWebViewClient(ShadowWebView paramShadowWebView, WebViewClient paramWebViewClient, Context paramContext)
  {
    this.mWebViewClient = paramWebViewClient;
    this.mContext = paramContext;
  }
  
  private WebResourceResponse getInterceptResponse(String paramString)
  {
    String str;
    if (paramString.startsWith("http://android.asset/"))
    {
      str = paramString.substring(21);
      if (str.contains(".css")) {
        paramString = "text/css";
      } else if (str.contains(".js")) {
        paramString = "application/x-javascript";
      } else if ((!str.contains(".jpg")) && (!str.contains(".gif")) && (!str.contains(".png")) && (!str.contains(".jpeg"))) {
        paramString = "text/html";
      } else {
        paramString = "image/*";
      }
    }
    try
    {
      paramString = new WebResourceResponse(paramString, "utf-8", this.mContext.getAssets().open(str));
      return paramString;
    }
    catch (IOException paramString)
    {
      label118:
      break label118;
    }
    return null;
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.mWebViewClient.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebViewClient.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    this.mWebViewClient.onLoadResource(paramWebView, paramString);
  }
  
  @TargetApi(23)
  public void onPageCommitVisible(WebView paramWebView, String paramString)
  {
    this.mWebViewClient.onPageCommitVisible(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.mWebViewClient.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    this.mWebViewClient.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  @TargetApi(21)
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    this.mWebViewClient.onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.mWebViewClient.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    this.mWebViewClient.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.mWebViewClient.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    this.mWebViewClient.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    this.mWebViewClient.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    this.mWebViewClient.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  @TargetApi(26)
  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    return this.mWebViewClient.onRenderProcessGone(paramWebView, paramRenderProcessGoneDetail);
  }
  
  @TargetApi(27)
  public void onSafeBrowsingHit(WebView paramWebView, WebResourceRequest paramWebResourceRequest, int paramInt, SafeBrowsingResponse paramSafeBrowsingResponse)
  {
    this.mWebViewClient.onSafeBrowsingHit(paramWebView, paramWebResourceRequest, paramInt, paramSafeBrowsingResponse);
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.mWebViewClient.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebViewClient.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.mWebViewClient.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
  }
  
  @TargetApi(21)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    WebResourceResponse localWebResourceResponse = getInterceptResponse(paramWebResourceRequest.getUrl().toString());
    if (localWebResourceResponse != null) {
      return localWebResourceResponse;
    }
    return this.mWebViewClient.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    WebResourceResponse localWebResourceResponse = getInterceptResponse(paramString);
    if (localWebResourceResponse != null) {
      return localWebResourceResponse;
    }
    return this.mWebViewClient.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    return this.mWebViewClient.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
  }
  
  @TargetApi(24)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return this.mWebViewClient.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return this.mWebViewClient.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowWebView.WarpWebViewClient
 * JD-Core Version:    0.7.0.1
 */