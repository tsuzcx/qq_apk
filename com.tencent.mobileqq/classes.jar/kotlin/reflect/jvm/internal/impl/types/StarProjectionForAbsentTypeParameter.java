package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class StarProjectionForAbsentTypeParameter
  extends TypeProjectionBase
{
  private final KotlinType nullableAnyType;
  
  public StarProjectionForAbsentTypeParameter(@NotNull KotlinBuiltIns paramKotlinBuiltIns)
  {
    paramKotlinBuiltIns = paramKotlinBuiltIns.getNullableAnyType();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinBuiltIns, "kotlinBuiltIns.nullableAnyType");
    this.nullableAnyType = ((KotlinType)paramKotlinBuiltIns);
  }
  
  @NotNull
  public Variance getProjectionKind()
  {
    return Variance.OUT_VARIANCE;
  }
  
  @NotNull
  public KotlinType getType()
  {
    return this.nullableAnyType;
  }
  
  public boolean isStarProjection()
  {
    return true;
  }
  
  @NotNull
  public TypeProjection refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return (TypeProjection)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter
 * JD-Core Version:    0.7.0.1
 */