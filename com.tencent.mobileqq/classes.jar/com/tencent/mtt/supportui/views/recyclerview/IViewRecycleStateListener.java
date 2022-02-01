package com.tencent.mtt.supportui.views.recyclerview;

public abstract interface IViewRecycleStateListener
{
  public static final int NOTIFY_ON_RECYCLE = 2;
  public static final int NOTIFY_ON_USE = 1;
  
  public abstract void onRecycle();
  
  public abstract void onUse();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.IViewRecycleStateListener
 * JD-Core Version:    0.7.0.1
 */