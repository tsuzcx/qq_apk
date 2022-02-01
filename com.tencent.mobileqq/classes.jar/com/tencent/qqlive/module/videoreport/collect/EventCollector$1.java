package com.tencent.qqlive.module.videoreport.collect;

import android.support.v7.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;

class EventCollector$1
  implements Runnable
{
  EventCollector$1(EventCollector paramEventCollector, RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    RecyclerViewSetAdapterNotifier localRecyclerViewSetAdapterNotifier = (RecyclerViewSetAdapterNotifier)ReusablePool.obtain(2);
    localRecyclerViewSetAdapterNotifier.init(this.val$recyclerView);
    EventCollector.access$200(this.this$0).addEventNotifier(this.val$recyclerView, localRecyclerViewSetAdapterNotifier);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventCollector.1
 * JD-Core Version:    0.7.0.1
 */