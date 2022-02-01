package com.tencent.qqperf.monitor.crash;

import android.content.Context;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;

class QQCrashReportManager$1
  implements Runnable
{
  QQCrashReportManager$1(QQCrashReportManager paramQQCrashReportManager, Context paramContext) {}
  
  public void run()
  {
    SafeModeUtil.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashReportManager.1
 * JD-Core Version:    0.7.0.1
 */