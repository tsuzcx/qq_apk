package com.tencent.mobileqq.triton.internal.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getValue", "T", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Triton_release"}, k=2, mv={1, 1, 16})
public final class ValueHolderKt
{
  public static final <T> T getValue(@NotNull ValueHolder<T> paramValueHolder, @Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramValueHolder, "$this$getValue");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    return paramValueHolder.getValue();
  }
  
  public static final <T> void setValue(@NotNull ValueHolder<T> paramValueHolder, @Nullable Object paramObject, @NotNull KProperty<?> paramKProperty, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramValueHolder, "$this$setValue");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramValueHolder.setValue(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.lifecycle.ValueHolderKt
 * JD-Core Version:    0.7.0.1
 */