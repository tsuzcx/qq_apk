package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WrappedValues
{
  private static final Object NULL_VALUE = new WrappedValues.1();
  public static volatile boolean throwWrappedProcessCanceledException = false;
  
  @NotNull
  public static <V> Object escapeNull(@Nullable V paramV)
  {
    if (paramV == null)
    {
      paramV = NULL_VALUE;
      if (paramV == null) {
        $$$reportNull$$$0(1);
      }
      return paramV;
    }
    if (paramV == null) {
      $$$reportNull$$$0(2);
    }
    return paramV;
  }
  
  @NotNull
  public static Object escapeThrowable(@NotNull Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      $$$reportNull$$$0(3);
    }
    return new WrappedValues.ThrowableWrapper(paramThrowable, null);
  }
  
  @Nullable
  public static <V> V unescapeExceptionOrNull(@NotNull Object paramObject)
  {
    if (paramObject == null) {
      $$$reportNull$$$0(4);
    }
    return unescapeNull(unescapeThrowable(paramObject));
  }
  
  @Nullable
  public static <V> V unescapeNull(@NotNull Object paramObject)
  {
    if (paramObject == null) {
      $$$reportNull$$$0(0);
    }
    Object localObject = paramObject;
    if (paramObject == NULL_VALUE) {
      localObject = null;
    }
    return localObject;
  }
  
  @Nullable
  public static <V> V unescapeThrowable(@Nullable Object paramObject)
  {
    if ((paramObject instanceof WrappedValues.ThrowableWrapper))
    {
      paramObject = ((WrappedValues.ThrowableWrapper)paramObject).getThrowable();
      if ((throwWrappedProcessCanceledException) && (ExceptionUtilsKt.isProcessCanceledException(paramObject))) {
        throw new WrappedValues.WrappedProcessCanceledException(paramObject);
      }
      throw ExceptionUtilsKt.rethrow(paramObject);
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.WrappedValues
 * JD-Core Version:    0.7.0.1
 */