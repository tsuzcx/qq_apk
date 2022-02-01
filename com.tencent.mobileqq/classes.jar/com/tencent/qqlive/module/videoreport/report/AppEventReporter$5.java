package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class AppEventReporter$5
  implements ListenerMgr.INotifyCallback<AppEventReporter.IAppEventListener>
{
  AppEventReporter$5(AppEventReporter paramAppEventReporter) {}
  
  public void onNotify(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    paramIAppEventListener.onAppOut(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.5
 * JD-Core Version:    0.7.0.1
 */