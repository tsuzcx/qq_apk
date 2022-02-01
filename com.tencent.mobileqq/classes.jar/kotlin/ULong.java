package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "data$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-impl", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-impl", "shr", "shr-impl", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class ULong
  implements Comparable<ULong>
{
  public static final ULong.Companion Companion = new ULong.Companion(null);
  public static final long MAX_VALUE = -1L;
  public static final long MIN_VALUE = 0L;
  public static final int SIZE_BITS = 64;
  public static final int SIZE_BYTES = 8;
  private final long data;
  
  @InlineOnly
  private static final long and-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 & paramLong2);
  }
  
  @InlineOnly
  private static final int compareTo-7apg3OU(long paramLong, byte paramByte)
  {
    return UnsignedKt.ulongCompare(paramLong, constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private int compareTo-VKZWuLQ(long paramLong)
  {
    return compareTo-VKZWuLQ(this.data, paramLong);
  }
  
  @InlineOnly
  private static int compareTo-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return UnsignedKt.ulongCompare(paramLong1, paramLong2);
  }
  
  @InlineOnly
  private static final int compareTo-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongCompare(paramLong, constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  @InlineOnly
  private static final int compareTo-xj2QHRw(long paramLong, short paramShort)
  {
    return UnsignedKt.ulongCompare(paramLong, constructor-impl(paramShort & 0xFFFF));
  }
  
  @PublishedApi
  public static long constructor-impl(long paramLong)
  {
    return paramLong;
  }
  
  @InlineOnly
  private static final long dec-impl(long paramLong)
  {
    return constructor-impl(-1L + paramLong);
  }
  
  @InlineOnly
  private static final long div-7apg3OU(long paramLong, byte paramByte)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong, constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long div-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong1, paramLong2);
  }
  
  @InlineOnly
  private static final long div-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong, constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  @InlineOnly
  private static final long div-xj2QHRw(long paramLong, short paramShort)
  {
    return UnsignedKt.ulongDivide-eb3DHEI(paramLong, constructor-impl(paramShort & 0xFFFF));
  }
  
  public static boolean equals-impl(long paramLong, @Nullable Object paramObject)
  {
    return ((paramObject instanceof ULong)) && (paramLong == ((ULong)paramObject).unbox-impl());
  }
  
  public static final boolean equals-impl0(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static int hashCode-impl(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  @InlineOnly
  private static final long inc-impl(long paramLong)
  {
    return constructor-impl(1L + paramLong);
  }
  
  @InlineOnly
  private static final long inv-impl(long paramLong)
  {
    return constructor-impl(0xFFFFFFFF ^ paramLong);
  }
  
  @InlineOnly
  private static final long minus-7apg3OU(long paramLong, byte paramByte)
  {
    return constructor-impl(paramLong - constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long minus-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 - paramLong2);
  }
  
  @InlineOnly
  private static final long minus-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong - constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  @InlineOnly
  private static final long minus-xj2QHRw(long paramLong, short paramShort)
  {
    return constructor-impl(paramLong - constructor-impl(paramShort & 0xFFFF));
  }
  
  @InlineOnly
  private static final long or-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 | paramLong2);
  }
  
  @InlineOnly
  private static final long plus-7apg3OU(long paramLong, byte paramByte)
  {
    return constructor-impl(constructor-impl(paramByte & 0xFF) + paramLong);
  }
  
  @InlineOnly
  private static final long plus-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 + paramLong2);
  }
  
  @InlineOnly
  private static final long plus-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return constructor-impl(constructor-impl(paramInt & 0xFFFFFFFF) + paramLong);
  }
  
  @InlineOnly
  private static final long plus-xj2QHRw(long paramLong, short paramShort)
  {
    return constructor-impl(constructor-impl(paramShort & 0xFFFF) + paramLong);
  }
  
  @InlineOnly
  private static final ULongRange rangeTo-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return new ULongRange(paramLong1, paramLong2, null);
  }
  
  @InlineOnly
  private static final long rem-7apg3OU(long paramLong, byte paramByte)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong, constructor-impl(paramByte & 0xFF));
  }
  
  @InlineOnly
  private static final long rem-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong1, paramLong2);
  }
  
  @InlineOnly
  private static final long rem-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong, constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  @InlineOnly
  private static final long rem-xj2QHRw(long paramLong, short paramShort)
  {
    return UnsignedKt.ulongRemainder-eb3DHEI(paramLong, constructor-impl(paramShort & 0xFFFF));
  }
  
  @InlineOnly
  private static final long shl-impl(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong << paramInt);
  }
  
  @InlineOnly
  private static final long shr-impl(long paramLong, int paramInt)
  {
    return constructor-impl(paramLong >>> paramInt);
  }
  
  @InlineOnly
  private static final long times-7apg3OU(long paramLong, byte paramByte)
  {
    return constructor-impl(constructor-impl(paramByte & 0xFF) * paramLong);
  }
  
  @InlineOnly
  private static final long times-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 * paramLong2);
  }
  
  @InlineOnly
  private static final long times-WZ4Q5Ns(long paramLong, int paramInt)
  {
    return constructor-impl(constructor-impl(paramInt & 0xFFFFFFFF) * paramLong);
  }
  
  @InlineOnly
  private static final long times-xj2QHRw(long paramLong, short paramShort)
  {
    return constructor-impl(constructor-impl(paramShort & 0xFFFF) * paramLong);
  }
  
  @InlineOnly
  private static final byte toByte-impl(long paramLong)
  {
    return (byte)(int)paramLong;
  }
  
  @InlineOnly
  private static final double toDouble-impl(long paramLong)
  {
    return UnsignedKt.ulongToDouble(paramLong);
  }
  
  @InlineOnly
  private static final float toFloat-impl(long paramLong)
  {
    return (float)UnsignedKt.ulongToDouble(paramLong);
  }
  
  @InlineOnly
  private static final int toInt-impl(long paramLong)
  {
    return (int)paramLong;
  }
  
  @InlineOnly
  private static final long toLong-impl(long paramLong)
  {
    return paramLong;
  }
  
  @InlineOnly
  private static final short toShort-impl(long paramLong)
  {
    return (short)(int)paramLong;
  }
  
  @NotNull
  public static String toString-impl(long paramLong)
  {
    return UnsignedKt.ulongToString(paramLong);
  }
  
  @InlineOnly
  private static final byte toUByte-impl(long paramLong)
  {
    return UByte.constructor-impl((byte)(int)paramLong);
  }
  
  @InlineOnly
  private static final int toUInt-impl(long paramLong)
  {
    return UInt.constructor-impl((int)paramLong);
  }
  
  @InlineOnly
  private static final long toULong-impl(long paramLong)
  {
    return paramLong;
  }
  
  @InlineOnly
  private static final short toUShort-impl(long paramLong)
  {
    return UShort.constructor-impl((short)(int)paramLong);
  }
  
  @InlineOnly
  private static final long xor-VKZWuLQ(long paramLong1, long paramLong2)
  {
    return constructor-impl(paramLong1 ^ paramLong2);
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
 * Qualified Name:     kotlin.ULong
 * JD-Core Version:    0.7.0.1
 */