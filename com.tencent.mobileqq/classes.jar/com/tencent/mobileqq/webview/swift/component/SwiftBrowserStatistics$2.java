package com.tencent.mobileqq.webview.swift.component;

import axqs;
import bbjc;
import bcfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SwiftBrowserStatistics$2
  implements Runnable
{
  public SwiftBrowserStatistics$2(bcfo parambcfo, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (!axqs.a)
    {
      boolean bool = bbjc.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 1, new Object[] { "reportPushEvent isScreenLock=", Boolean.valueOf(bool), ",isBackground=", Boolean.valueOf(this.a.isBackground_Stop) });
      }
      if ((bool) || (this.a.isBackground_Stop))
      {
        if (!this.this$0.g) {
          break label91;
        }
        bcfo.a(this.this$0);
      }
    }
    label91:
    while (!bcfo.a(this.this$0)) {
      return;
    }
    bcfo.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2
 * JD-Core Version:    0.7.0.1
 */