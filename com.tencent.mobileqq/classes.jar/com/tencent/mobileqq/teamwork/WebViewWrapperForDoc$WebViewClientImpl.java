package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

class WebViewWrapperForDoc$WebViewClientImpl
  extends WebViewClient
{
  ArrayMap<String, Object> a;
  
  WebViewWrapperForDoc$WebViewClientImpl(WebViewWrapperForDoc paramWebViewWrapperForDoc) {}
  
  WebResourceResponse a(WebView paramWebView, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    StringBuilder localStringBuilder2 = null;
    if (bool) {
      return null;
    }
    if (paramString.startsWith("mqqpa://resourceid/")) {
      return ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getWebResponse(paramString);
    }
    WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    if (localWebViewPluginEngine == null) {
      return null;
    }
    if (paramString.startsWith("https://jsbridge/"))
    {
      paramWebView = paramString.replace("https://jsbridge/", "jsbridge://");
    }
    else
    {
      paramWebView = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        paramWebView = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    if (QLog.isColorLevel()) {
      if ((paramWebView.startsWith("jsbridge://")) && (paramWebView.length() > 512))
      {
        paramString = new StringBuilder("doInterceptRequest:");
        paramString.append(paramWebView.substring(0, 512));
        QLog.i("WebLog_WebViewWrapper", 2, paramString.toString());
      }
      else
      {
        paramString = new StringBuilder("doInterceptRequest:");
        paramString.append(paramWebView);
        QLog.i("WebLog_WebViewWrapper", 2, paramString.toString());
      }
    }
    Object localObject1;
    if ((paramWebView.startsWith("jsbridge:")) && (WebViewWrapperForDoc.j(this.b) != null))
    {
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapperForDoc.WebViewClientImpl.1(this, localWebViewPluginEngine, paramWebView));
      localObject1 = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
      paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = new HashMap();
      }
      paramWebView.put("cache-control", "must-revalidate，no-store");
      ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        if (WebViewWrapperForDoc.a(this.b) == null) {
          break label457;
        }
        localObject1 = WebViewWrapperForDoc.b(this.b).requestResource(paramWebView);
        paramString = localObject2;
        if (!(localObject1 instanceof WebResourceResponse)) {
          break label388;
        }
        paramString = (WebResourceResponse)localObject1;
        try
        {
          QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
        }
        catch (Exception localException1) {}
        localStringBuilder2 = new StringBuilder();
      }
      catch (Exception localException2)
      {
        paramString = localStringBuilder2;
      }
      localStringBuilder2.append("shouldInterceptRequest:intercept by sonic error -> ");
      localStringBuilder2.append(localException2.getMessage());
      QLog.e("WebLog_WebViewWrapper", 1, localStringBuilder2.toString());
      label388:
      if (paramString == null) {
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
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("shouldInterceptRequest error:");
          localStringBuilder1.append(paramWebView.getMessage());
          QLog.e("WebLog_WebViewWrapper", 1, localStringBuilder1.toString());
        }
      }
      return paramString;
      label457:
      StringBuilder localStringBuilder1 = null;
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
    if (WebViewWrapperForDoc.K(this.b) != null) {
      WebViewWrapperForDoc.L(this.b).onDetectedBlankScreen(paramString, paramInt);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!WebViewWrapperForDoc.b(this.b).isFinishing())
    {
      if (WebViewWrapperForDoc.b(this.b) == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageFinished:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      super.onPageFinished(paramWebView, paramString);
      if (WebViewWrapperForDoc.x(this.b) != null) {
        WebViewWrapperForDoc.y(this.b).onPageFinished(paramWebView, paramString);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934594L, null);
      }
      ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).paramInitFinish(WebViewWrapperForDoc.a(this.b));
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (!WebViewWrapperForDoc.a(this.b).isFinishing())
    {
      if (WebViewWrapperForDoc.a(this.b) == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageStarted:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (WebViewWrapperForDoc.u(this.b) != null)
      {
        WebViewWrapperForDoc.v(this.b).onPageStarted(paramWebView, paramString, paramBitmap);
        WebViewWrapperForDoc.w(this.b).onWebViewClientImplPageStarted(paramWebView, paramString, paramBitmap);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934593L, null);
      }
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!WebViewWrapperForDoc.d(this.b).isFinishing())
    {
      if (WebViewWrapperForDoc.d(this.b) == null) {
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
      if (WebViewWrapperForDoc.B(this.b) != null) {
        WebViewWrapperForDoc.C(this.b).onReceivedError(paramWebView, paramInt, paramString1, paramString2);
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
          if (this.a == null) {
            this.a = new ArrayMap(4);
          }
          this.a.put("requestData", paramWebResourceRequest);
          this.a.put("responseData", paramWebResourceResponse);
          this.a.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
          paramWebView.a((String)localObject, 64L, this.a);
          paramWebView.a((String)localObject, 8589934612L, this.a);
        }
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (!WebViewWrapperForDoc.c(this.b).isFinishing())
    {
      if (WebViewWrapperForDoc.c(this.b) == null) {
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
      if (WebViewWrapperForDoc.z(this.b) != null) {
        WebViewWrapperForDoc.A(this.b).onReceivedSslError(paramWebView, paramSslError);
      }
      paramSslErrorHandler.cancel();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject1 = paramString;
    if ((WebViewWrapperForDoc.e(this.b) != null) && (!WebViewWrapperForDoc.e(this.b).isFinishing()))
    {
      if ((!TextUtils.isEmpty(paramString)) && (!"about:blank;".equals(localObject1)) && (!"about:blank".equals(localObject1)))
      {
        Object localObject2 = TencentDocPreloadConfigProcessor.a();
        if ((((String)localObject1).startsWith("mqqapi:")) && (((String)localObject1).contains("getTcntDocData")) && (((TencentDocPreloadConfigBean)localObject2).a()))
        {
          paramWebView = Uri.parse(paramString).getQueryParameter("id");
          TenDocWebViewPool.a(paramWebView, WebViewWrapperForDoc.f(this.b));
          if (((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isInstanceTeamWorkDocEditBrowserFragment(WebViewWrapperForDoc.D(this.b)))
          {
            TenDocWebViewPool.a(paramWebView, WebViewWrapperForDoc.g(this.b));
            return true;
          }
          TenDocWebViewPool.a().a(this.b.a());
          return true;
        }
        if (((String)localObject1).startsWith("https://jsbridge/"))
        {
          paramString = ((String)localObject1).replace("https://jsbridge/", "jsbridge://");
        }
        else
        {
          paramString = (String)localObject1;
          if (((String)localObject1).startsWith("http://jsbridge/")) {
            paramString = ((String)localObject1).replace("http://jsbridge/", "jsbridge://");
          }
        }
        if (QLog.isColorLevel()) {
          if ((paramString.startsWith("jsbridge://")) && (paramString.length() > 512))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("shouldOverrideUrlLoading:");
            ((StringBuilder)localObject1).append(paramString.substring(0, 512));
            QLog.d("WebLog_WebViewWrapper", 2, ((StringBuilder)localObject1).toString());
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("shouldOverrideUrlLoading:");
            ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
            QLog.d("WebLog_WebViewWrapper", 2, ((StringBuilder)localObject1).toString());
          }
        }
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).endUrlLoad(WebViewWrapperForDoc.b(this.b), paramString);
        localObject1 = CommonUtils.b(paramString);
        if ((WebViewWrapperForDoc.E(this.b) != null) && (WebViewWrapperForDoc.F(this.b).beforeWebViewEngineHandleOverrideUrl(WebViewWrapperForDoc.h(this.b), paramString)))
        {
          QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
          return true;
        }
        if ((("http".equals(localObject1)) || ("data".equals(localObject1))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          CustomWebView.addContextLog(Util.b(paramString, new String[0]));
        }
        try
        {
          localObject2 = ((CustomWebView)paramWebView).getPluginEngine();
          if ((localObject2 != null) && (((WebViewPluginEngine)localObject2).a(paramString, 1024L, null)))
          {
            QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
            return true;
          }
          if ((localObject2 != null) && (((WebViewPluginEngine)localObject2).a(paramString))) {
            return true;
          }
          if ((WebViewWrapperForDoc.G(this.b) != null) && (WebViewWrapperForDoc.H(this.b).shouldOverrideUrlLoading(paramWebView, paramString))) {
            return true;
          }
          if ((!"http".equals(localObject1)) && (!"https".equals(localObject1)) && (!"data".equals(localObject1)) && (!"file".equals(localObject1)))
          {
            if ((WebViewWrapperForDoc.I(this.b) != null) && (WebViewWrapperForDoc.J(this.b).afterWebViewEngineHandleOverrideUrl(WebViewWrapperForDoc.i(this.b), paramString))) {
              return true;
            }
          }
          else
          {
            if (localObject2 != null)
            {
              boolean bool = ((WebViewPluginEngine)localObject2).a(paramString, 16L, null);
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
      paramWebView.append((String)localObject1);
      paramWebView.append("].");
      QLog.e("WebLog_WebViewWrapper", 1, new Object[] { paramWebView });
      return true;
    }
    QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.WebViewWrapperForDoc.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */