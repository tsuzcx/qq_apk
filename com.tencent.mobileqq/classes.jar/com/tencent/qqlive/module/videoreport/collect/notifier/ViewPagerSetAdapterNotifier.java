package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.support.v4.view.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class ViewPagerSetAdapterNotifier
  implements IEventNotifier
{
  private ViewPager mView;
  
  public int getReuseType()
  {
    return 4;
  }
  
  public void init(ViewPager paramViewPager)
  {
    this.mView = paramViewPager;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onSetViewPagerAdapter(this.mView);
  }
  
  public void reset()
  {
    this.mView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.ViewPagerSetAdapterNotifier
 * JD-Core Version:    0.7.0.1
 */