package com.tencent.mobileqq.webview.swift.component;

import bedz;
import beea;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicInteger;
import nbv;

public class SwiftBrowserOfflineHandler$1
  implements Runnable
{
  public SwiftBrowserOfflineHandler$1(bedz parambedz, String paramString) {}
  
  public void run()
  {
    this.this$0.b();
    long l = System.currentTimeMillis();
    if (bedz.c.get() == 3) {}
    for (boolean bool = nbv.a(BaseApplicationImpl.getApplication().getApplicationContext(), this.a, new beea(this, l));; bool = false)
    {
      if (!bool) {
        this.this$0.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1
 * JD-Core Version:    0.7.0.1
 */