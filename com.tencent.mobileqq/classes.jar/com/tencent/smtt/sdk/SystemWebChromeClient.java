package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;

class SystemWebChromeClient
  extends android.webkit.WebChromeClient
{
  private WebChromeClient mChromeClient;
  private WebView mWebView;
  
  SystemWebChromeClient(WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    this.mWebView = paramWebView;
    this.mChromeClient = paramWebChromeClient;
  }
  
  @TargetApi(7)
  public Bitmap getDefaultVideoPoster()
  {
    Bitmap localBitmap2 = this.mChromeClient.getDefaultVideoPoster();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = localBitmap2;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        localBitmap1 = BitmapFactory.decodeResource(this.mWebView.getResources(), 17301540);
      }
      return localBitmap1;
    }
    catch (Exception localException) {}
    return localBitmap2;
  }
  
  @TargetApi(7)
  public View getVideoLoadingProgressView()
  {
    return this.mChromeClient.getVideoLoadingProgressView();
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
  {
    this.mChromeClient.getVisitedHistory(new SystemWebChromeClient.1(this, paramValueCallback));
  }
  
  public void onCloseWindow(android.webkit.WebView paramWebView)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mChromeClient.onCloseWindow(this.mWebView);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    this.mChromeClient.onConsoleMessage(new SystemWebChromeClient.ConsoleMessageImpl(paramString1, paramString2, paramInt));
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return this.mChromeClient.onConsoleMessage(new SystemWebChromeClient.ConsoleMessageImpl(paramConsoleMessage));
  }
  
  public boolean onCreateWindow(android.webkit.WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    paramWebView = this.mWebView;
    paramWebView.getClass();
    paramWebView = new WebView.WebViewTransport(paramWebView);
    paramMessage = Message.obtain(paramMessage.getTarget(), new SystemWebChromeClient.2(this, paramWebView, paramMessage));
    paramMessage.obj = paramWebView;
    return this.mChromeClient.onCreateWindow(this.mWebView, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  @Deprecated
  @TargetApi(5)
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.mChromeClient.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new SystemWebChromeClient.QuotaUpdaterImpl(this, paramQuotaUpdater));
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsHidePrompt()
  {
    this.mChromeClient.onGeolocationPermissionsHidePrompt();
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    this.mChromeClient.onGeolocationPermissionsShowPrompt(paramString, new SystemWebChromeClient.GeolocationPermissionsCallbackImpl(this, paramCallback));
  }
  
  @TargetApi(7)
  public void onHideCustomView()
  {
    this.mChromeClient.onHideCustomView();
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.mWebView.setSysWebView(paramWebView);
    return this.mChromeClient.onJsAlert(this.mWebView, paramString1, paramString2, new SystemWebChromeClient.JsResultImpl(this, paramJsResult));
  }
  
  public boolean onJsBeforeUnload(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.mWebView.setSysWebView(paramWebView);
    return this.mChromeClient.onJsBeforeUnload(this.mWebView, paramString1, paramString2, new SystemWebChromeClient.JsResultImpl(this, paramJsResult));
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.mWebView.setSysWebView(paramWebView);
    return this.mChromeClient.onJsConfirm(this.mWebView, paramString1, paramString2, new SystemWebChromeClient.JsResultImpl(this, paramJsResult));
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    this.mWebView.setSysWebView(paramWebView);
    return this.mChromeClient.onJsPrompt(this.mWebView, paramString1, paramString2, paramString3, new SystemWebChromeClient.JsPromptResultImpl(this, paramJsPromptResult));
  }
  
  @TargetApi(7)
  public boolean onJsTimeout()
  {
    return this.mChromeClient.onJsTimeout();
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mChromeClient.onProgressChanged(this.mWebView, paramInt);
  }
  
  @Deprecated
  @TargetApi(7)
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.mChromeClient.onReachedMaxAppCacheSize(paramLong1, paramLong2, new SystemWebChromeClient.QuotaUpdaterImpl(this, paramQuotaUpdater));
  }
  
  public void onReceivedIcon(android.webkit.WebView paramWebView, Bitmap paramBitmap)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mChromeClient.onReceivedIcon(this.mWebView, paramBitmap);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mChromeClient.onReceivedTitle(this.mWebView, paramString);
  }
  
  @TargetApi(7)
  public void onReceivedTouchIconUrl(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mChromeClient.onReceivedTouchIconUrl(this.mWebView, paramString, paramBoolean);
  }
  
  public void onRequestFocus(android.webkit.WebView paramWebView)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mChromeClient.onRequestFocus(this.mWebView);
  }
  
  @Deprecated
  @TargetApi(14)
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mChromeClient.onShowCustomView(paramView, paramInt, new SystemWebChromeClient.CustomViewCallbackImpl(this, paramCustomViewCallback));
  }
  
  @TargetApi(7)
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.mChromeClient.onShowCustomView(paramView, new SystemWebChromeClient.CustomViewCallbackImpl(this, paramCustomViewCallback));
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    paramValueCallback = new SystemWebChromeClient.4(this, paramValueCallback);
    paramFileChooserParams = new SystemWebChromeClient.5(this, paramFileChooserParams);
    this.mWebView.setSysWebView(paramWebView);
    return this.mChromeClient.onShowFileChooser(this.mWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    openFileChooser(paramValueCallback, null, null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    openFileChooser(paramValueCallback, paramString, null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.mChromeClient.openFileChooser(new SystemWebChromeClient.3(this, paramValueCallback), paramString1, paramString2);
  }
  
  public void setupAutoFill(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient
 * JD-Core Version:    0.7.0.1
 */