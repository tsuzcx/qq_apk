package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class ViewClickNotifier
  implements IEventNotifier
{
  private View mView;
  
  public int getReuseType()
  {
    return 3;
  }
  
  public void init(View paramView)
  {
    this.mView = paramView;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onViewClick(this.mView);
  }
  
  public void reset()
  {
    this.mView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.ViewClickNotifier
 * JD-Core Version:    0.7.0.1
 */