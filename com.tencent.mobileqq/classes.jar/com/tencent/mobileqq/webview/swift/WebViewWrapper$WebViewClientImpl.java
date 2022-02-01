package com.tencent.mobileqq.webview.swift;

import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticsConfigUtils;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class WebViewWrapper$WebViewClientImpl
  extends WebViewClient
{
  ArrayMap<String, Object> b;
  
  WebViewWrapper$WebViewClientImpl(WebViewWrapper paramWebViewWrapper) {}
  
  private String a(String paramString)
  {
    String str;
    if (paramString.startsWith("https://jsbridge/"))
    {
      str = paramString.replace("https://jsbridge/", "jsbridge://");
    }
    else
    {
      str = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        str = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    if (QLog.isColorLevel())
    {
      if ((str.startsWith("jsbridge://")) && (str.length() > 512))
      {
        paramString = new StringBuilder();
        paramString.append("shouldOverrideUrlLoading:");
        paramString.append(str.substring(0, 512));
        QLog.d("WebLog_WebViewWrapper", 2, paramString.toString());
        return str;
      }
      paramString = new StringBuilder();
      paramString.append("shouldOverrideUrlLoading:");
      paramString.append(Util.b(str, new String[0]));
      QLog.d("WebLog_WebViewWrapper", 2, paramString.toString());
    }
    return str;
  }
  
  private boolean a(String paramString, WebViewPluginEngine paramWebViewPluginEngine)
  {
    return (paramWebViewPluginEngine != null) && (paramWebViewPluginEngine.a(paramString));
  }
  
  WebResourceResponse a(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString, "", false);
  }
  
  WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    if (bool) {
      return null;
    }
    if ((WebViewWrapper.a(this.c) != null) && (WebViewWrapper.a(this.c).a(paramString1))) {
      return WebViewWrapper.a(this.c).a(paramWebView, paramString1, paramString2, paramBoolean);
    }
    WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    if (localWebViewPluginEngine == null) {
      return null;
    }
    if (paramString1.startsWith("https://jsbridge/"))
    {
      paramWebView = paramString1.replace("https://jsbridge/", "jsbridge://");
    }
    else
    {
      paramWebView = paramString1;
      if (paramString1.startsWith("http://jsbridge/")) {
        paramWebView = paramString1.replace("http://jsbridge/", "jsbridge://");
      }
    }
    if (QLog.isColorLevel()) {
      if ((paramWebView.startsWith("jsbridge://")) && (paramWebView.length() > 512))
      {
        paramString1 = new StringBuilder("doInterceptRequest:");
        paramString1.append(paramWebView.substring(0, 512));
        QLog.i("WebLog_WebViewWrapper", 2, paramString1.toString());
      }
      else
      {
        paramString1 = new StringBuilder("doInterceptRequest:");
        paramString1.append(paramWebView);
        QLog.i("WebLog_WebViewWrapper", 2, paramString1.toString());
      }
    }
    if ((this.c.d != null) && (paramString2.equalsIgnoreCase("post")) && (paramBoolean)) {
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.2(this, localWebViewPluginEngine, paramWebView));
    }
    if ((paramWebView.startsWith("jsbridge:")) && (this.c.d != null))
    {
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.3(this, localWebViewPluginEngine, paramWebView));
      return SwiftWebViewUtils.b();
    }
    for (;;)
    {
      try
      {
        if (this.c.g == null) {
          break label452;
        }
        paramString2 = this.c.g.requestResource(paramWebView);
        paramString1 = localObject;
        if (!(paramString2 instanceof WebResourceResponse)) {
          break label387;
        }
        paramString1 = (WebResourceResponse)paramString2;
        try
        {
          QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
        }
        catch (Exception paramString2) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Exception paramString2)
      {
        paramString1 = localStringBuilder;
      }
      localStringBuilder.append("shouldInterceptRequest:intercept by sonic error -> ");
      localStringBuilder.append(paramString2.getMessage());
      QLog.e("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      label387:
      if (paramString1 == null) {
        try
        {
          paramWebView = localWebViewPluginEngine.a(paramWebView, 8L);
          if ((paramWebView instanceof WebResourceResponse))
          {
            paramWebView = (WebResourceResponse)paramWebView;
            return paramWebView;
          }
        }
        catch (Exception paramWebView)
        {
          paramString2 = new StringBuilder();
          paramString2.append("shouldInterceptRequest error:");
          paramString2.append(paramWebView.getMessage());
          QLog.e("WebLog_WebViewWrapper", 1, paramString2.toString());
        }
      }
      return paramString1;
      label452:
      paramString2 = null;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetectedBlankScreen, status: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", url:");
    localStringBuilder.append(paramString);
    QLog.i("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
    if (this.c.c != null) {
      this.c.c.onDetectedBlankScreen(paramString, paramInt);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!this.c.e())
    {
      if (this.c.d == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageFinished:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      super.onPageFinished(paramWebView, paramString);
      if (this.c.c != null) {
        this.c.c.onPageFinished(paramWebView, paramString);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934594L, null);
      }
      if (this.c.d.getX5WebViewExtension() != null) {
        try
        {
          paramWebView = new Bundle();
          paramWebView.putString("input-box-num", "");
          paramString = new WebViewWrapper.WebViewClientImpl.1(this);
          this.c.d.getX5WebViewExtension().getFakeLoginStatus(paramWebView, paramString);
        }
        catch (Throwable paramWebView)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised e:", paramWebView);
          }
        }
      }
      BaseOpenWebMonitor.b(this.c.e);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (!this.c.e())
    {
      if (this.c.d == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageStarted:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (this.c.c != null)
      {
        this.c.c.onPageStarted(paramWebView, paramString, paramBitmap);
        this.c.c.onWebViewClientImplPageStarted(paramWebView, paramString, paramBitmap);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934593L, null);
      }
    }
    try
    {
      if (this.c.d.getX5WebViewExtension() != null)
      {
        paramWebView = new Bundle();
        paramWebView.putStringArrayList("recognised-text", SwiftBrowserStatisticsConfigUtils.a());
        this.c.d.getX5WebViewExtension().setFakeLoginParams(paramWebView);
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewWrapper", 2, "initWebviewExtension success");
        }
      }
      return;
    }
    catch (Throwable paramWebView) {}
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!this.c.e())
    {
      if (this.c.d == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", desc=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      QLog.e("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      if (this.c.c != null) {
        this.c.c.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString2, 8589934595L, paramInt);
      }
    }
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivedHttpError:");
      ((StringBuilder)localObject).append(paramWebResourceRequest.getUrl());
      ((StringBuilder)localObject).append("Occur error, resp code=");
      ((StringBuilder)localObject).append(paramWebResourceResponse.getStatusCode());
      QLog.e("WebLog_WebViewWrapper", 1, ((StringBuilder)localObject).toString());
      localObject = paramWebView.getUrl();
      if ((localObject != null) && (AuthorizeConfig.a().a((String)localObject)))
      {
        paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
        if (paramWebView != null)
        {
          if (this.b == null) {
            this.b = new ArrayMap(4);
          }
          this.b.put("requestData", paramWebResourceRequest);
          this.b.put("responseData", paramWebResourceResponse);
          this.b.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
          paramWebView.a((String)localObject, 64L, this.b);
          paramWebView.a((String)localObject, 8589934612L, this.b);
        }
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (!this.c.e())
    {
      if (this.c.d == null) {
        return;
      }
      Object localObject = paramSslError.getCertificate();
      String str = paramWebView.getUrl();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedSslError:");
      localStringBuilder.append(paramSslError.getPrimaryError());
      localStringBuilder.append(", cert=");
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = ((SslCertificate)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", pageUrl=");
      localStringBuilder.append(Util.b(str, new String[0]));
      QLog.e("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      if (this.c.c != null) {
        this.c.c.onReceivedSslError(paramWebView, paramSslError);
      }
      paramSslErrorHandler.cancel();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.c.d != null) && (!this.c.e()))
    {
      if ((!TextUtils.isEmpty(paramString)) && (!"about:blank;".equals(paramString)) && (!"about:blank".equals(paramString)))
      {
        paramString = a(paramString);
        BaseOpenWebMonitor.b(this.c.e, paramString);
        String str = SwiftWebViewUtils.b(paramString);
        if ((this.c.c != null) && (this.c.c.beforeWebViewEngineHandleOverrideUrl(this.c.d, paramString)))
        {
          QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
          return true;
        }
        if ((("http".equals(str)) || ("data".equals(str))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          CustomWebView.addContextLog(Util.b(paramString, new String[0]));
        }
        try
        {
          WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
          if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(paramString, 1024L, null)))
          {
            QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
            return true;
          }
          if (a(paramString, localWebViewPluginEngine)) {
            return true;
          }
          if ((this.c.c != null) && (this.c.c.shouldOverrideUrlLoading(paramWebView, paramString))) {
            return true;
          }
          if ((!"http".equals(str)) && (!"https".equals(str)) && (!"data".equals(str)) && (!"file".equals(str)))
          {
            if ((this.c.c != null) && (this.c.c.afterWebViewEngineHandleOverrideUrl(this.c.d, paramString))) {
              return true;
            }
          }
          else
          {
            if (localWebViewPluginEngine != null)
            {
              boolean bool = localWebViewPluginEngine.a(paramString, 16L, null);
              if (bool) {
                return true;
              }
            }
            return false;
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
          QLog.e("WebLog_WebViewWrapper", 1, paramString);
        }
        return true;
      }
      paramWebView = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
      paramWebView.append(paramString);
      paramWebView.append("].");
      QLog.e("WebLog_WebViewWrapper", 1, new Object[] { paramWebView });
      return true;
    }
    QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */