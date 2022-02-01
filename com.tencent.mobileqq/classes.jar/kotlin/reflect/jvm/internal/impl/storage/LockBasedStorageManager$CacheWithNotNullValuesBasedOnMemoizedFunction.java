package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

class LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction<K, V>
  extends LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction<K, V>
  implements CacheWithNotNullValues<K, V>
{
  private LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull ConcurrentMap<LockBasedStorageManager.KeyWithComputation<K, V>, Object> paramConcurrentMap)
  {
    super(paramLockBasedStorageManager, paramConcurrentMap, null);
  }
  
  @NotNull
  public V computeIfAbsent(K paramK, @NotNull Function0<? extends V> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(2);
    }
    paramK = super.computeIfAbsent(paramK, paramFunction0);
    if (paramK == null) {
      $$$reportNull$$$0(3);
    }
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNotNullValuesBasedOnMemoizedFunction
 * JD-Core Version:    0.7.0.1
 */