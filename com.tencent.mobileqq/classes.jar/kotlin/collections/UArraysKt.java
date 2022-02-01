package kotlin.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Deprecated(level=DeprecationLevel.HIDDEN, message="Provided for binary compatibility")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/UArraysKt;", "", "()V", "contentEquals", "", "Lkotlin/UByteArray;", "other", "contentEquals-kdPth3s", "([B[B)Z", "Lkotlin/UIntArray;", "contentEquals-ctEhBpI", "([I[I)Z", "Lkotlin/ULongArray;", "contentEquals-us8wMrg", "([J[J)Z", "Lkotlin/UShortArray;", "contentEquals-mazbYpA", "([S[S)Z", "contentHashCode", "", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode--ajY-9A", "([I)I", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-rL5Bavg", "([S)I", "contentToString", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "random", "Lkotlin/UByte;", "Lkotlin/random/Random;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", "toTypedArray", "", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UArraysKt
{
  public static final UArraysKt INSTANCE = new UArraysKt();
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final boolean contentEquals-ctEhBpI(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "other");
    return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final boolean contentEquals-kdPth3s(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "other");
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final boolean contentEquals-mazbYpA(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "other");
    return Arrays.equals(paramArrayOfShort1, paramArrayOfShort2);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final boolean contentEquals-us8wMrg(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$contentEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "other");
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final int contentHashCode--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfInt);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final int contentHashCode-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfByte);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final int contentHashCode-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final int contentHashCode-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contentHashCode");
    return Arrays.hashCode(paramArrayOfShort);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final String contentToString--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$contentToString");
    return CollectionsKt.joinToString$default(UIntArray.box-impl(paramArrayOfInt), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final String contentToString-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$contentToString");
    return CollectionsKt.joinToString$default(UByteArray.box-impl(paramArrayOfByte), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final String contentToString-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$contentToString");
    return CollectionsKt.joinToString$default(ULongArray.box-impl(paramArrayOfLong), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final String contentToString-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$contentToString");
    return CollectionsKt.joinToString$default(UShortArray.box-impl(paramArrayOfShort), (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56, null);
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final int random-2D5oskM(@NotNull int[] paramArrayOfInt, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!UIntArray.isEmpty-impl(paramArrayOfInt)) {
      return UIntArray.get-impl(paramArrayOfInt, paramRandom.nextInt(UIntArray.getSize-impl(paramArrayOfInt)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final long random-JzugnMA(@NotNull long[] paramArrayOfLong, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!ULongArray.isEmpty-impl(paramArrayOfLong)) {
      return ULongArray.get-impl(paramArrayOfLong, paramRandom.nextInt(ULongArray.getSize-impl(paramArrayOfLong)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final byte random-oSF2wD8(@NotNull byte[] paramArrayOfByte, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!UByteArray.isEmpty-impl(paramArrayOfByte)) {
      return UByteArray.get-impl(paramArrayOfByte, paramRandom.nextInt(UByteArray.getSize-impl(paramArrayOfByte)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  public static final short random-s5X_as8(@NotNull short[] paramArrayOfShort, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (!UShortArray.isEmpty-impl(paramArrayOfShort)) {
      return UShortArray.get-impl(paramArrayOfShort, paramRandom.nextInt(UShortArray.getSize-impl(paramArrayOfShort)));
    }
    throw ((Throwable)new NoSuchElementException("Array is empty."));
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final UInt[] toTypedArray--ajY-9A(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toTypedArray");
    int j = UIntArray.getSize-impl(paramArrayOfInt);
    UInt[] arrayOfUInt = new UInt[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUInt[i] = UInt.box-impl(UIntArray.get-impl(paramArrayOfInt, i));
      i += 1;
    }
    return arrayOfUInt;
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final UByte[] toTypedArray-GBYM_sE(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toTypedArray");
    int j = UByteArray.getSize-impl(paramArrayOfByte);
    UByte[] arrayOfUByte = new UByte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUByte[i] = UByte.box-impl(UByteArray.get-impl(paramArrayOfByte, i));
      i += 1;
    }
    return arrayOfUByte;
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final ULong[] toTypedArray-QwZRm1k(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toTypedArray");
    int j = ULongArray.getSize-impl(paramArrayOfLong);
    ULong[] arrayOfULong = new ULong[j];
    int i = 0;
    while (i < j)
    {
      arrayOfULong[i] = ULong.box-impl(ULongArray.get-impl(paramArrayOfLong, i));
      i += 1;
    }
    return arrayOfULong;
  }
  
  @JvmStatic
  @ExperimentalUnsignedTypes
  @NotNull
  public static final UShort[] toTypedArray-rL5Bavg(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toTypedArray");
    int j = UShortArray.getSize-impl(paramArrayOfShort);
    UShort[] arrayOfUShort = new UShort[j];
    int i = 0;
    while (i < j)
    {
      arrayOfUShort[i] = UShort.box-impl(UShortArray.get-impl(paramArrayOfShort, i));
      i += 1;
    }
    return arrayOfUShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.UArraysKt
 * JD-Core Version:    0.7.0.1
 */