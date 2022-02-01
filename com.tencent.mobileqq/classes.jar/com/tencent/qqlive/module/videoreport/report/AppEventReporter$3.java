package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;

class AppEventReporter$3
  implements Runnable
{
  AppEventReporter$3(AppEventReporter paramAppEventReporter, String paramString) {}
  
  public void run()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("AppEventReporter", "appStartDataSender: 启动上报");
    }
    FinalData localFinalData = AppEventReporter.access$500(this.this$0, this.val$eventKey);
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams(this.val$eventKey, localFinalData.getEventParams());
    }
    FinalDataTarget.handle(null, localFinalData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.3
 * JD-Core Version:    0.7.0.1
 */