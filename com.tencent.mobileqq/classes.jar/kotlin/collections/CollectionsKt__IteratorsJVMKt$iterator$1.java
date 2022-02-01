package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CollectionsKt__IteratorsJVMKt$iterator$1
  implements Iterator<T>, KMappedMarker
{
  CollectionsKt__IteratorsJVMKt$iterator$1(Enumeration<T> paramEnumeration) {}
  
  public boolean hasNext()
  {
    return this.$this_iterator.hasMoreElements();
  }
  
  public T next()
  {
    return this.$this_iterator.nextElement();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__IteratorsJVMKt.iterator.1
 * JD-Core Version:    0.7.0.1
 */