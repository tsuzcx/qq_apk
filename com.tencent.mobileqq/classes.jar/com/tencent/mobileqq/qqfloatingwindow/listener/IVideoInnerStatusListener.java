package com.tencent.mobileqq.qqfloatingwindow.listener;

public abstract interface IVideoInnerStatusListener
{
  public abstract void notifyVideoClose(int paramInt);
  
  public abstract void notifyVideoSeek(int paramInt);
  
  public abstract void notifyVideoStart();
  
  public abstract void notifyVideoStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
 * JD-Core Version:    0.7.0.1
 */