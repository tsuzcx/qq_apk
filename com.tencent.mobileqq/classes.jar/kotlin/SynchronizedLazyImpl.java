package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class SynchronizedLazyImpl<T>
  implements Serializable, Lazy<T>
{
  private volatile Object _value;
  private Function0<? extends T> initializer;
  private final Object lock;
  
  public SynchronizedLazyImpl(@NotNull Function0<? extends T> paramFunction0, @Nullable Object paramObject)
  {
    this.initializer = paramFunction0;
    this._value = UNINITIALIZED_VALUE.INSTANCE;
    if (paramObject != null) {}
    for (;;)
    {
      this.lock = paramObject;
      return;
      paramObject = this;
    }
  }
  
  private final Object writeReplace()
  {
    return new InitializedLazyImpl(getValue());
  }
  
  public T getValue()
  {
    Object localObject1 = this._value;
    if (localObject1 != UNINITIALIZED_VALUE.INSTANCE) {
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this._value;
      UNINITIALIZED_VALUE localUNINITIALIZED_VALUE = UNINITIALIZED_VALUE.INSTANCE;
      if (localObject1 != localUNINITIALIZED_VALUE) {
        return localObject1;
      }
      localObject1 = this.initializer;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((Function0)localObject1).invoke();
      this._value = localObject1;
      this.initializer = ((Function0)null);
    }
  }
  
  public boolean isInitialized()
  {
    return this._value != UNINITIALIZED_VALUE.INSTANCE;
  }
  
  @NotNull
  public String toString()
  {
    if (isInitialized()) {
      return String.valueOf(getValue());
    }
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.SynchronizedLazyImpl
 * JD-Core Version:    0.7.0.1
 */