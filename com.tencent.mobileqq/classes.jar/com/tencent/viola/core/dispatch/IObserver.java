package com.tencent.viola.core.dispatch;

public abstract interface IObserver
{
  public abstract String getRef();
  
  public abstract void onReceive(IEvent paramIEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.core.dispatch.IObserver
 * JD-Core Version:    0.7.0.1
 */