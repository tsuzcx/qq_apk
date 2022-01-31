package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "sortArray-GBYM_sE", "([B)V", "sortArray--ajY-9A", "([I)V", "sortArray-QwZRm1k", "([J)V", "sortArray-rL5Bavg", "([S)V", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UArraySortingKt
{
  @ExperimentalUnsignedTypes
  private static final int partition--nroSd4(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    long l1 = ULongArray.get-impl(paramArrayOfLong, (paramInt1 + paramInt2) / 2);
    int i = paramInt1;
    paramInt1 = paramInt2;
    paramInt2 = i;
    while (paramInt2 <= paramInt1)
    {
      i = paramInt2;
      int j;
      for (;;)
      {
        j = paramInt1;
        if (UnsignedKt.ulongCompare(ULongArray.get-impl(paramArrayOfLong, i), l1) >= 0) {
          break;
        }
        i += 1;
      }
      while (UnsignedKt.ulongCompare(ULongArray.get-impl(paramArrayOfLong, j), l1) > 0) {
        j -= 1;
      }
      paramInt2 = i;
      paramInt1 = j;
      if (i <= j)
      {
        long l2 = ULongArray.get-impl(paramArrayOfLong, i);
        ULongArray.set-k8EXiF4(paramArrayOfLong, i, ULongArray.get-impl(paramArrayOfLong, j));
        ULongArray.set-k8EXiF4(paramArrayOfLong, j, l2);
        paramInt2 = i + 1;
        paramInt1 = j - 1;
      }
    }
    return paramInt2;
  }
  
  @ExperimentalUnsignedTypes
  private static final int partition-4UcCI2c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = UByteArray.get-impl(paramArrayOfByte, (paramInt1 + paramInt2) / 2);
    int i = paramInt1;
    paramInt1 = paramInt2;
    paramInt2 = i;
    while (paramInt2 <= paramInt1)
    {
      i = paramInt2;
      int j;
      for (;;)
      {
        j = paramInt1;
        if (Intrinsics.compare(UByteArray.get-impl(paramArrayOfByte, i) & 0xFF, k & 0xFF) >= 0) {
          break;
        }
        i += 1;
      }
      while (Intrinsics.compare(UByteArray.get-impl(paramArrayOfByte, j) & 0xFF, k & 0xFF) > 0) {
        j -= 1;
      }
      paramInt2 = i;
      paramInt1 = j;
      if (i <= j)
      {
        byte b = UByteArray.get-impl(paramArrayOfByte, i);
        UByteArray.set-VurrAj0(paramArrayOfByte, i, UByteArray.get-impl(paramArrayOfByte, j));
        UByteArray.set-VurrAj0(paramArrayOfByte, j, b);
        paramInt2 = i + 1;
        paramInt1 = j - 1;
      }
    }
    return paramInt2;
  }
  
  @ExperimentalUnsignedTypes
  private static final int partition-Aa5vz7o(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = UShortArray.get-impl(paramArrayOfShort, (paramInt1 + paramInt2) / 2);
    int i = paramInt1;
    paramInt1 = paramInt2;
    paramInt2 = i;
    while (paramInt2 <= paramInt1)
    {
      i = paramInt2;
      int j;
      for (;;)
      {
        j = paramInt1;
        if (Intrinsics.compare(UShortArray.get-impl(paramArrayOfShort, i) & 0xFFFF, k & 0xFFFF) >= 0) {
          break;
        }
        i += 1;
      }
      while (Intrinsics.compare(UShortArray.get-impl(paramArrayOfShort, j) & 0xFFFF, k & 0xFFFF) > 0) {
        j -= 1;
      }
      paramInt2 = i;
      paramInt1 = j;
      if (i <= j)
      {
        short s = UShortArray.get-impl(paramArrayOfShort, i);
        UShortArray.set-01HTLdE(paramArrayOfShort, i, UShortArray.get-impl(paramArrayOfShort, j));
        UShortArray.set-01HTLdE(paramArrayOfShort, j, s);
        paramInt2 = i + 1;
        paramInt1 = j - 1;
      }
    }
    return paramInt2;
  }
  
  @ExperimentalUnsignedTypes
  private static final int partition-oBK06Vg(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = UIntArray.get-impl(paramArrayOfInt, (paramInt1 + paramInt2) / 2);
    int i = paramInt1;
    paramInt1 = paramInt2;
    paramInt2 = i;
    while (paramInt2 <= paramInt1)
    {
      i = paramInt2;
      int j;
      for (;;)
      {
        j = paramInt1;
        if (UnsignedKt.uintCompare(UIntArray.get-impl(paramArrayOfInt, i), k) >= 0) {
          break;
        }
        i += 1;
      }
      while (UnsignedKt.uintCompare(UIntArray.get-impl(paramArrayOfInt, j), k) > 0) {
        j -= 1;
      }
      paramInt2 = i;
      paramInt1 = j;
      if (i <= j)
      {
        paramInt1 = UIntArray.get-impl(paramArrayOfInt, i);
        UIntArray.set-VXSXFK8(paramArrayOfInt, i, UIntArray.get-impl(paramArrayOfInt, j));
        UIntArray.set-VXSXFK8(paramArrayOfInt, j, paramInt1);
        paramInt2 = i + 1;
        paramInt1 = j - 1;
      }
    }
    return paramInt2;
  }
  
  @ExperimentalUnsignedTypes
  private static final void quickSort--nroSd4(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int i = partition--nroSd4(paramArrayOfLong, paramInt1, paramInt2);
    if (paramInt1 < i - 1) {
      quickSort--nroSd4(paramArrayOfLong, paramInt1, i - 1);
    }
    if (i < paramInt2) {
      quickSort--nroSd4(paramArrayOfLong, i, paramInt2);
    }
  }
  
  @ExperimentalUnsignedTypes
  private static final void quickSort-4UcCI2c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = partition-4UcCI2c(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < i - 1) {
      quickSort-4UcCI2c(paramArrayOfByte, paramInt1, i - 1);
    }
    if (i < paramInt2) {
      quickSort-4UcCI2c(paramArrayOfByte, i, paramInt2);
    }
  }
  
  @ExperimentalUnsignedTypes
  private static final void quickSort-Aa5vz7o(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i = partition-Aa5vz7o(paramArrayOfShort, paramInt1, paramInt2);
    if (paramInt1 < i - 1) {
      quickSort-Aa5vz7o(paramArrayOfShort, paramInt1, i - 1);
    }
    if (i < paramInt2) {
      quickSort-Aa5vz7o(paramArrayOfShort, i, paramInt2);
    }
  }
  
  @ExperimentalUnsignedTypes
  private static final void quickSort-oBK06Vg(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = partition-oBK06Vg(paramArrayOfInt, paramInt1, paramInt2);
    if (paramInt1 < i - 1) {
      quickSort-oBK06Vg(paramArrayOfInt, paramInt1, i - 1);
    }
    if (i < paramInt2) {
      quickSort-oBK06Vg(paramArrayOfInt, i, paramInt2);
    }
  }
  
  @ExperimentalUnsignedTypes
  public static final void sortArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "array");
    quickSort-oBK06Vg(paramArrayOfInt, 0, UIntArray.getSize-impl(paramArrayOfInt) - 1);
  }
  
  @ExperimentalUnsignedTypes
  public static final void sortArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    quickSort-4UcCI2c(paramArrayOfByte, 0, UByteArray.getSize-impl(paramArrayOfByte) - 1);
  }
  
  @ExperimentalUnsignedTypes
  public static final void sortArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "array");
    quickSort--nroSd4(paramArrayOfLong, 0, ULongArray.getSize-impl(paramArrayOfLong) - 1);
  }
  
  @ExperimentalUnsignedTypes
  public static final void sortArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "array");
    quickSort-Aa5vz7o(paramArrayOfShort, 0, UShortArray.getSize-impl(paramArrayOfShort) - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.UArraySortingKt
 * JD-Core Version:    0.7.0.1
 */