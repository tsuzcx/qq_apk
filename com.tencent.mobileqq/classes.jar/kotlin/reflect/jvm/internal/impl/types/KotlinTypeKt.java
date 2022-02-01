package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class KotlinTypeKt
{
  public static final boolean isError(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isError");
    paramKotlinType = paramKotlinType.unwrap();
    return ((paramKotlinType instanceof ErrorType)) || (((paramKotlinType instanceof FlexibleType)) && ((((FlexibleType)paramKotlinType).getDelegate() instanceof ErrorType)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt
 * JD-Core Version:    0.7.0.1
 */