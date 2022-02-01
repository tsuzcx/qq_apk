package com.tencent.ttpic.openapi.util;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.tencent.ttpic.util.FrameRateUtil.Operation;

@Deprecated
@TargetApi(16)
public class GeneralFpsService
{
  private static GeneralFpsService.FPSFrameCallback fpsFrameCallback;
  private static volatile boolean isStart = false;
  
  public static void addTag(FrameRateUtil.Operation paramOperation)
  {
    try
    {
      if (fpsFrameCallback != null) {
        fpsFrameCallback.addFpsTag(paramOperation);
      }
      return;
    }
    finally
    {
      paramOperation = finally;
      throw paramOperation;
    }
  }
  
  public static void removeTag(FrameRateUtil.Operation paramOperation)
  {
    try
    {
      if (fpsFrameCallback != null) {
        fpsFrameCallback.removeFpsTag(paramOperation);
      }
      return;
    }
    finally
    {
      paramOperation = finally;
      throw paramOperation;
    }
  }
  
  public static void start()
  {
    try
    {
      boolean bool = isStart;
      if (bool) {
        return;
      }
      isStart = true;
      fpsFrameCallback = new GeneralFpsService.FPSFrameCallback(null);
      Choreographer.getInstance().postFrameCallback(fpsFrameCallback);
      return;
    }
    finally {}
  }
  
  public static void stop()
  {
    try
    {
      if (fpsFrameCallback != null)
      {
        fpsFrameCallback.setEnabled(false);
        fpsFrameCallback.clearTags();
      }
      isStart = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.GeneralFpsService
 * JD-Core Version:    0.7.0.1
 */