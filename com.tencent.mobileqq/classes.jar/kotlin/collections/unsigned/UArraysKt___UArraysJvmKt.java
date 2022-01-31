package kotlin.collections.unsigned;

import java.util.List;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, pn="kotlin.collections", xi=1, xs="kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UInt> asList--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$asList");
    return (List)new UArraysKt___UArraysJvmKt.asList.1(paramArrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UByte> asList-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$asList");
    return (List)new UArraysKt___UArraysJvmKt.asList.3(paramArrayOfByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<ULong> asList-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$asList");
    return (List)new UArraysKt___UArraysJvmKt.asList.2(paramArrayOfLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<UShort> asList-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$asList");
    return (List)new UArraysKt___UArraysJvmKt.asList.4(paramArrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int binarySearch-2fe2U9s(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt2, paramInt3, UIntArray.getSize-impl(paramArrayOfInt));
    paramInt3 -= 1;
    while (paramInt2 <= paramInt3)
    {
      int i = paramInt2 + paramInt3 >>> 1;
      int j = UnsignedKt.uintCompare(paramArrayOfInt[i], paramInt1);
      if (j < 0) {
        paramInt2 = i + 1;
      } else if (j > 0) {
        paramInt3 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt2 + 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int binarySearch-EtDCXyQ(@NotNull short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, UShortArray.getSize-impl(paramArrayOfShort));
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = UnsignedKt.uintCompare(paramArrayOfShort[i], paramShort & 0xFFFF);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int binarySearch-K6DWlUc(@NotNull long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, ULongArray.getSize-impl(paramArrayOfLong));
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = UnsignedKt.ulongCompare(paramArrayOfLong[i], paramLong);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int binarySearch-WpHrYlw(@NotNull byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$binarySearch");
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, UByteArray.getSize-impl(paramArrayOfByte));
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = UnsignedKt.uintCompare(paramArrayOfByte[i], paramByte & 0xFF);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final byte elementAt-PpDY95g(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    return UByteArray.get-impl(paramArrayOfByte, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short elementAt-nggk6HY(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    return UShortArray.get-impl(paramArrayOfShort, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int elementAt-qFRl0hI(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    return UIntArray.get-impl(paramArrayOfInt, paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long elementAt-r7IrZao(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    return ULongArray.get-impl(paramArrayOfLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysJvmKt
 * JD-Core Version:    0.7.0.1
 */