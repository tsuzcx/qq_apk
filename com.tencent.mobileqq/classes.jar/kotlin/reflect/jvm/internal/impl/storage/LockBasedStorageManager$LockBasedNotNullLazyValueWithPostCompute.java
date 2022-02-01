package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

abstract class LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute<T>
  extends LockBasedStorageManager.LockBasedLazyValueWithPostCompute<T>
  implements NotNullLazyValue<T>
{
  public LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull Function0<? extends T> paramFunction0)
  {
    super(paramLockBasedStorageManager, paramFunction0);
  }
  
  @NotNull
  public T invoke()
  {
    Object localObject = super.invoke();
    if (localObject == null) {
      $$$reportNull$$$0(2);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedNotNullLazyValueWithPostCompute
 * JD-Core Version:    0.7.0.1
 */