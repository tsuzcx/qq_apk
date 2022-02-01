package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import org.jetbrains.annotations.NotNull;

final class OverridingUtil$1
  implements KotlinTypeChecker.TypeConstructorEquality
{
  public boolean equals(@NotNull TypeConstructor paramTypeConstructor1, @NotNull TypeConstructor paramTypeConstructor2)
  {
    if (paramTypeConstructor1 == null) {
      $$$reportNull$$$0(0);
    }
    if (paramTypeConstructor2 == null) {
      $$$reportNull$$$0(1);
    }
    return paramTypeConstructor1.equals(paramTypeConstructor2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.1
 * JD-Core Version:    0.7.0.1
 */