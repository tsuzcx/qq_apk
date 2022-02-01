package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

final class KotlinTypeCheckerImpl$1
  extends TypeCheckerProcedureCallbacksImpl
{
  KotlinTypeCheckerImpl$1(KotlinTypeChecker.TypeConstructorEquality paramTypeConstructorEquality) {}
  
  public boolean assertEqualTypeConstructors(@NotNull TypeConstructor paramTypeConstructor1, @NotNull TypeConstructor paramTypeConstructor2)
  {
    boolean bool = false;
    if (paramTypeConstructor1 == null) {
      $$$reportNull$$$0(0);
    }
    if (paramTypeConstructor2 == null) {
      $$$reportNull$$$0(1);
    }
    if ((paramTypeConstructor1.equals(paramTypeConstructor2)) || (this.val$equalityAxioms.equals(paramTypeConstructor1, paramTypeConstructor2))) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl.1
 * JD-Core Version:    0.7.0.1
 */