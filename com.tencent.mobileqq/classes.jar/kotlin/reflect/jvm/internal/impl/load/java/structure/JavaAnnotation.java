package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaAnnotation
  extends JavaElement
{
  @NotNull
  public abstract Collection<JavaAnnotationArgument> getArguments();
  
  @Nullable
  public abstract ClassId getClassId();
  
  public abstract boolean isIdeExternalAnnotation();
  
  @Nullable
  public abstract JavaClass resolve();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
 * JD-Core Version:    0.7.0.1
 */