package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toUByte", "Lkotlin/UByte;", "", "(B)B", "", "(I)B", "", "(J)B", "", "(S)B", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UByteKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte toUByte(byte paramByte)
  {
    return UByte.constructor-impl(paramByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte toUByte(int paramInt)
  {
    return UByte.constructor-impl((byte)paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte toUByte(long paramLong)
  {
    return UByte.constructor-impl((byte)(int)paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte toUByte(short paramShort)
  {
    return UByte.constructor-impl((byte)paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UByteKt
 * JD-Core Version:    0.7.0.1
 */