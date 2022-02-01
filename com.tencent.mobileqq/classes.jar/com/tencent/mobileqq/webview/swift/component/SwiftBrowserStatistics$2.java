package com.tencent.mobileqq.webview.swift.component;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class SwiftBrowserStatistics$2
  implements Runnable
{
  SwiftBrowserStatistics$2(SwiftBrowserStatistics paramSwiftBrowserStatistics, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (!PushReportController.a)
    {
      boolean bool = QQUtils.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 1, new Object[] { "reportPushEvent isScreenLock=", Boolean.valueOf(bool), ",isBackground=", Boolean.valueOf(this.a.isBackgroundStop) });
      }
      if ((bool) || (this.a.isBackgroundStop))
      {
        if (!this.this$0.g) {
          break label91;
        }
        SwiftBrowserStatistics.a(this.this$0);
      }
    }
    label91:
    while (!SwiftBrowserStatistics.a(this.this$0)) {
      return;
    }
    SwiftBrowserStatistics.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2
 * JD-Core Version:    0.7.0.1
 */