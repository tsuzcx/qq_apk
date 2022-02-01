package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

class AppEventReporter$1
  implements Runnable
{
  AppEventReporter$1(AppEventReporter paramAppEventReporter) {}
  
  public void run()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "appInDataSender: 前台上报");
    }
    AppEventReporter.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.1
 * JD-Core Version:    0.7.0.1
 */