package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.smtt.sdk.WebView;

public abstract interface SwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext
{
  public abstract Activity getHostActivity();
  
  public abstract WebView getHostWebView();
  
  public abstract WebViewProvider getWebViewProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext
 * JD-Core Version:    0.7.0.1
 */