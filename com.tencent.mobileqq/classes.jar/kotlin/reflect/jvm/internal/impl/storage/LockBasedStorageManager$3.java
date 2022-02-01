package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

class LockBasedStorageManager$3
  extends LockBasedStorageManager.LockBasedNotNullLazyValue<T>
{
  LockBasedStorageManager$3(LockBasedStorageManager paramLockBasedStorageManager1, LockBasedStorageManager paramLockBasedStorageManager2, Function0 paramFunction0, Object paramObject)
  {
    super(paramLockBasedStorageManager2, paramFunction0);
  }
  
  @NotNull
  protected LockBasedStorageManager.RecursionDetectedResult<T> recursionDetected(boolean paramBoolean)
  {
    LockBasedStorageManager.RecursionDetectedResult localRecursionDetectedResult = LockBasedStorageManager.RecursionDetectedResult.value(this.val$onRecursiveCall);
    if (localRecursionDetectedResult == null) {
      $$$reportNull$$$0(0);
    }
    return localRecursionDetectedResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.3
 * JD-Core Version:    0.7.0.1
 */