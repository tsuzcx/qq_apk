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
    SwiftBrowserStatistics.af = System.currentTimeMillis() - this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initX5Environment on sub thread, cost ");
    localStringBuilder.append(SwiftBrowserStatistics.af);
    localStringBuilder.append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, localStringBuilder.toString());
    this.this$0.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3
 * JD-Core Version:    0.7.0.1
 */