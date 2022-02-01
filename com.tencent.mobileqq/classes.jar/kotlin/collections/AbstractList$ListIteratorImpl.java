package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
class AbstractList$ListIteratorImpl
  extends AbstractList<E>.IteratorImpl
  implements ListIterator<E>, KMappedMarker
{
  public AbstractList$ListIteratorImpl(int paramInt)
  {
    super(paramInt);
    int i;
    AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, paramInt.size());
    setIndex(i);
  }
  
  public void add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean hasPrevious()
  {
    return getIndex() > 0;
  }
  
  public int nextIndex()
  {
    return getIndex();
  }
  
  public E previous()
  {
    if (hasPrevious())
    {
      AbstractList localAbstractList = this.this$0;
      setIndex(getIndex() - 1);
      return localAbstractList.get(getIndex());
    }
    throw ((Throwable)new NoSuchElementException());
  }
  
  public int previousIndex()
  {
    return getIndex() - 1;
  }
  
  public void set(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractList.ListIteratorImpl
 * JD-Core Version:    0.7.0.1
 */