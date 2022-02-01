package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

class LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction$1
  implements Function1<LockBasedStorageManager.KeyWithComputation<K, V>, V>
{
  public V invoke(LockBasedStorageManager.KeyWithComputation<K, V> paramKeyWithComputation)
  {
    return LockBasedStorageManager.KeyWithComputation.access$400(paramKeyWithComputation).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
 * JD-Core Version:    0.7.0.1
 */