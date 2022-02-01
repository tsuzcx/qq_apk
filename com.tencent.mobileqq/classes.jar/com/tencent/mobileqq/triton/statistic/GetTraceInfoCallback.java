package com.tencent.mobileqq.triton.statistic;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "", "onGetTraceInfo", "", "statistics", "Lcom/tencent/mobileqq/triton/statistic/TraceStatistics;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GetTraceInfoCallback
{
  @MainThread
  public abstract void onGetTraceInfo(@NotNull TraceStatistics paramTraceStatistics);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback
 * JD-Core Version:    0.7.0.1
 */