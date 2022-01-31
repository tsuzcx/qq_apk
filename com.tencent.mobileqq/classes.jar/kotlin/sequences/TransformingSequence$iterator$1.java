package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TransformingSequence$iterator$1
  implements Iterator<R>, KMappedMarker
{
  @NotNull
  private final Iterator<T> iterator;
  
  TransformingSequence$iterator$1()
  {
    this.iterator = TransformingSequence.access$getSequence$p(localTransformingSequence).iterator();
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
    return TransformingSequence.access$getTransformer$p(this.this$0).invoke(this.iterator.next());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.TransformingSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */