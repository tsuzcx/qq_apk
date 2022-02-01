package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class JankCanaryAgent$getTraceInfo$1$1
  implements Runnable
{
  JankCanaryAgent$getTraceInfo$1$1(JankCanaryAgent.getTraceInfo.1 param1, TraceStatistics paramTraceStatistics) {}
  
  public final void run()
  {
    this.this$0.$callback.onGetTraceInfo(this.$statistics);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.getTraceInfo.1.1
 * JD-Core Version:    0.7.0.1
 */