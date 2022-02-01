package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

class WebViewKernel$2$1
  implements Runnable
{
  WebViewKernel$2$1(WebViewKernel.2 param2) {}
  
  public void run()
  {
    SwiftBrowserTBSHandler localSwiftBrowserTBSHandler = (SwiftBrowserTBSHandler)WebViewKernel.a(this.a.this$0).getComponentProvider().a(16);
    if (localSwiftBrowserTBSHandler != null) {
      localSwiftBrowserTBSHandler.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel.2.1
 * JD-Core Version:    0.7.0.1
 */