package com.tencent.open.appstore.report;

import com.tencent.replacemonitor.replace.ReplaceMonitor;

final class AppCenterReporter$6
  implements Runnable
{
  AppCenterReporter$6(String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    ReplaceMonitor.get().onAppInstalled(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.6
 * JD-Core Version:    0.7.0.1
 */