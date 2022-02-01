package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import org.jetbrains.annotations.NotNull;

public final class ReflectAnnotationSource
  implements SourceElement
{
  @NotNull
  private final Annotation annotation;
  
  public ReflectAnnotationSource(@NotNull Annotation paramAnnotation)
  {
    this.annotation = paramAnnotation;
  }
  
  @NotNull
  public final Annotation getAnnotation()
  {
    return this.annotation;
  }
  
  @NotNull
  public SourceFile getContainingFile()
  {
    SourceFile localSourceFile = SourceFile.NO_SOURCE_FILE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceFile, "SourceFile.NO_SOURCE_FILE");
    return localSourceFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource
 * JD-Core Version:    0.7.0.1
 */