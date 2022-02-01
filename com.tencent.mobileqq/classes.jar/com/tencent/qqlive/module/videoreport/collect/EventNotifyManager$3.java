package com.tencent.qqlive.module.videoreport.collect;

import com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$3
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$3(EventNotifyManager paramEventNotifyManager, IEventNotifier paramIEventNotifier) {}
  
  public void onNotify(IEventListener paramIEventListener)
  {
    this.val$notifier.notifyEvent(paramIEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.3
 * JD-Core Version:    0.7.0.1
 */