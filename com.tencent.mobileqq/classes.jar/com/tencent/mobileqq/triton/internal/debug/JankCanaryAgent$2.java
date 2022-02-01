package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "invoke"}, k=3, mv={1, 1, 16})
final class JankCanaryAgent$2
  extends Lambda
  implements Function1<GetTraceInfoCallback, Unit>
{
  JankCanaryAgent$2(JankCanaryAgent paramJankCanaryAgent, ValueHolder paramValueHolder)
  {
    super(1);
  }
  
  public final void invoke(@Nullable GetTraceInfoCallback paramGetTraceInfoCallback)
  {
    if (paramGetTraceInfoCallback != null)
    {
      this.$getTraceInfoHolder.setValue(null);
      JankCanaryAgent.access$getTraceInfo(this.this$0, paramGetTraceInfoCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.2
 * JD-Core Version:    0.7.0.1
 */