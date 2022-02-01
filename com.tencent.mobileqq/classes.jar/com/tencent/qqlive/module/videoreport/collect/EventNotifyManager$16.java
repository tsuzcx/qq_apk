package com.tencent.qqlive.module.videoreport.collect;

import android.view.View;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$16
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$16(EventNotifyManager paramEventNotifyManager, View paramView1, View paramView2) {}
  
  public void a(IEventListener paramIEventListener)
  {
    paramIEventListener.onChildViewAdded(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.16
 * JD-Core Version:    0.7.0.1
 */