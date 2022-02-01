package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LazyJavaAnnotations$annotationDescriptors$1
  extends Lambda
  implements Function1<JavaAnnotation, AnnotationDescriptor>
{
  LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations paramLazyJavaAnnotations)
  {
    super(1);
  }
  
  @Nullable
  public final AnnotationDescriptor invoke(@NotNull JavaAnnotation paramJavaAnnotation)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaAnnotation, "annotation");
    return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(paramJavaAnnotation, LazyJavaAnnotations.access$getC$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations.annotationDescriptors.1
 * JD-Core Version:    0.7.0.1
 */