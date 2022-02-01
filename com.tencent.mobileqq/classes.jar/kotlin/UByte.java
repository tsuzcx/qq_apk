package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "data$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UByte
  implements Comparable<UByte>
{
  public static final UByte.Companion Companion = new UByte.Companion(null);
  public static final byte MAX_VALUE = -1;
  public static final byte MIN_VALUE = 0;
  public static final int SIZE_BITS = 8;
  public static final int SIZE_BYTES = 1;
  private final byte data;
  
  @InlineOnly
  private static final byte and-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return constructor-impl((byte)(paramByte1 & paramByte2));
  }
  
  @InlineOnly
  private int compareTo-7apg3OU(byte paramByte)
  {
    return compareTo-7apg3OU(this.data, paramByte);
  }
  
  @InlineOnly
  private static int compareTo-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF);
  }
  
  @InlineOnly
  private static final int compareTo-VKZWuLQ(byte paramByte, long paramLong)
  {
    return UnsignedKt.ulongCompare(ULong.constructor-impl(paramByte & 0xFF), paramLong);
  }
  
  @InlineOnly
  private static final int compareTo-WZ4Q5Ns(byte paramByte, int paramInt)
  {
    return UnsignedKt.uintCompare(UInt.constructor-impl(paramByte & 0xFF), paramInt);
  }
  
  @InlineOnly
  private static final int compareTo-xj2QHRw(byte paramByte, short paramShort)
  {
    return Intrinsics.compare(paramByte & 0xFF, paramShort & 0xFFFF);
  }
  
  @PublishedApi
  public static byte constructor-impl(byte paramByte)
  {
    return paramByte;
  }
  
  @InlineOnly
  private static final byte dec-impl(byte paramByte)
  {
    return constructor-impl((byte)(paramByte - 1));
  }
  
  @InlineOnly
  private static final int div-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(paramByte2 & 0xFF));
  }
  
  @InlineOnly
  private static final long div-VKZWuLQ(byte paramByte, long paramLong)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl(paramByte & 0xFF), paramLong);
  }
  
  @InlineOnly
  private static final int div-WZ4Q5Ns(byte paramByte, int paramInt)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramByte & 0xFF), paramInt);
  }
  
  @InlineOnly
  private static final int div-xj2QHRw(byte paramByte, short paramShort)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramByte & 0xFF), UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  public static boolean equals-impl(byte paramByte, @Nullable Object paramObject)
  {
    return ((paramObject instanceof UByte)) && (paramByte == ((UByte)paramObject).unbox-impl());
  }
  
  public static final boolean equals-impl0(byte paramByte1, byte paramByte2)
  {
    return paramByte1 == paramByte2;
  }
  
  public static int hashCode-impl(byte paramByte)
  {
    return paramByte;
  }
  
  @InlineOnly
  private static final byte inc-impl(byte paramByte)
  {
    return constructor-impl((byte)(paramByte + 1));
  }
  
  @InlineOnly
  private static final byte inv-impl(byte paramByte)
  {
    return constructor-impl((byte)(paramByte ^ 0xFFFFFFFF));
  }
  
  @InlineOnly
  private static final int minus-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte1 & 0xFF) - UInt.constructor-impl(paramByte2 & 0xFF));
  }
  
  @InlineOnly
  private static final long minus-VKZWuLQ(byte paramByte, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramByte & 0xFF) - paramLong);
  }
  
  @InlineOnly
  private static final int minus-WZ4Q5Ns(byte paramByte, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte & 0xFF) - paramInt);
  }
  
  @InlineOnly
  private static final int minus-xj2QHRw(byte paramByte, short paramShort)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte & 0xFF) - UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  @InlineOnly
  private static final byte or-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return constructor-impl((byte)(paramByte1 | paramByte2));
  }
  
  @InlineOnly
  private static final int plus-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte1 & 0xFF) + UInt.constructor-impl(paramByte2 & 0xFF));
  }
  
  @InlineOnly
  private static final long plus-VKZWuLQ(byte paramByte, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramByte & 0xFF) + paramLong);
  }
  
  @InlineOnly
  private static final int plus-WZ4Q5Ns(byte paramByte, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte & 0xFF) + paramInt);
  }
  
  @InlineOnly
  private static final int plus-xj2QHRw(byte paramByte, short paramShort)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte & 0xFF) + UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  @InlineOnly
  private static final UIntRange rangeTo-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return new UIntRange(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(paramByte2 & 0xFF), null);
  }
  
  @InlineOnly
  private static final int rem-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(paramByte2 & 0xFF));
  }
  
  @InlineOnly
  private static final long rem-VKZWuLQ(byte paramByte, long paramLong)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl(paramByte & 0xFF), paramLong);
  }
  
  @InlineOnly
  private static final int rem-WZ4Q5Ns(byte paramByte, int paramInt)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramByte & 0xFF), paramInt);
  }
  
  @InlineOnly
  private static final int rem-xj2QHRw(byte paramByte, short paramShort)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramByte & 0xFF), UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  @InlineOnly
  private static final int times-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte1 & 0xFF) * UInt.constructor-impl(paramByte2 & 0xFF));
  }
  
  @InlineOnly
  private static final long times-VKZWuLQ(byte paramByte, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramByte & 0xFF) * paramLong);
  }
  
  @InlineOnly
  private static final int times-WZ4Q5Ns(byte paramByte, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte & 0xFF) * paramInt);
  }
  
  @InlineOnly
  private static final int times-xj2QHRw(byte paramByte, short paramShort)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramByte & 0xFF) * UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  @InlineOnly
  private static final byte toByte-impl(byte paramByte)
  {
    return paramByte;
  }
  
  @InlineOnly
  private static final double toDouble-impl(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  @InlineOnly
  private static final float toFloat-impl(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  @InlineOnly
  private static final int toInt-impl(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  @InlineOnly
  private static final long toLong-impl(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  @InlineOnly
  private static final short toShort-impl(byte paramByte)
  {
    return (short)((short)paramByte & 0xFF);
  }
  
  @NotNull
  public static String toString-impl(byte paramByte)
  {
    return String.valueOf(paramByte & 0xFF);
  }
  
  @InlineOnly
  private static final byte toUByte-impl(byte paramByte)
  {
    return paramByte;
  }
  
  @InlineOnly
  private static final int toUInt-impl(byte paramByte)
  {
    return UInt.constructor-impl(paramByte & 0xFF);
  }
  
  @InlineOnly
  private static final long toULong-impl(byte paramByte)
  {
    return ULong.constructor-impl(paramByte & 0xFF);
  }
  
  @InlineOnly
  private static final short toUShort-impl(byte paramByte)
  {
    return UShort.constructor-impl((short)((short)paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final byte xor-7apg3OU(byte paramByte1, byte paramByte2)
  {
    return constructor-impl((byte)(paramByte1 ^ paramByte2));
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.data, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.data);
  }
  
  @NotNull
  public String toString()
  {
    return toString-impl(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UByte
 * JD-Core Version:    0.7.0.1
 */