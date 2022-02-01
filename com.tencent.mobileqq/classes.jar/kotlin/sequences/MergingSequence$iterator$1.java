package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/MergingSequence$iterator$1", "", "iterator1", "getIterator1", "()Ljava/util/Iterator;", "iterator2", "getIterator2", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MergingSequence$iterator$1
  implements Iterator<V>, KMappedMarker
{
  @NotNull
  private final Iterator<T1> iterator1;
  @NotNull
  private final Iterator<T2> iterator2;
  
  MergingSequence$iterator$1()
  {
    this.iterator1 = MergingSequence.access$getSequence1$p(localMergingSequence).iterator();
    this.iterator2 = MergingSequence.access$getSequence2$p(localMergingSequence).iterator();
  }
  
  @NotNull
  public final Iterator<T1> getIterator1()
  {
    return this.iterator1;
  }
  
  @NotNull
  public final Iterator<T2> getIterator2()
  {
    return this.iterator2;
  }
  
  public boolean hasNext()
  {
    return (this.iterator1.hasNext()) && (this.iterator2.hasNext());
  }
  
  public V next()
  {
    return MergingSequence.access$getTransform$p(this.this$0).invoke(this.iterator1.next(), this.iterator2.next());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.MergingSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */