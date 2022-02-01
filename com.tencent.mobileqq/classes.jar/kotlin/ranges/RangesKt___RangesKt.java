package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/ranges/RangesKt")
class RangesKt___RangesKt
  extends RangesKt__RangesKt
{
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="byteRangeContains")
  public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> paramClosedRange, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Byte localByte = RangesKt.toByteExactOrNull(paramDouble);
    if (localByte != null) {
      return paramClosedRange.contains((Comparable)localByte);
    }
    return false;
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="byteRangeContains")
  public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> paramClosedRange, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Byte localByte = RangesKt.toByteExactOrNull(paramFloat);
    if (localByte != null) {
      return paramClosedRange.contains((Comparable)localByte);
    }
    return false;
  }
  
  @JvmName(name="byteRangeContains")
  public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> paramClosedRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Byte localByte = RangesKt.toByteExactOrNull(paramInt);
    if (localByte != null) {
      return paramClosedRange.contains((Comparable)localByte);
    }
    return false;
  }
  
  @JvmName(name="byteRangeContains")
  public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> paramClosedRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Byte localByte = RangesKt.toByteExactOrNull(paramLong);
    if (localByte != null) {
      return paramClosedRange.contains((Comparable)localByte);
    }
    return false;
  }
  
  @JvmName(name="byteRangeContains")
  public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> paramClosedRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Byte localByte = RangesKt.toByteExactOrNull(paramShort);
    if (localByte != null) {
      return paramClosedRange.contains((Comparable)localByte);
    }
    return false;
  }
  
  public static final byte coerceAtLeast(byte paramByte1, byte paramByte2)
  {
    byte b = paramByte1;
    if (paramByte1 < paramByte2) {
      b = paramByte2;
    }
    return b;
  }
  
  public static final double coerceAtLeast(double paramDouble1, double paramDouble2)
  {
    double d = paramDouble1;
    if (paramDouble1 < paramDouble2) {
      d = paramDouble2;
    }
    return d;
  }
  
  public static final float coerceAtLeast(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < paramFloat2) {
      f = paramFloat2;
    }
    return f;
  }
  
  public static final int coerceAtLeast(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static final long coerceAtLeast(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 < paramLong2) {
      l = paramLong2;
    }
    return l;
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> T coerceAtLeast(@NotNull T paramT1, @NotNull T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "$this$coerceAtLeast");
    Intrinsics.checkParameterIsNotNull(paramT2, "minimumValue");
    T ? = paramT1;
    if (paramT1.compareTo(paramT2) < 0) {
      ? = paramT2;
    }
    return ?;
  }
  
  public static final short coerceAtLeast(short paramShort1, short paramShort2)
  {
    short s = paramShort1;
    if (paramShort1 < paramShort2) {
      s = paramShort2;
    }
    return s;
  }
  
  public static final byte coerceAtMost(byte paramByte1, byte paramByte2)
  {
    byte b = paramByte1;
    if (paramByte1 > paramByte2) {
      b = paramByte2;
    }
    return b;
  }
  
  public static final double coerceAtMost(double paramDouble1, double paramDouble2)
  {
    double d = paramDouble1;
    if (paramDouble1 > paramDouble2) {
      d = paramDouble2;
    }
    return d;
  }
  
  public static final float coerceAtMost(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 > paramFloat2) {
      f = paramFloat2;
    }
    return f;
  }
  
  public static final int coerceAtMost(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static final long coerceAtMost(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 > paramLong2) {
      l = paramLong2;
    }
    return l;
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> T coerceAtMost(@NotNull T paramT1, @NotNull T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "$this$coerceAtMost");
    Intrinsics.checkParameterIsNotNull(paramT2, "maximumValue");
    T ? = paramT1;
    if (paramT1.compareTo(paramT2) > 0) {
      ? = paramT2;
    }
    return ?;
  }
  
  public static final short coerceAtMost(short paramShort1, short paramShort2)
  {
    short s = paramShort1;
    if (paramShort1 > paramShort2) {
      s = paramShort2;
    }
    return s;
  }
  
  public static final byte coerceIn(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    if (paramByte2 <= paramByte3)
    {
      if (paramByte1 < paramByte2) {
        return paramByte2;
      }
      if (paramByte1 > paramByte3) {
        return paramByte3;
      }
      return paramByte1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramByte3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramByte2);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final double coerceIn(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (paramDouble2 <= paramDouble3)
    {
      if (paramDouble1 < paramDouble2) {
        return paramDouble2;
      }
      if (paramDouble1 > paramDouble3) {
        return paramDouble3;
      }
      return paramDouble1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramDouble3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramDouble2);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final float coerceIn(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat2 <= paramFloat3)
    {
      if (paramFloat1 < paramFloat2) {
        return paramFloat2;
      }
      if (paramFloat1 > paramFloat3) {
        return paramFloat3;
      }
      return paramFloat1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramFloat3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final int coerceIn(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt3)
    {
      if (paramInt1 < paramInt2) {
        return paramInt2;
      }
      if (paramInt1 > paramInt3) {
        return paramInt3;
      }
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final int coerceIn(int paramInt, @NotNull ClosedRange<Integer> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      return ((Number)RangesKt.coerceIn((Comparable)Integer.valueOf(paramInt), (ClosedFloatingPointRange)paramClosedRange)).intValue();
    }
    if (!paramClosedRange.isEmpty())
    {
      if (paramInt < ((Number)paramClosedRange.getStart()).intValue()) {
        return ((Number)paramClosedRange.getStart()).intValue();
      }
      int i = paramInt;
      if (paramInt > ((Number)paramClosedRange.getEndInclusive()).intValue()) {
        i = ((Number)paramClosedRange.getEndInclusive()).intValue();
      }
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: ");
    localStringBuilder.append(paramClosedRange);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final long coerceIn(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong2 <= paramLong3)
    {
      if (paramLong1 < paramLong2) {
        return paramLong2;
      }
      if (paramLong1 > paramLong3) {
        return paramLong3;
      }
      return paramLong1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramLong3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public static final long coerceIn(long paramLong, @NotNull ClosedRange<Long> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      return ((Number)RangesKt.coerceIn((Comparable)Long.valueOf(paramLong), (ClosedFloatingPointRange)paramClosedRange)).longValue();
    }
    if (!paramClosedRange.isEmpty())
    {
      if (paramLong < ((Number)paramClosedRange.getStart()).longValue()) {
        return ((Number)paramClosedRange.getStart()).longValue();
      }
      long l = paramLong;
      if (paramLong > ((Number)paramClosedRange.getEndInclusive()).longValue()) {
        l = ((Number)paramClosedRange.getEndInclusive()).longValue();
      }
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: ");
    localStringBuilder.append(paramClosedRange);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T paramT1, @Nullable T paramT2, @Nullable T paramT3)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "$this$coerceIn");
    if ((paramT2 != null) && (paramT3 != null))
    {
      if (paramT2.compareTo(paramT3) <= 0)
      {
        if (paramT1.compareTo(paramT2) < 0) {
          return paramT2;
        }
        if (paramT1.compareTo(paramT3) > 0) {
          return paramT3;
        }
      }
      else
      {
        paramT1 = new StringBuilder();
        paramT1.append("Cannot coerce value to an empty range: maximum ");
        paramT1.append(paramT3);
        paramT1.append(" is less than minimum ");
        paramT1.append(paramT2);
        paramT1.append('.');
        throw ((Throwable)new IllegalArgumentException(paramT1.toString()));
      }
    }
    else
    {
      if ((paramT2 != null) && (paramT1.compareTo(paramT2) < 0)) {
        return paramT2;
      }
      if ((paramT3 != null) && (paramT1.compareTo(paramT3) > 0)) {
        return paramT3;
      }
    }
    return paramT1;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T paramT, @NotNull ClosedFloatingPointRange<T> paramClosedFloatingPointRange)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$coerceIn");
    Intrinsics.checkParameterIsNotNull(paramClosedFloatingPointRange, "range");
    if (!paramClosedFloatingPointRange.isEmpty())
    {
      if ((paramClosedFloatingPointRange.lessThanOrEquals(paramT, paramClosedFloatingPointRange.getStart())) && (!paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramT))) {
        return paramClosedFloatingPointRange.getStart();
      }
      Object localObject = paramT;
      if (paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getEndInclusive(), paramT))
      {
        localObject = paramT;
        if (!paramClosedFloatingPointRange.lessThanOrEquals(paramT, paramClosedFloatingPointRange.getEndInclusive())) {
          localObject = paramClosedFloatingPointRange.getEndInclusive();
        }
      }
      return localObject;
    }
    paramT = new StringBuilder();
    paramT.append("Cannot coerce value to an empty range: ");
    paramT.append(paramClosedFloatingPointRange);
    paramT.append('.');
    throw ((Throwable)new IllegalArgumentException(paramT.toString()));
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T paramT, @NotNull ClosedRange<T> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$coerceIn");
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      return RangesKt.coerceIn(paramT, (ClosedFloatingPointRange)paramClosedRange);
    }
    if (!paramClosedRange.isEmpty())
    {
      if (paramT.compareTo(paramClosedRange.getStart()) < 0) {
        return paramClosedRange.getStart();
      }
      Object localObject = paramT;
      if (paramT.compareTo(paramClosedRange.getEndInclusive()) > 0) {
        localObject = paramClosedRange.getEndInclusive();
      }
      return localObject;
    }
    paramT = new StringBuilder();
    paramT.append("Cannot coerce value to an empty range: ");
    paramT.append(paramClosedRange);
    paramT.append('.');
    throw ((Throwable)new IllegalArgumentException(paramT.toString()));
  }
  
  public static final short coerceIn(short paramShort1, short paramShort2, short paramShort3)
  {
    if (paramShort2 <= paramShort3)
    {
      if (paramShort1 < paramShort2) {
        return paramShort2;
      }
      if (paramShort1 > paramShort3) {
        return paramShort3;
      }
      return paramShort1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramShort3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramShort2);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains(@NotNull CharRange paramCharRange, Character paramCharacter)
  {
    Intrinsics.checkParameterIsNotNull(paramCharRange, "$this$contains");
    return (paramCharacter != null) && (paramCharRange.contains(paramCharacter.charValue()));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains(@NotNull IntRange paramIntRange, Integer paramInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramIntRange, "$this$contains");
    return (paramInteger != null) && (paramIntRange.contains(paramInteger.intValue()));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains(@NotNull LongRange paramLongRange, Long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramLongRange, "$this$contains");
    return (paramLong != null) && (paramLongRange.contains(paramLong.longValue()));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="doubleRangeContains")
  public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> paramClosedRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Double.valueOf(paramByte));
  }
  
  @JvmName(name="doubleRangeContains")
  public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> paramClosedRange, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Double.valueOf(paramFloat));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="doubleRangeContains")
  public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> paramClosedRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Double.valueOf(paramInt));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="doubleRangeContains")
  public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> paramClosedRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Double.valueOf(paramLong));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="doubleRangeContains")
  public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> paramClosedRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Double.valueOf(paramShort));
  }
  
  @NotNull
  public static final CharProgression downTo(char paramChar1, char paramChar2)
  {
    return CharProgression.Companion.fromClosedRange(paramChar1, paramChar2, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(byte paramByte1, byte paramByte2)
  {
    return IntProgression.Companion.fromClosedRange(paramByte1, paramByte2, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(byte paramByte, int paramInt)
  {
    return IntProgression.Companion.fromClosedRange(paramByte, paramInt, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(byte paramByte, short paramShort)
  {
    return IntProgression.Companion.fromClosedRange(paramByte, paramShort, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(int paramInt, byte paramByte)
  {
    return IntProgression.Companion.fromClosedRange(paramInt, paramByte, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(int paramInt1, int paramInt2)
  {
    return IntProgression.Companion.fromClosedRange(paramInt1, paramInt2, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(int paramInt, short paramShort)
  {
    return IntProgression.Companion.fromClosedRange(paramInt, paramShort, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(short paramShort, byte paramByte)
  {
    return IntProgression.Companion.fromClosedRange(paramShort, paramByte, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(short paramShort, int paramInt)
  {
    return IntProgression.Companion.fromClosedRange(paramShort, paramInt, -1);
  }
  
  @NotNull
  public static final IntProgression downTo(short paramShort1, short paramShort2)
  {
    return IntProgression.Companion.fromClosedRange(paramShort1, paramShort2, -1);
  }
  
  @NotNull
  public static final LongProgression downTo(byte paramByte, long paramLong)
  {
    return LongProgression.Companion.fromClosedRange(paramByte, paramLong, -1L);
  }
  
  @NotNull
  public static final LongProgression downTo(int paramInt, long paramLong)
  {
    return LongProgression.Companion.fromClosedRange(paramInt, paramLong, -1L);
  }
  
  @NotNull
  public static final LongProgression downTo(long paramLong, byte paramByte)
  {
    return LongProgression.Companion.fromClosedRange(paramLong, paramByte, -1L);
  }
  
  @NotNull
  public static final LongProgression downTo(long paramLong, int paramInt)
  {
    return LongProgression.Companion.fromClosedRange(paramLong, paramInt, -1L);
  }
  
  @NotNull
  public static final LongProgression downTo(long paramLong1, long paramLong2)
  {
    return LongProgression.Companion.fromClosedRange(paramLong1, paramLong2, -1L);
  }
  
  @NotNull
  public static final LongProgression downTo(long paramLong, short paramShort)
  {
    return LongProgression.Companion.fromClosedRange(paramLong, paramShort, -1L);
  }
  
  @NotNull
  public static final LongProgression downTo(short paramShort, long paramLong)
  {
    return LongProgression.Companion.fromClosedRange(paramShort, paramLong, -1L);
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="floatRangeContains")
  public static final boolean floatRangeContains(@NotNull ClosedRange<Float> paramClosedRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Float.valueOf(paramByte));
  }
  
  @JvmName(name="floatRangeContains")
  public static final boolean floatRangeContains(@NotNull ClosedRange<Float> paramClosedRange, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Float.valueOf((float)paramDouble));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="floatRangeContains")
  public static final boolean floatRangeContains(@NotNull ClosedRange<Float> paramClosedRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Float.valueOf(paramInt));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="floatRangeContains")
  public static final boolean floatRangeContains(@NotNull ClosedRange<Float> paramClosedRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Float.valueOf((float)paramLong));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="floatRangeContains")
  public static final boolean floatRangeContains(@NotNull ClosedRange<Float> paramClosedRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Float.valueOf(paramShort));
  }
  
  @JvmName(name="intRangeContains")
  public static final boolean intRangeContains(@NotNull ClosedRange<Integer> paramClosedRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Integer.valueOf(paramByte));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="intRangeContains")
  public static final boolean intRangeContains(@NotNull ClosedRange<Integer> paramClosedRange, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Integer localInteger = RangesKt.toIntExactOrNull(paramDouble);
    if (localInteger != null) {
      return paramClosedRange.contains((Comparable)localInteger);
    }
    return false;
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="intRangeContains")
  public static final boolean intRangeContains(@NotNull ClosedRange<Integer> paramClosedRange, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Integer localInteger = RangesKt.toIntExactOrNull(paramFloat);
    if (localInteger != null) {
      return paramClosedRange.contains((Comparable)localInteger);
    }
    return false;
  }
  
  @JvmName(name="intRangeContains")
  public static final boolean intRangeContains(@NotNull ClosedRange<Integer> paramClosedRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Integer localInteger = RangesKt.toIntExactOrNull(paramLong);
    if (localInteger != null) {
      return paramClosedRange.contains((Comparable)localInteger);
    }
    return false;
  }
  
  @JvmName(name="intRangeContains")
  public static final boolean intRangeContains(@NotNull ClosedRange<Integer> paramClosedRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Integer.valueOf(paramShort));
  }
  
  @JvmName(name="longRangeContains")
  public static final boolean longRangeContains(@NotNull ClosedRange<Long> paramClosedRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Long.valueOf(paramByte));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="longRangeContains")
  public static final boolean longRangeContains(@NotNull ClosedRange<Long> paramClosedRange, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Long localLong = RangesKt.toLongExactOrNull(paramDouble);
    if (localLong != null) {
      return paramClosedRange.contains((Comparable)localLong);
    }
    return false;
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="longRangeContains")
  public static final boolean longRangeContains(@NotNull ClosedRange<Long> paramClosedRange, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Long localLong = RangesKt.toLongExactOrNull(paramFloat);
    if (localLong != null) {
      return paramClosedRange.contains((Comparable)localLong);
    }
    return false;
  }
  
  @JvmName(name="longRangeContains")
  public static final boolean longRangeContains(@NotNull ClosedRange<Long> paramClosedRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Long.valueOf(paramInt));
  }
  
  @JvmName(name="longRangeContains")
  public static final boolean longRangeContains(@NotNull ClosedRange<Long> paramClosedRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Long.valueOf(paramShort));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final char random(@NotNull CharRange paramCharRange)
  {
    return RangesKt.random(paramCharRange, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final char random(@NotNull CharRange paramCharRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCharRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      int i = paramRandom.nextInt(paramCharRange.getFirst(), paramCharRange.getLast() + '\001');
      return (char)i;
    }
    catch (IllegalArgumentException paramCharRange)
    {
      throw ((Throwable)new NoSuchElementException(paramCharRange.getMessage()));
    }
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int random(@NotNull IntRange paramIntRange)
  {
    return RangesKt.random(paramIntRange, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final int random(@NotNull IntRange paramIntRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramIntRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      int i = RandomKt.nextInt(paramRandom, paramIntRange);
      return i;
    }
    catch (IllegalArgumentException paramIntRange)
    {
      throw ((Throwable)new NoSuchElementException(paramIntRange.getMessage()));
    }
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long random(@NotNull LongRange paramLongRange)
  {
    return RangesKt.random(paramLongRange, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final long random(@NotNull LongRange paramLongRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramLongRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      long l = RandomKt.nextLong(paramRandom, paramLongRange);
      return l;
    }
    catch (IllegalArgumentException paramLongRange)
    {
      throw ((Throwable)new NoSuchElementException(paramLongRange.getMessage()));
    }
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Character randomOrNull(@NotNull CharRange paramCharRange)
  {
    return RangesKt.randomOrNull(paramCharRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character randomOrNull(@NotNull CharRange paramCharRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCharRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramCharRange.isEmpty()) {
      return null;
    }
    return Character.valueOf((char)paramRandom.nextInt(paramCharRange.getFirst(), paramCharRange.getLast() + '\001'));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Integer randomOrNull(@NotNull IntRange paramIntRange)
  {
    return RangesKt.randomOrNull(paramIntRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Integer randomOrNull(@NotNull IntRange paramIntRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramIntRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramIntRange.isEmpty()) {
      return null;
    }
    return Integer.valueOf(RandomKt.nextInt(paramRandom, paramIntRange));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Long randomOrNull(@NotNull LongRange paramLongRange)
  {
    return RangesKt.randomOrNull(paramLongRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Long randomOrNull(@NotNull LongRange paramLongRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramLongRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramLongRange.isEmpty()) {
      return null;
    }
    return Long.valueOf(RandomKt.nextLong(paramRandom, paramLongRange));
  }
  
  @NotNull
  public static final CharProgression reversed(@NotNull CharProgression paramCharProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramCharProgression, "$this$reversed");
    return CharProgression.Companion.fromClosedRange(paramCharProgression.getLast(), paramCharProgression.getFirst(), -paramCharProgression.getStep());
  }
  
  @NotNull
  public static final IntProgression reversed(@NotNull IntProgression paramIntProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramIntProgression, "$this$reversed");
    return IntProgression.Companion.fromClosedRange(paramIntProgression.getLast(), paramIntProgression.getFirst(), -paramIntProgression.getStep());
  }
  
  @NotNull
  public static final LongProgression reversed(@NotNull LongProgression paramLongProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramLongProgression, "$this$reversed");
    return LongProgression.Companion.fromClosedRange(paramLongProgression.getLast(), paramLongProgression.getFirst(), -paramLongProgression.getStep());
  }
  
  @JvmName(name="shortRangeContains")
  public static final boolean shortRangeContains(@NotNull ClosedRange<Short> paramClosedRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    return paramClosedRange.contains((Comparable)Short.valueOf((short)paramByte));
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="shortRangeContains")
  public static final boolean shortRangeContains(@NotNull ClosedRange<Short> paramClosedRange, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Short localShort = RangesKt.toShortExactOrNull(paramDouble);
    if (localShort != null) {
      return paramClosedRange.contains((Comparable)localShort);
    }
    return false;
  }
  
  @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
  @JvmName(name="shortRangeContains")
  public static final boolean shortRangeContains(@NotNull ClosedRange<Short> paramClosedRange, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Short localShort = RangesKt.toShortExactOrNull(paramFloat);
    if (localShort != null) {
      return paramClosedRange.contains((Comparable)localShort);
    }
    return false;
  }
  
  @JvmName(name="shortRangeContains")
  public static final boolean shortRangeContains(@NotNull ClosedRange<Short> paramClosedRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Short localShort = RangesKt.toShortExactOrNull(paramInt);
    if (localShort != null) {
      return paramClosedRange.contains((Comparable)localShort);
    }
    return false;
  }
  
  @JvmName(name="shortRangeContains")
  public static final boolean shortRangeContains(@NotNull ClosedRange<Short> paramClosedRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "$this$contains");
    Short localShort = RangesKt.toShortExactOrNull(paramLong);
    if (localShort != null) {
      return paramClosedRange.contains((Comparable)localShort);
    }
    return false;
  }
  
  @NotNull
  public static final CharProgression step(@NotNull CharProgression paramCharProgression, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharProgression, "$this$step");
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    RangesKt.checkStepIsPositive(bool, (Number)Integer.valueOf(paramInt));
    CharProgression.Companion localCompanion = CharProgression.Companion;
    char c1 = paramCharProgression.getFirst();
    char c2 = paramCharProgression.getLast();
    if (paramCharProgression.getStep() <= 0) {
      paramInt = -paramInt;
    }
    return localCompanion.fromClosedRange(c1, c2, paramInt);
  }
  
  @NotNull
  public static final IntProgression step(@NotNull IntProgression paramIntProgression, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIntProgression, "$this$step");
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    RangesKt.checkStepIsPositive(bool, (Number)Integer.valueOf(paramInt));
    IntProgression.Companion localCompanion = IntProgression.Companion;
    int i = paramIntProgression.getFirst();
    int j = paramIntProgression.getLast();
    if (paramIntProgression.getStep() <= 0) {
      paramInt = -paramInt;
    }
    return localCompanion.fromClosedRange(i, j, paramInt);
  }
  
  @NotNull
  public static final LongProgression step(@NotNull LongProgression paramLongProgression, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramLongProgression, "$this$step");
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    RangesKt.checkStepIsPositive(bool, (Number)Long.valueOf(paramLong));
    LongProgression.Companion localCompanion = LongProgression.Companion;
    long l1 = paramLongProgression.getFirst();
    long l2 = paramLongProgression.getLast();
    if (paramLongProgression.getStep() <= 0L) {
      paramLong = -paramLong;
    }
    return localCompanion.fromClosedRange(l1, l2, paramLong);
  }
  
  @Nullable
  public static final Byte toByteExactOrNull(double paramDouble)
  {
    double d1 = -128;
    double d2 = 127;
    if ((paramDouble >= d1) && (paramDouble <= d2)) {
      return Byte.valueOf((byte)(int)paramDouble);
    }
    return null;
  }
  
  @Nullable
  public static final Byte toByteExactOrNull(float paramFloat)
  {
    float f1 = -128;
    float f2 = 127;
    if ((paramFloat >= f1) && (paramFloat <= f2)) {
      return Byte.valueOf((byte)(int)paramFloat);
    }
    return null;
  }
  
  @Nullable
  public static final Byte toByteExactOrNull(int paramInt)
  {
    if ((-128 <= paramInt) && (127 >= paramInt)) {
      return Byte.valueOf((byte)paramInt);
    }
    return null;
  }
  
  @Nullable
  public static final Byte toByteExactOrNull(long paramLong)
  {
    long l1 = -128;
    long l2 = 127;
    if ((l1 <= paramLong) && (l2 >= paramLong)) {
      return Byte.valueOf((byte)(int)paramLong);
    }
    return null;
  }
  
  @Nullable
  public static final Byte toByteExactOrNull(short paramShort)
  {
    short s1 = (short)-128;
    short s2 = (short)127;
    if ((s1 <= paramShort) && (s2 >= paramShort)) {
      return Byte.valueOf((byte)paramShort);
    }
    return null;
  }
  
  @Nullable
  public static final Integer toIntExactOrNull(double paramDouble)
  {
    double d1 = -2147483648;
    double d2 = 2147483647;
    if ((paramDouble >= d1) && (paramDouble <= d2)) {
      return Integer.valueOf((int)paramDouble);
    }
    return null;
  }
  
  @Nullable
  public static final Integer toIntExactOrNull(float paramFloat)
  {
    float f1 = -2147483648;
    float f2 = 2147483647;
    if ((paramFloat >= f1) && (paramFloat <= f2)) {
      return Integer.valueOf((int)paramFloat);
    }
    return null;
  }
  
  @Nullable
  public static final Integer toIntExactOrNull(long paramLong)
  {
    long l1 = -2147483648;
    long l2 = 2147483647;
    if ((l1 <= paramLong) && (l2 >= paramLong)) {
      return Integer.valueOf((int)paramLong);
    }
    return null;
  }
  
  @Nullable
  public static final Long toLongExactOrNull(double paramDouble)
  {
    double d1 = -9223372036854775808L;
    double d2 = 9223372036854775807L;
    if ((paramDouble >= d1) && (paramDouble <= d2)) {
      return Long.valueOf(paramDouble);
    }
    return null;
  }
  
  @Nullable
  public static final Long toLongExactOrNull(float paramFloat)
  {
    float f1 = (float)-9223372036854775808L;
    float f2 = (float)9223372036854775807L;
    if ((paramFloat >= f1) && (paramFloat <= f2)) {
      return Long.valueOf(paramFloat);
    }
    return null;
  }
  
  @Nullable
  public static final Short toShortExactOrNull(double paramDouble)
  {
    double d1 = -32768;
    double d2 = 32767;
    if ((paramDouble >= d1) && (paramDouble <= d2)) {
      return Short.valueOf((short)(int)paramDouble);
    }
    return null;
  }
  
  @Nullable
  public static final Short toShortExactOrNull(float paramFloat)
  {
    float f1 = -32768;
    float f2 = 32767;
    if ((paramFloat >= f1) && (paramFloat <= f2)) {
      return Short.valueOf((short)(int)paramFloat);
    }
    return null;
  }
  
  @Nullable
  public static final Short toShortExactOrNull(int paramInt)
  {
    if ((-32768 <= paramInt) && (32767 >= paramInt)) {
      return Short.valueOf((short)paramInt);
    }
    return null;
  }
  
  @Nullable
  public static final Short toShortExactOrNull(long paramLong)
  {
    long l1 = -32768;
    long l2 = 32767;
    if ((l1 <= paramLong) && (l2 >= paramLong)) {
      return Short.valueOf((short)(int)paramLong);
    }
    return null;
  }
  
  @NotNull
  public static final CharRange until(char paramChar1, char paramChar2)
  {
    if (paramChar2 <= 0) {
      return CharRange.Companion.getEMPTY();
    }
    return new CharRange(paramChar1, (char)(paramChar2 - '\001'));
  }
  
  @NotNull
  public static final IntRange until(byte paramByte1, byte paramByte2)
  {
    return new IntRange(paramByte1, paramByte2 - 1);
  }
  
  @NotNull
  public static final IntRange until(byte paramByte, int paramInt)
  {
    if (paramInt <= -2147483648) {
      return IntRange.Companion.getEMPTY();
    }
    return new IntRange(paramByte, paramInt - 1);
  }
  
  @NotNull
  public static final IntRange until(byte paramByte, short paramShort)
  {
    return new IntRange(paramByte, paramShort - 1);
  }
  
  @NotNull
  public static final IntRange until(int paramInt, byte paramByte)
  {
    return new IntRange(paramInt, paramByte - 1);
  }
  
  @NotNull
  public static final IntRange until(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= -2147483648) {
      return IntRange.Companion.getEMPTY();
    }
    return new IntRange(paramInt1, paramInt2 - 1);
  }
  
  @NotNull
  public static final IntRange until(int paramInt, short paramShort)
  {
    return new IntRange(paramInt, paramShort - 1);
  }
  
  @NotNull
  public static final IntRange until(short paramShort, byte paramByte)
  {
    return new IntRange(paramShort, paramByte - 1);
  }
  
  @NotNull
  public static final IntRange until(short paramShort, int paramInt)
  {
    if (paramInt <= -2147483648) {
      return IntRange.Companion.getEMPTY();
    }
    return new IntRange(paramShort, paramInt - 1);
  }
  
  @NotNull
  public static final IntRange until(short paramShort1, short paramShort2)
  {
    return new IntRange(paramShort1, paramShort2 - 1);
  }
  
  @NotNull
  public static final LongRange until(byte paramByte, long paramLong)
  {
    if (paramLong <= -9223372036854775808L) {
      return LongRange.Companion.getEMPTY();
    }
    return new LongRange(paramByte, paramLong - 1L);
  }
  
  @NotNull
  public static final LongRange until(int paramInt, long paramLong)
  {
    if (paramLong <= -9223372036854775808L) {
      return LongRange.Companion.getEMPTY();
    }
    return new LongRange(paramInt, paramLong - 1L);
  }
  
  @NotNull
  public static final LongRange until(long paramLong, byte paramByte)
  {
    return new LongRange(paramLong, paramByte - 1L);
  }
  
  @NotNull
  public static final LongRange until(long paramLong, int paramInt)
  {
    return new LongRange(paramLong, paramInt - 1L);
  }
  
  @NotNull
  public static final LongRange until(long paramLong1, long paramLong2)
  {
    if (paramLong2 <= -9223372036854775808L) {
      return LongRange.Companion.getEMPTY();
    }
    return new LongRange(paramLong1, paramLong2 - 1L);
  }
  
  @NotNull
  public static final LongRange until(long paramLong, short paramShort)
  {
    return new LongRange(paramLong, paramShort - 1L);
  }
  
  @NotNull
  public static final LongRange until(short paramShort, long paramLong)
  {
    if (paramLong <= -9223372036854775808L) {
      return LongRange.Companion.getEMPTY();
    }
    return new LongRange(paramShort, paramLong - 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.RangesKt___RangesKt
 * JD-Core Version:    0.7.0.1
 */