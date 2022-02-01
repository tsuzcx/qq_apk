package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import org.jetbrains.annotations.NotNull;

class OverridingUtil$3
  implements KotlinTypeChecker.TypeConstructorEquality
{
  OverridingUtil$3(OverridingUtil paramOverridingUtil, Map paramMap) {}
  
  public boolean equals(@NotNull TypeConstructor paramTypeConstructor1, @NotNull TypeConstructor paramTypeConstructor2)
  {
    boolean bool2 = false;
    if (paramTypeConstructor1 == null) {
      $$$reportNull$$$0(0);
    }
    if (paramTypeConstructor2 == null) {
      $$$reportNull$$$0(1);
    }
    if (OverridingUtil.access$000(this.this$0).equals(paramTypeConstructor1, paramTypeConstructor2)) {
      return true;
    }
    TypeConstructor localTypeConstructor1 = (TypeConstructor)this.val$matchingTypeConstructors.get(paramTypeConstructor1);
    TypeConstructor localTypeConstructor2 = (TypeConstructor)this.val$matchingTypeConstructors.get(paramTypeConstructor2);
    boolean bool1;
    if ((localTypeConstructor1 == null) || (!localTypeConstructor1.equals(paramTypeConstructor2)))
    {
      bool1 = bool2;
      if (localTypeConstructor2 != null)
      {
        bool1 = bool2;
        if (!localTypeConstructor2.equals(paramTypeConstructor1)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.3
 * JD-Core Version:    0.7.0.1
 */