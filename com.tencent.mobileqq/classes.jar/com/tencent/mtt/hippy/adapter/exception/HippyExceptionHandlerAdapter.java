package com.tencent.mtt.hippy.adapter.exception;

import com.tencent.mtt.hippy.common.HippyJsException;

public abstract interface HippyExceptionHandlerAdapter
{
  public abstract void handleBackgroundTracing(String paramString);
  
  public abstract void handleJsException(HippyJsException paramHippyJsException);
  
  public abstract void handleNativeException(Exception paramException, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
 * JD-Core Version:    0.7.0.1
 */