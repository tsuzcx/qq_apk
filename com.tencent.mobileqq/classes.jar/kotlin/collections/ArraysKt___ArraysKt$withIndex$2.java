package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/collections/ByteIterator;", "invoke"}, k=3, mv={1, 1, 16})
final class ArraysKt___ArraysKt$withIndex$2
  extends Lambda
  implements Function0<ByteIterator>
{
  ArraysKt___ArraysKt$withIndex$2(byte[] paramArrayOfByte)
  {
    super(0);
  }
  
  @NotNull
  public final ByteIterator invoke()
  {
    return ArrayIteratorsKt.iterator(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.withIndex.2
 * JD-Core Version:    0.7.0.1
 */