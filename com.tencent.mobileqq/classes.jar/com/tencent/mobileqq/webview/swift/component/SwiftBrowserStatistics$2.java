package com.tencent.mobileqq.webview.swift.component;

import bdku;
import bhgy;
import bihv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SwiftBrowserStatistics$2
  implements Runnable
{
  public SwiftBrowserStatistics$2(bihv parambihv, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (!bdku.a)
    {
      boolean bool = bhgy.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 1, new Object[] { "reportPushEvent isScreenLock=", Boolean.valueOf(bool), ",isBackground=", Boolean.valueOf(this.a.isBackgroundStop) });
      }
      if ((bool) || (this.a.isBackgroundStop))
      {
        if (!this.this$0.g) {
          break label91;
        }
        bihv.a(this.this$0);
      }
    }
    label91:
    while (!bihv.a(this.this$0)) {
      return;
    }
    bihv.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2
 * JD-Core Version:    0.7.0.1
 */