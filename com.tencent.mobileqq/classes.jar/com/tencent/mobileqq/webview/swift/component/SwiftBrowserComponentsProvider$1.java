package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.smtt.sdk.WebView;

class SwiftBrowserComponentsProvider$1
  implements SwiftBrowserComponentsProvider.SwiftBrowserComponentContext
{
  SwiftBrowserComponentsProvider$1(SwiftBrowserComponentsProvider paramSwiftBrowserComponentsProvider) {}
  
  public Activity a()
  {
    return this.a.a.getHostActivity();
  }
  
  public WebViewProvider a()
  {
    return this.a.a.getWebViewProvider();
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return this.a;
  }
  
  public WebView a()
  {
    return this.a.a.getHostWebView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.1
 * JD-Core Version:    0.7.0.1
 */