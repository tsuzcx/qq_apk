package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;

public abstract interface IX5WebChromeClient
{
  public abstract Bitmap getDefaultVideoPoster();
  
  public abstract void getVisitedHistory(ValueCallback<String[]> paramValueCallback);
  
  public abstract void onCloseWindow(IX5WebViewBase paramIX5WebViewBase);
  
  @Deprecated
  public abstract void onConsoleMessage(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean onConsoleMessage(ConsoleMessage paramConsoleMessage);
  
  public abstract boolean onCreateWindow(IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage);
  
  public abstract void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater);
  
  public abstract void onGeolocationPermissionsHidePrompt();
  
  public abstract void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback);
  
  public abstract void onGeolocationStartUpdating(ValueCallback<Location> paramValueCallback, ValueCallback<Bundle> paramValueCallback1);
  
  public abstract void onGeolocationStopUpdating();
  
  public abstract void onHideCustomView();
  
  public abstract boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult);
  
  public abstract boolean onJsTimeout();
  
  public abstract void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt);
  
  public abstract void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater);
  
  public abstract void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap);
  
  public abstract void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString);
  
  public abstract void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean);
  
  public abstract void onRequestFocus(IX5WebViewBase paramIX5WebViewBase);
  
  public abstract void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, ValueCallback<Uri[]> paramValueCallback, IX5WebChromeClient.FileChooserParams paramFileChooserParams);
  
  public abstract void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
 * JD-Core Version:    0.7.0.1
 */