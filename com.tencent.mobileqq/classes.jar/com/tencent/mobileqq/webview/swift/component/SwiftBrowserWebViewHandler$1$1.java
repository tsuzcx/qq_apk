package com.tencent.mobileqq.webview.swift.component;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class SwiftBrowserWebViewHandler$1$1
  implements Runnable
{
  SwiftBrowserWebViewHandler$1$1(SwiftBrowserWebViewHandler.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.this$0.b.iterator();
    while (localIterator.hasNext()) {
      ((SwiftBrowserWebViewHandler.AsyncInitWebViewCallback)localIterator.next()).a();
    }
    this.a.this$0.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler.1.1
 * JD-Core Version:    0.7.0.1
 */