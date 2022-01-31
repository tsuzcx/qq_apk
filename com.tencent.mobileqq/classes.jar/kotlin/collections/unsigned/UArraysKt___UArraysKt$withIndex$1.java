package kotlin.collections.unsigned;

import kotlin.Metadata;
import kotlin.UIntArray;
import kotlin.collections.UIntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/collections/UIntIterator;", "invoke"}, k=3, mv={1, 1, 16})
final class UArraysKt___UArraysKt$withIndex$1
  extends Lambda
  implements Function0<UIntIterator>
{
  UArraysKt___UArraysKt$withIndex$1(int[] paramArrayOfInt)
  {
    super(0);
  }
  
  @NotNull
  public final UIntIterator invoke()
  {
    return UIntArray.iterator-impl(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysKt.withIndex.1
 * JD-Core Version:    0.7.0.1
 */