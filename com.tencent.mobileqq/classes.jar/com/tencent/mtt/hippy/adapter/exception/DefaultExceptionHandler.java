package com.tencent.mtt.hippy.adapter.exception;

import com.tencent.mtt.hippy.common.HippyJsException;

public class DefaultExceptionHandler
  implements HippyExceptionHandlerAdapter
{
  public void handleBackgroundTracing(String paramString) {}
  
  public void handleJsException(HippyJsException paramHippyJsException) {}
  
  public void handleNativeException(Exception paramException, boolean paramBoolean)
  {
    if (paramException != null) {
      paramException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.exception.DefaultExceptionHandler
 * JD-Core Version:    0.7.0.1
 */