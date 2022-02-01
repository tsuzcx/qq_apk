package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction<K, V>
  extends LockBasedStorageManager.MapBasedMemoizedFunction<LockBasedStorageManager.KeyWithComputation<K, V>, V>
{
  private LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull ConcurrentMap<LockBasedStorageManager.KeyWithComputation<K, V>, Object> paramConcurrentMap)
  {
    super(paramLockBasedStorageManager, paramConcurrentMap, new LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1());
  }
  
  @Nullable
  public V computeIfAbsent(K paramK, @NotNull Function0<? extends V> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(2);
    }
    return invoke(new LockBasedStorageManager.KeyWithComputation(paramK, paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction
 * JD-Core Version:    0.7.0.1
 */