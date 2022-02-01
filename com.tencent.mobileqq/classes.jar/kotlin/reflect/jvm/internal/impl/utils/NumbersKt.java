package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class NumbersKt
{
  @NotNull
  public static final NumberWithRadix extractRadix(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    if ((!StringsKt.startsWith$default(paramString, "0x", false, 2, null)) && (!StringsKt.startsWith$default(paramString, "0X", false, 2, null)))
    {
      if ((!StringsKt.startsWith$default(paramString, "0b", false, 2, null)) && (!StringsKt.startsWith$default(paramString, "0B", false, 2, null))) {
        return new NumberWithRadix(paramString, 10);
      }
      paramString = paramString.substring(2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      return new NumberWithRadix(paramString, 2);
    }
    paramString = paramString.substring(2);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
    return new NumberWithRadix(paramString, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.NumbersKt
 * JD-Core Version:    0.7.0.1
 */