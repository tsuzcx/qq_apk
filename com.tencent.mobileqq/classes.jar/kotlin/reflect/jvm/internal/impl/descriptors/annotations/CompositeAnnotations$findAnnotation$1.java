package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CompositeAnnotations$findAnnotation$1
  extends Lambda
  implements Function1<Annotations, AnnotationDescriptor>
{
  CompositeAnnotations$findAnnotation$1(FqName paramFqName)
  {
    super(1);
  }
  
  @Nullable
  public final AnnotationDescriptor invoke(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "it");
    return paramAnnotations.findAnnotation(this.$fqName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.findAnnotation.1
 * JD-Core Version:    0.7.0.1
 */