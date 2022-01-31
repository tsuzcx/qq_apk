package com.tencent.mobileqq.webview.swift.component;

import bbcn;
import bbco;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class SwiftBrowserWebViewHandler$1$1
  implements Runnable
{
  SwiftBrowserWebViewHandler$1$1(SwiftBrowserWebViewHandler.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.this$0.a.iterator();
    while (localIterator.hasNext()) {
      ((bbco)localIterator.next()).a();
    }
    this.a.this$0.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler.1.1
 * JD-Core Version:    0.7.0.1
 */