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
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;

class i
  extends X5ProxyWebViewClient
{
  private static String c;
  private WebViewClient a;
  private WebView b;
  
  public i(IX5WebViewClient paramIX5WebViewClient, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    super(paramIX5WebViewClient);
    this.b = paramWebView;
    this.a = paramWebViewClient;
    this.a.a = this;
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(this.b.c(), 0, 0, paramString, paramBitmap);
  }
  
  public void a(String paramString)
  {
    paramString = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
    paramString.addFlags(268435456);
    try
    {
      if (this.b.getContext() != null)
      {
        this.b.getContext().startActivity(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void countPVContentCacheCallBack(String paramString)
  {
    paramString = this.b;
    paramString.a += 1;
  }
  
  public void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
  }
  
  public void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onDetectedBlankScreen(paramString, paramInt);
  }
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onLoadResource(this.b, paramString);
  }
  
  public void onPageCommitVisible(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onPageCommitVisible(this.b, paramString);
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString)
  {
    if (c == null)
    {
      localObject = n.a();
      if (localObject != null)
      {
        ((n)localObject).a(false);
        c = Boolean.toString(false);
      }
    }
    this.b.a(paramIX5WebViewBase);
    Object localObject = this.b;
    ((WebView)localObject).a += 1;
    this.a.onPageFinished(this.b, paramString);
    if ("com.qzone".equals(paramIX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
      this.b.a(paramIX5WebViewBase.getView().getContext());
    }
    TbsLog.app_extra("SmttWebViewClient", paramIX5WebViewBase.getView().getContext());
    try
    {
      super.onPageFinished(paramIX5WebViewBase, paramInt1, paramInt2, paramString);
      label130:
      WebView.d();
      if ((!TbsShareManager.mHasQueryed) && (this.b.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.b.getContext())))
      {
        TbsShareManager.mHasQueryed = true;
        new Thread(new i.1(this)).start();
      }
      if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
      {
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
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
    this.b.a(paramIX5WebViewBase);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    onPageStarted(paramIX5WebViewBase, 0, 0, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedClientCertRequest(this.b, paramClientCertRequest);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    int i = paramInt;
    if (paramInt < -15) {
      if (paramInt == -17) {
        i = -1;
      } else {
        return;
      }
    }
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedError(this.b, i, paramString1, paramString2);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedError(this.b, paramWebResourceRequest, paramWebResourceError);
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedHttpAuthRequest(this.b, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  public void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedHttpError(this.b, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedSslError(this.b, paramSslErrorHandler, paramSslError);
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.b.a(paramIX5WebViewBase);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    this.b.a(paramIX5WebViewBase);
    return this.a.shouldInterceptRequest(this.b, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    this.b.a(paramIX5WebViewBase);
    return this.a.shouldInterceptRequest(this.b, paramWebResourceRequest, paramBundle);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.b.a(paramIX5WebViewBase);
    return this.a.shouldInterceptRequest(this.b, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.b.a(paramIX5WebViewBase);
    return this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    String str;
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {
      str = paramWebResourceRequest.getUrl().toString();
    } else {
      str = null;
    }
    if (str != null)
    {
      if (this.b.showDebugView(str)) {
        return true;
      }
      this.b.a(paramIX5WebViewBase);
      boolean bool = this.a.shouldOverrideUrlLoading(this.b, paramWebResourceRequest);
      if (!bool)
      {
        if (str.startsWith("wtai://wp/mc;"))
        {
          paramIX5WebViewBase = new StringBuilder();
          paramIX5WebViewBase.append("tel:");
          paramIX5WebViewBase.append(str.substring(13));
          paramIX5WebViewBase = new Intent("android.intent.action.VIEW", Uri.parse(paramIX5WebViewBase.toString()));
          this.b.getContext().startActivity(paramIX5WebViewBase);
          return true;
        }
        if (str.startsWith("tel:"))
        {
          a(str);
          return true;
        }
      }
      return bool;
    }
    return true;
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    if (paramString != null)
    {
      if (this.b.showDebugView(paramString)) {
        return true;
      }
      this.b.a(paramIX5WebViewBase);
      boolean bool = this.a.shouldOverrideUrlLoading(this.b, paramString);
      if (!bool)
      {
        if (paramString.startsWith("wtai://wp/mc;"))
        {
          paramIX5WebViewBase = new StringBuilder();
          paramIX5WebViewBase.append("tel:");
          paramIX5WebViewBase.append(paramString.substring(13));
          paramIX5WebViewBase = new Intent("android.intent.action.VIEW", Uri.parse(paramIX5WebViewBase.toString()));
          this.b.getContext().startActivity(paramIX5WebViewBase);
          return true;
        }
        if (paramString.startsWith("tel:"))
        {
          a(paramString);
          return true;
        }
      }
      return bool;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.i
 * JD-Core Version:    0.7.0.1
 */