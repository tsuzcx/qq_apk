package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

public abstract interface JavaArrayType
  extends JavaType
{
  @NotNull
  public abstract JavaType getComponentType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
 * JD-Core Version:    0.7.0.1
 */