package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaAnnotationOwner
  extends JavaElement
{
  @Nullable
  public abstract JavaAnnotation findAnnotation(@NotNull FqName paramFqName);
  
  @NotNull
  public abstract Collection<JavaAnnotation> getAnnotations();
  
  public abstract boolean isDeprecatedInJavaDoc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
 * JD-Core Version:    0.7.0.1
 */