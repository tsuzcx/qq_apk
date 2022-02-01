package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ExceptionUtilsKt
{
  public static final boolean isProcessCanceledException(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "$this$isProcessCanceledException");
    paramThrowable = paramThrowable.getClass();
    do
    {
      if (Intrinsics.areEqual(paramThrowable.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
        return true;
      }
      paramThrowable = paramThrowable.getSuperclass();
    } while (paramThrowable != null);
    return false;
  }
  
  @NotNull
  public static final RuntimeException rethrow(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "e");
    throw paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt
 * JD-Core Version:    0.7.0.1
 */