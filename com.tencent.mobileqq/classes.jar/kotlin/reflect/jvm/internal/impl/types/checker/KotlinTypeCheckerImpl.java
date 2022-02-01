package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public class KotlinTypeCheckerImpl
  implements KotlinTypeChecker
{
  private final TypeCheckingProcedure procedure;
  
  protected KotlinTypeCheckerImpl(@NotNull TypeCheckingProcedure paramTypeCheckingProcedure)
  {
    this.procedure = paramTypeCheckingProcedure;
  }
  
  @NotNull
  public static KotlinTypeChecker withAxioms(@NotNull KotlinTypeChecker.TypeConstructorEquality paramTypeConstructorEquality)
  {
    if (paramTypeConstructorEquality == null) {
      $$$reportNull$$$0(0);
    }
    return new KotlinTypeCheckerImpl(new TypeCheckingProcedure(new KotlinTypeCheckerImpl.1(paramTypeConstructorEquality)));
  }
  
  public boolean equalTypes(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(4);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(5);
    }
    return this.procedure.equalTypes(paramKotlinType1, paramKotlinType2);
  }
  
  public boolean isSubtypeOf(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(2);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(3);
    }
    return this.procedure.isSubtypeOf(paramKotlinType1, paramKotlinType2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl
 * JD-Core Version:    0.7.0.1
 */