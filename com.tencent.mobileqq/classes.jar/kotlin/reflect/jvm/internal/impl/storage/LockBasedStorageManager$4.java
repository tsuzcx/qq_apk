package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

class LockBasedStorageManager$4
  extends LockBasedStorageManager.LockBasedNotNullLazyValueWithPostCompute<T>
{
  LockBasedStorageManager$4(LockBasedStorageManager paramLockBasedStorageManager1, LockBasedStorageManager paramLockBasedStorageManager2, Function0 paramFunction0, Function1 paramFunction11, Function1 paramFunction12)
  {
    super(paramLockBasedStorageManager2, paramFunction0);
  }
  
  protected void doPostCompute(@NotNull T paramT)
  {
    if (paramT == null) {
      $$$reportNull$$$0(2);
    }
    this.val$postCompute.invoke(paramT);
  }
  
  @NotNull
  protected LockBasedStorageManager.RecursionDetectedResult<T> recursionDetected(boolean paramBoolean)
  {
    Object localObject = this.val$onRecursiveCall;
    if (localObject == null)
    {
      localObject = super.recursionDetected(paramBoolean);
      if (localObject == null) {
        $$$reportNull$$$0(0);
      }
      return localObject;
    }
    localObject = LockBasedStorageManager.RecursionDetectedResult.value(((Function1)localObject).invoke(Boolean.valueOf(paramBoolean)));
    if (localObject == null) {
      $$$reportNull$$$0(1);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
 * JD-Core Version:    0.7.0.1
 */