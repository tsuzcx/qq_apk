package kotlin.collections.unsigned;

import kotlin.Metadata;
import kotlin.ULongArray;
import kotlin.collections.ULongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/collections/ULongIterator;", "invoke"}, k=3, mv={1, 1, 16})
final class UArraysKt___UArraysKt$withIndex$2
  extends Lambda
  implements Function0<ULongIterator>
{
  UArraysKt___UArraysKt$withIndex$2(long[] paramArrayOfLong)
  {
    super(0);
  }
  
  @NotNull
  public final ULongIterator invoke()
  {
    return ULongArray.iterator-impl(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysKt.withIndex.2
 * JD-Core Version:    0.7.0.1
 */