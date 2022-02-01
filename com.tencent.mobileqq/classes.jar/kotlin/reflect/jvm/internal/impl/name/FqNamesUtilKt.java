package kotlin.reflect.jvm.internal.impl.name;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FqNamesUtilKt
{
  private static final boolean isSubpackageOf(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (StringsKt.startsWith$default(paramString1, paramString2, false, 2, null))
    {
      bool1 = bool2;
      if (paramString1.charAt(paramString2.length()) == '.') {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean isSubpackageOf(@NotNull FqName paramFqName1, @NotNull FqName paramFqName2)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName1, "$this$isSubpackageOf");
    Intrinsics.checkParameterIsNotNull(paramFqName2, "packageName");
    if (Intrinsics.areEqual(paramFqName1, paramFqName2)) {
      return true;
    }
    if (paramFqName2.isRoot()) {
      return true;
    }
    paramFqName1 = paramFqName1.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramFqName1, "this.asString()");
    paramFqName2 = paramFqName2.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramFqName2, "packageName.asString()");
    return isSubpackageOf(paramFqName1, paramFqName2);
  }
  
  public static final boolean isValidJavaFqName(@Nullable String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    State localState = State.BEGINNING;
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      int k = FqNamesUtilKt.WhenMappings.$EnumSwitchMapping$0[localState.ordinal()];
      if ((k != 1) && (k != 2))
      {
        if (k == 3) {
          if (c == '.') {
            localState = State.AFTER_DOT;
          } else if (!Character.isJavaIdentifierPart(c)) {
            return false;
          }
        }
      }
      else
      {
        if (!Character.isJavaIdentifierPart(c)) {
          return false;
        }
        localState = State.MIDDLE;
      }
      i += 1;
    }
    if (localState != State.AFTER_DOT) {
      bool = true;
    }
    return bool;
  }
  
  @NotNull
  public static final FqName tail(@NotNull FqName paramFqName1, @NotNull FqName paramFqName2)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName1, "$this$tail");
    Intrinsics.checkParameterIsNotNull(paramFqName2, "prefix");
    if (isSubpackageOf(paramFqName1, paramFqName2))
    {
      if (paramFqName2.isRoot()) {
        return paramFqName1;
      }
      if (Intrinsics.areEqual(paramFqName1, paramFqName2))
      {
        paramFqName1 = FqName.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(paramFqName1, "FqName.ROOT");
        return paramFqName1;
      }
      paramFqName1 = paramFqName1.asString();
      Intrinsics.checkExpressionValueIsNotNull(paramFqName1, "asString()");
      int i = paramFqName2.asString().length();
      if (paramFqName1 != null)
      {
        paramFqName1 = paramFqName1.substring(i + 1);
        Intrinsics.checkExpressionValueIsNotNull(paramFqName1, "(this as java.lang.String).substring(startIndex)");
        return new FqName(paramFqName1);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramFqName1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt
 * JD-Core Version:    0.7.0.1
 */