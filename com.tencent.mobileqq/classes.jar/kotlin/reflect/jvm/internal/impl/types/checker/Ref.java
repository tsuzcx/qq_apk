package kotlin.reflect.jvm.internal.impl.types.checker;

import org.jetbrains.annotations.Nullable;

public final class Ref<T>
{
  @Nullable
  private T value;
  
  public Ref(@Nullable T paramT)
  {
    this.value = paramT;
  }
  
  @Nullable
  public final T getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.Ref
 * JD-Core Version:    0.7.0.1
 */