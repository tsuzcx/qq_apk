package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

public abstract interface JavaClassObjectAnnotationArgument
  extends JavaAnnotationArgument
{
  @NotNull
  public abstract JavaType getReferencedType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */