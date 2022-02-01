package com.tencent.mobileqq.upgrade;

import android.graphics.Bitmap;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class UpgradeTipsDialog$1
  extends WebViewClient
{
  UpgradeTipsDialog$1(UpgradeTipsDialog paramUpgradeTipsDialog) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageFinished: ");
      paramWebView.append(paramString);
      QLog.d("UpgradeController", 2, paramWebView.toString());
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageStarted: ");
      paramWebView.append(paramString);
      QLog.d("UpgradeController", 2, paramWebView.toString());
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onReceivedError: ");
      paramWebView.append(paramInt);
      paramWebView.append(", ");
      paramWebView.append(paramString1);
      QLog.d("UpgradeController", 2, paramWebView.toString());
    }
    ReportController.b(UpgradeTipsDialog.b(this.a), "CliOper", "", "", "Update_tips", "Upd_fail", 0, paramInt, "", "", "", "");
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)) && (!"about:blank;".equals(paramString)))
    {
      if ("about:blank".equals(paramString)) {
        return true;
      }
      if (UpgradeTipsDialog.a(this.a).a(paramWebView, paramString)) {
        return true;
      }
      this.a.a.loadUrl(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog.1
 * JD-Core Version:    0.7.0.1
 */