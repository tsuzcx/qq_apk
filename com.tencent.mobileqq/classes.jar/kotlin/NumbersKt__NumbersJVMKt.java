package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt
  extends NumbersKt__BigIntegersKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits(int paramInt)
  {
    return Integer.numberOfLeadingZeros(paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countLeadingZeroBits(long paramLong)
  {
    return Long.numberOfLeadingZeros(paramLong);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits(int paramInt)
  {
    return Integer.bitCount(paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countOneBits(long paramLong)
  {
    return Long.bitCount(paramLong);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits(int paramInt)
  {
    return Integer.numberOfTrailingZeros(paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int countTrailingZeroBits(long paramLong)
  {
    return Long.numberOfTrailingZeros(paramLong);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final double fromBits(@NotNull DoubleCompanionObject paramDoubleCompanionObject, long paramLong)
  {
    return Double.longBitsToDouble(paramLong);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final float fromBits(@NotNull FloatCompanionObject paramFloatCompanionObject, int paramInt)
  {
    return Float.intBitsToFloat(paramInt);
  }
  
  @InlineOnly
  private static final boolean isFinite(double paramDouble)
  {
    return (!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble));
  }
  
  @InlineOnly
  private static final boolean isFinite(float paramFloat)
  {
    return (!Float.isInfinite(paramFloat)) && (!Float.isNaN(paramFloat));
  }
  
  @InlineOnly
  private static final boolean isInfinite(double paramDouble)
  {
    return Double.isInfinite(paramDouble);
  }
  
  @InlineOnly
  private static final boolean isInfinite(float paramFloat)
  {
    return Float.isInfinite(paramFloat);
  }
  
  @InlineOnly
  private static final boolean isNaN(double paramDouble)
  {
    return Double.isNaN(paramDouble);
  }
  
  @InlineOnly
  private static final boolean isNaN(float paramFloat)
  {
    return Float.isNaN(paramFloat);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int rotateLeft(int paramInt1, int paramInt2)
  {
    return Integer.rotateLeft(paramInt1, paramInt2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long rotateLeft(long paramLong, int paramInt)
  {
    return Long.rotateLeft(paramLong, paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int rotateRight(int paramInt1, int paramInt2)
  {
    return Integer.rotateRight(paramInt1, paramInt2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long rotateRight(long paramLong, int paramInt)
  {
    return Long.rotateRight(paramLong, paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int takeHighestOneBit(int paramInt)
  {
    return Integer.highestOneBit(paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long takeHighestOneBit(long paramLong)
  {
    return Long.highestOneBit(paramLong);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int takeLowestOneBit(int paramInt)
  {
    return Integer.lowestOneBit(paramInt);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long takeLowestOneBit(long paramLong)
  {
    return Long.lowestOneBit(paramLong);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final int toBits(float paramFloat)
  {
    return Float.floatToIntBits(paramFloat);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final long toBits(double paramDouble)
  {
    return Double.doubleToLongBits(paramDouble);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final int toRawBits(float paramFloat)
  {
    return Float.floatToRawIntBits(paramFloat);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final long toRawBits(double paramDouble)
  {
    return Double.doubleToRawLongBits(paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.NumbersKt__NumbersJVMKt
 * JD-Core Version:    0.7.0.1
 */