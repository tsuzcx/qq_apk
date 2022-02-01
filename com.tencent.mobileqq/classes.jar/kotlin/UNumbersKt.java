package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="UNumbersKt")
public final class UNumbersKt
{
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits-7apg3OU(byte paramByte)
  {
    return Integer.numberOfLeadingZeros(paramByte & 0xFF) - 24;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits-VKZWuLQ(long paramLong)
  {
    return Long.numberOfLeadingZeros(paramLong);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits-WZ4Q5Ns(int paramInt)
  {
    return Integer.numberOfLeadingZeros(paramInt);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits-xj2QHRw(short paramShort)
  {
    return Integer.numberOfLeadingZeros(0xFFFF & paramShort) - 16;
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits-7apg3OU(byte paramByte)
  {
    return Integer.bitCount(UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits-VKZWuLQ(long paramLong)
  {
    return Long.bitCount(paramLong);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits-WZ4Q5Ns(int paramInt)
  {
    return Integer.bitCount(paramInt);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits-xj2QHRw(short paramShort)
  {
    return Integer.bitCount(UInt.constructor-impl(0xFFFF & paramShort));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits-7apg3OU(byte paramByte)
  {
    return Integer.numberOfTrailingZeros(paramByte | 0x100);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits-VKZWuLQ(long paramLong)
  {
    return Long.numberOfTrailingZeros(paramLong);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits-WZ4Q5Ns(int paramInt)
  {
    return Integer.numberOfTrailingZeros(paramInt);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits-xj2QHRw(short paramShort)
  {
    return Integer.numberOfTrailingZeros(0x10000 | paramShort);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long rotateLeft-JSWoG40(long paramLong, int paramInt)
  {
    return ULong.constructor-impl(Long.rotateLeft(paramLong, paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte rotateLeft-LxnNnR4(byte paramByte, int paramInt)
  {
    return UByte.constructor-impl(NumbersKt.rotateLeft(paramByte, paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int rotateLeft-V7xB4Y4(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl(Integer.rotateLeft(paramInt1, paramInt2));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short rotateLeft-olVBNx4(short paramShort, int paramInt)
  {
    return UShort.constructor-impl(NumbersKt.rotateLeft(paramShort, paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long rotateRight-JSWoG40(long paramLong, int paramInt)
  {
    return ULong.constructor-impl(Long.rotateRight(paramLong, paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte rotateRight-LxnNnR4(byte paramByte, int paramInt)
  {
    return UByte.constructor-impl(NumbersKt.rotateRight(paramByte, paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int rotateRight-V7xB4Y4(int paramInt1, int paramInt2)
  {
    return UInt.constructor-impl(Integer.rotateRight(paramInt1, paramInt2));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short rotateRight-olVBNx4(short paramShort, int paramInt)
  {
    return UShort.constructor-impl(NumbersKt.rotateRight(paramShort, paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte takeHighestOneBit-7apg3OU(byte paramByte)
  {
    return UByte.constructor-impl((byte)Integer.highestOneBit(paramByte & 0xFF));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long takeHighestOneBit-VKZWuLQ(long paramLong)
  {
    return ULong.constructor-impl(Long.highestOneBit(paramLong));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int takeHighestOneBit-WZ4Q5Ns(int paramInt)
  {
    return UInt.constructor-impl(Integer.highestOneBit(paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short takeHighestOneBit-xj2QHRw(short paramShort)
  {
    return UShort.constructor-impl((short)Integer.highestOneBit(0xFFFF & paramShort));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte takeLowestOneBit-7apg3OU(byte paramByte)
  {
    return UByte.constructor-impl((byte)Integer.lowestOneBit(paramByte & 0xFF));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long takeLowestOneBit-VKZWuLQ(long paramLong)
  {
    return ULong.constructor-impl(Long.lowestOneBit(paramLong));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int takeLowestOneBit-WZ4Q5Ns(int paramInt)
  {
    return UInt.constructor-impl(Integer.lowestOneBit(paramInt));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short takeLowestOneBit-xj2QHRw(short paramShort)
  {
    return UShort.constructor-impl((short)Integer.lowestOneBit(0xFFFF & paramShort));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.UNumbersKt
 * JD-Core Version:    0.7.0.1
 */