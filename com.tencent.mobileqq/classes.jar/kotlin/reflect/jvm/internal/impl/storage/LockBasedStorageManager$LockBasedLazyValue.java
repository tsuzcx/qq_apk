package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class LockBasedStorageManager$LockBasedLazyValue<T>
  implements NullableLazyValue<T>
{
  private final Function0<? extends T> computable;
  private final LockBasedStorageManager storageManager;
  @Nullable
  private volatile Object value = LockBasedStorageManager.NotValue.NOT_COMPUTED;
  
  public LockBasedStorageManager$LockBasedLazyValue(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull Function0<? extends T> paramFunction0)
  {
    this.storageManager = paramLockBasedStorageManager;
    this.computable = paramFunction0;
  }
  
  public T invoke()
  {
    Object localObject1 = this.value;
    if (!(localObject1 instanceof LockBasedStorageManager.NotValue)) {
      return WrappedValues.unescapeThrowable(localObject1);
    }
    this.storageManager.lock.lock();
    try
    {
      localObject1 = this.value;
      if (!(localObject1 instanceof LockBasedStorageManager.NotValue)) {
        localObject1 = WrappedValues.unescapeThrowable(localObject1);
      }
      for (;;)
      {
        this.storageManager.lock.unlock();
        return localObject1;
        if (localObject1 == LockBasedStorageManager.NotValue.COMPUTING)
        {
          this.value = LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED;
          LockBasedStorageManager.RecursionDetectedResult localRecursionDetectedResult = recursionDetected(true);
          if (!localRecursionDetectedResult.isFallThrough())
          {
            localObject1 = localRecursionDetectedResult.getValue();
            continue;
          }
        }
        if (localObject1 == LockBasedStorageManager.NotValue.RECURSION_WAS_DETECTED)
        {
          localObject1 = recursionDetected(false);
          if (!((LockBasedStorageManager.RecursionDetectedResult)localObject1).isFallThrough())
          {
            localObject1 = ((LockBasedStorageManager.RecursionDetectedResult)localObject1).getValue();
            continue;
          }
        }
        this.value = LockBasedStorageManager.NotValue.COMPUTING;
        try
        {
          localObject1 = this.computable.invoke();
          postCompute(localObject1);
          this.value = localObject1;
        }
        catch (Throwable localThrowable)
        {
          if (!ExceptionUtilsKt.isProcessCanceledException(localThrowable))
          {
            if (this.value == LockBasedStorageManager.NotValue.COMPUTING) {
              this.value = WrappedValues.escapeThrowable(localThrowable);
            }
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(localThrowable);
          }
          this.value = LockBasedStorageManager.NotValue.NOT_COMPUTED;
          throw ((RuntimeException)localThrowable);
        }
      }
      throw localObject2;
    }
    finally
    {
      this.storageManager.lock.unlock();
    }
    for (;;) {}
  }
  
  public boolean isComputed()
  {
    return (this.value != LockBasedStorageManager.NotValue.NOT_COMPUTED) && (this.value != LockBasedStorageManager.NotValue.COMPUTING);
  }
  
  protected void postCompute(T paramT) {}
  
  @NotNull
  protected LockBasedStorageManager.RecursionDetectedResult<T> recursionDetected(boolean paramBoolean)
  {
    LockBasedStorageManager.RecursionDetectedResult localRecursionDetectedResult = this.storageManager.recursionDetectedDefault();
    if (localRecursionDetectedResult == null) {
      $$$reportNull$$$0(2);
    }
    return localRecursionDetectedResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
 * JD-Core Version:    0.7.0.1
 */