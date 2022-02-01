package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="UStringsKt")
public final class UStringsKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String toString-JSWoG40(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongToString(paramLong, CharsKt.checkRadix(paramInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String toString-LxnNnR4(byte paramByte, int paramInt)
  {
    String str = Integer.toString(paramByte & 0xFF, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    return str;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String toString-V7xB4Y4(int paramInt1, int paramInt2)
  {
    String str = Long.toString(paramInt1 & 0xFFFFFFFF, CharsKt.checkRadix(paramInt2));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    return str;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String toString-olVBNx4(short paramShort, int paramInt)
  {
    String str = Integer.toString(paramShort & 0xFFFF, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Integer.toStri…(this, checkRadix(radix))");
    return str;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte toUByte(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUByte");
    UByte localUByte = toUByteOrNull(paramString);
    if (localUByte != null) {
      return localUByte.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte toUByte(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUByte");
    UByte localUByte = toUByteOrNull(paramString, paramInt);
    if (localUByte != null) {
      return localUByte.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte toUByteOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUByteOrNull");
    return toUByteOrNull(paramString, 10);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UByte toUByteOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUByteOrNull");
    paramString = toUIntOrNull(paramString, paramInt);
    if (paramString != null)
    {
      paramInt = paramString.unbox-impl();
      if (UnsignedKt.uintCompare(paramInt, UInt.constructor-impl(255)) > 0) {
        return null;
      }
      return UByte.box-impl(UByte.constructor-impl((byte)paramInt));
    }
    return null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int toUInt(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUInt");
    UInt localUInt = toUIntOrNull(paramString);
    if (localUInt != null) {
      return localUInt.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int toUInt(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUInt");
    UInt localUInt = toUIntOrNull(paramString, paramInt);
    if (localUInt != null) {
      return localUInt.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt toUIntOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUIntOrNull");
    return toUIntOrNull(paramString, 10);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt toUIntOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUIntOrNull");
    CharsKt.checkRadix(paramInt);
    int n = paramString.length();
    if (n == 0) {
      return null;
    }
    int k = 0;
    int j = paramString.charAt(0);
    int i = 1;
    if (j < 48)
    {
      if ((n == 1) || (j != 43)) {
        return null;
      }
    }
    else {
      i = 0;
    }
    int i1 = UInt.constructor-impl(paramInt);
    int m = 119304647;
    j = i;
    while (j < n)
    {
      int i2 = CharsKt.digitOf(paramString.charAt(j), paramInt);
      if (i2 < 0) {
        return null;
      }
      i = m;
      if (UnsignedKt.uintCompare(k, m) > 0) {
        if (m == 119304647)
        {
          m = UnsignedKt.uintDivide-J1ME1BU(-1, i1);
          i = m;
          if (UnsignedKt.uintCompare(k, m) <= 0) {}
        }
        else
        {
          return null;
        }
      }
      m = UInt.constructor-impl(k * i1);
      k = UInt.constructor-impl(UInt.constructor-impl(i2) + m);
      if (UnsignedKt.uintCompare(k, m) < 0) {
        return null;
      }
      j += 1;
      m = i;
    }
    return UInt.box-impl(k);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long toULong(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toULong");
    ULong localULong = toULongOrNull(paramString);
    if (localULong != null) {
      return localULong.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long toULong(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toULong");
    ULong localULong = toULongOrNull(paramString, paramInt);
    if (localULong != null) {
      return localULong.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong toULongOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toULongOrNull");
    return toULongOrNull(paramString, 10);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong toULongOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toULongOrNull");
    CharsKt.checkRadix(paramInt);
    int j = paramString.length();
    if (j == 0) {
      return null;
    }
    int i = 0;
    int k = paramString.charAt(0);
    if (k < 48) {
      if (j != 1)
      {
        if (k != 43) {
          return null;
        }
        i = 1;
      }
      else
      {
        return null;
      }
    }
    long l4 = ULong.constructor-impl(paramInt);
    long l2 = 0L;
    long l1;
    for (long l3 = 512409557603043100L; i < j; l3 = l1)
    {
      k = CharsKt.digitOf(paramString.charAt(i), paramInt);
      if (k < 0) {
        return null;
      }
      l1 = l3;
      if (UnsignedKt.ulongCompare(l2, l3) > 0) {
        if (l3 == 512409557603043100L)
        {
          l3 = UnsignedKt.ulongDivide-eb3DHEI(-1L, l4);
          l1 = l3;
          if (UnsignedKt.ulongCompare(l2, l3) <= 0) {}
        }
        else
        {
          return null;
        }
      }
      l3 = ULong.constructor-impl(l2 * l4);
      l2 = ULong.constructor-impl(ULong.constructor-impl(UInt.constructor-impl(k) & 0xFFFFFFFF) + l3);
      if (UnsignedKt.ulongCompare(l2, l3) < 0) {
        return null;
      }
      i += 1;
    }
    return ULong.box-impl(l2);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short toUShort(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUShort");
    UShort localUShort = toUShortOrNull(paramString);
    if (localUShort != null) {
      return localUShort.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short toUShort(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUShort");
    UShort localUShort = toUShortOrNull(paramString, paramInt);
    if (localUShort != null) {
      return localUShort.unbox-impl();
    }
    StringsKt.numberFormatError(paramString);
    throw null;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort toUShortOrNull(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUShortOrNull");
    return toUShortOrNull(paramString, 10);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UShort toUShortOrNull(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toUShortOrNull");
    paramString = toUIntOrNull(paramString, paramInt);
    if (paramString != null)
    {
      paramInt = paramString.unbox-impl();
      if (UnsignedKt.uintCompare(paramInt, UInt.constructor-impl(65535)) > 0) {
        return null;
      }
      return UShort.box-impl(UShort.constructor-impl((short)paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.UStringsKt
 * JD-Core Version:    0.7.0.1
 */