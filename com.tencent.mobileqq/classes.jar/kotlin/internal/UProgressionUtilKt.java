package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UProgressionUtilKt
{
  private static final int differenceModulo-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = UnsignedKt.uintRemainder-J1ME1BU(paramInt1, paramInt3);
    paramInt2 = UnsignedKt.uintRemainder-J1ME1BU(paramInt2, paramInt3);
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) >= 0) {
      return UInt.constructor-impl(paramInt1 - paramInt2);
    }
    return UInt.constructor-impl(UInt.constructor-impl(paramInt1 - paramInt2) + paramInt3);
  }
  
  private static final long differenceModulo-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = UnsignedKt.ulongRemainder-eb3DHEI(paramLong1, paramLong3);
    paramLong2 = UnsignedKt.ulongRemainder-eb3DHEI(paramLong2, paramLong3);
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) >= 0) {
      return ULong.constructor-impl(paramLong1 - paramLong2);
    }
    return ULong.constructor-impl(ULong.constructor-impl(paramLong1 - paramLong2) + paramLong3);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  public static final long getProgressionLastElement-7ftBX0g(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 > 0L) {
      if (UnsignedKt.ulongCompare(paramLong1, paramLong2) < 0) {}
    }
    do
    {
      return paramLong2;
      return ULong.constructor-impl(paramLong2 - differenceModulo-sambcqE(paramLong2, paramLong1, ULong.constructor-impl(paramLong3)));
      if (paramLong3 >= 0L) {
        break;
      }
    } while (UnsignedKt.ulongCompare(paramLong1, paramLong2) <= 0);
    return ULong.constructor-impl(differenceModulo-sambcqE(paramLong1, paramLong2, ULong.constructor-impl(-paramLong3)) + paramLong2);
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  public static final int getProgressionLastElement-Nkh28Cs(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0) {
      if (UnsignedKt.uintCompare(paramInt1, paramInt2) < 0) {}
    }
    do
    {
      return paramInt2;
      return UInt.constructor-impl(paramInt2 - differenceModulo-WZ9TVnA(paramInt2, paramInt1, UInt.constructor-impl(paramInt3)));
      if (paramInt3 >= 0) {
        break;
      }
    } while (UnsignedKt.uintCompare(paramInt1, paramInt2) <= 0);
    return UInt.constructor-impl(differenceModulo-WZ9TVnA(paramInt1, paramInt2, UInt.constructor-impl(-paramInt3)) + paramInt2);
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.internal.UProgressionUtilKt
 * JD-Core Version:    0.7.0.1
 */