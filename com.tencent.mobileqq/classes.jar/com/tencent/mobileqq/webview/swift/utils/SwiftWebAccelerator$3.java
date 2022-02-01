package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;

class SwiftWebAccelerator$3
  implements Runnable
{
  SwiftWebAccelerator$3(SwiftWebAccelerator paramSwiftWebAccelerator, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    SwiftWebAccelerator.TbsAccelerator.b();
    SwiftBrowserStatistics.Y = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on sub thread, cost " + SwiftBrowserStatistics.Y + "ms.");
    this.this$0.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3
 * JD-Core Version:    0.7.0.1
 */