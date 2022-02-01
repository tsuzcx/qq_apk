package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

class LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull<K, V>
  extends LockBasedStorageManager.MapBasedMemoizedFunction<K, V>
  implements MemoizedFunctionToNotNull<K, V>
{
  public LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull ConcurrentMap<K, Object> paramConcurrentMap, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    super(paramLockBasedStorageManager, paramConcurrentMap, paramFunction1);
  }
  
  @NotNull
  public V invoke(K paramK)
  {
    paramK = super.invoke(paramK);
    if (paramK == null) {
      $$$reportNull$$$0(3);
    }
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunctionToNotNull
 * JD-Core Version:    0.7.0.1
 */