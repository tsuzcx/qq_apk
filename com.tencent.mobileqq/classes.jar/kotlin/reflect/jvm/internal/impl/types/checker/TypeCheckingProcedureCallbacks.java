package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

public abstract interface TypeCheckingProcedureCallbacks
{
  public abstract boolean assertEqualTypeConstructors(@NotNull TypeConstructor paramTypeConstructor1, @NotNull TypeConstructor paramTypeConstructor2);
  
  public abstract boolean assertEqualTypes(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeCheckingProcedure paramTypeCheckingProcedure);
  
  public abstract boolean assertSubtype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeCheckingProcedure paramTypeCheckingProcedure);
  
  public abstract boolean capture(@NotNull KotlinType paramKotlinType, @NotNull TypeProjection paramTypeProjection);
  
  public abstract boolean noCorrespondingSupertype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
 * JD-Core Version:    0.7.0.1
 */