package com.tencent.mobileqq.upgrade.activity;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

class UpgradeDetailActivity$TroopSeedWebChromeClient
  extends WebChromeClient
{
  private UpgradeDetailActivity$TroopSeedWebChromeClient(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    paramGeolocationPermissionsCallback.invoke(paramString, true, false);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onProgressChanged: ");
      paramWebView.append(paramInt);
      paramWebView.append("%");
      QLog.d("UpgradeDetailActivity", 2, paramWebView.toString());
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onReceivedTitle:");
      paramWebView.append(paramString);
      QLog.d("UpgradeDetailActivity", 2, paramWebView.toString());
    }
    this.a.setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity.TroopSeedWebChromeClient
 * JD-Core Version:    0.7.0.1
 */