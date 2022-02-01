package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/TransformingIndexedSequence$iterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TransformingIndexedSequence$iterator$1
  implements Iterator<R>, KMappedMarker
{
  private int index;
  @NotNull
  private final Iterator<T> iterator;
  
  TransformingIndexedSequence$iterator$1()
  {
    this.iterator = TransformingIndexedSequence.access$getSequence$p(localTransformingIndexedSequence).iterator();
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
  
  public R next()
  {
    Function2 localFunction2 = TransformingIndexedSequence.access$getTransformer$p(this.this$0);
    int i = this.index;
    this.index = (i + 1);
    if (i < 0) {
      CollectionsKt.throwIndexOverflow();
    }
    return localFunction2.invoke(Integer.valueOf(i), this.iterator.next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.TransformingIndexedSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */