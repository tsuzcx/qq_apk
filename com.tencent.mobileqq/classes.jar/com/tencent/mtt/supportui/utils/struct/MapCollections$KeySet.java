package com.tencent.mtt.supportui.utils.struct;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class MapCollections$KeySet
  implements Set<K>
{
  MapCollections$KeySet(MapCollections paramMapCollections) {}
  
  public boolean add(K paramK)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends K> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    this.a.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.colIndexOfKey(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return MapCollections.containsAllHelper(this.a.colGetMap(), paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return MapCollections.equalsSetHelper(this, paramObject);
  }
  
  public int hashCode()
  {
    int i = this.a.colGetSize() - 1;
    int j = 0;
    while (i >= 0)
    {
      Object localObject = this.a.colGetEntry(i, 0);
      int k;
      if (localObject == null) {
        k = 0;
      } else {
        k = localObject.hashCode();
      }
      j += k;
      i -= 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return this.a.colGetSize() == 0;
  }
  
  public Iterator<K> iterator()
  {
    return new MapCollections.ArrayIterator(this.a, 0);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = this.a.colIndexOfKey(paramObject);
    if (i >= 0)
    {
      this.a.colRemoveAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return MapCollections.removeAllHelper(this.a.colGetMap(), paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return MapCollections.retainAllHelper(this.a.colGetMap(), paramCollection);
  }
  
  public int size()
  {
    return this.a.colGetSize();
  }
  
  public Object[] toArray()
  {
    return this.a.toArrayHelper(0);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.a.toArrayHelper(paramArrayOfT, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.KeySet
 * JD-Core Version:    0.7.0.1
 */