package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeWithEnhancementKt
{
  @Nullable
  public static final KotlinType getEnhancement(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getEnhancement");
    if ((paramKotlinType instanceof TypeWithEnhancement)) {
      return ((TypeWithEnhancement)paramKotlinType).getEnhancement();
    }
    return null;
  }
  
  @NotNull
  public static final UnwrappedType inheritEnhancement(@NotNull UnwrappedType paramUnwrappedType, @NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "$this$inheritEnhancement");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "origin");
    return wrapEnhancement(paramUnwrappedType, getEnhancement(paramKotlinType));
  }
  
  @NotNull
  public static final KotlinType unwrapEnhancement(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$unwrapEnhancement");
    KotlinType localKotlinType = getEnhancement(paramKotlinType);
    if (localKotlinType != null) {
      paramKotlinType = localKotlinType;
    }
    return paramKotlinType;
  }
  
  @NotNull
  public static final UnwrappedType wrapEnhancement(@NotNull UnwrappedType paramUnwrappedType, @Nullable KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "$this$wrapEnhancement");
    if (paramKotlinType == null) {
      return paramUnwrappedType;
    }
    if ((paramUnwrappedType instanceof SimpleType)) {
      return (UnwrappedType)new SimpleTypeWithEnhancement((SimpleType)paramUnwrappedType, paramKotlinType);
    }
    if ((paramUnwrappedType instanceof FlexibleType)) {
      return (UnwrappedType)new FlexibleTypeWithEnhancement((FlexibleType)paramUnwrappedType, paramKotlinType);
    }
    throw new NoWhenBranchMatchedException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt
 * JD-Core Version:    0.7.0.1
 */