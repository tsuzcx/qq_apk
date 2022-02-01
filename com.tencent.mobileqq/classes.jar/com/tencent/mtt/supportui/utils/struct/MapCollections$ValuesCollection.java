package com.tencent.mtt.supportui.utils.struct;

import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection
  implements Collection<V>
{
  MapCollections$ValuesCollection(MapCollections paramMapCollections) {}
  
  public boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    this.a.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.colIndexOfValue(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.a.colGetSize() == 0;
  }
  
  public Iterator<V> iterator()
  {
    return new MapCollections.ArrayIterator(this.a, 1);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = this.a.colIndexOfValue(paramObject);
    if (i >= 0)
    {
      this.a.colRemoveAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    int j = this.a.colGetSize();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      int k = j;
      int m = i;
      if (paramCollection.contains(this.a.colGetEntry(i, 1)))
      {
        this.a.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int j = this.a.colGetSize();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      int k = j;
      int m = i;
      if (!paramCollection.contains(this.a.colGetEntry(i, 1)))
      {
        this.a.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public int size()
  {
    return this.a.colGetSize();
  }
  
  public Object[] toArray()
  {
    return this.a.toArrayHelper(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.a.toArrayHelper(paramArrayOfT, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.ValuesCollection
 * JD-Core Version:    0.7.0.1
 */