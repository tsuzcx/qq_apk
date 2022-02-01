package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaArrayAnnotationArgument
  extends JavaAnnotationArgument
{
  @NotNull
  public abstract List<JavaAnnotationArgument> getElements();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */