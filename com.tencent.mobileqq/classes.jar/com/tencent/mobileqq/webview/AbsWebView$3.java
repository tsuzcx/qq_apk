package com.tencent.mobileqq.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class AbsWebView$3
  extends AbsWebView.WebViewClientImpl
{
  AbsWebView$3(AbsWebView paramAbsWebView)
  {
    super(paramAbsWebView, null);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "new shouldInterceptRequest");
    }
    return a(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.3
 * JD-Core Version:    0.7.0.1
 */