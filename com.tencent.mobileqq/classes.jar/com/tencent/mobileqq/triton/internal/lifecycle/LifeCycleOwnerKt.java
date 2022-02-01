package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"observe", "", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "owner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "Triton_release"}, k=2, mv={1, 1, 16})
public final class LifeCycleOwnerKt
{
  public static final void observe(@NotNull LifeCycle paramLifeCycle, @NotNull LifeCycleOwner paramLifeCycleOwner)
  {
    Intrinsics.checkParameterIsNotNull(paramLifeCycle, "$this$observe");
    Intrinsics.checkParameterIsNotNull(paramLifeCycleOwner, "owner");
    paramLifeCycleOwner.observeLifeCycle(paramLifeCycle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwnerKt
 * JD-Core Version:    0.7.0.1
 */