package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractList<E>
  extends AbstractCollection<E>
  implements List<E>, KMappedMarker
{
  public static final AbstractList.Companion Companion = new AbstractList.Companion(null);
  
  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AbstractList)this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    return Companion.orderedEquals$kotlin_stdlib((Collection)this, (Collection)paramObject);
  }
  
  public abstract E get(int paramInt);
  
  public abstract int getSize();
  
  public int hashCode()
  {
    return Companion.orderedHashCode$kotlin_stdlib((Collection)this);
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      if (Intrinsics.areEqual(localIterator.next(), paramObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @NotNull
  public Iterator<E> iterator()
  {
    return (Iterator)new AbstractList.IteratorImpl(this);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    ListIterator localListIterator = listIterator(size());
    while (localListIterator.hasPrevious()) {
      if (Intrinsics.areEqual(localListIterator.previous(), paramObject)) {
        return localListIterator.nextIndex();
      }
    }
    return -1;
  }
  
  @NotNull
  public ListIterator<E> listIterator()
  {
    return (ListIterator)new AbstractList.ListIteratorImpl(this, 0);
  }
  
  @NotNull
  public ListIterator<E> listIterator(int paramInt)
  {
    return (ListIterator)new AbstractList.ListIteratorImpl(this, paramInt);
  }
  
  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  @NotNull
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return (List)new AbstractList.SubList(this, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractList
 * JD-Core Version:    0.7.0.1
 */