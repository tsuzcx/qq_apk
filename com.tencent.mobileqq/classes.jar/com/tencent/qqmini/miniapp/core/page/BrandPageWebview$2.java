package com.tencent.qqmini.miniapp.core.page;

import Override;
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

class BrandPageWebview$2
  extends WebViewClient
{
  BrandPageWebview$2(BrandPageWebview paramBrandPageWebview) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.this$0.setCurrState(BrandPageWebview.access$300(this.this$0));
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    QMLog.i("TAG_CHROMIUM", "shouldInterceptRequest: " + paramWebResourceRequest.getUrl());
    Object localObject1;
    if (paramWebResourceRequest.getUrl() != null)
    {
      localObject1 = paramWebResourceRequest.getUrl().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("https://appservice.qq.com/")) || (((String)localObject1).startsWith("wxfile://")))) {
        localObject1 = BrandPageWebview.access$200(this.this$0, paramWebView, paramWebResourceRequest.getUrl().toString());
      }
    }
    do
    {
      Object localObject2;
      do
      {
        return localObject1;
        localObject2 = null;
        localObject1 = localObject2;
      } while (paramWebResourceRequest.getUrl() == null);
      localObject1 = localObject2;
    } while (!IPV6OnlyUtils.isIPV6Enable(paramWebResourceRequest.getUrl().toString()));
    return this.this$0.doIPV6OnlyRequest(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.2
 * JD-Core Version:    0.7.0.1
 */