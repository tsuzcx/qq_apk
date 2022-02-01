package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt
  extends StringsKt__StringNumberConversionsJVMKt
{
  @NotNull
  public static final Void numberFormatError(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "input");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid number format: '");
    localStringBuilder.append(paramString);
    localStringBuilder.append('\'');
    throw ((Throwable)new NumberFormatException(localStringBuilder.toString()));
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Byte toByteOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toByteOrNull");
    return StringsKt.toByteOrNull(paramString, 10);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Byte toByteOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toByteOrNull");
    paramString = StringsKt.toIntOrNull(paramString, paramInt);
    if (paramString != null)
    {
      paramInt = paramString.intValue();
      if (paramInt >= -128)
      {
        if (paramInt > 127) {
          return null;
        }
        return Byte.valueOf((byte)paramInt);
      }
    }
    return null;
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Integer toIntOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toIntOrNull");
    return StringsKt.toIntOrNull(paramString, 10);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Integer toIntOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toIntOrNull");
    CharsKt.checkRadix(paramInt);
    int i2 = paramString.length();
    if (i2 == 0) {
      return null;
    }
    int n = 0;
    int i = paramString.charAt(0);
    int k = -2147483647;
    int j = 1;
    if (i < 48)
    {
      if (i2 == 1) {
        return null;
      }
      if (i == 45)
      {
        k = -2147483648;
        i = 1;
      }
      else if (i == 43)
      {
        i = 0;
      }
      else
      {
        return null;
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    int m;
    for (int i1 = -59652323; j < i2; i1 = m)
    {
      int i3 = CharsKt.digitOf(paramString.charAt(j), paramInt);
      if (i3 < 0) {
        return null;
      }
      m = i1;
      if (n < i1) {
        if (i1 == -59652323)
        {
          i1 = k / paramInt;
          m = i1;
          if (n >= i1) {}
        }
        else
        {
          return null;
        }
      }
      n *= paramInt;
      if (n < k + i3) {
        return null;
      }
      n -= i3;
      j += 1;
    }
    if (i != 0) {
      return Integer.valueOf(n);
    }
    return Integer.valueOf(-n);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Long toLongOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toLongOrNull");
    return StringsKt.toLongOrNull(paramString, 10);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Long toLongOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toLongOrNull");
    CharsKt.checkRadix(paramInt);
    int k = paramString.length();
    if (k == 0) {
      return null;
    }
    int j = 0;
    int m = paramString.charAt(0);
    long l1 = -9223372036854775807L;
    int i = 1;
    if (m < 48)
    {
      if (k == 1) {
        return null;
      }
      if (m == 45)
      {
        l1 = -9223372036854775808L;
        j = 1;
      }
      else if (m != 43)
      {
        return null;
      }
    }
    else
    {
      i = 0;
    }
    long l3 = 0L;
    long l2;
    for (long l4 = -256204778801521550L; i < k; l4 = l2)
    {
      m = CharsKt.digitOf(paramString.charAt(i), paramInt);
      if (m < 0) {
        return null;
      }
      l2 = l4;
      if (l3 < l4) {
        if (l4 == -256204778801521550L)
        {
          l4 = l1 / paramInt;
          l2 = l4;
          if (l3 >= l4) {}
        }
        else
        {
          return null;
        }
      }
      l3 *= paramInt;
      l4 = m;
      if (l3 < l1 + l4) {
        return null;
      }
      l3 -= l4;
      i += 1;
    }
    if (j != 0) {
      return Long.valueOf(l3);
    }
    return Long.valueOf(-l3);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Short toShortOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toShortOrNull");
    return StringsKt.toShortOrNull(paramString, 10);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Short toShortOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toShortOrNull");
    paramString = StringsKt.toIntOrNull(paramString, paramInt);
    if (paramString != null)
    {
      paramInt = paramString.intValue();
      if (paramInt >= -32768)
      {
        if (paramInt > 32767) {
          return null;
        }
        return Short.valueOf((short)paramInt);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt__StringNumberConversionsKt
 * JD-Core Version:    0.7.0.1
 */