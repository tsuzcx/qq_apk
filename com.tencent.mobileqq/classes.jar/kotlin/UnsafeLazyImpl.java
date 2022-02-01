package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UnsafeLazyImpl<T>
  implements Serializable, Lazy<T>
{
  private Object _value;
  private Function0<? extends T> initializer;
  
  public UnsafeLazyImpl(@NotNull Function0<? extends T> paramFunction0)
  {
    this.initializer = paramFunction0;
    this._value = UNINITIALIZED_VALUE.INSTANCE;
  }
  
  private final Object writeReplace()
  {
    return new InitializedLazyImpl(getValue());
  }
  
  public T getValue()
  {
    if (this._value == UNINITIALIZED_VALUE.INSTANCE)
    {
      Function0 localFunction0 = this.initializer;
      if (localFunction0 == null) {
        Intrinsics.throwNpe();
      }
      this._value = localFunction0.invoke();
      this.initializer = ((Function0)null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UnsafeLazyImpl
 * JD-Core Version:    0.7.0.1
 */