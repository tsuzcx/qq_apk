package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;

public final class ClassicTypeSystemContextKt
{
  @NotNull
  public static final TypeVariance convertVariance(@NotNull Variance paramVariance)
  {
    Intrinsics.checkParameterIsNotNull(paramVariance, "$this$convertVariance");
    int i = ClassicTypeSystemContextKt.WhenMappings.$EnumSwitchMapping$1[paramVariance.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return TypeVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
      }
      return TypeVariance.IN;
    }
    return TypeVariance.INV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContextKt
 * JD-Core Version:    0.7.0.1
 */