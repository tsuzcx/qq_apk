package com.tencent.qqmini.sdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.browser.BrowserPluginEngine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class BaseBrowserFragment$1
  extends WebViewClient
{
  BaseBrowserFragment$1(BaseBrowserFragment paramBaseBrowserFragment) {}
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageFinished ");
    localStringBuilder.append(paramString);
    QMLog.d("BaseBrowserFragment", localStringBuilder.toString());
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageStarted ");
    localStringBuilder.append(paramString);
    QMLog.d("BaseBrowserFragment", localStringBuilder.toString());
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    paramWebView = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedError ");
    localStringBuilder.append(paramWebView);
    localStringBuilder.append("; webResourceError : ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", failingUrl=");
    localStringBuilder.append(paramString2);
    QMLog.d("BaseBrowserFragment", localStringBuilder.toString());
    BaseBrowserFragment.access$300(this.this$0, paramInt, paramString1, paramString2, paramWebView);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    Object localObject = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedError ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; webResourceError : ");
    if (paramWebResourceError != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramWebResourceError.getDescription());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramWebResourceError.getErrorCode());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    QMLog.d("BaseBrowserFragment", localStringBuilder.toString());
    if (this.this$0.mCoreDumpData == null) {
      this.this$0.mCoreDumpData = new ArrayMap(4);
    }
    this.this$0.mCoreDumpData.put("errorCode", Integer.valueOf(paramWebResourceError.getErrorCode()));
    this.this$0.mCoreDumpData.put("errorMsg", paramWebResourceError.getDescription());
    this.this$0.mCoreDumpData.put("requestUrl", paramWebResourceRequest.getUrl().toString());
    if ((this.this$0.mBrowerEngin != null) && (paramWebResourceError.getErrorCode() >= 400)) {
      this.this$0.mBrowerEngin.handleEvent(paramWebView.getUrl(), 1L, this.this$0.mCoreDumpData);
    }
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedHttpError:");
    localStringBuilder.append(paramWebResourceResponse.getStatusCode());
    QMLog.i("BaseBrowserFragment", localStringBuilder.toString());
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    BaseBrowserFragment.access$300(this.this$0, paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceRequest.getUrl().toString(), paramWebView.getUrl());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shouldOverrideUrlLoading ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.d("BaseBrowserFragment", ((StringBuilder)localObject).toString());
    if (BaseBrowserFragment.access$000(this.this$0, paramString))
    {
      paramWebView = new StringBuilder();
      paramWebView.append("");
      localObject = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("].");
      paramWebView.append(localObject);
      QMLog.e("BaseBrowserFragment", paramWebView.toString());
      return true;
    }
    if (paramString.startsWith("https://jsbridge/"))
    {
      localObject = paramString.replace("https://jsbridge/", "jsbridge://");
    }
    else if (paramString.startsWith("http://jsbridge/"))
    {
      localObject = paramString.replace("http://jsbridge/", "jsbridge://");
    }
    else
    {
      localObject = paramString;
      if (BaseBrowserFragment.access$100(this.this$0, paramString))
      {
        BaseBrowserFragment.access$200(this.this$0).getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        return true;
      }
    }
    if ((this.this$0.mBrowerEngin != null) && (this.this$0.mBrowerEngin.shouldOverrideUrlRequest((String)localObject))) {
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.BaseBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */