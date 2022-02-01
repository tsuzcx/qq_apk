package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationOwner$DefaultImpls
{
  @Nullable
  public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner paramReflectJavaAnnotationOwner, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    paramReflectJavaAnnotationOwner = paramReflectJavaAnnotationOwner.getElement();
    if (paramReflectJavaAnnotationOwner != null)
    {
      paramReflectJavaAnnotationOwner = paramReflectJavaAnnotationOwner.getDeclaredAnnotations();
      if (paramReflectJavaAnnotationOwner != null) {
        return ReflectJavaAnnotationOwnerKt.findAnnotation(paramReflectJavaAnnotationOwner, paramFqName);
      }
    }
    return null;
  }
  
  @NotNull
  public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner paramReflectJavaAnnotationOwner)
  {
    paramReflectJavaAnnotationOwner = paramReflectJavaAnnotationOwner.getElement();
    if (paramReflectJavaAnnotationOwner != null)
    {
      paramReflectJavaAnnotationOwner = paramReflectJavaAnnotationOwner.getDeclaredAnnotations();
      if (paramReflectJavaAnnotationOwner != null)
      {
        paramReflectJavaAnnotationOwner = ReflectJavaAnnotationOwnerKt.getAnnotations(paramReflectJavaAnnotationOwner);
        if (paramReflectJavaAnnotationOwner != null) {
          return paramReflectJavaAnnotationOwner;
        }
      }
    }
    return CollectionsKt.emptyList();
  }
  
  public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner paramReflectJavaAnnotationOwner)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */