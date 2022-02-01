package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UShort
  implements Comparable<UShort>
{
  public static final UShort.Companion Companion = new UShort.Companion(null);
  public static final short MAX_VALUE = -1;
  public static final short MIN_VALUE = 0;
  public static final int SIZE_BITS = 16;
  public static final int SIZE_BYTES = 2;
  private final short data;
  
  @InlineOnly
  private static final short and-xj2QHRw(short paramShort1, short paramShort2)
  {
    return constructor-impl((short)(paramShort1 & paramShort2));
  }
  
  @InlineOnly
  private static final int compareTo-7apg3OU(short paramShort, byte paramByte)
  {
    return Intrinsics.compare(paramShort & 0xFFFF, paramByte & 0xFF);
  }
  
  @InlineOnly
  private static final int compareTo-VKZWuLQ(short paramShort, long paramLong)
  {
    return UnsignedKt.ulongCompare(ULong.constructor-impl(paramShort & 0xFFFF), paramLong);
  }
  
  @InlineOnly
  private static final int compareTo-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UnsignedKt.uintCompare(UInt.constructor-impl(paramShort & 0xFFFF), paramInt);
  }
  
  @InlineOnly
  private int compareTo-xj2QHRw(short paramShort)
  {
    return compareTo-xj2QHRw(this.data, paramShort);
  }
  
  @InlineOnly
  private static int compareTo-xj2QHRw(short paramShort1, short paramShort2)
  {
    return Intrinsics.compare(paramShort1 & 0xFFFF, paramShort2 & 0xFFFF);
  }
  
  @PublishedApi
  public static short constructor-impl(short paramShort)
  {
    return paramShort;
  }
  
  @InlineOnly
  private static final short dec-impl(short paramShort)
  {
    return constructor-impl((short)(paramShort - 1));
  }
  
  @InlineOnly
  private static final int div-7apg3OU(short paramShort, byte paramByte)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long div-VKZWuLQ(short paramShort, long paramLong)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl(paramShort & 0xFFFF), paramLong);
  }
  
  @InlineOnly
  private static final int div-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), paramInt);
  }
  
  @InlineOnly
  private static final int div-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  public static boolean equals-impl(short paramShort, @Nullable Object paramObject)
  {
    return ((paramObject instanceof UShort)) && (paramShort == ((UShort)paramObject).unbox-impl());
  }
  
  public static final boolean equals-impl0(short paramShort1, short paramShort2)
  {
    return paramShort1 == paramShort2;
  }
  
  public static int hashCode-impl(short paramShort)
  {
    return paramShort;
  }
  
  @InlineOnly
  private static final short inc-impl(short paramShort)
  {
    return constructor-impl((short)(paramShort + 1));
  }
  
  @InlineOnly
  private static final short inv-impl(short paramShort)
  {
    return constructor-impl((short)(paramShort ^ 0xFFFFFFFF));
  }
  
  @InlineOnly
  private static final int minus-7apg3OU(short paramShort, byte paramByte)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) - UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long minus-VKZWuLQ(short paramShort, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramShort & 0xFFFF) - paramLong);
  }
  
  @InlineOnly
  private static final int minus-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) - paramInt);
  }
  
  @InlineOnly
  private static final int minus-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort1 & 0xFFFF) - UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  @InlineOnly
  private static final short or-xj2QHRw(short paramShort1, short paramShort2)
  {
    return constructor-impl((short)(paramShort1 | paramShort2));
  }
  
  @InlineOnly
  private static final int plus-7apg3OU(short paramShort, byte paramByte)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) + UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long plus-VKZWuLQ(short paramShort, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramShort & 0xFFFF) + paramLong);
  }
  
  @InlineOnly
  private static final int plus-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) + paramInt);
  }
  
  @InlineOnly
  private static final int plus-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort1 & 0xFFFF) + UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  @InlineOnly
  private static final UIntRange rangeTo-xj2QHRw(short paramShort1, short paramShort2)
  {
    return new UIntRange(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF), null);
  }
  
  @InlineOnly
  private static final int rem-7apg3OU(short paramShort, byte paramByte)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long rem-VKZWuLQ(short paramShort, long paramLong)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl(paramShort & 0xFFFF), paramLong);
  }
  
  @InlineOnly
  private static final int rem-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramShort & 0xFFFF), paramInt);
  }
  
  @InlineOnly
  private static final int rem-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  @InlineOnly
  private static final int times-7apg3OU(short paramShort, byte paramByte)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) * UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long times-VKZWuLQ(short paramShort, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramShort & 0xFFFF) * paramLong);
  }
  
  @InlineOnly
  private static final int times-WZ4Q5Ns(short paramShort, int paramInt)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort & 0xFFFF) * paramInt);
  }
  
  @InlineOnly
  private static final int times-xj2QHRw(short paramShort1, short paramShort2)
  {
    return UInt.constructor-impl(UInt.constructor-impl(paramShort1 & 0xFFFF) * UInt.constructor-impl(paramShort2 & 0xFFFF));
  }
  
  @InlineOnly
  private static final byte toByte-impl(short paramShort)
  {
    return (byte)paramShort;
  }
  
  @InlineOnly
  private static final double toDouble-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  @InlineOnly
  private static final float toFloat-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  @InlineOnly
  private static final int toInt-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  @InlineOnly
  private static final long toLong-impl(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  @InlineOnly
  private static final short toShort-impl(short paramShort)
  {
    return paramShort;
  }
  
  @NotNull
  public static String toString-impl(short paramShort)
  {
    return String.valueOf(paramShort & 0xFFFF);
  }
  
  @InlineOnly
  private static final byte toUByte-impl(short paramShort)
  {
    return UByte.constructor-impl((byte)paramShort);
  }
  
  @InlineOnly
  private static final int toUInt-impl(short paramShort)
  {
    return UInt.constructor-impl(paramShort & 0xFFFF);
  }
  
  @InlineOnly
  private static final long toULong-impl(short paramShort)
  {
    return ULong.constructor-impl(paramShort & 0xFFFF);
  }
  
  @InlineOnly
  private static final short toUShort-impl(short paramShort)
  {
    return paramShort;
  }
  
  @InlineOnly
  private static final short xor-xj2QHRw(short paramShort1, short paramShort2)
  {
    return constructor-impl((short)(paramShort1 ^ paramShort2));
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
 * Qualified Name:     kotlin.UShort
 * JD-Core Version:    0.7.0.1
 */