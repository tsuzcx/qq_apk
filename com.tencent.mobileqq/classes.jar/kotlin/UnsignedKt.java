package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="UnsignedKt")
public final class UnsignedKt
{
  @PublishedApi
  public static final int doubleToUInt(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {}
    while (paramDouble <= uintToDouble(0)) {
      return 0;
    }
    if (paramDouble >= uintToDouble(-1)) {
      return -1;
    }
    if (paramDouble <= 2147483647) {
      return UInt.constructor-impl((int)paramDouble);
    }
    return UInt.constructor-impl(UInt.constructor-impl((int)(paramDouble - 2147483647)) + UInt.constructor-impl(2147483647));
  }
  
  @PublishedApi
  public static final long doubleToULong(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {}
    while (paramDouble <= ulongToDouble(0L)) {
      return 0L;
    }
    if (paramDouble >= ulongToDouble(-1L)) {
      return -1L;
    }
    if (paramDouble < 9223372036854775807L) {
      return ULong.constructor-impl(paramDouble);
    }
    return ULong.constructor-impl(ULong.constructor-impl((paramDouble - 9.223372036854776E+018D)) - -9223372036854775808L);
  }
  
  @PublishedApi
  public static final int uintCompare(int paramInt1, int paramInt2)
  {
    return Intrinsics.compare(paramInt1 ^ 0x80000000, 0x80000000 ^ paramInt2);
  }
  
  @PublishedApi
  public static final int uintDivide-J1ME1BU(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl((int)((paramInt1 & 0xFFFFFFFF) / (paramInt2 & 0xFFFFFFFF)));
  }
  
  @PublishedApi
  public static final int uintRemainder-J1ME1BU(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl((int)((paramInt1 & 0xFFFFFFFF) % (paramInt2 & 0xFFFFFFFF)));
  }
  
  @PublishedApi
  public static final double uintToDouble(int paramInt)
  {
    return (0x7FFFFFFF & paramInt) + (paramInt >>> 31 << 30) * 2;
  }
  
  @PublishedApi
  public static final int ulongCompare(long paramLong1, long paramLong2)
  {
    return (paramLong1 ^ 0x0) < (0x0 ^ paramLong2);
  }
  
  @PublishedApi
  public static final long ulongDivide-eb3DHEI(long paramLong1, long paramLong2)
  {
    int i = 1;
    if (paramLong2 < 0L)
    {
      if (ulongCompare(paramLong1, paramLong2) < 0) {
        return ULong.constructor-impl(0L);
      }
      return ULong.constructor-impl(1L);
    }
    if (paramLong1 >= 0L) {
      return ULong.constructor-impl(paramLong1 / paramLong2);
    }
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (ulongCompare(ULong.constructor-impl(paramLong1 - l * paramLong2), ULong.constructor-impl(paramLong2)) >= 0) {}
    for (;;)
    {
      return ULong.constructor-impl(i + l);
      i = 0;
    }
  }
  
  @PublishedApi
  public static final long ulongRemainder-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L)
    {
      if (ulongCompare(paramLong1, paramLong2) < 0) {
        return paramLong1;
      }
      return ULong.constructor-impl(paramLong1 - paramLong2);
    }
    if (paramLong1 >= 0L) {
      return ULong.constructor-impl(paramLong1 % paramLong2);
    }
    paramLong1 -= ((paramLong1 >>> 1) / paramLong2 << 1) * paramLong2;
    if (ulongCompare(ULong.constructor-impl(paramLong1), ULong.constructor-impl(paramLong2)) >= 0) {}
    for (;;)
    {
      return ULong.constructor-impl(paramLong1 - paramLong2);
      paramLong2 = 0L;
    }
  }
  
  @PublishedApi
  public static final double ulongToDouble(long paramLong)
  {
    return (paramLong >>> 11) * 2048 + (0x7FF & paramLong);
  }
  
  @NotNull
  public static final String ulongToString(long paramLong)
  {
    return ulongToString(paramLong, 10);
  }
  
  @NotNull
  public static final String ulongToString(long paramLong, int paramInt)
  {
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      return localObject;
    }
    long l2 = (paramLong >>> 1) / paramInt << 1;
    long l3 = paramLong - paramInt * l2;
    long l1 = l3;
    paramLong = l2;
    if (l3 >= paramInt)
    {
      l1 = l3 - paramInt;
      paramLong = l2 + 1L;
    }
    Object localObject = new StringBuilder();
    String str = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    localObject = ((StringBuilder)localObject).append(str);
    str = Long.toString(l1, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.UnsignedKt
 * JD-Core Version:    0.7.0.1
 */