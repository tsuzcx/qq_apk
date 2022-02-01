package com.tencent.mobileqq.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.utils.WebStateReporter;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;

class AbsWebView$WebViewClientImpl
  extends WebViewClient
{
  private AbsWebView$WebViewClientImpl(AbsWebView paramAbsWebView) {}
  
  protected WebResourceResponse a(WebView paramWebView, String paramString)
  {
    WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    Object localObject4 = null;
    Object localObject3 = null;
    if (localWebViewPluginEngine == null) {
      return null;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doInterceptRequest url = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AbsWebView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("https://jsbridge/")) {
        localObject1 = paramString.replace("https://jsbridge/", "jsbridge://");
      } else if (paramString.startsWith("http://jsbridge/")) {
        localObject1 = paramString.replace("http://jsbridge/", "jsbridge://");
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doInterceptRequest  https://jsbridge/ temp url = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("AbsWebView", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject2 = null;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (this.b.mWebview != null))
    {
      ThreadManagerV2.getUIHandlerV2().post(new AbsWebView.WebViewClientImpl.1(this, localWebViewPluginEngine, (String)localObject2));
      return new WebResourceResponse("text/html", "utf-8", null);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge")) && (this.b.mWebview != null)) {
      ThreadManagerV2.getUIHandlerV2().post(new AbsWebView.WebViewClientImpl.2(this, localWebViewPluginEngine, paramString));
    }
    try
    {
      localObject1 = this.b.doInterceptRequest(paramWebView, paramString);
      paramWebView = localObject4;
      if (!(localObject1 instanceof WebResourceResponse)) {
        break label339;
      }
      paramWebView = (WebResourceResponse)localObject1;
      try
      {
        QLog.i("AbsWebView", 1, "doInterceptRequest: resource intercept by sonic.");
      }
      catch (Exception localException1) {}
      localObject2 = new StringBuilder();
    }
    catch (Exception localException2)
    {
      paramWebView = localObject3;
    }
    ((StringBuilder)localObject2).append("shouldInterceptRequest:resource intercept by sonic error -> ");
    ((StringBuilder)localObject2).append(localException2.getMessage());
    QLog.e("AbsWebView", 1, ((StringBuilder)localObject2).toString());
    label339:
    if (paramWebView == null) {
      try
      {
        paramString = (WebResourceResponse)localWebViewPluginEngine.a(paramString, 8L);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AbsWebView", 2, "shouldInterceptRequest got exception!", paramString);
        }
      }
    }
    return paramWebView;
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetectedBlankScreen, status: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", url:");
    localStringBuilder.append(paramString);
    QLog.i("AbsWebView", 1, localStringBuilder.toString());
    this.b.mStateReporter.a(this.b.mInterface, paramString, paramInt);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageFinished:");
      localStringBuilder.append(paramString);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    if (this.b.mProgressBarController != null) {
      this.b.mProgressBarController.a((byte)2);
    }
    super.onPageFinished(paramWebView, paramString);
    this.b.onPageFinished(paramWebView, paramString);
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934594L, null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageStarted:");
      localStringBuilder.append(paramString);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    if (!"about:blank".equalsIgnoreCase(paramString)) {
      this.b.mStateReporter.a(2);
    }
    if ((!this.b.isIsFirstOnPageStart()) && (this.b.mProgressBarController != null) && (this.b.mProgressBarController.d() != 0)) {
      this.b.mProgressBarController.a((byte)0);
    }
    if (this.b.isIsFirstOnPageStart())
    {
      this.b.setIsFirstOnPageStart(false);
      this.b.setStartLoadUrlMilliTimeStamp(System.currentTimeMillis());
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.b.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934593L, null);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", desc=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    this.b.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString2, 8589934595L, paramInt);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    SslCertificate localSslCertificate = paramSslError.getCertificate();
    String str = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedSslError:");
    localStringBuilder.append(paramSslError.getPrimaryError());
    localStringBuilder.append(", cert=");
    if (localSslCertificate == null) {
      paramWebView = "null";
    } else {
      paramWebView = localSslCertificate.toString();
    }
    localStringBuilder.append(paramWebView);
    localStringBuilder.append(", pageUrl=");
    localStringBuilder.append(Util.b(str, new String[0]));
    QLog.w("AbsWebView", 1, localStringBuilder.toString());
    paramSslErrorHandler.cancel();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldOverrideUrlLoading ");
      ((StringBuilder)localObject).append(Util.b(paramString, new String[0]));
      QLog.d("AbsWebView", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.b.setPerfFirstLoadTag(false);
      this.b.setTimeBeforeLoadUrl(System.currentTimeMillis());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!"about:blank;".equals(paramString)))
    {
      if ("about:blank".equals(paramString)) {
        return true;
      }
      if (((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        CustomWebView.addContextLog(Util.b(paramString, new String[0]));
      }
      try
      {
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          localObject = paramWebView.getHitTestResult();
          if ((localObject != null) && (((WebView.HitTestResult)localObject).getType() == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("shouldOverrideUrlLoading detect 302 url: ");
              ((StringBuilder)localObject).append(paramString);
              QLog.i("AbsWebView", 2, ((StringBuilder)localObject).toString());
            }
            this.b.mRedirect302Time = System.currentTimeMillis();
            this.b.mRedirect302Url = paramString;
            SwiftBrowserCookieMonster.d();
          }
        }
        localObject = ((CustomWebView)paramWebView).getPluginEngine();
        if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString))) {
          return true;
        }
        if (this.b.shouldOverrideUrlLoading(paramWebView, paramString)) {
          return true;
        }
        if ((!paramString.startsWith("file://")) && (!paramString.startsWith("data:")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
        {
          if (paramString.startsWith("tnow://openpage/recordstory"))
          {
            paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            paramWebView.setFlags(268435456);
            this.b.mContext.startActivity(paramWebView);
            return true;
          }
        }
        else
        {
          bool1 = bool2;
          if (localObject != null)
          {
            boolean bool3 = ((WebViewPluginEngine)localObject).a(paramString, 16L, null);
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
          return bool1;
        }
      }
      catch (RuntimeException paramWebView)
      {
        paramString = QLog.getStackTraceString(paramWebView);
        if (paramString.length() > 255) {
          paramWebView = paramString.substring(0, 255);
        } else {
          paramWebView = paramString;
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        QLog.e("AbsWebView", 2, paramString);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */