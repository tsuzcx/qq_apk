package com.tencent.qqmini.miniapp.core.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class BrandPageWebview$3
  extends WebViewClient
{
  BrandPageWebview$3(BrandPageWebview paramBrandPageWebview) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = this.this$0;
    paramWebView.setCurrState(BrandPageWebview.access$600(paramWebView));
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("shouldInterceptRequest: ");
    ((StringBuilder)localObject1).append(paramWebResourceRequest.getUrl());
    QMLog.i("TAG_CHROMIUM", ((StringBuilder)localObject1).toString());
    if (paramWebResourceRequest.getUrl() != null)
    {
      localObject1 = paramWebResourceRequest.getUrl().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("https://appservice.qq.com/")) || (((String)localObject1).startsWith("wxfile://")))) {
        return BrandPageWebview.access$500(this.this$0, paramWebView, paramWebResourceRequest.getUrl().toString());
      }
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (paramWebResourceRequest.getUrl() != null)
    {
      localObject1 = localObject2;
      if (IPV6OnlyUtils.isIPV6Enable(paramWebResourceRequest.getUrl().toString())) {
        localObject1 = this.this$0.doIPV6OnlyRequest(paramWebView, paramWebResourceRequest);
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.3
 * JD-Core Version:    0.7.0.1
 */