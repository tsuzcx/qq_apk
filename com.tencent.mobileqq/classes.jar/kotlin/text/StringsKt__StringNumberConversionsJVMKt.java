package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsJVMKt
  extends StringsKt__StringBuilderKt
{
  private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String paramString, Function1<? super String, ? extends T> paramFunction1)
  {
    try
    {
      if (ScreenFloatValueRegEx.value.matches((CharSequence)paramString))
      {
        paramString = paramFunction1.invoke(paramString);
        return paramString;
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(@NotNull String paramString)
  {
    return new BigDecimal(paramString);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(@NotNull String paramString, MathContext paramMathContext)
  {
    return new BigDecimal(paramString, paramMathContext);
  }
  
  @SinceKotlin(version="1.2")
  @Nullable
  public static final BigDecimal toBigDecimalOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toBigDecimalOrNull");
    try
    {
      if (ScreenFloatValueRegEx.value.matches((CharSequence)paramString))
      {
        paramString = new BigDecimal(paramString);
        return paramString;
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @SinceKotlin(version="1.2")
  @Nullable
  public static final BigDecimal toBigDecimalOrNull(@NotNull String paramString, @NotNull MathContext paramMathContext)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toBigDecimalOrNull");
    Intrinsics.checkParameterIsNotNull(paramMathContext, "mathContext");
    try
    {
      if (ScreenFloatValueRegEx.value.matches((CharSequence)paramString))
      {
        paramString = new BigDecimal(paramString, paramMathContext);
        return paramString;
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger toBigInteger(@NotNull String paramString)
  {
    return new BigInteger(paramString);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger toBigInteger(@NotNull String paramString, int paramInt)
  {
    return new BigInteger(paramString, CharsKt.checkRadix(paramInt));
  }
  
  @SinceKotlin(version="1.2")
  @Nullable
  public static final BigInteger toBigIntegerOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toBigIntegerOrNull");
    return StringsKt.toBigIntegerOrNull(paramString, 10);
  }
  
  @SinceKotlin(version="1.2")
  @Nullable
  public static final BigInteger toBigIntegerOrNull(@NotNull String paramString, int paramInt)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toBigIntegerOrNull");
    CharsKt.checkRadix(paramInt);
    int j = paramString.length();
    switch (j)
    {
    default: 
      if (paramString.charAt(0) == '-') {
        i = 1;
      }
      break;
    }
    while (i < j)
    {
      if (CharsKt.digitOf(paramString.charAt(i), paramInt) < 0)
      {
        return null;
        return null;
        if (CharsKt.digitOf(paramString.charAt(0), paramInt) >= 0) {
          break;
        }
        return null;
      }
      i += 1;
    }
    return new BigInteger(paramString, CharsKt.checkRadix(paramInt));
  }
  
  @InlineOnly
  private static final boolean toBoolean(@NotNull String paramString)
  {
    return Boolean.parseBoolean(paramString);
  }
  
  @InlineOnly
  private static final byte toByte(@NotNull String paramString)
  {
    return Byte.parseByte(paramString);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte toByte(@NotNull String paramString, int paramInt)
  {
    return Byte.parseByte(paramString, CharsKt.checkRadix(paramInt));
  }
  
  @InlineOnly
  private static final double toDouble(@NotNull String paramString)
  {
    return Double.parseDouble(paramString);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Double toDoubleOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toDoubleOrNull");
    try
    {
      if (ScreenFloatValueRegEx.value.matches((CharSequence)paramString))
      {
        double d = Double.parseDouble(paramString);
        return Double.valueOf(d);
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @InlineOnly
  private static final float toFloat(@NotNull String paramString)
  {
    return Float.parseFloat(paramString);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Float toFloatOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toFloatOrNull");
    try
    {
      if (ScreenFloatValueRegEx.value.matches((CharSequence)paramString))
      {
        float f = Float.parseFloat(paramString);
        return Float.valueOf(f);
      }
      return null;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  @InlineOnly
  private static final int toInt(@NotNull String paramString)
  {
    return Integer.parseInt(paramString);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int toInt(@NotNull String paramString, int paramInt)
  {
    return Integer.parseInt(paramString, CharsKt.checkRadix(paramInt));
  }
  
  @InlineOnly
  private static final long toLong(@NotNull String paramString)
  {
    return Long.parseLong(paramString);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final long toLong(@NotNull String paramString, int paramInt)
  {
    return Long.parseLong(paramString, CharsKt.checkRadix(paramInt));
  }
  
  @InlineOnly
  private static final short toShort(@NotNull String paramString)
  {
    return Short.parseShort(paramString);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short toShort(@NotNull String paramString, int paramInt)
  {
    return Short.parseShort(paramString, CharsKt.checkRadix(paramInt));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String toString(byte paramByte, int paramInt)
  {
    String str = Integer.toString(paramByte, CharsKt.checkRadix(CharsKt.checkRadix(paramInt)));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    return str;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String toString(int paramInt1, int paramInt2)
  {
    String str = Integer.toString(paramInt1, CharsKt.checkRadix(paramInt2));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    return str;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String toString(long paramLong, int paramInt)
  {
    String str = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    return str;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String toString(short paramShort, int paramInt)
  {
    String str = Integer.toString(paramShort, CharsKt.checkRadix(CharsKt.checkRadix(paramInt)));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.StringsKt__StringNumberConversionsJVMKt
 * JD-Core Version:    0.7.0.1
 */