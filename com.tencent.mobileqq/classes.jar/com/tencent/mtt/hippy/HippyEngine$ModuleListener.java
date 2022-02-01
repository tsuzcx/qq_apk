package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.HippyJsException;

public abstract interface HippyEngine$ModuleListener
{
  public abstract boolean onJsException(HippyJsException paramHippyJsException);
  
  public abstract void onLoadCompleted(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngine.ModuleListener
 * JD-Core Version:    0.7.0.1
 */