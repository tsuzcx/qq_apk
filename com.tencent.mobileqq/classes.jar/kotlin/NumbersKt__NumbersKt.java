package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__NumbersKt
  extends NumbersKt__NumbersJVMKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits(byte paramByte)
  {
    return Integer.numberOfLeadingZeros(paramByte & 0xFF) - 24;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits(short paramShort)
  {
    return Integer.numberOfLeadingZeros(0xFFFF & paramShort) - 16;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits(byte paramByte)
  {
    return Integer.bitCount(paramByte & 0xFF);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits(short paramShort)
  {
    return Integer.bitCount(0xFFFF & paramShort);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits(byte paramByte)
  {
    return Integer.numberOfTrailingZeros(paramByte | 0x100);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits(short paramShort)
  {
    return Integer.numberOfTrailingZeros(0x10000 | paramShort);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  public static final byte rotateLeft(byte paramByte, int paramInt)
  {
    return (byte)(paramByte << (paramInt & 0x7) | (paramByte & 0xFF) >>> 8 - (paramInt & 0x7));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  public static final short rotateLeft(short paramShort, int paramInt)
  {
    return (short)(paramShort << (paramInt & 0xF) | (0xFFFF & paramShort) >>> 16 - (paramInt & 0xF));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  public static final byte rotateRight(byte paramByte, int paramInt)
  {
    return (byte)(paramByte << 8 - (paramInt & 0x7) | (paramByte & 0xFF) >>> (paramInt & 0x7));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  public static final short rotateRight(short paramShort, int paramInt)
  {
    return (short)(paramShort << 16 - (paramInt & 0xF) | (0xFFFF & paramShort) >>> (paramInt & 0xF));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte takeHighestOneBit(byte paramByte)
  {
    return (byte)Integer.highestOneBit(paramByte & 0xFF);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short takeHighestOneBit(short paramShort)
  {
    return (short)Integer.highestOneBit(0xFFFF & paramShort);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte takeLowestOneBit(byte paramByte)
  {
    return (byte)Integer.lowestOneBit(paramByte);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short takeLowestOneBit(short paramShort)
  {
    return (short)Integer.lowestOneBit(paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.NumbersKt__NumbersKt
 * JD-Core Version:    0.7.0.1
 */