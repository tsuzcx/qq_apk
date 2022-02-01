package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.net.Uri;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class InnerWebView$5
  extends WebViewClient
{
  InnerWebView$5(InnerWebView paramInnerWebView) {}
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doUpdateVisitedHistory ");
    localStringBuilder.append(paramString);
    QMLog.d("InnerWebView", localStringBuilder.toString());
    if ((InnerWebView.access$600(this.this$0) != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      InnerWebView.access$600(this.this$0).performAction(new InnerWebView.5.1(this, paramString));
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageFinished ");
    paramWebView.append(paramString);
    QMLog.d("InnerWebView", paramWebView.toString());
    paramWebView = this.this$0;
    paramWebView.evaluateJavascript(InnerWebView.access$1200(paramWebView), new InnerWebView.5.2(this));
    InnerWebView.access$1300(this.this$0, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageStarted ");
    paramWebView.append(paramString);
    QMLog.d("InnerWebView", paramWebView.toString());
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    paramWebResourceRequest = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedError ");
    localStringBuilder.append(paramWebResourceRequest);
    localStringBuilder.append("; webResourceError : ");
    if (paramWebResourceError != null)
    {
      paramWebView = new StringBuilder();
      paramWebView.append(paramWebResourceError.getDescription());
      paramWebView.append(" ");
      paramWebView.append(paramWebResourceError.getErrorCode());
      paramWebView = paramWebView.toString();
    }
    else
    {
      paramWebView = null;
    }
    localStringBuilder.append(paramWebView);
    QMLog.d("InnerWebView", localStringBuilder.toString());
    InnerWebView.access$1400(this.this$0, paramWebResourceRequest);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (IPV6OnlyUtils.isIPV6Enable(paramWebResourceRequest.getUrl().toString()))
    {
      WebResourceResponse localWebResourceResponse = InnerWebView.access$1100(this.this$0, paramWebView, paramWebResourceRequest);
      if (localWebResourceResponse != null) {
        return localWebResourceResponse;
      }
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (InnerWebView.access$900(this.this$0, paramString)) {
      return true;
    }
    if (InnerWebView.access$1000(this.this$0, paramString)) {
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.5
 * JD-Core Version:    0.7.0.1
 */