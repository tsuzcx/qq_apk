package kotlin.reflect.jvm.internal;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReflectProperties
{
  @NotNull
  public static <T> ReflectProperties.LazyVal<T> lazy(@NotNull Function0<T> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(0);
    }
    return new ReflectProperties.LazyVal(paramFunction0);
  }
  
  @NotNull
  public static <T> ReflectProperties.LazySoftVal<T> lazySoft(@Nullable T paramT, @NotNull Function0<T> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(1);
    }
    return new ReflectProperties.LazySoftVal(paramT, paramFunction0);
  }
  
  @NotNull
  public static <T> ReflectProperties.LazySoftVal<T> lazySoft(@NotNull Function0<T> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(2);
    }
    return lazySoft(null, paramFunction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectProperties
 * JD-Core Version:    0.7.0.1
 */