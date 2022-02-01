package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$14
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$14(EventNotifyManager paramEventNotifyManager, Activity paramActivity, Dialog paramDialog) {}
  
  public void onNotify(IEventListener paramIEventListener)
  {
    paramIEventListener.onDialogHide(this.val$dialogActivity, this.val$dialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.14
 * JD-Core Version:    0.7.0.1
 */