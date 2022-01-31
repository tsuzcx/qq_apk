package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;

class SmttWebViewClient
  extends X5ProxyWebViewClient
{
  static final String SCHEME_WTAI_MC = "wtai://wp/mc;";
  private static String result_configForceSyswebview = null;
  private WebViewClient mClient;
  private WebView mWebView;
  
  public SmttWebViewClient(IX5WebViewClient paramIX5WebViewClient, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    super(paramIX5WebViewClient);
    this.mWebView = paramWebView;
    this.mClient = paramWebViewClient;
    this.mClient.mX5Client = this;
  }
  
  public void countPVContentCacheCallBack(String paramString)
  {
    paramString = this.mWebView;
    paramString.mPv += 1;
  }
  
  public void doDial(String paramString)
  {
    paramString = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
    paramString.addFlags(268435456);
    try
    {
      if (this.mWebView.getContext() != null) {
        this.mWebView.getContext().startActivity(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.doUpdateVisitedHistory(this.mWebView, paramString, paramBoolean);
  }
  
  public void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onDetectedBlankScreen(paramString, paramInt);
  }
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onFormResubmission(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onLoadResource(this.mWebView, paramString);
  }
  
  public void onPageCommitVisible(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onPageCommitVisible(this.mWebView, paramString);
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString)
  {
    if (result_configForceSyswebview == null)
    {
      localObject = TbsConfigFile.getInstance();
      if (localObject != null)
      {
        ((TbsConfigFile)localObject).setForceUseSystemWebview(false);
        result_configForceSyswebview = Boolean.toString(false);
      }
    }
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    Object localObject = this.mWebView;
    ((WebView)localObject).mPv += 1;
    this.mClient.onPageFinished(this.mWebView, paramString);
    if ("com.qzone".equals(paramIX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
      this.mWebView.writetbscorepvfile(paramIX5WebViewBase.getView().getContext());
    }
    TbsLog.app_extra("SmttWebViewClient", paramIX5WebViewBase.getView().getContext());
    try
    {
      super.onPageFinished(paramIX5WebViewBase, paramInt1, paramInt2, paramString);
      label130:
      WebView.updateRebootStatus();
      if ((!TbsShareManager.mHasQueryed) && (this.mWebView.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.mWebView.getContext())))
      {
        TbsShareManager.mHasQueryed = true;
        new Thread(new SmttWebViewClient.1(this)).start();
      }
      if ((this.mWebView.getContext() != null) && (!TbsLogReport.getInstance(this.mWebView.getContext()).getShouldUploadEventReport()))
      {
        TbsLogReport.getInstance(this.mWebView.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.mWebView.getContext()).dailyReport();
      }
      return;
    }
    catch (Exception paramIX5WebViewBase)
    {
      break label130;
    }
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    onPageFinished(paramIX5WebViewBase, 0, 0, paramString);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onPageStarted(this.mWebView, paramString, paramBitmap);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    onPageStarted(paramIX5WebViewBase, 0, 0, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedClientCertRequest(this.mWebView, paramClientCertRequest);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    int i = paramInt;
    if (paramInt < -15)
    {
      if (paramInt == -17) {
        i = -1;
      }
    }
    else
    {
      this.mWebView.setX5WebView(paramIX5WebViewBase);
      this.mClient.onReceivedError(this.mWebView, i, paramString1, paramString2);
    }
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedError(this.mWebView, paramWebResourceRequest, paramWebResourceError);
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedHttpAuthRequest(this.mWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  public void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedHttpError(this.mWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedLoginRequest(this.mWebView, paramString1, paramString2, paramString3);
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedSslError(this.mWebView, paramSslErrorHandler, paramSslError);
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onScaleChanged(this.mWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onTooManyRedirects(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onUnhandledKeyEvent(this.mWebView, paramKeyEvent);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldInterceptRequest(this.mWebView, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldInterceptRequest(this.mWebView, paramWebResourceRequest, paramBundle);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldInterceptRequest(this.mWebView, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldOverrideKeyEvent(this.mWebView, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {}
    for (String str = paramWebResourceRequest.getUrl().toString();; str = null)
    {
      if ((str == null) || (this.mWebView.showDebugView(str))) {
        return true;
      }
      this.mWebView.setX5WebView(paramIX5WebViewBase);
      boolean bool = this.mClient.shouldOverrideUrlLoading(this.mWebView, paramWebResourceRequest);
      if (!bool)
      {
        if (str.startsWith("wtai://wp/mc;"))
        {
          paramIX5WebViewBase = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring("wtai://wp/mc;".length())));
          this.mWebView.getContext().startActivity(paramIX5WebViewBase);
          return true;
        }
        if (str.startsWith("tel:"))
        {
          doDial(str);
          return true;
        }
      }
      return bool;
    }
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    if ((paramString == null) || (this.mWebView.showDebugView(paramString))) {
      return true;
    }
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    boolean bool = this.mClient.shouldOverrideUrlLoading(this.mWebView, paramString);
    if (!bool)
    {
      if (paramString.startsWith("wtai://wp/mc;"))
      {
        paramIX5WebViewBase = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + paramString.substring("wtai://wp/mc;".length())));
        this.mWebView.getContext().startActivity(paramIX5WebViewBase);
        return true;
      }
      if (paramString.startsWith("tel:"))
      {
        doDial(paramString);
        return true;
      }
    }
    return bool;
  }
  
  public void super_onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(this.mWebView.getX5WebView(), 0, 0, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebViewClient
 * JD-Core Version:    0.7.0.1
 */