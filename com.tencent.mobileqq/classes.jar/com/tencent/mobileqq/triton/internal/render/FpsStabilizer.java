package com.tencent.mobileqq.triton.internal.render;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/FpsStabilizer;", "", "()V", "accumulateStartTimeNanos", "", "accumulatedFrames", "", "fpsIntervalNanos", "", "setTargetFps", "", "fps", "", "shouldDoFrame", "", "drawingTimeNanos", "Triton_release"}, k=1, mv={1, 1, 16})
public final class FpsStabilizer
{
  private volatile long accumulateStartTimeNanos = -1000L;
  private int accumulatedFrames;
  private volatile double fpsIntervalNanos;
  
  public final void setTargetFps(float paramFloat)
  {
    double d1;
    if (paramFloat <= 0)
    {
      d1 = 0.0D;
    }
    else
    {
      d1 = TimeUnit.SECONDS.toNanos(1L);
      double d2 = paramFloat;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
    }
    this.fpsIntervalNanos = d1;
    this.accumulateStartTimeNanos = 0L;
  }
  
  public final boolean shouldDoFrame(long paramLong)
  {
    double d1 = this.fpsIntervalNanos;
    boolean bool2 = true;
    boolean bool1 = true;
    if (d1 != 0.0D)
    {
      if (paramLong <= 0L) {
        return true;
      }
      long l = paramLong - this.accumulateStartTimeNanos;
      d1 = l;
      double d2 = this.fpsIntervalNanos;
      Double.isNaN(d1);
      d1 /= d2;
      int i = this.accumulatedFrames;
      if (d1 >= i) {
        this.accumulatedFrames = (i + 1);
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (l > TimeUnit.SECONDS.toNanos(1L))
      {
        this.accumulateStartTimeNanos = paramLong;
        this.accumulatedFrames = 0;
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.FpsStabilizer
 * JD-Core Version:    0.7.0.1
 */