package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class RandomKt
{
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Random Random(int paramInt)
  {
    return (Random)new XorWowRandom(paramInt, paramInt >> 31);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Random Random(long paramLong)
  {
    return (Random)new XorWowRandom((int)paramLong, (int)(paramLong >> 32));
  }
  
  @NotNull
  public static final String boundsErrorMessage(@NotNull Object paramObject1, @NotNull Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "from");
    Intrinsics.checkParameterIsNotNull(paramObject2, "until");
    return "Random range is empty: [" + paramObject1 + ", " + paramObject2 + ").";
  }
  
  public static final void checkRangeBounds(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 > paramDouble1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(boundsErrorMessage(Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)).toString()));
    }
  }
  
  public static final void checkRangeBounds(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).toString()));
    }
  }
  
  public static final void checkRangeBounds(long paramLong1, long paramLong2)
  {
    if (paramLong2 > paramLong1) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(boundsErrorMessage(Long.valueOf(paramLong1), Long.valueOf(paramLong2)).toString()));
    }
  }
  
  public static final int fastLog2(int paramInt)
  {
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  @SinceKotlin(version="1.3")
  public static final int nextInt(@NotNull Random paramRandom, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextInt");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    if (paramIntRange.isEmpty()) {
      throw ((Throwable)new IllegalArgumentException("Cannot get random in empty range: " + paramIntRange));
    }
    if (paramIntRange.getLast() < 2147483647) {
      return paramRandom.nextInt(paramIntRange.getFirst(), paramIntRange.getLast() + 1);
    }
    if (paramIntRange.getFirst() > -2147483648) {
      return paramRandom.nextInt(paramIntRange.getFirst() - 1, paramIntRange.getLast()) + 1;
    }
    return paramRandom.nextInt();
  }
  
  @SinceKotlin(version="1.3")
  public static final long nextLong(@NotNull Random paramRandom, @NotNull LongRange paramLongRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextLong");
    Intrinsics.checkParameterIsNotNull(paramLongRange, "range");
    if (paramLongRange.isEmpty()) {
      throw ((Throwable)new IllegalArgumentException("Cannot get random in empty range: " + paramLongRange));
    }
    if (paramLongRange.getLast() < 9223372036854775807L) {
      return paramRandom.nextLong(paramLongRange.getFirst(), paramLongRange.getLast() + 1L);
    }
    if (paramLongRange.getFirst() > -9223372036854775808L) {
      return paramRandom.nextLong(paramLongRange.getFirst() - 1L, paramLongRange.getLast()) + 1L;
    }
    return paramRandom.nextLong();
  }
  
  public static final int takeUpperBits(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 & -paramInt2 >> 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.random.RandomKt
 * JD-Core Version:    0.7.0.1
 */