package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class CapitalizeDecapitalizeKt
{
  @NotNull
  public static final String capitalizeAsciiOnly(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$capitalizeAsciiOnly");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramString;
    }
    char c = paramString.charAt(0);
    if ('a' > c) {
      return paramString;
    }
    Object localObject = paramString;
    if ('z' >= c)
    {
      c = Character.toUpperCase(c);
      paramString = paramString.substring(1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(c));
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  @NotNull
  public static final String decapitalizeAsciiOnly(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decapitalizeAsciiOnly");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramString;
    }
    char c = paramString.charAt(0);
    if ('A' > c) {
      return paramString;
    }
    Object localObject = paramString;
    if ('Z' >= c)
    {
      c = Character.toLowerCase(c);
      paramString = paramString.substring(1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(c));
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  @NotNull
  public static final String decapitalizeSmartForCompiler(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decapitalizeSmartForCompiler");
    Object localObject2 = (CharSequence)paramString;
    int i;
    if (((CharSequence)localObject2).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = paramString;
    if (i == 0)
    {
      if (!isUpperCaseCharAt(paramString, 0, paramBoolean)) {
        return paramString;
      }
      if ((paramString.length() != 1) && (isUpperCaseCharAt(paramString, 1, paramBoolean)))
      {
        localObject2 = ((Iterable)StringsKt.getIndices((CharSequence)localObject2)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if ((isUpperCaseCharAt(paramString, ((Number)localObject1).intValue(), paramBoolean) ^ true)) {
            break label121;
          }
        }
        localObject1 = null;
        label121:
        localObject1 = (Integer)localObject1;
        if (localObject1 != null)
        {
          i = ((Integer)localObject1).intValue() - 1;
          localObject1 = new StringBuilder();
          localObject2 = paramString.substring(0, i);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((StringBuilder)localObject1).append(toLowerCase((String)localObject2, paramBoolean));
          paramString = paramString.substring(i);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
          ((StringBuilder)localObject1).append(paramString);
          return ((StringBuilder)localObject1).toString();
        }
        return toLowerCase(paramString, paramBoolean);
      }
      if (paramBoolean) {
        return decapitalizeAsciiOnly(paramString);
      }
      localObject1 = StringsKt.decapitalize(paramString);
    }
    return localObject1;
  }
  
  private static final boolean isUpperCaseCharAt(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    char c = paramString.charAt(paramInt);
    if (paramBoolean) {
      return ('A' <= c) && ('Z' >= c);
    }
    return Character.isUpperCase(c);
  }
  
  private static final String toLowerCase(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return toLowerCaseAsciiOnly(paramString);
    }
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public static final String toLowerCaseAsciiOnly(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toLowerCaseAsciiOnly");
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c2 = paramString.charAt(i);
      char c1;
      if ('A' > c2)
      {
        c1 = c2;
      }
      else
      {
        c1 = c2;
        if ('Z' >= c2) {
          c1 = Character.toLowerCase(c2);
        }
      }
      localStringBuilder.append(c1);
      i += 1;
    }
    paramString = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "builder.toString()");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt
 * JD-Core Version:    0.7.0.1
 */