package com.tencent.mobileqq.triton.statistic;

import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "", "onFrameBegin", "", "frameTimeNanos", "", "firstFrame", "", "onFrameEnd", "frameDurationNanos", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface FrameCallback
{
  @WorkerThread
  public abstract void onFrameBegin(long paramLong, boolean paramBoolean);
  
  @WorkerThread
  public abstract void onFrameEnd(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.FrameCallback
 * JD-Core Version:    0.7.0.1
 */