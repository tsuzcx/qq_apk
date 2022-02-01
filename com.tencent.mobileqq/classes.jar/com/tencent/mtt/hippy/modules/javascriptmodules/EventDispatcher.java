package com.tencent.mtt.hippy.modules.javascriptmodules;

import com.tencent.mtt.hippy.common.HippyMap;

public abstract interface EventDispatcher
  extends HippyJavaScriptModule
{
  public abstract void receiveNativeEvent(String paramString, Object paramObject);
  
  public abstract void receiveNativeGesture(HippyMap paramHippyMap);
  
  public abstract void receiveUIComponentEvent(int paramInt, String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */