package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationOwnerKt
{
  @Nullable
  public static final ReflectJavaAnnotation findAnnotation(@NotNull Annotation[] paramArrayOfAnnotation, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfAnnotation, "$this$findAnnotation");
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = null;
      if (i >= j) {
        break;
      }
      Annotation localAnnotation = paramArrayOfAnnotation[i];
      if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(localAnnotation))).asSingleFqName(), paramFqName))
      {
        paramArrayOfAnnotation = localAnnotation;
        break label66;
      }
      i += 1;
    }
    paramArrayOfAnnotation = null;
    label66:
    paramFqName = localObject;
    if (paramArrayOfAnnotation != null) {
      paramFqName = new ReflectJavaAnnotation(paramArrayOfAnnotation);
    }
    return paramFqName;
  }
  
  @NotNull
  public static final List<ReflectJavaAnnotation> getAnnotations(@NotNull Annotation[] paramArrayOfAnnotation)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfAnnotation, "$this$getAnnotations");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfAnnotation.length);
    int j = paramArrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new ReflectJavaAnnotation(paramArrayOfAnnotation[i]));
      i += 1;
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt
 * JD-Core Version:    0.7.0.1
 */