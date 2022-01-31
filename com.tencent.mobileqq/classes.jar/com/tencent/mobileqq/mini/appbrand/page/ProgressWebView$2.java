package com.tencent.mobileqq.mini.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.cookieUtils;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import org.json.JSONObject;

class ProgressWebView$2
  extends WebViewClient
{
  ProgressWebView$2(ProgressWebView paramProgressWebView, AppBrandRuntime paramAppBrandRuntime) {}
  
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
    Uri localUri = null;
    Object localObject = localUri;
    if (paramWebResourceRequest != null)
    {
      localObject = localUri;
      if (paramWebResourceRequest.getUrl() != null) {
        localObject = paramWebResourceRequest.getUrl().toString();
      }
    }
    try
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.val$appBrandRuntime != null) && (this.val$appBrandRuntime.activity != null))
      {
        localUri = Uri.parse((String)localObject);
        if ((localUri != null) && ("open.mp.qq.com".equals(localUri.getHost())))
        {
          cookieUtils.setCookie(this.val$appBrandRuntime.activity, (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("ProgressWebView", 2, "setcookie : " + localUri.getHost());
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ProgressWebView", 1, "setCookie error, ", localThrowable);
      }
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.2
 * JD-Core Version:    0.7.0.1
 */