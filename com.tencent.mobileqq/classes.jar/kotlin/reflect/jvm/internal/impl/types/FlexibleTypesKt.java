package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FlexibleTypesKt
{
  @NotNull
  public static final FlexibleType asFlexibleType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$asFlexibleType");
    paramKotlinType = paramKotlinType.unwrap();
    if (paramKotlinType != null) {
      return (FlexibleType)paramKotlinType;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
  }
  
  public static final boolean isFlexible(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isFlexible");
    return paramKotlinType.unwrap() instanceof FlexibleType;
  }
  
  @NotNull
  public static final SimpleType lowerIfFlexible(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$lowerIfFlexible");
    paramKotlinType = paramKotlinType.unwrap();
    if ((paramKotlinType instanceof FlexibleType)) {
      return ((FlexibleType)paramKotlinType).getLowerBound();
    }
    if ((paramKotlinType instanceof SimpleType)) {
      return (SimpleType)paramKotlinType;
    }
    throw new NoWhenBranchMatchedException();
  }
  
  @NotNull
  public static final SimpleType upperIfFlexible(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$upperIfFlexible");
    paramKotlinType = paramKotlinType.unwrap();
    if ((paramKotlinType instanceof FlexibleType)) {
      return ((FlexibleType)paramKotlinType).getUpperBound();
    }
    if ((paramKotlinType instanceof SimpleType)) {
      return (SimpleType)paramKotlinType;
    }
    throw new NoWhenBranchMatchedException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt
 * JD-Core Version:    0.7.0.1
 */