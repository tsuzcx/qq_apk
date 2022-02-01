package com.tencent.mobileqq.webview.swift.proxy;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;

public class WebKernelCallBackProxy
  implements WebViewKernelCallBack
{
  protected WebViewKernelCallBack webViewKernelCallBack;
  
  public WebKernelCallBackProxy(@NonNull WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    this.webViewKernelCallBack = paramWebViewKernelCallBack;
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    return this.webViewKernelCallBack.afterWebViewEngineHandleOverrideUrl(paramWebView, paramString);
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    return this.webViewKernelCallBack.beforeWebViewEngineHandleOverrideUrl(paramWebView, paramString);
  }
  
  public String getUAMark()
  {
    return this.webViewKernelCallBack.getUAMark();
  }
  
  public View getVideoLoadingProgressView()
  {
    return this.webViewKernelCallBack.getVideoLoadingProgressView();
  }
  
  public void handlePreloadCallback(int paramInt, String paramString)
  {
    this.webViewKernelCallBack.handlePreloadCallback(paramInt, paramString);
  }
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    return this.webViewKernelCallBack.handlerMiscCallback(paramString, paramBundle);
  }
  
  public boolean interceptInitUIFrame()
  {
    return this.webViewKernelCallBack.interceptInitUIFrame();
  }
  
  public boolean interceptStartLoadUrl()
  {
    return this.webViewKernelCallBack.interceptStartLoadUrl();
  }
  
  public boolean interceptTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void loadUrlFinish()
  {
    this.webViewKernelCallBack.loadUrlFinish();
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    this.webViewKernelCallBack.onDataInit(paramBundle);
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    this.webViewKernelCallBack.onDetectedBlankScreen(paramString, paramInt);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    this.webViewKernelCallBack.onFinalState(paramBundle);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.webViewKernelCallBack.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    this.webViewKernelCallBack.onHideCustomView();
  }
  
  public void onInitBottomBar(Bundle paramBundle)
  {
    this.webViewKernelCallBack.onInitBottomBar(paramBundle);
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    this.webViewKernelCallBack.onInitTitleBar(paramBundle);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.webViewKernelCallBack.onInitUIContent(paramBundle);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.webViewKernelCallBack.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.webViewKernelCallBack.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.webViewKernelCallBack.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    this.webViewKernelCallBack.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.webViewKernelCallBack.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    this.webViewKernelCallBack.onReceivedSslError(paramWebView, paramSslError);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.webViewKernelCallBack.onReceivedTitle(paramWebView, paramString);
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return this.webViewKernelCallBack.onShowFileChooser(paramValueCallback, paramFileChooserParams);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    this.webViewKernelCallBack.onShowPreview(paramBundle);
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    this.webViewKernelCallBack.onUrlChange(paramString1, paramString2);
  }
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.webViewKernelCallBack.onWebViewClientImplPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    this.webViewKernelCallBack.onWebViewInit(paramBundle, paramTouchWebView);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.webViewKernelCallBack.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return this.webViewKernelCallBack.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.webViewKernelCallBack.showCustomView(paramView, paramInt, paramCustomViewCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy
 * JD-Core Version:    0.7.0.1
 */