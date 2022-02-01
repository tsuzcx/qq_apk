package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/InitializedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isInitialized", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class InitializedLazyImpl<T>
  implements Serializable, Lazy<T>
{
  private final T value;
  
  public InitializedLazyImpl(T paramT)
  {
    this.value = paramT;
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    return String.valueOf(getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.InitializedLazyImpl
 * JD-Core Version:    0.7.0.1
 */