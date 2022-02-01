package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

class TypeCheckerProcedureCallbacksImpl
  implements TypeCheckingProcedureCallbacks
{
  public boolean assertEqualTypeConstructors(@NotNull TypeConstructor paramTypeConstructor1, @NotNull TypeConstructor paramTypeConstructor2)
  {
    if (paramTypeConstructor1 == null) {
      $$$reportNull$$$0(3);
    }
    if (paramTypeConstructor2 == null) {
      $$$reportNull$$$0(4);
    }
    return paramTypeConstructor1.equals(paramTypeConstructor2);
  }
  
  public boolean assertEqualTypes(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeCheckingProcedure paramTypeCheckingProcedure)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(0);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(1);
    }
    if (paramTypeCheckingProcedure == null) {
      $$$reportNull$$$0(2);
    }
    return paramTypeCheckingProcedure.equalTypes(paramKotlinType1, paramKotlinType2);
  }
  
  public boolean assertSubtype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeCheckingProcedure paramTypeCheckingProcedure)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(5);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(6);
    }
    if (paramTypeCheckingProcedure == null) {
      $$$reportNull$$$0(7);
    }
    return paramTypeCheckingProcedure.isSubtypeOf(paramKotlinType1, paramKotlinType2);
  }
  
  public boolean capture(@NotNull KotlinType paramKotlinType, @NotNull TypeProjection paramTypeProjection)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(8);
    }
    if (paramTypeProjection == null) {
      $$$reportNull$$$0(9);
    }
    return false;
  }
  
  public boolean noCorrespondingSupertype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(10);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(11);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl
 * JD-Core Version:    0.7.0.1
 */