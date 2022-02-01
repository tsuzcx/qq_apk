package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

final class TdsReaderGlobal$WebViewClientImpl
  extends WebViewClient
{
  private final Context a;
  private final IHostInterface.IWebClient b;
  
  private TdsReaderGlobal$WebViewClientImpl(Context paramContext, IHostInterface.IWebClient paramIWebClient)
  {
    this.a = paramContext;
    this.b = paramIWebClient;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    IHostInterface.IWebClient localIWebClient = this.b;
    if ((localIWebClient == null) || (!localIWebClient.onPageFinished(paramWebView, paramString))) {
      super.onPageFinished(paramWebView, paramString);
    }
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    IHostInterface.IWebClient localIWebClient = this.b;
    if ((localIWebClient != null) && (localIWebClient.shouldOverrideUrlLoading(paramWebView, paramString))) {
      return true;
    }
    paramWebView = new Intent(this.a, QQBrowserDelegationActivity.class);
    paramWebView.putExtra("param_force_internal_browser", true);
    paramWebView.putExtra("url", paramString);
    WebAccelerator.a(this.a, paramWebView, paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */