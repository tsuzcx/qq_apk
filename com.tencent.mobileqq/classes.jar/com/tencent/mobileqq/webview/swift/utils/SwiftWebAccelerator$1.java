package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

class SwiftWebAccelerator$1
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  SwiftWebAccelerator$1(SwiftWebAccelerator paramSwiftWebAccelerator) {}
  
  public int a(Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "mScheduler.next:is in real world, stop the preload task.");
      return -1;
    }
    if ((this.a.b & 0x2) != 0)
    {
      if ((this.a.jdField_a_of_type_Int & 0x400) == 0) {
        this.a.b(paramBundle);
      }
      if ((this.a.jdField_a_of_type_Int & 0x800) == 0) {
        this.a.c(paramBundle);
      }
      if ((this.a.jdField_a_of_type_Int & 0x1000) == 0) {
        this.a.d(paramBundle);
      }
      if ((this.a.jdField_a_of_type_Int & 0x1) == 0) {
        return this.a.a(paramBundle);
      }
    }
    if ((this.a.b & 0x1) != 0)
    {
      if ((this.a.jdField_a_of_type_Int & 0x2) == 0) {
        return this.a.b(paramBundle);
      }
      if (!SwiftBrowserStatistics.p)
      {
        SwiftBrowserStatistics.p = true;
        if ((WebProcessReceiver.a > 0L) && (WebProcessReceiver.b > 0L))
        {
          SwiftBrowserStatistics.V = WebProcessReceiver.b - WebProcessReceiver.a;
          SwiftBrowserStatistics.W = System.currentTimeMillis() - WebProcessReceiver.b;
          int i = (int)SwiftBrowserStatistics.V;
          int j = (int)SwiftBrowserStatistics.W;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cross process cost: ");
          localStringBuilder.append(i);
          localStringBuilder.append("ms, preload cost: ");
          localStringBuilder.append(j);
          localStringBuilder.append("ms.");
          QLog.i("WebLog_SwiftWebAccelerator", 1, localStringBuilder.toString());
          VasBaseWebviewUtil.reportVasStatus("Preload_Web_Process", "", "", i, j, 0, 0, "", "");
        }
      }
      if ((this.a.jdField_a_of_type_Int & 0x4) == 0) {
        return this.a.c(paramBundle);
      }
      if ((this.a.jdField_a_of_type_Int & 0x8) == 0) {
        return this.a.e(paramBundle);
      }
      if ((paramBundle.getBoolean("_should_set_cookie_", false)) && ((this.a.jdField_a_of_type_Int & 0x10) == 0)) {
        return this.a.d(paramBundle);
      }
      if (!SwiftBrowserStatistics.q)
      {
        SwiftBrowserStatistics.q = true;
        if ((WebProcessReceiver.a > 0L) && (WebProcessReceiver.b > 0L))
        {
          SwiftBrowserStatistics.X = System.currentTimeMillis() - WebProcessReceiver.b;
          paramBundle = new StringBuilder();
          paramBundle.append("WebProcessReceiver.onReceive cost: ");
          paramBundle.append(SwiftBrowserStatistics.V);
          paramBundle.append("ms, complete preload cost: ");
          paramBundle.append(SwiftBrowserStatistics.X);
          paramBundle.append("ms.");
          QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
        }
        QLog.i("WebLog_SwiftWebAccelerator", 1, "well done, all preload task execute success!");
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.1
 * JD-Core Version:    0.7.0.1
 */