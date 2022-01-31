package com.tencent.plato.sdk.utils.fps;

import android.view.Choreographer;

public class BlockDetectByChoreographer
{
  private static FPSFrameCallback mFrameCallback;
  private static boolean mIsDetect;
  
  public static boolean isDetecting()
  {
    return mIsDetect;
  }
  
  public static void start()
  {
    if (mIsDetect) {
      return;
    }
    mFrameCallback = new FPSFrameCallback(System.nanoTime());
    mIsDetect = true;
    Choreographer.getInstance().postFrameCallback(mFrameCallback);
  }
  
  public static void stop()
  {
    mIsDetect = false;
    Choreographer.getInstance().removeFrameCallback(mFrameCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.fps.BlockDetectByChoreographer
 * JD-Core Version:    0.7.0.1
 */