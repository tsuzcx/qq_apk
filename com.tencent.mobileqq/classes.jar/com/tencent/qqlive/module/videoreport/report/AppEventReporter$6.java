package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class AppEventReporter$6
  implements ListenerMgr.INotifyCallback<ISessionChangeListener>
{
  AppEventReporter$6(AppEventReporter paramAppEventReporter, SessionChangeReason paramSessionChangeReason) {}
  
  public void onNotify(ISessionChangeListener paramISessionChangeListener)
  {
    paramISessionChangeListener.changeSession(this.val$reason);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.6
 * JD-Core Version:    0.7.0.1
 */