package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.NotNull;

public final class Constant
  extends JavaDefaultValue
{
  @NotNull
  private final Object value;
  
  public Constant(@NotNull Object paramObject)
  {
    super(null);
    this.value = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.Constant
 * JD-Core Version:    0.7.0.1
 */