package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-5PvTz6A", "minOf-VKSA0NQ", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short maxOf-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) >= 0) {
      return paramShort1;
    }
    return paramShort2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int maxOf-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) >= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte maxOf-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) >= 0) {
      return paramByte1;
    }
    return paramByte2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short maxOf-VKSA0NQ(short paramShort1, short paramShort2, short paramShort3)
  {
    return UComparisonsKt.maxOf-5PvTz6A(paramShort1, UComparisonsKt.maxOf-5PvTz6A(paramShort2, paramShort3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int maxOf-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    return UComparisonsKt.maxOf-J1ME1BU(paramInt1, UComparisonsKt.maxOf-J1ME1BU(paramInt2, paramInt3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte maxOf-b33U2AM(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    return UComparisonsKt.maxOf-Kr8caGY(paramByte1, UComparisonsKt.maxOf-Kr8caGY(paramByte2, paramByte3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long maxOf-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) >= 0) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long maxOf-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    return UComparisonsKt.maxOf-eb3DHEI(paramLong1, UComparisonsKt.maxOf-eb3DHEI(paramLong2, paramLong3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short minOf-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) <= 0) {
      return paramShort1;
    }
    return paramShort2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int minOf-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte minOf-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) <= 0) {
      return paramByte1;
    }
    return paramByte2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short minOf-VKSA0NQ(short paramShort1, short paramShort2, short paramShort3)
  {
    return UComparisonsKt.minOf-5PvTz6A(paramShort1, UComparisonsKt.minOf-5PvTz6A(paramShort2, paramShort3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int minOf-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    return UComparisonsKt.minOf-J1ME1BU(paramInt1, UComparisonsKt.minOf-J1ME1BU(paramInt2, paramInt3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte minOf-b33U2AM(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    return UComparisonsKt.minOf-Kr8caGY(paramByte1, UComparisonsKt.minOf-Kr8caGY(paramByte2, paramByte3));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long minOf-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) <= 0) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long minOf-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    return UComparisonsKt.minOf-eb3DHEI(paramLong1, UComparisonsKt.minOf-eb3DHEI(paramLong2, paramLong3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.comparisons.UComparisonsKt___UComparisonsKt
 * JD-Core Version:    0.7.0.1
 */