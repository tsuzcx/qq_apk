package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.support.v7.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public class RecyclerViewSetAdapterNotifier
  implements IEventNotifier
{
  private RecyclerView mView;
  
  public int getReuseType()
  {
    return 2;
  }
  
  public void init(RecyclerView paramRecyclerView)
  {
    this.mView = paramRecyclerView;
  }
  
  public void notifyEvent(IEventListener paramIEventListener)
  {
    paramIEventListener.onSetRecyclerViewAdapter(this.mView);
  }
  
  public void reset()
  {
    this.mView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewSetAdapterNotifier
 * JD-Core Version:    0.7.0.1
 */