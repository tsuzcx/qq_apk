package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;

class AppEventReporter$2
  implements Runnable
{
  AppEventReporter$2(AppEventReporter paramAppEventReporter) {}
  
  public void run()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AppEventReporter", "appInDataSender: 前台上报");
    }
    AppEventReporter.access$300(this.this$0);
    AppEventReporter.access$400(this.this$0).startNotify(new AppEventReporter.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.2
 * JD-Core Version:    0.7.0.1
 */