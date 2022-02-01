package com.tencent.mtt.hippy;

public abstract interface HippyInstanceLifecycleEventListener
{
  public abstract void onInstanceDestroy(int paramInt);
  
  public abstract void onInstanceLoad(int paramInt);
  
  public abstract void onInstancePause(int paramInt);
  
  public abstract void onInstanceResume(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
 * JD-Core Version:    0.7.0.1
 */