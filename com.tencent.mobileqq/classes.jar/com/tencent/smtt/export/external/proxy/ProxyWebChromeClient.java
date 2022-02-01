package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

public class ProxyWebChromeClient
  implements IX5WebChromeClient
{
  protected IX5WebChromeClient mWebChromeClient;
  
  public Bitmap getDefaultVideoPoster()
  {
    return null;
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.getVisitedHistory(paramValueCallback);
    }
  }
  
  public IX5WebChromeClient getmWebChromeClient()
  {
    return this.mWebChromeClient;
  }
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onCloseWindow(paramIX5WebViewBase);
    }
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onConsoleMessage(paramString1, paramInt, paramString2);
    }
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onConsoleMessage(paramConsoleMessage);
    }
    return false;
  }
  
  public boolean onCreateWindow(IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onCreateWindow(paramIX5WebViewBase, paramBoolean1, paramBoolean2, paramMessage);
    }
    return false;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramQuotaUpdater);
    }
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onGeolocationPermissionsHidePrompt();
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onGeolocationStartUpdating(ValueCallback<Location> paramValueCallback, ValueCallback<Bundle> paramValueCallback1)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onGeolocationStartUpdating(paramValueCallback, paramValueCallback1);
    }
  }
  
  public void onGeolocationStopUpdating()
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onGeolocationStopUpdating();
    }
  }
  
  public void onHideCustomView()
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onHideCustomView();
    }
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onJsAlert(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onJsBeforeUnload(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onJsConfirm(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onJsPrompt(paramIX5WebViewBase, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    return false;
  }
  
  public boolean onJsTimeout()
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      return localIX5WebChromeClient.onJsTimeout();
    }
    return false;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onProgressChanged(paramIX5WebViewBase, paramInt);
    }
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onReachedMaxAppCacheSize(paramLong1, paramLong2, paramQuotaUpdater);
    }
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onReceivedIcon(paramIX5WebViewBase, paramBitmap);
    }
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onReceivedTitle(paramIX5WebViewBase, paramString);
    }
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onReceivedTouchIconUrl(paramIX5WebViewBase, paramString, paramBoolean);
    }
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onRequestFocus(paramIX5WebViewBase);
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
    }
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
    }
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, ValueCallback<Uri[]> paramValueCallback, IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    IX5WebChromeClient localIX5WebChromeClient = this.mWebChromeClient;
    if (localIX5WebChromeClient != null) {
      localIX5WebChromeClient.openFileChooser(paramValueCallback, paramString1, paramString2, paramBoolean);
    }
  }
  
  public void setWebChromeClient(IX5WebChromeClient paramIX5WebChromeClient)
  {
    this.mWebChromeClient = paramIX5WebChromeClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.ProxyWebChromeClient
 * JD-Core Version:    0.7.0.1
 */