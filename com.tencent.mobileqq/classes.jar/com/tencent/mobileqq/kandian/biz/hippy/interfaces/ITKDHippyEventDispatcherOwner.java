package com.tencent.mobileqq.kandian.biz.hippy.interfaces;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;

public abstract interface ITKDHippyEventDispatcherOwner
{
  @NonNull
  public abstract ITKDHippyEventDispatcher getTKDHippyEventDispatcher();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner
 * JD-Core Version:    0.7.0.1
 */