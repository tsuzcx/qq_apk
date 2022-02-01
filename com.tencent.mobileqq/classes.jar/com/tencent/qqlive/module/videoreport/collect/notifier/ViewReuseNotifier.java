package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class ViewReuseNotifier
  implements IEventNotifier
{
  private long mItemId = -1L;
  private ViewGroup mParentView;
  private View mView;
  
  public int getReuseType()
  {
    return 5;
  }
  
  public void init(ViewGroup paramViewGroup, View paramView, long paramLong)
  {
    this.mParentView = paramViewGroup;
    this.mView = paramView;
    this.mItemId = paramLong;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onViewReused(this.mParentView, this.mView, this.mItemId);
  }
  
  public void reset()
  {
    this.mParentView = null;
    this.mView = null;
    this.mItemId = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.ViewReuseNotifier
 * JD-Core Version:    0.7.0.1
 */