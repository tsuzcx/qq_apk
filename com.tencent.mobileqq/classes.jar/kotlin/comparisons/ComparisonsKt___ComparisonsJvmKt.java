package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt
  extends ComparisonsKt__ComparisonsKt
{
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte maxOf(byte paramByte1, byte paramByte2)
  {
    return (byte)Math.max(paramByte1, paramByte2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte maxOf(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    return (byte)Math.max(paramByte1, Math.max(paramByte2, paramByte3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final double maxOf(double paramDouble1, double paramDouble2)
  {
    return Math.max(paramDouble1, paramDouble2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final double maxOf(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.max(paramDouble1, Math.max(paramDouble2, paramDouble3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final float maxOf(float paramFloat1, float paramFloat2)
  {
    return Math.max(paramFloat1, paramFloat2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final float maxOf(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat1, Math.max(paramFloat2, paramFloat3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int maxOf(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1, paramInt2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int maxOf(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt1, Math.max(paramInt2, paramInt3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final long maxOf(long paramLong1, long paramLong2)
  {
    return Math.max(paramLong1, paramLong2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final long maxOf(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong1, Math.max(paramLong2, paramLong3));
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T extends Comparable<? super T>> T maxOf(@NotNull T paramT1, @NotNull T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "a");
    Intrinsics.checkParameterIsNotNull(paramT2, "b");
    if (paramT1.compareTo(paramT2) >= 0) {
      return paramT1;
    }
    return paramT2;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T extends Comparable<? super T>> T maxOf(@NotNull T paramT1, @NotNull T paramT2, @NotNull T paramT3)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "a");
    Intrinsics.checkParameterIsNotNull(paramT2, "b");
    Intrinsics.checkParameterIsNotNull(paramT3, "c");
    return ComparisonsKt.maxOf(paramT1, ComparisonsKt.maxOf(paramT2, paramT3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short maxOf(short paramShort1, short paramShort2)
  {
    return (short)Math.max(paramShort1, paramShort2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short maxOf(short paramShort1, short paramShort2, short paramShort3)
  {
    return (short)Math.max(paramShort1, Math.max(paramShort2, paramShort3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte minOf(byte paramByte1, byte paramByte2)
  {
    return (byte)Math.min(paramByte1, paramByte2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final byte minOf(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    return (byte)Math.min(paramByte1, Math.min(paramByte2, paramByte3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final double minOf(double paramDouble1, double paramDouble2)
  {
    return Math.min(paramDouble1, paramDouble2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final double minOf(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.min(paramDouble1, Math.min(paramDouble2, paramDouble3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final float minOf(float paramFloat1, float paramFloat2)
  {
    return Math.min(paramFloat1, paramFloat2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final float minOf(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(paramFloat1, Math.min(paramFloat2, paramFloat3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int minOf(int paramInt1, int paramInt2)
  {
    return Math.min(paramInt1, paramInt2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int minOf(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(paramInt1, Math.min(paramInt2, paramInt3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final long minOf(long paramLong1, long paramLong2)
  {
    return Math.min(paramLong1, paramLong2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final long minOf(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.min(paramLong1, Math.min(paramLong2, paramLong3));
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T extends Comparable<? super T>> T minOf(@NotNull T paramT1, @NotNull T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "a");
    Intrinsics.checkParameterIsNotNull(paramT2, "b");
    if (paramT1.compareTo(paramT2) <= 0) {
      return paramT1;
    }
    return paramT2;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T extends Comparable<? super T>> T minOf(@NotNull T paramT1, @NotNull T paramT2, @NotNull T paramT3)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "a");
    Intrinsics.checkParameterIsNotNull(paramT2, "b");
    Intrinsics.checkParameterIsNotNull(paramT3, "c");
    return ComparisonsKt.minOf(paramT1, ComparisonsKt.minOf(paramT2, paramT3));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short minOf(short paramShort1, short paramShort2)
  {
    return (short)Math.min(paramShort1, paramShort2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final short minOf(short paramShort1, short paramShort2, short paramShort3)
  {
    return (short)Math.min(paramShort1, Math.min(paramShort2, paramShort3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt
 * JD-Core Version:    0.7.0.1
 */