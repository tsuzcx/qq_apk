package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/collections/BooleanIterator;", "invoke"}, k=3, mv={1, 1, 16})
final class ArraysKt___ArraysKt$withIndex$8
  extends Lambda
  implements Function0<BooleanIterator>
{
  ArraysKt___ArraysKt$withIndex$8(boolean[] paramArrayOfBoolean)
  {
    super(0);
  }
  
  @NotNull
  public final BooleanIterator invoke()
  {
    return ArrayIteratorsKt.iterator(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.withIndex.8
 * JD-Core Version:    0.7.0.1
 */