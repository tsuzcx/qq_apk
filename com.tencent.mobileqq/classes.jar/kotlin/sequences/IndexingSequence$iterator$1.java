package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/IndexingSequence$iterator$1", "", "Lkotlin/collections/IndexedValue;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IndexingSequence$iterator$1
  implements Iterator<IndexedValue<? extends T>>, KMappedMarker
{
  private int index;
  @NotNull
  private final Iterator<T> iterator;
  
  IndexingSequence$iterator$1()
  {
    this.iterator = IndexingSequence.access$getSequence$p(localIndexingSequence).iterator();
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  @NotNull
  public final Iterator<T> getIterator()
  {
    return this.iterator;
  }
  
  public boolean hasNext()
  {
    return this.iterator.hasNext();
  }
  
  @NotNull
  public IndexedValue<T> next()
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
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.IndexingSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */