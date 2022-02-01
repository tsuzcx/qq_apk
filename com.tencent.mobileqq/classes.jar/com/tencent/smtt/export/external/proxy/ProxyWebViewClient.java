package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public abstract class ProxyWebViewClient
  implements IX5WebViewClient
{
  private boolean mCompatibleOnPageStartedOrFinishedMethod = false;
  protected IX5WebViewClient mWebViewClient;
  
  public void countPVContentCacheCallBack(String paramString) {}
  
  public void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.doUpdateVisitedHistory(paramIX5WebViewBase, paramString, paramBoolean);
    }
  }
  
  public void onContentSizeChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onContentSizeChanged(paramIX5WebViewBase, paramInt1, paramInt2);
    }
  }
  
  public void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt) {}
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onFormResubmission(paramIX5WebViewBase, paramMessage1, paramMessage2);
    }
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onLoadResource(paramIX5WebViewBase, paramString);
    }
  }
  
  public void onPageCommitVisible(IX5WebViewBase paramIX5WebViewBase, String paramString) {}
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString) {}
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onPageFinished(paramIX5WebViewBase, paramString);
    }
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap) {}
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onPageStarted(paramIX5WebViewBase, paramString, paramBitmap);
    }
  }
  
  public void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedClientCertRequest(paramIX5WebViewBase, paramClientCertRequest);
    }
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedError(paramIX5WebViewBase, paramInt, paramString1, paramString2);
    }
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedError(paramIX5WebViewBase, paramWebResourceRequest, paramWebResourceError);
    }
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedHttpAuthRequest(paramIX5WebViewBase, paramHttpAuthHandler, paramString1, paramString2);
    }
  }
  
  public void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedHttpError(paramIX5WebViewBase, paramWebResourceRequest, paramWebResourceResponse);
    }
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedLoginRequest(paramIX5WebViewBase, paramString1, paramString2, paramString3);
    }
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onReceivedSslError(paramIX5WebViewBase, paramSslErrorHandler, paramSslError);
    }
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onScaleChanged(paramIX5WebViewBase, paramFloat1, paramFloat2);
    }
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onTooManyRedirects(paramIX5WebViewBase, paramMessage1, paramMessage2);
    }
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      localIX5WebViewClient.onUnhandledKeyEvent(paramIX5WebViewBase, paramKeyEvent);
    }
  }
  
  public void setWebViewClient(IX5WebViewClient paramIX5WebViewClient)
  {
    this.mWebViewClient = paramIX5WebViewClient;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      return localIX5WebViewClient.shouldInterceptRequest(paramIX5WebViewBase, paramWebResourceRequest);
    }
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      return localIX5WebViewClient.shouldInterceptRequest(paramIX5WebViewBase, paramWebResourceRequest, paramBundle);
    }
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    if (localIX5WebViewClient != null) {
      return localIX5WebViewClient.shouldInterceptRequest(paramIX5WebViewBase, paramString);
    }
    return null;
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    return (localIX5WebViewClient != null) && (localIX5WebViewClient.shouldOverrideKeyEvent(paramIX5WebViewBase, paramKeyEvent));
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    return (localIX5WebViewClient != null) && (localIX5WebViewClient.shouldOverrideUrlLoading(paramIX5WebViewBase, paramWebResourceRequest));
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    IX5WebViewClient localIX5WebViewClient = this.mWebViewClient;
    return (localIX5WebViewClient != null) && (localIX5WebViewClient.shouldOverrideUrlLoading(paramIX5WebViewBase, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.ProxyWebViewClient
 * JD-Core Version:    0.7.0.1
 */