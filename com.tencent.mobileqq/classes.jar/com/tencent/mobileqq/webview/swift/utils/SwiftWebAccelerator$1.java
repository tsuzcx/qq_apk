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
    if (this.a.b)
    {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "mScheduler.next:is in real world, stop the preload task.");
      return -1;
    }
    if ((this.a.c & 0x2) != 0)
    {
      if ((this.a.a & 0x400) == 0) {
        this.a.g(paramBundle);
      }
      if ((this.a.a & 0x800) == 0) {
        this.a.h(paramBundle);
      }
      if ((this.a.a & 0x1000) == 0) {
        this.a.i(paramBundle);
      }
      if ((this.a.a & 0x1) == 0) {
        return this.a.b(paramBundle);
      }
    }
    if ((this.a.c & 0x1) != 0)
    {
      if ((this.a.a & 0x2) == 0) {
        return this.a.c(paramBundle);
      }
      if (!SwiftBrowserStatistics.aD)
      {
        SwiftBrowserStatistics.aD = true;
        if ((WebProcessReceiver.b > 0L) && (WebProcessReceiver.c > 0L))
        {
          SwiftBrowserStatistics.ac = WebProcessReceiver.c - WebProcessReceiver.b;
          SwiftBrowserStatistics.ad = System.currentTimeMillis() - WebProcessReceiver.c;
          int i = (int)SwiftBrowserStatistics.ac;
          int j = (int)SwiftBrowserStatistics.ad;
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
      if ((this.a.a & 0x4) == 0) {
        return this.a.d(paramBundle);
      }
      if ((this.a.a & 0x8) == 0) {
        return this.a.f(paramBundle);
      }
      if ((paramBundle.getBoolean("_should_set_cookie_", false)) && ((this.a.a & 0x10) == 0)) {
        return this.a.e(paramBundle);
      }
      if (!SwiftBrowserStatistics.aE)
      {
        SwiftBrowserStatistics.aE = true;
        if ((WebProcessReceiver.b > 0L) && (WebProcessReceiver.c > 0L))
        {
          SwiftBrowserStatistics.ae = System.currentTimeMillis() - WebProcessReceiver.c;
          paramBundle = new StringBuilder();
          paramBundle.append("WebProcessReceiver.onReceive cost: ");
          paramBundle.append(SwiftBrowserStatistics.ac);
          paramBundle.append("ms, complete preload cost: ");
          paramBundle.append(SwiftBrowserStatistics.ae);
          paramBundle.append("ms.");
          QLog.i("WebLog_SwiftWebAccelerator", 1, paramBundle.toString());
        }
        QLog.i("WebLog_SwiftWebAccelerator", 1, "well done, all preload task execute success!");
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.1
 * JD-Core Version:    0.7.0.1
 */