package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IndexingIterator<T>
  implements Iterator<IndexedValue<? extends T>>, KMappedMarker
{
  private int index;
  private final Iterator<T> iterator;
  
  public IndexingIterator(@NotNull Iterator<? extends T> paramIterator)
  {
    this.iterator = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return this.iterator.hasNext();
  }
  
  @NotNull
  public final IndexedValue<T> next()
  {
    int i = this.index;
    this.index = (i + 1);
    if (i < 0) {
      CollectionsKt.throwIndexOverflow();
    }
    return new IndexedValue(i, this.iterator.next());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.IndexingIterator
 * JD-Core Version:    0.7.0.1
 */