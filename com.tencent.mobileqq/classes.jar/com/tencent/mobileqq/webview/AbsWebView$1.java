package com.tencent.mobileqq.webview;

import android.os.SystemClock;
import baxr;
import com.tencent.qphone.base.util.QLog;

public class AbsWebView$1
  implements Runnable
{
  public AbsWebView$1(baxr parambaxr) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.this$0.mPluginEngine == null)
    {
      this.this$0.initPluginEngine();
      if (QLog.isColorLevel())
      {
        long l2 = SystemClock.uptimeMillis();
        QLog.d("AbsWebView", 2, "initPluginEngine cost= " + (l2 - l1));
      }
    }
    Thread.yield();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.1
 * JD-Core Version:    0.7.0.1
 */