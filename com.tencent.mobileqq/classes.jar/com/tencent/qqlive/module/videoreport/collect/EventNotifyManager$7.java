package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$7
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$7(EventNotifyManager paramEventNotifyManager, Activity paramActivity) {}
  
  public void onNotify(IEventListener paramIEventListener)
  {
    paramIEventListener.onActivityPause(this.val$activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.7
 * JD-Core Version:    0.7.0.1
 */