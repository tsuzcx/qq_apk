package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltInFictitiousFunctionClassFactory$Companion
{
  private final BuiltInFictitiousFunctionClassFactory.KindWithArity parseClassName(String paramString, FqName paramFqName)
  {
    FunctionClassDescriptor.Kind localKind = FunctionClassDescriptor.Kind.Companion.byClassNamePrefix(paramFqName, paramString);
    paramFqName = null;
    if (localKind != null)
    {
      String str = localKind.getClassNamePrefix();
      Object localObject = (Companion)this;
      int i = str.length();
      if (paramString != null)
      {
        paramString = paramString.substring(i);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localObject = ((Companion)localObject).toInt(paramString);
        paramString = paramFqName;
        if (localObject != null) {
          paramString = new BuiltInFictitiousFunctionClassFactory.KindWithArity(localKind, ((Integer)localObject).intValue());
        }
        return paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return null;
  }
  
  private final Integer toInt(String paramString)
  {
    int i = ((CharSequence)paramString).length();
    int k = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    int m = paramString.length();
    int j = 0;
    i = k;
    while (i < m)
    {
      k = paramString.charAt(i) - '0';
      if (k >= 0)
      {
        if (9 < k) {
          return null;
        }
        j = j * 10 + k;
        i += 1;
      }
      else
      {
        return null;
      }
    }
    return Integer.valueOf(j);
  }
  
  @JvmStatic
  @Nullable
  public final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull String paramString, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    paramString = ((Companion)this).parseClassName(paramString, paramFqName);
    if (paramString != null) {
      return paramString.getKind();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory.Companion
 * JD-Core Version:    0.7.0.1
 */