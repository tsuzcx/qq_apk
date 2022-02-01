package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.Nullable;

final class LazyJavaAnnotationDescriptor$fqName$2
  extends Lambda
  implements Function0<FqName>
{
  LazyJavaAnnotationDescriptor$fqName$2(LazyJavaAnnotationDescriptor paramLazyJavaAnnotationDescriptor)
  {
    super(0);
  }
  
  @Nullable
  public final FqName invoke()
  {
    ClassId localClassId = LazyJavaAnnotationDescriptor.access$getJavaAnnotation$p(this.this$0).getClassId();
    if (localClassId != null) {
      return localClassId.asSingleFqName();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor.fqName.2
 * JD-Core Version:    0.7.0.1
 */