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
    if (paramFloat <= 0) {}
    for (double d = 0.0D;; d = TimeUnit.SECONDS.toNanos(1L) / paramFloat)
    {
      this.fpsIntervalNanos = d;
      this.accumulateStartTimeNanos = 0L;
      return;
    }
  }
  
  public final boolean shouldDoFrame(long paramLong)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (this.fpsIntervalNanos != 0.0D)
    {
      if (paramLong <= 0L) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    long l = paramLong - this.accumulateStartTimeNanos;
    if (l / this.fpsIntervalNanos >= this.accumulatedFrames) {
      this.accumulatedFrames += 1;
    }
    for (bool1 = bool3;; bool1 = false)
    {
      bool2 = bool1;
      if (l <= TimeUnit.SECONDS.toNanos(1L)) {
        break;
      }
      this.accumulateStartTimeNanos = paramLong;
      this.accumulatedFrames = 0;
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.FpsStabilizer
 * JD-Core Version:    0.7.0.1
 */