package com.tencent.mobileqq.triton.internal.debug;

import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/debug/JankCanaryAgent$Companion;", "", "()V", "nativeGetBriefTraceInfo", "", "nativeInstancePointer", "", "objClass", "Ljava/lang/Class;", "(JLjava/lang/Class;)[Ljava/lang/Object;", "nativeSetJankTraceLevel", "", "jankTraceLevel", "", "toJankTraceLevel", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "toNative", "Triton_release"}, k=1, mv={1, 1, 16})
public final class JankCanaryAgent$Companion
{
  @JvmStatic
  private final Object[] nativeGetBriefTraceInfo(long paramLong, Class<Object> paramClass)
  {
    return JankCanaryAgent.access$nativeGetBriefTraceInfo(paramLong, paramClass);
  }
  
  @JvmStatic
  private final void nativeSetJankTraceLevel(long paramLong, int paramInt)
  {
    JankCanaryAgent.access$nativeSetJankTraceLevel(paramLong, paramInt);
  }
  
  private final JankTraceLevel toJankTraceLevel(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return JankTraceLevel.NONE;
      }
      return JankTraceLevel.BRIEF;
    }
    return JankTraceLevel.DETAIL;
  }
  
  private final int toNative(@NotNull JankTraceLevel paramJankTraceLevel)
  {
    int i = JankCanaryAgent.Companion.WhenMappings.$EnumSwitchMapping$0[paramJankTraceLevel.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return 2;
        }
        throw new NoWhenBranchMatchedException();
      }
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent.Companion
 * JD-Core Version:    0.7.0.1
 */