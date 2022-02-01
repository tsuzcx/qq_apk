package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class JvmTypeFactoryImpl
  implements JvmTypeFactory<JvmType>
{
  public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();
  
  @NotNull
  public JvmType boxType(@NotNull JvmType paramJvmType)
  {
    Intrinsics.checkParameterIsNotNull(paramJvmType, "possiblyPrimitiveType");
    JvmType localJvmType = paramJvmType;
    if ((paramJvmType instanceof JvmType.Primitive))
    {
      JvmType.Primitive localPrimitive = (JvmType.Primitive)paramJvmType;
      localJvmType = paramJvmType;
      if (localPrimitive.getJvmPrimitiveType() != null)
      {
        paramJvmType = JvmClassName.byFqNameWithoutInnerClasses(localPrimitive.getJvmPrimitiveType().getWrapperFqName());
        Intrinsics.checkExpressionValueIsNotNull(paramJvmType, "JvmClassName.byFqNameWit…mitiveType.wrapperFqName)");
        paramJvmType = paramJvmType.getInternalName();
        Intrinsics.checkExpressionValueIsNotNull(paramJvmType, "JvmClassName.byFqNameWit…apperFqName).internalName");
        localJvmType = (JvmType)createObjectType(paramJvmType);
      }
    }
    return localJvmType;
  }
  
  @NotNull
  public JvmType createFromString(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "representation");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = localCharSequence.length();
    int k = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0)) {
      throw ((Throwable)new AssertionError("empty string as JvmType"));
    }
    int m = paramString.charAt(0);
    JvmPrimitiveType[] arrayOfJvmPrimitiveType = JvmPrimitiveType.values();
    int n = arrayOfJvmPrimitiveType.length;
    i = 0;
    while (i < n)
    {
      localObject = arrayOfJvmPrimitiveType[i];
      int j;
      if (((JvmPrimitiveType)localObject).getDesc().charAt(0) == m) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label129;
      }
      i += 1;
    }
    Object localObject = null;
    label129:
    if (localObject != null) {
      return (JvmType)new JvmType.Primitive((JvmPrimitiveType)localObject);
    }
    if (m != 86)
    {
      if (m != 91)
      {
        i = k;
        if (m == 76)
        {
          i = k;
          if (StringsKt.endsWith$default(localCharSequence, ';', false, 2, null)) {
            i = 1;
          }
        }
        if ((_Assertions.ENABLED) && (i == 0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Type that is not primitive nor array should be Object, but '");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("' was found");
          throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
        }
        paramString = paramString.substring(1, paramString.length() - 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return (JvmType)new JvmType.Object(paramString);
      }
      paramString = paramString.substring(1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      return (JvmType)new JvmType.Array(createFromString(paramString));
    }
    return (JvmType)new JvmType.Primitive(null);
  }
  
  @NotNull
  public JvmType.Object createObjectType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "internalName");
    return new JvmType.Object(paramString);
  }
  
  @NotNull
  public JvmType getJavaLangClassType()
  {
    return (JvmType)createObjectType("java/lang/Class");
  }
  
  @NotNull
  public String toString(@NotNull JvmType paramJvmType)
  {
    Intrinsics.checkParameterIsNotNull(paramJvmType, "type");
    StringBuilder localStringBuilder;
    if ((paramJvmType instanceof JvmType.Array))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(toString(((JvmType.Array)paramJvmType).getElementType()));
      return localStringBuilder.toString();
    }
    if ((paramJvmType instanceof JvmType.Primitive))
    {
      paramJvmType = ((JvmType.Primitive)paramJvmType).getJvmPrimitiveType();
      if (paramJvmType != null)
      {
        paramJvmType = paramJvmType.getDesc();
        if (paramJvmType != null) {
          return paramJvmType;
        }
      }
      return "V";
    }
    if ((paramJvmType instanceof JvmType.Object))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("L");
      localStringBuilder.append(((JvmType.Object)paramJvmType).getInternalName());
      localStringBuilder.append(";");
      return localStringBuilder.toString();
    }
    throw new NoWhenBranchMatchedException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl
 * JD-Core Version:    0.7.0.1
 */