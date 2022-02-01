package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationAsAnnotationArgument
  extends ReflectJavaAnnotationArgument
  implements JavaAnnotationAsAnnotationArgument
{
  private final Annotation annotation;
  
  public ReflectJavaAnnotationAsAnnotationArgument(@Nullable Name paramName, @NotNull Annotation paramAnnotation)
  {
    super(paramName);
    this.annotation = paramAnnotation;
  }
  
  @NotNull
  public JavaAnnotation getAnnotation()
  {
    return (JavaAnnotation)new ReflectJavaAnnotation(this.annotation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationAsAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */