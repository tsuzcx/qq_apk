package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class TypeSubstitutor$1
  implements Function1<FqName, Boolean>
{
  public Boolean invoke(@NotNull FqName paramFqName)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(0);
    }
    return Boolean.valueOf(paramFqName.equals(KotlinBuiltIns.FQ_NAMES.unsafeVariance) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.1
 * JD-Core Version:    0.7.0.1
 */