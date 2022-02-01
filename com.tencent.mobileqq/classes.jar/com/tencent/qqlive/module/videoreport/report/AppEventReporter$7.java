package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatManager;

class AppEventReporter$7
  implements Runnable
{
  AppEventReporter$7(AppEventReporter paramAppEventReporter) {}
  
  public void run()
  {
    if (AppEventReporter.access$700(this.this$0) != null) {
      AppForegroundSession.reportLastHeartBeat(AppEventReporter.access$700(this.this$0).getAppSessionId());
    }
    VideoHeartBeatManager.getInstance().supplementReportsEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.7
 * JD-Core Version:    0.7.0.1
 */