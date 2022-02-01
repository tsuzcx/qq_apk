package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationArgument$Factory
{
  @NotNull
  public final ReflectJavaAnnotationArgument create(@NotNull Object paramObject, @Nullable Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(paramObject.getClass())) {
      return (ReflectJavaAnnotationArgument)new ReflectJavaEnumValueAnnotationArgument(paramName, (Enum)paramObject);
    }
    if ((paramObject instanceof Annotation)) {
      return (ReflectJavaAnnotationArgument)new ReflectJavaAnnotationAsAnnotationArgument(paramName, (Annotation)paramObject);
    }
    if ((paramObject instanceof Object[])) {
      return (ReflectJavaAnnotationArgument)new ReflectJavaArrayAnnotationArgument(paramName, (Object[])paramObject);
    }
    if ((paramObject instanceof Class)) {
      return (ReflectJavaAnnotationArgument)new ReflectJavaClassObjectAnnotationArgument(paramName, (Class)paramObject);
    }
    return (ReflectJavaAnnotationArgument)new ReflectJavaLiteralAnnotationArgument(paramName, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory
 * JD-Core Version:    0.7.0.1
 */