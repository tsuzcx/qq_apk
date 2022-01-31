package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SubSequence$iterator$1
  implements Iterator<T>, KMappedMarker
{
  @NotNull
  private final Iterator<T> iterator;
  private int position;
  
  SubSequence$iterator$1()
  {
    this.iterator = SubSequence.access$getSequence$p(localSubSequence).iterator();
  }
  
  private final void drop()
  {
    while ((this.position < SubSequence.access$getStartIndex$p(this.this$0)) && (this.iterator.hasNext()))
    {
      this.iterator.next();
      this.position += 1;
    }
  }
  
  @NotNull
  public final Iterator<T> getIterator()
  {
    return this.iterator;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public boolean hasNext()
  {
    drop();
    return (this.position < SubSequence.access$getEndIndex$p(this.this$0)) && (this.iterator.hasNext());
  }
  
  public T next()
  {
    drop();
    if (this.position >= SubSequence.access$getEndIndex$p(this.this$0)) {
      throw ((Throwable)new NoSuchElementException());
    }
    this.position += 1;
    return this.iterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.SubSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */