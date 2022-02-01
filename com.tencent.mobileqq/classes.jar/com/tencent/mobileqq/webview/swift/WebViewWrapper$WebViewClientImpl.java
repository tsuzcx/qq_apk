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
  ArrayMap<String, Object> a;
  
  WebViewWrapper$WebViewClientImpl(WebViewWrapper paramWebViewWrapper) {}
  
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
    if ((WebViewWrapper.a(this.b) != null) && (WebViewWrapper.a(this.b).a(paramString1))) {
      return WebViewWrapper.a(this.b).a(paramWebView, paramString1, paramString2, paramBoolean);
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
    if ((this.b.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (paramString2.equalsIgnoreCase("post")) && (paramBoolean)) {
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.2(this, localWebViewPluginEngine, paramWebView));
    }
    if ((paramWebView.startsWith("jsbridge:")) && (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
    {
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.3(this, localWebViewPluginEngine, paramWebView));
      return SwiftWebViewUtils.a();
    }
    for (;;)
    {
      try
      {
        if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl == null) {
          break label452;
        }
        paramString2 = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.requestResource(paramWebView);
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
    if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
      this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.onDetectedBlankScreen(paramString, paramInt);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!this.b.a())
    {
      if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageFinished:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      super.onPageFinished(paramWebView, paramString);
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.onPageFinished(paramWebView, paramString);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934594L, null);
      }
      if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {
        try
        {
          paramWebView = new Bundle();
          paramWebView.putString("input-box-num", "");
          paramString = new WebViewWrapper.WebViewClientImpl.1(this);
          this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().getFakeLoginStatus(paramWebView, paramString);
        }
        catch (Throwable paramWebView)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised e:", paramWebView);
          }
        }
      }
      BaseOpenWebMonitor.b(this.b.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (!this.b.a())
    {
      if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageStarted:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null)
      {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.onPageStarted(paramWebView, paramString, paramBitmap);
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.onWebViewClientImplPageStarted(paramWebView, paramString, paramBitmap);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934593L, null);
      }
    }
    try
    {
      if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
      {
        paramWebView = new Bundle();
        paramWebView.putStringArrayList("recognised-text", SwiftBrowserStatisticsConfigUtils.a());
        this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().setFakeLoginParams(paramWebView);
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
    if (!this.b.a())
    {
      if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
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
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
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
    if (!this.b.a())
    {
      if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
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
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.onReceivedSslError(paramWebView, paramSslError);
      }
      paramSslErrorHandler.cancel();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = paramString;
    if ((this.b.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (!this.b.a()))
    {
      if ((!TextUtils.isEmpty(paramString)) && (!"about:blank;".equals(localObject)) && (!"about:blank".equals(localObject)))
      {
        if (((String)localObject).startsWith("https://jsbridge/"))
        {
          paramString = ((String)localObject).replace("https://jsbridge/", "jsbridge://");
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).startsWith("http://jsbridge/")) {
            paramString = ((String)localObject).replace("http://jsbridge/", "jsbridge://");
          }
        }
        if (QLog.isColorLevel()) {
          if ((paramString.startsWith("jsbridge://")) && (paramString.length() > 512))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("shouldOverrideUrlLoading:");
            ((StringBuilder)localObject).append(paramString.substring(0, 512));
            QLog.d("WebLog_WebViewWrapper", 2, ((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("shouldOverrideUrlLoading:");
            ((StringBuilder)localObject).append(Util.b(paramString, new String[0]));
            QLog.d("WebLog_WebViewWrapper", 2, ((StringBuilder)localObject).toString());
          }
        }
        BaseOpenWebMonitor.b(this.b.jdField_a_of_type_AndroidContentIntent, paramString);
        localObject = SwiftWebViewUtils.b(paramString);
        if ((this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) && (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.beforeWebViewEngineHandleOverrideUrl(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, paramString)))
        {
          QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
          return true;
        }
        if ((("http".equals(localObject)) || ("data".equals(localObject))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
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
          if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(paramString))) {
            return true;
          }
          if ((this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) && (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.shouldOverrideUrlLoading(paramWebView, paramString))) {
            return true;
          }
          if ((!"http".equals(localObject)) && (!"https".equals(localObject)) && (!"data".equals(localObject)) && (!"file".equals(localObject)))
          {
            if ((this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) && (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.afterWebViewEngineHandleOverrideUrl(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, paramString))) {
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
      paramWebView.append((String)localObject);
      paramWebView.append("].");
      QLog.e("WebLog_WebViewWrapper", 1, new Object[] { paramWebView });
      return true;
    }
    QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */