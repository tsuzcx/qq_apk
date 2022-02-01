package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

class AppEventReporter$2
  implements Runnable
{
  AppEventReporter$2(AppEventReporter paramAppEventReporter) {}
  
  public void run()
  {
    if (AppEventReporter.access$100(this.this$0) == 0)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("AppEventReporter", "满足条件，补充appOut事件");
      }
      AppEventReporter.access$200(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.2
 * JD-Core Version:    0.7.0.1
 */