package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaTypeParameter
  extends JavaClassifier
{
  @NotNull
  public abstract Collection<JavaClassifierType> getUpperBounds();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
 * JD-Core Version:    0.7.0.1
 */