package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract class LockBasedStorageManager$LockBasedLazyValueWithPostCompute<T>
  extends LockBasedStorageManager.LockBasedLazyValue<T>
{
  @Nullable
  private volatile SingleThreadValue<T> valuePostCompute = null;
  
  public LockBasedStorageManager$LockBasedLazyValueWithPostCompute(@NotNull LockBasedStorageManager paramLockBasedStorageManager, @NotNull Function0<? extends T> paramFunction0)
  {
    super(paramLockBasedStorageManager, paramFunction0);
  }
  
  protected abstract void doPostCompute(T paramT);
  
  public T invoke()
  {
    SingleThreadValue localSingleThreadValue = this.valuePostCompute;
    if ((localSingleThreadValue != null) && (localSingleThreadValue.hasValue())) {
      return localSingleThreadValue.getValue();
    }
    return super.invoke();
  }
  
  protected final void postCompute(T paramT)
  {
    this.valuePostCompute = new SingleThreadValue(paramT);
    try
    {
      doPostCompute(paramT);
      return;
    }
    finally
    {
      this.valuePostCompute = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
 * JD-Core Version:    0.7.0.1
 */