package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DropSequence$iterator$1
  implements Iterator<T>, KMappedMarker
{
  @NotNull
  private final Iterator<T> iterator;
  private int left;
  
  DropSequence$iterator$1()
  {
    this.iterator = DropSequence.access$getSequence$p(localDropSequence).iterator();
    this.left = DropSequence.access$getCount$p(localDropSequence);
  }
  
  private final void drop()
  {
    while ((this.left > 0) && (this.iterator.hasNext()))
    {
      this.iterator.next();
      this.left -= 1;
    }
  }
  
  @NotNull
  public final Iterator<T> getIterator()
  {
    return this.iterator;
  }
  
  public final int getLeft()
  {
    return this.left;
  }
  
  public boolean hasNext()
  {
    drop();
    return this.iterator.hasNext();
  }
  
  public T next()
  {
    drop();
    return this.iterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setLeft(int paramInt)
  {
    this.left = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.DropSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */