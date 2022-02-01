package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class SafePublicationLazyImpl<T>
  implements Serializable, Lazy<T>
{
  public static final SafePublicationLazyImpl.Companion Companion = new SafePublicationLazyImpl.Companion(null);
  private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
  private volatile Object _value;
  private final Object jdField_final;
  private volatile Function0<? extends T> initializer;
  
  public SafePublicationLazyImpl(@NotNull Function0<? extends T> paramFunction0)
  {
    this.initializer = paramFunction0;
    this._value = UNINITIALIZED_VALUE.INSTANCE;
    this.jdField_final = UNINITIALIZED_VALUE.INSTANCE;
  }
  
  private final Object writeReplace()
  {
    return new InitializedLazyImpl(getValue());
  }
  
  public T getValue()
  {
    Object localObject = this._value;
    if (localObject != UNINITIALIZED_VALUE.INSTANCE) {
      return localObject;
    }
    localObject = this.initializer;
    if (localObject != null)
    {
      localObject = ((Function0)localObject).invoke();
      if (valueUpdater.compareAndSet(this, UNINITIALIZED_VALUE.INSTANCE, localObject))
      {
        this.initializer = ((Function0)null);
        return localObject;
      }
    }
    return this._value;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.SafePublicationLazyImpl
 * JD-Core Version:    0.7.0.1
 */