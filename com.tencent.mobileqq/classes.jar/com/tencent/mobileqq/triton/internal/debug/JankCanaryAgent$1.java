package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "invoke"}, k=3, mv={1, 1, 16})
final class JankCanaryAgent$1
  extends Lambda
  implements Function1<JankTraceLevel, Unit>
{
  JankCanaryAgent$1(JankCanaryAgent paramJankCanaryAgent)
  {
    super(1);
  }
  
  public final void invoke(@NotNull JankTraceLevel paramJankTraceLevel)
  {
    Intrinsics.checkParameterIsNotNull(paramJankTraceLevel, "it");
    JankCanaryAgent.Companion.access$nativeSetJankTraceLevel(JankCanaryAgent.Companion, JankCanaryAgent.access$getNativeInstancePointer$p(this.this$0), JankCanaryAgent.Companion.access$toNative(JankCanaryAgent.Companion, paramJankTraceLevel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.1
 * JD-Core Version:    0.7.0.1
 */