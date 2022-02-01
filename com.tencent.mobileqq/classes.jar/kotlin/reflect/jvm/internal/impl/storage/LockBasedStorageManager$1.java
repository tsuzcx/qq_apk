package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import org.jetbrains.annotations.NotNull;

final class LockBasedStorageManager$1
  extends LockBasedStorageManager
{
  LockBasedStorageManager$1(String paramString, LockBasedStorageManager.ExceptionHandlingStrategy paramExceptionHandlingStrategy, Lock paramLock)
  {
    super(paramString, paramExceptionHandlingStrategy, paramLock, null);
  }
  
  @NotNull
  protected <T> LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedDefault()
  {
    LockBasedStorageManager.RecursionDetectedResult localRecursionDetectedResult = LockBasedStorageManager.RecursionDetectedResult.fallThrough();
    if (localRecursionDetectedResult == null) {
      $$$reportNull$$$0(0);
    }
    return localRecursionDetectedResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
 * JD-Core Version:    0.7.0.1
 */