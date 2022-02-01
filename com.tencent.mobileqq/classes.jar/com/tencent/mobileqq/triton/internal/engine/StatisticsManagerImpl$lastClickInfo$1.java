package com.tencent.mobileqq.triton.internal.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class StatisticsManagerImpl$lastClickInfo$1
  extends Lambda
  implements Function1<String, Unit>
{
  StatisticsManagerImpl$lastClickInfo$1(Ref.ObjectRef paramObjectRef)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    this.$clickInfo.element = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl.lastClickInfo.1
 * JD-Core Version:    0.7.0.1
 */