package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
class AbstractList$IteratorImpl
  implements Iterator<E>, KMappedMarker
{
  private int index;
  
  protected final int getIndex()
  {
    return this.index;
  }
  
  public boolean hasNext()
  {
    return this.index < this.this$0.size();
  }
  
  public E next()
  {
    if (!hasNext()) {
      throw ((Throwable)new NoSuchElementException());
    }
    AbstractList localAbstractList = this.this$0;
    int i = this.index;
    this.index = (i + 1);
    return localAbstractList.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  protected final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractList.IteratorImpl
 * JD-Core Version:    0.7.0.1
 */