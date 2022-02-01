package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class AppEventReporter$4
  implements ListenerMgr.INotifyCallback<AppEventReporter.IAppEventListener>
{
  AppEventReporter$4(AppEventReporter paramAppEventReporter) {}
  
  public void onNotify(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    paramIAppEventListener.onAppIn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.4
 * JD-Core Version:    0.7.0.1
 */