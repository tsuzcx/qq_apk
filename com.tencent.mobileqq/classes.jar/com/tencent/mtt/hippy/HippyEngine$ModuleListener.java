package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.HippyJsException;

public abstract interface HippyEngine$ModuleListener
{
  public abstract void onInitialized(int paramInt, String paramString, HippyRootView paramHippyRootView);
  
  public abstract boolean onJsException(HippyJsException paramHippyJsException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngine.ModuleListener
 * JD-Core Version:    0.7.0.1
 */