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
    QMLog.d("BaseBrowserFragment", "onPageFinished " + paramString);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    QMLog.d("BaseBrowserFragment", "onPageStarted " + paramString);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    paramWebView = paramWebView.getUrl();
    QMLog.d("BaseBrowserFragment", "onReceivedError " + paramWebView + "; webResourceError : " + paramString1 + ", errCode = " + paramInt + ", failingUrl=" + paramString2);
    BaseBrowserFragment.access$300(this.this$0, paramInt, paramString1, paramString2, paramWebView);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    String str = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder().append("onReceivedError ").append(str).append("; webResourceError : ");
    if (paramWebResourceError != null) {}
    for (str = paramWebResourceError.getDescription() + " " + paramWebResourceError.getErrorCode();; str = null)
    {
      QMLog.d("BaseBrowserFragment", str);
      if (this.this$0.mCoreDumpData == null) {
        this.this$0.mCoreDumpData = new ArrayMap(4);
      }
      this.this$0.mCoreDumpData.put("errorCode", Integer.valueOf(paramWebResourceError.getErrorCode()));
      this.this$0.mCoreDumpData.put("errorMsg", paramWebResourceError.getDescription());
      this.this$0.mCoreDumpData.put("requestUrl", paramWebResourceRequest.getUrl().toString());
      if ((this.this$0.mBrowerEngin != null) && (paramWebResourceError.getErrorCode() >= 400)) {
        this.this$0.mBrowerEngin.handleEvent(paramWebView.getUrl(), 1L, this.this$0.mCoreDumpData);
      }
      return;
    }
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    QMLog.i("BaseBrowserFragment", "onReceivedHttpError:" + paramWebResourceResponse.getStatusCode());
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    BaseBrowserFragment.access$300(this.this$0, paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceRequest.getUrl().toString(), paramWebView.getUrl());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    QMLog.d("BaseBrowserFragment", "shouldOverrideUrlLoading " + paramString);
    if (BaseBrowserFragment.access$000(this.this$0, paramString)) {
      QMLog.e("BaseBrowserFragment", "" + new StringBuilder("shouldOverrideUrlLoading fail , url=[").append(paramString).append("]."));
    }
    label148:
    do
    {
      for (;;)
      {
        return true;
        if (paramString.startsWith("https://jsbridge/")) {}
        for (str = paramString.replace("https://jsbridge/", "jsbridge://"); (this.this$0.mBrowerEngin == null) || (!this.this$0.mBrowerEngin.shouldOverrideUrlRequest(str)); str = paramString.replace("http://jsbridge/", "jsbridge://"))
        {
          return super.shouldOverrideUrlLoading(paramWebView, str);
          if (!paramString.startsWith("http://jsbridge/")) {
            break label148;
          }
        }
      }
      String str = paramString;
    } while (!BaseBrowserFragment.access$100(this.this$0, paramString));
    BaseBrowserFragment.access$200(this.this$0).getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.BaseBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */