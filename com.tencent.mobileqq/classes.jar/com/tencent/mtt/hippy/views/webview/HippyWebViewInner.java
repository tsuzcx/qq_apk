package com.tencent.mtt.hippy.views.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import java.io.File;

class HippyWebViewInner
  extends DtWebView
{
  public HippyWebViewInner(Context paramContext)
  {
    super(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setAppCacheEnabled(false);
    localWebSettings.setSupportMultipleWindows(false);
    localWebSettings.setAppCachePath(paramContext.getDir("hwebview_appcache", 0).getPath());
    localWebSettings.setDatabasePath(paramContext.getDir("hwebview_databases", 0).getPath());
    localWebSettings.setGeolocationDatabasePath(paramContext.getDir("hwebview_geolocation", 0).getPath());
    localWebSettings.setLoadsImagesAutomatically(true);
    localWebSettings.setAllowContentAccess(false);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    if (Build.VERSION.SDK_INT >= 26) {
      localWebSettings.setSafeBrowsingEnabled(true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (canGoBack()))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.webview.HippyWebViewInner
 * JD-Core Version:    0.7.0.1
 */