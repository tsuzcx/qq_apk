package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

final class SignatureSerializer
{
  public static final SignatureSerializer INSTANCE = new SignatureSerializer();
  
  @NotNull
  public final String constructorDesc(@NotNull Constructor<?> paramConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramConstructor, "constructor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    paramConstructor = paramConstructor.getParameterTypes();
    int j = paramConstructor.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstructor[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject, "parameterType");
      localStringBuilder.append(ReflectClassUtilKt.getDesc(localObject));
      i += 1;
    }
    localStringBuilder.append(")V");
    paramConstructor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramConstructor, "sb.toString()");
    return paramConstructor;
  }
  
  @NotNull
  public final String fieldDesc(@NotNull Field paramField)
  {
    Intrinsics.checkParameterIsNotNull(paramField, "field");
    paramField = paramField.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramField, "field.type");
    return ReflectClassUtilKt.getDesc(paramField);
  }
  
  @NotNull
  public final String methodDesc(@NotNull Method paramMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramMethod, "method");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      Intrinsics.checkExpressionValueIsNotNull(localClass, "parameterType");
      localStringBuilder.append(ReflectClassUtilKt.getDesc(localClass));
      i += 1;
    }
    localStringBuilder.append(")");
    paramMethod = paramMethod.getReturnType();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "method.returnType");
    localStringBuilder.append(ReflectClassUtilKt.getDesc(paramMethod));
    paramMethod = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "sb.toString()");
    return paramMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.SignatureSerializer
 * JD-Core Version:    0.7.0.1
 */