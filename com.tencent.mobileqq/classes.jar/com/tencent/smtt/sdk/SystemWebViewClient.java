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
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient
  extends android.webkit.WebViewClient
{
  private static String result_configForceSyswebview = null;
  private WebViewClient mClient;
  private WebView mWebView;
  
  SystemWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.mWebView = paramWebView;
    this.mClient = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.doUpdateVisitedHistory(this.mWebView, paramString, paramBoolean);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onFormResubmission(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onLoadResource(this.mWebView, paramString);
  }
  
  public void onPageCommitVisible(android.webkit.WebView paramWebView, String paramString)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onPageCommitVisible(this.mWebView, paramString);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    if (result_configForceSyswebview == null)
    {
      localObject = TbsConfigFile.getInstance();
      if (localObject != null)
      {
        ((TbsConfigFile)localObject).setForceUseSystemWebview(true);
        result_configForceSyswebview = Boolean.toString(true);
      }
    }
    this.mWebView.setSysWebView(paramWebView);
    Object localObject = this.mWebView;
    ((WebView)localObject).mPv += 1;
    this.mClient.onPageFinished(this.mWebView, paramString);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      this.mWebView.writetbscorepvfile(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.updateRebootStatus();
    if ((!TbsShareManager.mHasQueryed) && (this.mWebView.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.mWebView.getContext())))
    {
      TbsShareManager.mHasQueryed = true;
      new Thread(new SystemWebViewClient.1(this)).start();
    }
    if ((this.mWebView.getContext() != null) && (!TbsLogReport.getInstance(this.mWebView.getContext()).getShouldUploadEventReport()))
    {
      TbsLogReport.getInstance(this.mWebView.getContext()).setShouldUploadEventReport(true);
      TbsLogReport.getInstance(this.mWebView.getContext()).dailyReport();
    }
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onPageStarted(this.mWebView, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mWebView.setSysWebView(paramWebView);
      paramWebView = new SystemWebViewClient.ClientCertRequestImpl(paramClientCertRequest);
      this.mClient.onReceivedClientCertRequest(this.mWebView, paramWebView);
    }
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onReceivedError(this.mWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    this.mWebView.setSysWebView(paramWebView);
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new SystemWebViewClient.WebResourceRequestImpl2(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new SystemWebViewClient.2(this, paramWebResourceError);
      }
      this.mClient.onReceivedError(this.mWebView, paramWebView, paramWebResourceRequest);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onReceivedHttpAuthRequest(this.mWebView, new SystemWebViewClient.HttpAuthHandlerImpl(paramHttpAuthHandler), paramString1, paramString2);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.mWebView.setSysWebView(paramWebView);
    paramWebView = new SystemWebViewClient.WebResourceRequestImpl2(paramWebResourceRequest);
    paramWebResourceRequest = new SystemWebViewClient.WebResourceResponseImpl2(paramWebResourceResponse);
    this.mClient.onReceivedHttpError(this.mWebView, paramWebView, paramWebResourceRequest);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.mWebView.setSysWebView(paramWebView);
      this.mClient.onReceivedLoginRequest(this.mWebView, paramString1, paramString2, paramString3);
    }
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.mWebView.setSysWebView(paramWebView);
      this.mClient.onReceivedSslError(this.mWebView, new SystemWebViewClient.SslErrorHandlerImpl(paramSslErrorHandler), new SystemWebViewClient.SslErrorImpl(paramSslError));
    }
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onScaleChanged(this.mWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onTooManyRedirects(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onUnhandledKeyEvent(this.mWebView, paramKeyEvent);
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
          paramWebView = ReflectionUtils.invokeInstance(paramWebResourceRequest, "isRedirect");
          bool1 = bool2;
          if ((paramWebView instanceof Boolean)) {
            bool1 = ((Boolean)paramWebView).booleanValue();
          }
        }
        paramWebView = new SystemWebViewClient.WebResourceRequestImpl(this, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
        paramWebView = this.mClient.shouldInterceptRequest(this.mWebView, paramWebView);
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
      paramWebView = this.mClient.shouldInterceptRequest(this.mWebView, paramString);
    } while (paramWebView == null);
    return new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.mWebView.setSysWebView(paramWebView);
    return this.mClient.shouldOverrideKeyEvent(this.mWebView, paramKeyEvent);
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
    if ((localObject1 == null) || (this.mWebView.showDebugView((String)localObject1))) {
      return true;
    }
    this.mWebView.setSysWebView(paramWebView);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = ReflectionUtils.invokeInstance(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new SystemWebViewClient.WebResourceRequestImpl(this, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    return this.mClient.shouldOverrideUrlLoading(this.mWebView, paramWebView);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    if ((paramString == null) || (this.mWebView.showDebugView(paramString))) {
      return true;
    }
    this.mWebView.setSysWebView(paramWebView);
    return this.mClient.shouldOverrideUrlLoading(this.mWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient
 * JD-Core Version:    0.7.0.1
 */