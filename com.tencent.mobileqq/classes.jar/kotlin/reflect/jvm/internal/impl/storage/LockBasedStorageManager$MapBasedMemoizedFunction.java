package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class LockBasedStorageManager$MapBasedMemoizedFunction<K, V>
  implements MemoizedFunctionToNullable<K, V>
{
  private final ConcurrentMap<K, Object> cache;
  private final Function1<? super K, ? extends V> compute;
  private final LockBasedStorageManager storageManager;
  
  public LockBasedStorageManager$MapBasedMemoizedFunction(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull ConcurrentMap<K, Object> paramConcurrentMap, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    this.storageManager = paramLockBasedStorageManager;
    this.cache = paramConcurrentMap;
    this.compute = paramFunction1;
  }
  
  @NotNull
  private AssertionError raceCondition(K paramK, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Race condition detected on input ");
    localStringBuilder.append(paramK);
    localStringBuilder.append(". Old value is ");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(" under ");
    localStringBuilder.append(this.storageManager);
    paramK = (AssertionError)LockBasedStorageManager.access$200(new AssertionError(localStringBuilder.toString()));
    if (paramK == null) {
      $$$reportNull$$$0(4);
    }
    return paramK;
  }
  
  @NotNull
  private AssertionError recursionDetected(K paramK)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recursion detected on input: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append(" under ");
    localStringBuilder.append(this.storageManager);
    paramK = (AssertionError)LockBasedStorageManager.access$200(new AssertionError(localStringBuilder.toString()));
    if (paramK == null) {
      $$$reportNull$$$0(3);
    }
    return paramK;
  }
  
  protected LockBasedStorageManager getStorageManager()
  {
    return this.storageManager;
  }
  
  @Nullable
  public V invoke(K paramK)
  {
    Object localObject1 = this.cache.get(paramK);
    if ((localObject1 != null) && (localObject1 != LockBasedStorageManager.NotValue.COMPUTING)) {
      return WrappedValues.unescapeExceptionOrNull(localObject1);
    }
    this.storageManager.lock.lock();
    try
    {
      localObject1 = this.cache.get(paramK);
      if (localObject1 != LockBasedStorageManager.NotValue.COMPUTING)
      {
        if (localObject1 != null)
        {
          paramK = WrappedValues.unescapeExceptionOrNull(localObject1);
          return paramK;
        }
        AssertionError localAssertionError = null;
        localObject1 = localAssertionError;
        try
        {
          this.cache.put(paramK, LockBasedStorageManager.NotValue.COMPUTING);
          localObject1 = localAssertionError;
          Object localObject2 = this.compute.invoke(paramK);
          localObject1 = localAssertionError;
          Object localObject3 = this.cache.put(paramK, WrappedValues.escapeNull(localObject2));
          localObject1 = localAssertionError;
          LockBasedStorageManager.NotValue localNotValue = LockBasedStorageManager.NotValue.COMPUTING;
          if (localObject3 == localNotValue) {
            return localObject2;
          }
          localObject1 = localAssertionError;
          localAssertionError = raceCondition(paramK, localObject3);
          localObject1 = localAssertionError;
          throw localAssertionError;
        }
        catch (Throwable localThrowable)
        {
          if (!ExceptionUtilsKt.isProcessCanceledException(localThrowable))
          {
            if (localThrowable != localObject1)
            {
              localObject1 = this.cache.put(paramK, WrappedValues.escapeThrowable(localThrowable));
              if (localObject1 != LockBasedStorageManager.NotValue.COMPUTING) {
                throw raceCondition(paramK, localObject1);
              }
              throw LockBasedStorageManager.access$100(this.storageManager).handleException(localThrowable);
            }
            throw LockBasedStorageManager.access$100(this.storageManager).handleException(localThrowable);
          }
          this.cache.remove(paramK);
          throw ((RuntimeException)localThrowable);
        }
      }
      throw recursionDetected(paramK);
    }
    finally
    {
      this.storageManager.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction
 * JD-Core Version:    0.7.0.1
 */