package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import org.jetbrains.annotations.NotNull;

final class LockBasedStorageManager$ExceptionHandlingStrategy$1
  implements LockBasedStorageManager.ExceptionHandlingStrategy
{
  @NotNull
  public RuntimeException handleException(@NotNull Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      $$$reportNull$$$0(0);
    }
    throw ExceptionUtilsKt.rethrow(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
 * JD-Core Version:    0.7.0.1
 */