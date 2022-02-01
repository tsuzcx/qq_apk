package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaType$Factory
{
  @NotNull
  public final ReflectJavaType create(@NotNull Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "type");
    boolean bool = paramType instanceof Class;
    if (bool)
    {
      Class localClass = (Class)paramType;
      if (localClass.isPrimitive()) {
        return (ReflectJavaType)new ReflectJavaPrimitiveType(localClass);
      }
    }
    if ((!(paramType instanceof GenericArrayType)) && ((!bool) || (!((Class)paramType).isArray())))
    {
      if ((paramType instanceof WildcardType)) {
        return (ReflectJavaType)new ReflectJavaWildcardType((WildcardType)paramType);
      }
      return (ReflectJavaType)new ReflectJavaClassifierType(paramType);
    }
    return (ReflectJavaType)new ReflectJavaArrayType(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory
 * JD-Core Version:    0.7.0.1
 */