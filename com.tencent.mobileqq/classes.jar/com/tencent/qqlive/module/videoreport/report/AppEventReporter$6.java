package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession;

class AppEventReporter$6
  implements Runnable
{
  AppEventReporter$6(AppEventReporter paramAppEventReporter) {}
  
  public void run()
  {
    if (AppEventReporter.access$500(this.this$0) != null) {
      AppForegroundSession.reportLastHeartBeat(AppEventReporter.access$500(this.this$0).getAppSessionId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.6
 * JD-Core Version:    0.7.0.1
 */