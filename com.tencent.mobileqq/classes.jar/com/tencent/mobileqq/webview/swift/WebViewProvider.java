package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.OfflinePluginInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;

public abstract interface WebViewProvider
  extends WebUiBaseInterface, WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter, WebUiUtils.OfflinePluginInterface, WebUiUtils.WebTitleBarInterface, WebUiUtils.WebUiMethodInterface
{
  public abstract View getContentView();
  
  public abstract Intent getIntent();
  
  public abstract String getUrlFromIntent();
  
  public abstract void setCurUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewProvider
 * JD-Core Version:    0.7.0.1
 */