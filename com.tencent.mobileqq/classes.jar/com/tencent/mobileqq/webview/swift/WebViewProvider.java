package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.OfflinePluginInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import mqq.app.AppRuntime;

public abstract interface WebViewProvider
  extends WebUiBaseInterface, WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter, WebUiUtils.OfflinePluginInterface, WebUiUtils.WebUiMethodInterface, WebUiUtils.WebViewProviderInterface
{
  public abstract void doOnBackEvent();
  
  public abstract AppRuntime getAppRuntime();
  
  public abstract WebBrowserViewContainer getContentView();
  
  public abstract Intent getIntent();
  
  public abstract Resources getResource();
  
  public abstract String getUin();
  
  public abstract String getUrlFromIntent();
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isNightMode();
  
  public abstract void setCurUrl(String paramString);
  
  public abstract void setWebView(TouchWebView paramTouchWebView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewProvider
 * JD-Core Version:    0.7.0.1
 */