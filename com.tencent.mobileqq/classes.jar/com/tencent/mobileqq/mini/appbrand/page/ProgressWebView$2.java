package com.tencent.mobileqq.mini.appbrand.page;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.IPV6OnlyUtils;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import common.config.service.QzoneConfig;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class ProgressWebView$2
  extends WebViewClient
{
  ProgressWebView$2(ProgressWebView paramProgressWebView) {}
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    QLog.d("ProgressWebView", 1, "doUpdateVisitedHistory " + paramString);
    if ((ProgressWebView.access$100(this.this$0) != null) && (ProgressWebView.access$100(this.this$0).getPageWebView() != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      if ((ProgressWebView.access$100(this.this$0).pageContainer != null) && (ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage() != null) && (ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar() != null)) {
        ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar().updateProgress((byte)0);
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("htmlId", this.this$0.htmlId);
      localJSONObject.put("src", paramString);
      ProgressWebView.access$100(this.this$0).getPageWebView().evaluateSubcribeJS("onWebviewStartLoad", localJSONObject.toString(), ProgressWebView.access$100(this.this$0).getPageWebView().pageWebviewId);
      super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProgressWebView", 1, "onPageStarted error." + localException);
      }
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QLog.d("ProgressWebView", 1, "onPageFinished " + paramString);
    this.this$0.evaluateJavascript(ProgressWebView.access$400(this.this$0), new ProgressWebView.2.1(this));
    if ((ProgressWebView.access$100(this.this$0) != null) && (ProgressWebView.access$100(this.this$0).getPageWebView() != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      if ((ProgressWebView.access$100(this.this$0).pageContainer != null) && (ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage() != null) && (ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar() != null)) {
        ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar().updateProgress((byte)2);
      }
    }
    try
    {
      paramWebView = new JSONObject();
      paramWebView.put("htmlId", this.this$0.htmlId);
      paramWebView.put("src", paramString);
      ProgressWebView.access$100(this.this$0).getPageWebView().evaluateSubcribeJS("onWebviewFinishLoad", paramWebView.toString(), ProgressWebView.access$100(this.this$0).getPageWebView().pageWebviewId);
      return;
    }
    catch (Exception paramWebView)
    {
      QLog.e("ProgressWebView", 1, "onPageStarted error." + paramWebView);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    QLog.d("ProgressWebView", 1, "onPageStarted " + paramString);
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    paramWebResourceRequest = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder().append("onReceivedError ").append(paramWebResourceRequest).append("; webResourceError : ");
    if (paramWebResourceError != null) {}
    for (paramWebView = paramWebResourceError.getDescription() + " " + paramWebResourceError.getErrorCode();; paramWebView = null)
    {
      QLog.d("ProgressWebView", 1, paramWebView);
      if ((ProgressWebView.access$100(this.this$0) != null) && (ProgressWebView.access$100(this.this$0).getPageWebView() != null) && (paramWebResourceRequest != null) && (!paramWebResourceRequest.equals("about:blank"))) {}
      try
      {
        paramWebView = new JSONObject();
        paramWebView.put("htmlId", this.this$0.htmlId);
        paramWebView.put("src", paramWebResourceRequest);
        ProgressWebView.access$100(this.this$0).getPageWebView().evaluateSubcribeJS("onWebviewError", paramWebView.toString(), ProgressWebView.access$100(this.this$0).getPageWebView().pageWebviewId);
        return;
      }
      catch (Exception paramWebView)
      {
        QLog.e("ProgressWebView", 1, "onPageStarted error." + paramWebView);
      }
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Object localObject1 = paramWebResourceRequest.getUrl().toString();
    QLog.d("ProgressWebView", 1, "ipv6 innerwebview shouldInterceptRequest " + (String)localObject1);
    String str;
    HttpURLConnection localHttpURLConnection;
    if (IPV6OnlyUtils.isIPV6Enable((String)localObject1))
    {
      localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
      try
      {
        str = (String)localObject3 + (String)localObject1;
        QLog.d("ProgressWebView", 2, "url = " + str);
        localHttpURLConnection = (HttpURLConnection)new URL(str).openConnection();
        localHttpURLConnection.setRequestMethod(paramWebResourceRequest.getMethod());
        if (paramWebResourceRequest.getRequestHeaders() != null)
        {
          localObject1 = paramWebResourceRequest.getRequestHeaders().entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
            continue;
            return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("ProgressWebView", 1, "shouldInterceptRequest failed, ", localException);
      }
    }
    localHttpURLConnection.setConnectTimeout(6000);
    localHttpURLConnection.setReadTimeout(6000);
    Object localObject3 = "";
    Object localObject2 = localObject3;
    if (localHttpURLConnection.getHeaderFields() != null)
    {
      localObject2 = localObject3;
      if (localHttpURLConnection.getHeaderFields().containsKey("Content-Type")) {
        localObject2 = (String)((List)localHttpURLConnection.getHeaderFields().get("Content-Type")).get(0);
      }
    }
    localObject3 = IPV6OnlyUtils.getMimeType((String)localObject2);
    localObject2 = IPV6OnlyUtils.getEncoding((String)localObject2);
    QLog.d("ProgressWebView", 2, "ipv6 code:" + localHttpURLConnection.getResponseCode() + "  url:" + str);
    QLog.d("ProgressWebView", 2, "mimeType = " + (String)localObject3 + "encoding:" + (String)localObject2);
    localObject2 = new WebResourceResponse((String)localObject3, (String)localObject2, localHttpURLConnection.getInputStream());
    return localObject2;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (((ProgressWebView.access$100(this.this$0) != null) && (ProgressWebView.access$100(this.this$0).getApkgInfo() != null) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https:"))) || (paramString.startsWith("http:")))
    {
      boolean bool = ProgressWebView.access$100(this.this$0).getApkgInfo().isDomainValid(false, paramString, 4);
      QLog.i("ProgressWebView", 1, "shouldOverrideUrlLoading url = " + paramString + "; ret = " + bool);
      if (!bool)
      {
        String str = QzoneConfig.getInstance().getConfig("qqminiapp", "https://m.q.qq.com/webview/error?url={url}&appid={appid}", "https://m.q.qq.com/webview/error?url={url}&appid={appid}");
        paramWebView = str;
        if (!TextUtils.isEmpty(str)) {
          paramWebView = str.replace("{url}", paramString).replace("{appid}", ProgressWebView.access$100(this.this$0).appId);
        }
        this.this$0.loadUrl(paramWebView);
        return true;
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("tel:")) && (ProgressWebView.access$300(this.this$0) != null) && (!ProgressWebView.access$300(this.this$0).isFinishing()))
    {
      paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramWebView.putExtra("big_brother_source_key", "biz_src_miniapp");
      try
      {
        ProgressWebView.access$300(this.this$0).startActivity(paramWebView);
        return true;
      }
      catch (Throwable paramWebView)
      {
        for (;;)
        {
          QLog.e("ProgressWebView", 1, "error happend:" + paramWebView);
        }
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.2
 * JD-Core Version:    0.7.0.1
 */