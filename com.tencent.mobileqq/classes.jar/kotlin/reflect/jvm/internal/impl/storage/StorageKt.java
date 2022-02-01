package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StorageKt
{
  @NotNull
  public static final <T> T getValue(@NotNull NotNullLazyValue<? extends T> paramNotNullLazyValue, @Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramNotNullLazyValue, "$this$getValue");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "p");
    return paramNotNullLazyValue.invoke();
  }
  
  @Nullable
  public static final <T> T getValue(@NotNull NullableLazyValue<? extends T> paramNullableLazyValue, @Nullable Object paramObject, @NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramNullableLazyValue, "$this$getValue");
    Intrinsics.checkParameterIsNotNull(paramKProperty, "p");
    return paramNullableLazyValue.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.StorageKt
 * JD-Core Version:    0.7.0.1
 */