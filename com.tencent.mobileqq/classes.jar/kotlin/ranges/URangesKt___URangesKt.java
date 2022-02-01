package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/ranges/URangesKt")
class URangesKt___URangesKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short coerceAtLeast-5PvTz6A(short paramShort1, short paramShort2)
  {
    short s = paramShort1;
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) < 0) {
      s = paramShort2;
    }
    return s;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceAtLeast-J1ME1BU(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) < 0) {
      i = paramInt2;
    }
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte coerceAtLeast-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    byte b = paramByte1;
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) < 0) {
      b = paramByte2;
    }
    return b;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceAtLeast-eb3DHEI(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) < 0) {
      l = paramLong2;
    }
    return l;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short coerceAtMost-5PvTz6A(short paramShort1, short paramShort2)
  {
    short s = paramShort1;
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) > 0) {
      s = paramShort2;
    }
    return s;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceAtMost-J1ME1BU(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) > 0) {
      i = paramInt2;
    }
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte coerceAtMost-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    byte b = paramByte1;
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) > 0) {
      b = paramByte2;
    }
    return b;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceAtMost-eb3DHEI(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) > 0) {
      l = paramLong2;
    }
    return l;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceIn-JPwROB0(long paramLong, @NotNull ClosedRange<ULong> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      return ((ULong)RangesKt.coerceIn(ULong.box-impl(paramLong), (ClosedFloatingPointRange)paramClosedRange)).unbox-impl();
    }
    if (!paramClosedRange.isEmpty())
    {
      if (UnsignedKt.ulongCompare(paramLong, ((ULong)paramClosedRange.getStart()).unbox-impl()) < 0) {
        return ((ULong)paramClosedRange.getStart()).unbox-impl();
      }
      long l = paramLong;
      if (UnsignedKt.ulongCompare(paramLong, ((ULong)paramClosedRange.getEndInclusive()).unbox-impl()) > 0) {
        l = ((ULong)paramClosedRange.getEndInclusive()).unbox-impl();
      }
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: ");
    localStringBuilder.append(paramClosedRange);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short coerceIn-VKSA0NQ(short paramShort1, short paramShort2, short paramShort3)
  {
    int i = paramShort2 & 0xFFFF;
    int j = paramShort3 & 0xFFFF;
    if (Intrinsics.compare(i, j) <= 0)
    {
      int k = 0xFFFF & paramShort1;
      if (Intrinsics.compare(k, i) < 0) {
        return paramShort2;
      }
      if (Intrinsics.compare(k, j) > 0) {
        return paramShort3;
      }
      return paramShort1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(UShort.toString-impl(paramShort3));
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(UShort.toString-impl(paramShort2));
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceIn-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    if (UnsignedKt.uintCompare(paramInt2, paramInt3) <= 0)
    {
      if (UnsignedKt.uintCompare(paramInt1, paramInt2) < 0) {
        return paramInt2;
      }
      if (UnsignedKt.uintCompare(paramInt1, paramInt3) > 0) {
        return paramInt3;
      }
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(UInt.toString-impl(paramInt3));
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(UInt.toString-impl(paramInt2));
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte coerceIn-b33U2AM(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    int i = paramByte2 & 0xFF;
    int j = paramByte3 & 0xFF;
    if (Intrinsics.compare(i, j) <= 0)
    {
      int k = paramByte1 & 0xFF;
      if (Intrinsics.compare(k, i) < 0) {
        return paramByte2;
      }
      if (Intrinsics.compare(k, j) > 0) {
        return paramByte3;
      }
      return paramByte1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(UByte.toString-impl(paramByte3));
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(UByte.toString-impl(paramByte2));
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceIn-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    if (UnsignedKt.ulongCompare(paramLong2, paramLong3) <= 0)
    {
      if (UnsignedKt.ulongCompare(paramLong1, paramLong2) < 0) {
        return paramLong2;
      }
      if (UnsignedKt.ulongCompare(paramLong1, paramLong3) > 0) {
        return paramLong3;
      }
      return paramLong1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(ULong.toString-impl(paramLong3));
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(ULong.toString-impl(paramLong2));
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceIn-wuiCnnA(int paramInt, @NotNull ClosedRange<UInt> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      return ((UInt)RangesKt.coerceIn(UInt.box-impl(paramInt), (ClosedFloatingPointRange)paramClosedRange)).unbox-impl();
    }
    if (!paramClosedRange.isEmpty())
    {
      if (UnsignedKt.uintCompare(paramInt, ((UInt)paramClosedRange.getStart()).unbox-impl()) < 0) {
        return ((UInt)paramClosedRange.getStart()).unbox-impl();
      }
      int i = paramInt;
      if (UnsignedKt.uintCompare(paramInt, ((UInt)paramClosedRange.getEndInclusive()).unbox-impl()) > 0) {
        i = ((UInt)paramClosedRange.getEndInclusive()).unbox-impl();
      }
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: ");
    localStringBuilder.append(paramClosedRange);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-68kG9v0(@NotNull UIntRange paramUIntRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return paramUIntRange.contains-WZ4Q5Ns(UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains-GYNo2lE(@NotNull ULongRange paramULongRange, ULong paramULong)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return (paramULong != null) && (paramULongRange.contains-VKZWuLQ(paramULong.unbox-impl()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-Gab390E(@NotNull ULongRange paramULongRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return paramULongRange.contains-VKZWuLQ(ULong.constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-ULb-yJY(@NotNull ULongRange paramULongRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return paramULongRange.contains-VKZWuLQ(ULong.constructor-impl(paramByte & 0xFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-ZsK3CEQ(@NotNull UIntRange paramUIntRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return paramUIntRange.contains-WZ4Q5Ns(UInt.constructor-impl(paramShort & 0xFFFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains-biwQdVI(@NotNull UIntRange paramUIntRange, UInt paramUInt)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return (paramUInt != null) && (paramUIntRange.contains-WZ4Q5Ns(paramUInt.unbox-impl()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-fz5IDCE(@NotNull UIntRange paramUIntRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return (ULong.constructor-impl(paramLong >>> 32) == 0L) && (paramUIntRange.contains-WZ4Q5Ns(UInt.constructor-impl((int)paramLong)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-uhHAxoY(@NotNull ULongRange paramULongRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return paramULongRange.contains-VKZWuLQ(ULong.constructor-impl(paramShort & 0xFFFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression downTo-5PvTz6A(short paramShort1, short paramShort2)
  {
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(paramShort2 & 0xFFFF), -1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression downTo-J1ME1BU(int paramInt1, int paramInt2)
  {
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(paramInt1, paramInt2, -1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression downTo-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(paramByte2 & 0xFF), -1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongProgression downTo-eb3DHEI(long paramLong1, long paramLong2)
  {
    return ULongProgression.Companion.fromClosedRange-7ftBX0g(paramLong1, paramLong2, -1L);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int random(@NotNull UIntRange paramUIntRange)
  {
    return URangesKt.random(paramUIntRange, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int random(@NotNull UIntRange paramUIntRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      int i = URandomKt.nextUInt(paramRandom, paramUIntRange);
      return i;
    }
    catch (IllegalArgumentException paramUIntRange)
    {
      throw ((Throwable)new NoSuchElementException(paramUIntRange.getMessage()));
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long random(@NotNull ULongRange paramULongRange)
  {
    return URangesKt.random(paramULongRange, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long random(@NotNull ULongRange paramULongRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      long l = URandomKt.nextULong(paramRandom, paramULongRange);
      return l;
    }
    catch (IllegalArgumentException paramULongRange)
    {
      throw ((Throwable)new NoSuchElementException(paramULongRange.getMessage()));
    }
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt randomOrNull(@NotNull UIntRange paramUIntRange)
  {
    return URangesKt.randomOrNull(paramUIntRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt randomOrNull(@NotNull UIntRange paramUIntRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramUIntRange.isEmpty()) {
      return null;
    }
    return UInt.box-impl(URandomKt.nextUInt(paramRandom, paramUIntRange));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong randomOrNull(@NotNull ULongRange paramULongRange)
  {
    return URangesKt.randomOrNull(paramULongRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong randomOrNull(@NotNull ULongRange paramULongRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramULongRange.isEmpty()) {
      return null;
    }
    return ULong.box-impl(URandomKt.nextULong(paramRandom, paramULongRange));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression reversed(@NotNull UIntProgression paramUIntProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntProgression, "$this$reversed");
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(paramUIntProgression.getLast(), paramUIntProgression.getFirst(), -paramUIntProgression.getStep());
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongProgression reversed(@NotNull ULongProgression paramULongProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramULongProgression, "$this$reversed");
    return ULongProgression.Companion.fromClosedRange-7ftBX0g(paramULongProgression.getLast(), paramULongProgression.getFirst(), -paramULongProgression.getStep());
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression step(@NotNull UIntProgression paramUIntProgression, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntProgression, "$this$step");
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    RangesKt.checkStepIsPositive(bool, (Number)Integer.valueOf(paramInt));
    UIntProgression.Companion localCompanion = UIntProgression.Companion;
    int i = paramUIntProgression.getFirst();
    int j = paramUIntProgression.getLast();
    if (paramUIntProgression.getStep() <= 0) {
      paramInt = -paramInt;
    }
    return localCompanion.fromClosedRange-Nkh28Cs(i, j, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongProgression step(@NotNull ULongProgression paramULongProgression, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramULongProgression, "$this$step");
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    RangesKt.checkStepIsPositive(bool, (Number)Long.valueOf(paramLong));
    ULongProgression.Companion localCompanion = ULongProgression.Companion;
    long l1 = paramULongProgression.getFirst();
    long l2 = paramULongProgression.getLast();
    if (paramULongProgression.getStep() <= 0L) {
      paramLong = -paramLong;
    }
    return localCompanion.fromClosedRange-7ftBX0g(l1, l2, paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntRange until-5PvTz6A(short paramShort1, short paramShort2)
  {
    paramShort2 &= 0xFFFF;
    if (Intrinsics.compare(paramShort2, 0) <= 0) {
      return UIntRange.Companion.getEMPTY();
    }
    return new UIntRange(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(UInt.constructor-impl(paramShort2) - 1), null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntRange until-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt2, 0) <= 0) {
      return UIntRange.Companion.getEMPTY();
    }
    return new UIntRange(paramInt1, UInt.constructor-impl(paramInt2 - 1), null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntRange until-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    paramByte2 &= 0xFF;
    if (Intrinsics.compare(paramByte2, 0) <= 0) {
      return UIntRange.Companion.getEMPTY();
    }
    return new UIntRange(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(UInt.constructor-impl(paramByte2) - 1), null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongRange until-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong2, 0L) <= 0) {
      return ULongRange.Companion.getEMPTY();
    }
    return new ULongRange(paramLong1, ULong.constructor-impl(paramLong2 - ULong.constructor-impl(1 & 0xFFFFFFFF)), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ranges.URangesKt___URangesKt
 * JD-Core Version:    0.7.0.1
 */