package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;

public abstract class JvmType
{
  @NotNull
  public String toString()
  {
    return JvmTypeFactoryImpl.INSTANCE.toString(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType
 * JD-Core Version:    0.7.0.1
 */