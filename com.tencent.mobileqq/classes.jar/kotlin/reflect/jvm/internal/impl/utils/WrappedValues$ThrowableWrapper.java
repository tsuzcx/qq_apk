package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;

final class WrappedValues$ThrowableWrapper
{
  private final Throwable throwable;
  
  private WrappedValues$ThrowableWrapper(@NotNull Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
  }
  
  @NotNull
  public Throwable getThrowable()
  {
    Throwable localThrowable = this.throwable;
    if (localThrowable == null) {
      $$$reportNull$$$0(1);
    }
    return localThrowable;
  }
  
  public String toString()
  {
    return this.throwable.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.WrappedValues.ThrowableWrapper
 * JD-Core Version:    0.7.0.1
 */