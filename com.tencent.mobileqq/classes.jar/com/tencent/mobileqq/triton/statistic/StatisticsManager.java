package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "", "accumulatedDrawCalls", "", "getAccumulatedDrawCalls", "()J", "accumulatedFrames", "getAccumulatedFrames", "currentDrawCalls", "getCurrentDrawCalls", "currentFPS", "", "getCurrentFPS", "()F", "jankTraceLevel", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "getJankTraceLevel", "()Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "setJankTraceLevel", "(Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;)V", "lastBlackScreenTimeMillis", "getLastBlackScreenTimeMillis", "lastClickInfo", "", "getLastClickInfo", "()Ljava/lang/String;", "lastClicks", "getLastClicks", "targetFPS", "getTargetFPS", "getTraceInfo", "", "callback", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "setErrorCallback", "errorCallback", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "setFrameCallback", "frameCallback", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "setSubpackageLoadStatisticsCallback", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface StatisticsManager
{
  public abstract long getAccumulatedDrawCalls();
  
  public abstract long getAccumulatedFrames();
  
  public abstract long getCurrentDrawCalls();
  
  public abstract float getCurrentFPS();
  
  @NotNull
  public abstract JankTraceLevel getJankTraceLevel();
  
  public abstract long getLastBlackScreenTimeMillis();
  
  @NotNull
  public abstract String getLastClickInfo();
  
  @NotNull
  public abstract String getLastClicks();
  
  public abstract float getTargetFPS();
  
  public abstract void getTraceInfo(@NotNull GetTraceInfoCallback paramGetTraceInfoCallback);
  
  public abstract void setErrorCallback(@Nullable ErrorCallback paramErrorCallback);
  
  public abstract void setFrameCallback(@Nullable FrameCallback paramFrameCallback);
  
  public abstract void setJankTraceLevel(@NotNull JankTraceLevel paramJankTraceLevel);
  
  public abstract void setSubpackageLoadStatisticsCallback(@NotNull SubpackageLoadStatisticsCallback paramSubpackageLoadStatisticsCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.StatisticsManager
 * JD-Core Version:    0.7.0.1
 */