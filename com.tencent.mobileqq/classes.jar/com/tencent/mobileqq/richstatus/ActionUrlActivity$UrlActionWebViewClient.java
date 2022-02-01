package com.tencent.mobileqq.richstatus;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;

class ActionUrlActivity$UrlActionWebViewClient
  extends WebViewClient
{
  private ActionUrlActivity$UrlActionWebViewClient(ActionUrlActivity paramActionUrlActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ActionUrlActivity.b(this.a).setVisibility(8);
    super.onPageFinished(paramWebView, paramString);
    this.a.a();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    ActionUrlActivity.b(this.a).setVisibility(0);
    ActionUrlActivity.c(this.a).setVisibility(8);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    ActionUrlActivity.d(this.a).clearView();
    ActionUrlActivity.b(this.a).setVisibility(8);
    ActionUrlActivity.c(this.a).setVisibility(0);
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return ActionUrlActivity.a(this.a).a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionUrlActivity.UrlActionWebViewClient
 * JD-Core Version:    0.7.0.1
 */