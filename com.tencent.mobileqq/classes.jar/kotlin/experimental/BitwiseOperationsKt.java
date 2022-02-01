package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class BitwiseOperationsKt
{
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte and(byte paramByte1, byte paramByte2)
  {
    return (byte)(paramByte1 & paramByte2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short and(short paramShort1, short paramShort2)
  {
    return (short)(paramShort1 & paramShort2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte inv(byte paramByte)
  {
    return (byte)(paramByte ^ 0xFFFFFFFF);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short inv(short paramShort)
  {
    return (short)(paramShort ^ 0xFFFFFFFF);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte or(byte paramByte1, byte paramByte2)
  {
    return (byte)(paramByte1 | paramByte2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short or(short paramShort1, short paramShort2)
  {
    return (short)(paramShort1 | paramShort2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte xor(byte paramByte1, byte paramByte2)
  {
    return (byte)(paramByte1 ^ paramByte2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short xor(short paramShort1, short paramShort2)
  {
    return (short)(paramShort1 ^ paramShort2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.experimental.BitwiseOperationsKt
 * JD-Core Version:    0.7.0.1
 */