package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8
  implements Iterable<Boolean>, KMappedMarker
{
  public ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8(boolean[] paramArrayOfBoolean) {}
  
  @NotNull
  public Iterator<Boolean> iterator()
  {
    return (Iterator)ArrayIteratorsKt.iterator(this.$this_asIterable$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.asIterable..inlined.Iterable.8
 * JD-Core Version:    0.7.0.1
 */