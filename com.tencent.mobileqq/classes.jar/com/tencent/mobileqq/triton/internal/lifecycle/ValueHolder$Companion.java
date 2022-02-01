package com.tencent.mobileqq.triton.internal.lifecycle;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder$Companion;", "", "()V", "just", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "T", "initialValue", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ValueHolder$Companion
{
  @NotNull
  public final <T> ValueHolder<T> just(T paramT)
  {
    return new ValueHolder(paramT, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder.Companion
 * JD-Core Version:    0.7.0.1
 */