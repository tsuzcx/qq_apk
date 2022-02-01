package kotlin.sequences;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUByte")
  public static final int sumOfUByte(@NotNull Sequence<UByte> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = UInt.constructor-impl(i + UInt.constructor-impl(((UByte)paramSequence.next()).unbox-impl() & 0xFF))) {}
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUInt")
  public static final int sumOfUInt(@NotNull Sequence<UInt> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = UInt.constructor-impl(i + ((UInt)paramSequence.next()).unbox-impl())) {}
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfULong")
  public static final long sumOfULong(@NotNull Sequence<ULong> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (long l = 0L; paramSequence.hasNext(); l = ULong.constructor-impl(l + ((ULong)paramSequence.next()).unbox-impl())) {}
    return l;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUShort")
  public static final int sumOfUShort(@NotNull Sequence<UShort> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$sum");
    paramSequence = paramSequence.iterator();
    for (int i = 0; paramSequence.hasNext(); i = UInt.constructor-impl(i + UInt.constructor-impl(((UShort)paramSequence.next()).unbox-impl() & 0xFFFF))) {}
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.USequencesKt___USequencesKt
 * JD-Core Version:    0.7.0.1
 */