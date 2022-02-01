package com.tencent.qqlive.module.videoreport.collect;

import android.support.v4.view.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewPagerSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;

class EventCollector$2
  implements Runnable
{
  EventCollector$2(EventCollector paramEventCollector, ViewPager paramViewPager) {}
  
  public void run()
  {
    ViewPagerSetAdapterNotifier localViewPagerSetAdapterNotifier = (ViewPagerSetAdapterNotifier)ReusablePool.obtain(4);
    localViewPagerSetAdapterNotifier.init(this.val$viewPager);
    EventCollector.access$200(this.this$0).addEventNotifier(this.val$viewPager, localViewPagerSetAdapterNotifier);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventCollector.2
 * JD-Core Version:    0.7.0.1
 */