package com.tencent.qqlive.module.videoreport.collect.notifier;

import com.tencent.qqlive.module.videoreport.collect.IEventListener;

public abstract interface IEventNotifier
{
  public abstract int getReuseType();
  
  public abstract void notifyEvent(IEventListener paramIEventListener);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
 * JD-Core Version:    0.7.0.1
 */