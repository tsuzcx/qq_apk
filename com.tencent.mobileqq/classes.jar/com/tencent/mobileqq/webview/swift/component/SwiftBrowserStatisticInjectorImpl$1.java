package com.tencent.mobileqq.webview.swift.component;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class SwiftBrowserStatisticInjectorImpl$1
  implements Runnable
{
  SwiftBrowserStatisticInjectorImpl$1(SwiftBrowserStatisticInjectorImpl paramSwiftBrowserStatisticInjectorImpl, AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    if (!PushReportController.a)
    {
      boolean bool = QQUtils.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 1, new Object[] { "reportPushEvent isScreenLock=", Boolean.valueOf(bool), ",isBackground=", Boolean.valueOf(this.jdField_a_of_type_MqqAppAppRuntime.isBackgroundStop) });
      }
      if ((bool) || (this.jdField_a_of_type_MqqAppAppRuntime.isBackgroundStop))
      {
        if (this.this$0.b)
        {
          SwiftBrowserStatisticInjectorImpl.a(this.this$0, this.jdField_a_of_type_JavaLangString);
          return;
        }
        if (SwiftBrowserStatisticInjectorImpl.a(this.this$0)) {
          SwiftBrowserStatisticInjectorImpl.b(this.this$0, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticInjectorImpl.1
 * JD-Core Version:    0.7.0.1
 */