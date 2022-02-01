package com.tencent.mobileqq.upgrade.activity;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class UpgradeDetailActivity$TroopSeedWebViewClient
  extends WebViewClient
{
  private UpgradeDetailActivity$TroopSeedWebViewClient(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageFinished: ");
      localStringBuilder.append(paramString);
      QLog.d("UpgradeDetailActivity", 2, localStringBuilder.toString());
    }
    this.a.b.setVisibility(8);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageStarted: ");
      paramWebView.append(paramString);
      QLog.d("UpgradeDetailActivity", 2, paramWebView.toString());
    }
    if (this.a.a(paramString)) {
      this.a.b.setVisibility(8);
    }
    try
    {
      this.a.a.stopLoading();
      return;
    }
    catch (Exception paramWebView) {}
    this.a.b.setVisibility(0);
    return;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.a(true);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldOverrideUrlLoading: ");
      localStringBuilder.append(paramString);
      QLog.d("UpgradeDetailActivity", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (!"".equals(paramString)) && (!"about:blank;".equals(paramString)) && (!"about:blank".equals(paramString)) && (!UpgradeDetailActivity.e(this.a).a(paramWebView, paramString)) && (!this.a.a(paramString))) {
      this.a.b(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity.TroopSeedWebViewClient
 * JD-Core Version:    0.7.0.1
 */