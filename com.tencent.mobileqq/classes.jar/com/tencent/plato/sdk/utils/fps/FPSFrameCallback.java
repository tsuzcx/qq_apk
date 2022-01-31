package com.tencent.plato.sdk.utils.fps;

import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

class FPSFrameCallback
  implements Choreographer.FrameCallback
{
  private static final String TAG = "FPSFrameCallback";
  private static final float deviceRefreshRateMs = 16.6F;
  private static long mFrameIntervalNanos = 16666666L;
  private static long mLastFrameTimeNanos = 0L;
  
  FPSFrameCallback(long paramLong)
  {
    mLastFrameTimeNanos = paramLong;
  }
  
  private int skipFrameCount(long paramLong1, long paramLong2, float paramFloat)
  {
    int i = 0;
    paramLong1 = Math.round((float)(paramLong2 - paramLong1) / 1000000.0F);
    paramLong2 = Math.round(paramFloat);
    if (paramLong1 > paramLong2) {
      i = (int)(paramLong1 / paramLong2);
    }
    return i;
  }
  
  public void doFrame(long paramLong)
  {
    if (mLastFrameTimeNanos == 0L)
    {
      mLastFrameTimeNanos = paramLong;
      Choreographer.getInstance().postFrameCallback(this);
      return;
    }
    float f = (float)(paramLong - mLastFrameTimeNanos) / 1000000.0F;
    int i = skipFrameCount(mLastFrameTimeNanos, paramLong, 16.6F);
    if (i >= 3) {
      Log.e("FPSFrameCallback", "帧隔时间：" + f + " skipFrameCount：" + i + "");
    }
    mLastFrameTimeNanos = paramLong;
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.fps.FPSFrameCallback
 * JD-Core Version:    0.7.0.1
 */