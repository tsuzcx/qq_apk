package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class URandomKt
{
  @ExperimentalUnsignedTypes
  public static final void checkUIntRangeBounds-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt2, paramInt1) > 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.box-impl(paramInt1), UInt.box-impl(paramInt2)).toString()));
    }
  }
  
  @ExperimentalUnsignedTypes
  public static final void checkULongRangeBounds-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong2, paramLong1) > 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.box-impl(paramLong1), ULong.box-impl(paramLong2)).toString()));
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] nextUBytes(@NotNull Random paramRandom, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUBytes");
    return UByteArray.constructor-impl(paramRandom.nextBytes(paramInt));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] nextUBytes-EVgfTAA(@NotNull Random paramRandom, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    paramRandom.nextBytes(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] nextUBytes-Wvrt4B4(@NotNull Random paramRandom, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    paramRandom.nextBytes(paramArrayOfByte, paramInt1, paramInt2);
    return paramArrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int nextUInt(@NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    return UInt.constructor-impl(paramRandom.nextInt());
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int nextUInt(@NotNull Random paramRandom, @NotNull UIntRange paramUIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "range");
    if (paramUIntRange.isEmpty()) {
      throw ((Throwable)new IllegalArgumentException("Cannot get random in empty range: " + paramUIntRange));
    }
    if (UnsignedKt.uintCompare(paramUIntRange.getLast(), -1) < 0) {
      return nextUInt-a8DCA5k(paramRandom, paramUIntRange.getFirst(), UInt.constructor-impl(paramUIntRange.getLast() + 1));
    }
    if (UnsignedKt.uintCompare(paramUIntRange.getFirst(), 0) > 0) {
      return UInt.constructor-impl(nextUInt-a8DCA5k(paramRandom, UInt.constructor-impl(paramUIntRange.getFirst() - 1), paramUIntRange.getLast()) + 1);
    }
    return nextUInt(paramRandom);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int nextUInt-a8DCA5k(@NotNull Random paramRandom, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    checkUIntRangeBounds-J1ME1BU(paramInt1, paramInt2);
    return UInt.constructor-impl(paramRandom.nextInt(paramInt1 ^ 0x80000000, paramInt2 ^ 0x80000000) ^ 0x80000000);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int nextUInt-qCasIEU(@NotNull Random paramRandom, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextUInt");
    return nextUInt-a8DCA5k(paramRandom, 0, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long nextULong(@NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    return ULong.constructor-impl(paramRandom.nextLong());
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long nextULong(@NotNull Random paramRandom, @NotNull ULongRange paramULongRange)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    Intrinsics.checkParameterIsNotNull(paramULongRange, "range");
    if (paramULongRange.isEmpty()) {
      throw ((Throwable)new IllegalArgumentException("Cannot get random in empty range: " + paramULongRange));
    }
    if (UnsignedKt.ulongCompare(paramULongRange.getLast(), -1L) < 0) {
      return nextULong-jmpaW-c(paramRandom, paramULongRange.getFirst(), ULong.constructor-impl(paramULongRange.getLast() + ULong.constructor-impl(1 & 0xFFFFFFFF)));
    }
    if (UnsignedKt.ulongCompare(paramULongRange.getFirst(), 0L) > 0) {
      return ULong.constructor-impl(nextULong-jmpaW-c(paramRandom, ULong.constructor-impl(paramULongRange.getFirst() - ULong.constructor-impl(1 & 0xFFFFFFFF)), paramULongRange.getLast()) + ULong.constructor-impl(1 & 0xFFFFFFFF));
    }
    return nextULong(paramRandom);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long nextULong-V1Xi4fY(@NotNull Random paramRandom, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    return nextULong-jmpaW-c(paramRandom, 0L, paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long nextULong-jmpaW-c(@NotNull Random paramRandom, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$nextULong");
    checkULongRangeBounds-eb3DHEI(paramLong1, paramLong2);
    return ULong.constructor-impl(paramRandom.nextLong(paramLong1 ^ 0x0, paramLong2 ^ 0x0) ^ 0x0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.random.URandomKt
 * JD-Core Version:    0.7.0.1
 */