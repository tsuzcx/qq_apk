package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaAnnotationsKt
{
  @NotNull
  public static final Annotations resolveAnnotations(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaAnnotationOwner paramJavaAnnotationOwner)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyJavaResolverContext, "$this$resolveAnnotations");
    Intrinsics.checkParameterIsNotNull(paramJavaAnnotationOwner, "annotationsOwner");
    return (Annotations)new LazyJavaAnnotations(paramLazyJavaResolverContext, paramJavaAnnotationOwner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt
 * JD-Core Version:    0.7.0.1
 */