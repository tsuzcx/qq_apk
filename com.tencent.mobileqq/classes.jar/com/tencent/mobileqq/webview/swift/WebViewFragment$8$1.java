package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

class WebViewFragment$8$1
  implements Runnable
{
  WebViewFragment$8$1(WebViewFragment.8 param8) {}
  
  public void run()
  {
    SwiftBrowserTBSHandler localSwiftBrowserTBSHandler = (SwiftBrowserTBSHandler)this.a.this$0.mComponentsProvider.a(16);
    if (localSwiftBrowserTBSHandler != null) {
      localSwiftBrowserTBSHandler.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.8.1
 * JD-Core Version:    0.7.0.1
 */