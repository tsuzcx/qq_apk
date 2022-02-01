package com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDHippy2NativeEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDNative2HippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDHippy2TuWenEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDTuWen2HippyEventReceiver;
import java.util.List;

public abstract interface ITKDHippyEventDispatcher
  extends ITKDHippyEventReceiver, ITKDHippy2NativeEventReceiver, ITKDNative2HippyEventReceiver, ITKDHippy2TuWenEventReceiver, ITKDTuWen2HippyEventReceiver
{
  public abstract void clear();
  
  @NonNull
  public abstract List<ITKDHippyEventReceiver> getAllReceivers();
  
  public abstract void merge(@Nullable ITKDHippyEventDispatcher paramITKDHippyEventDispatcher);
  
  public abstract void register(@Nullable ITKDHippyEventReceiver paramITKDHippyEventReceiver);
  
  public abstract void unregister(@Nullable ITKDHippyEventReceiver paramITKDHippyEventReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher
 * JD-Core Version:    0.7.0.1
 */