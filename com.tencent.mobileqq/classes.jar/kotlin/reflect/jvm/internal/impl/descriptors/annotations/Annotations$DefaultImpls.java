package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Annotations$DefaultImpls
{
  @Nullable
  public static AnnotationDescriptor findAnnotation(Annotations paramAnnotations, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Iterator localIterator = ((Iterable)paramAnnotations).iterator();
    while (localIterator.hasNext())
    {
      paramAnnotations = localIterator.next();
      if (Intrinsics.areEqual(((AnnotationDescriptor)paramAnnotations).getFqName(), paramFqName)) {
        break label53;
      }
    }
    paramAnnotations = null;
    label53:
    return (AnnotationDescriptor)paramAnnotations;
  }
  
  public static boolean hasAnnotation(Annotations paramAnnotations, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return paramAnnotations.findAnnotation(paramFqName) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */