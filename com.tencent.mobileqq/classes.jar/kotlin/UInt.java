package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "data$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UInt
  implements Comparable<UInt>
{
  public static final UInt.Companion Companion = new UInt.Companion(null);
  public static final int MAX_VALUE = -1;
  public static final int MIN_VALUE = 0;
  public static final int SIZE_BITS = 32;
  public static final int SIZE_BYTES = 4;
  private final int data;
  
  @InlineOnly
  private static final int and-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 & paramInt2);
  }
  
  @InlineOnly
  private static final int compareTo-7apg3OU(int paramInt, byte paramByte)
  {
    return UnsignedKt.uintCompare(paramInt, constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final int compareTo-VKZWuLQ(int paramInt, long paramLong)
  {
    return UnsignedKt.ulongCompare(ULong.constructor-impl(paramInt & 0xFFFFFFFF), paramLong);
  }
  
  @InlineOnly
  private int compareTo-WZ4Q5Ns(int paramInt)
  {
    return compareTo-WZ4Q5Ns(this.data, paramInt);
  }
  
  @InlineOnly
  private static int compareTo-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return UnsignedKt.uintCompare(paramInt1, paramInt2);
  }
  
  @InlineOnly
  private static final int compareTo-xj2QHRw(int paramInt, short paramShort)
  {
    return UnsignedKt.uintCompare(paramInt, constructor-impl(0xFFFF & paramShort));
  }
  
  @PublishedApi
  public static int constructor-impl(int paramInt)
  {
    return paramInt;
  }
  
  @InlineOnly
  private static final int dec-impl(int paramInt)
  {
    return constructor-impl(paramInt - 1);
  }
  
  @InlineOnly
  private static final int div-7apg3OU(int paramInt, byte paramByte)
  {
    return UnsignedKt.uintDivide-J1ME1BU(paramInt, constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long div-VKZWuLQ(int paramInt, long paramLong)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl(paramInt & 0xFFFFFFFF), paramLong);
  }
  
  @InlineOnly
  private static final int div-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return UnsignedKt.uintDivide-J1ME1BU(paramInt1, paramInt2);
  }
  
  @InlineOnly
  private static final int div-xj2QHRw(int paramInt, short paramShort)
  {
    return UnsignedKt.uintDivide-J1ME1BU(paramInt, constructor-impl(0xFFFF & paramShort));
  }
  
  public static boolean equals-impl(int paramInt, @Nullable Object paramObject)
  {
    return ((paramObject instanceof UInt)) && (paramInt == ((UInt)paramObject).unbox-impl());
  }
  
  public static final boolean equals-impl0(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static int hashCode-impl(int paramInt)
  {
    return paramInt;
  }
  
  @InlineOnly
  private static final int inc-impl(int paramInt)
  {
    return constructor-impl(paramInt + 1);
  }
  
  @InlineOnly
  private static final int inv-impl(int paramInt)
  {
    return constructor-impl(paramInt ^ 0xFFFFFFFF);
  }
  
  @InlineOnly
  private static final int minus-7apg3OU(int paramInt, byte paramByte)
  {
    return constructor-impl(paramInt - constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long minus-VKZWuLQ(int paramInt, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramInt & 0xFFFFFFFF) - paramLong);
  }
  
  @InlineOnly
  private static final int minus-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 - paramInt2);
  }
  
  @InlineOnly
  private static final int minus-xj2QHRw(int paramInt, short paramShort)
  {
    return constructor-impl(paramInt - constructor-impl(0xFFFF & paramShort));
  }
  
  @InlineOnly
  private static final int or-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 | paramInt2);
  }
  
  @InlineOnly
  private static final int plus-7apg3OU(int paramInt, byte paramByte)
  {
    return constructor-impl(constructor-impl(paramByte & 0xFF) + paramInt);
  }
  
  @InlineOnly
  private static final long plus-VKZWuLQ(int paramInt, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramInt & 0xFFFFFFFF) + paramLong);
  }
  
  @InlineOnly
  private static final int plus-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 + paramInt2);
  }
  
  @InlineOnly
  private static final int plus-xj2QHRw(int paramInt, short paramShort)
  {
    return constructor-impl(constructor-impl(0xFFFF & paramShort) + paramInt);
  }
  
  @InlineOnly
  private static final UIntRange rangeTo-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return new UIntRange(paramInt1, paramInt2, null);
  }
  
  @InlineOnly
  private static final int rem-7apg3OU(int paramInt, byte paramByte)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(paramInt, constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long rem-VKZWuLQ(int paramInt, long paramLong)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl(paramInt & 0xFFFFFFFF), paramLong);
  }
  
  @InlineOnly
  private static final int rem-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(paramInt1, paramInt2);
  }
  
  @InlineOnly
  private static final int rem-xj2QHRw(int paramInt, short paramShort)
  {
    return UnsignedKt.uintRemainder-J1ME1BU(paramInt, constructor-impl(0xFFFF & paramShort));
  }
  
  @InlineOnly
  private static final int shl-impl(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 << paramInt2);
  }
  
  @InlineOnly
  private static final int shr-impl(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 >>> paramInt2);
  }
  
  @InlineOnly
  private static final int times-7apg3OU(int paramInt, byte paramByte)
  {
    return constructor-impl(constructor-impl(paramByte & 0xFF) * paramInt);
  }
  
  @InlineOnly
  private static final long times-VKZWuLQ(int paramInt, long paramLong)
  {
    return ULong.constructor-impl(ULong.constructor-impl(paramInt & 0xFFFFFFFF) * paramLong);
  }
  
  @InlineOnly
  private static final int times-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 * paramInt2);
  }
  
  @InlineOnly
  private static final int times-xj2QHRw(int paramInt, short paramShort)
  {
    return constructor-impl(constructor-impl(0xFFFF & paramShort) * paramInt);
  }
  
  @InlineOnly
  private static final byte toByte-impl(int paramInt)
  {
    return (byte)paramInt;
  }
  
  @InlineOnly
  private static final double toDouble-impl(int paramInt)
  {
    return UnsignedKt.uintToDouble(paramInt);
  }
  
  @InlineOnly
  private static final float toFloat-impl(int paramInt)
  {
    return (float)UnsignedKt.uintToDouble(paramInt);
  }
  
  @InlineOnly
  private static final int toInt-impl(int paramInt)
  {
    return paramInt;
  }
  
  @InlineOnly
  private static final long toLong-impl(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  @InlineOnly
  private static final short toShort-impl(int paramInt)
  {
    return (short)paramInt;
  }
  
  @NotNull
  public static String toString-impl(int paramInt)
  {
    return String.valueOf(paramInt & 0xFFFFFFFF);
  }
  
  @InlineOnly
  private static final byte toUByte-impl(int paramInt)
  {
    return UByte.constructor-impl((byte)paramInt);
  }
  
  @InlineOnly
  private static final int toUInt-impl(int paramInt)
  {
    return paramInt;
  }
  
  @InlineOnly
  private static final long toULong-impl(int paramInt)
  {
    return ULong.constructor-impl(paramInt & 0xFFFFFFFF);
  }
  
  @InlineOnly
  private static final short toUShort-impl(int paramInt)
  {
    return UShort.constructor-impl((short)paramInt);
  }
  
  @InlineOnly
  private static final int xor-WZ4Q5Ns(int paramInt1, int paramInt2)
  {
    return constructor-impl(paramInt1 ^ paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.UInt
 * JD-Core Version:    0.7.0.1
 */