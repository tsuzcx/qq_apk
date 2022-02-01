package kotlin.reflect.jvm.internal.impl.load.java.sources;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaSourceElementFactory
{
  @NotNull
  public abstract JavaSourceElement source(@NotNull JavaElement paramJavaElement);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
 * JD-Core Version:    0.7.0.1
 */