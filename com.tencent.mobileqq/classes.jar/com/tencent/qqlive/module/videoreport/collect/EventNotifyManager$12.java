package com.tencent.qqlive.module.videoreport.collect;

import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$12
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$12(EventNotifyManager paramEventNotifyManager, FragmentCompat paramFragmentCompat) {}
  
  public void onNotify(IEventListener paramIEventListener)
  {
    paramIEventListener.onFragmentDestroyView(this.val$fragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.12
 * JD-Core Version:    0.7.0.1
 */