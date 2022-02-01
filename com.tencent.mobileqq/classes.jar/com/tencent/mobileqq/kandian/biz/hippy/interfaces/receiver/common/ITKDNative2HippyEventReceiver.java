package com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mtt.hippy.common.HippyMap;

public abstract interface ITKDNative2HippyEventReceiver
  extends ITKDHippyEventReceiver
{
  public abstract void jsCloseComment();
  
  public abstract void onFontScaleChange(double paramDouble);
  
  public abstract void refreshNewAndHotData(HippyMap paramHippyMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDNative2HippyEventReceiver
 * JD-Core Version:    0.7.0.1
 */