package com.tencent.mtt.supportui.utils.struct;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MapCollections$EntrySet
  implements Set<Map.Entry<K, V>>
{
  MapCollections$EntrySet(MapCollections paramMapCollections) {}
  
  public boolean add(Map.Entry<K, V> paramEntry)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = this.a.colGetSize();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      this.a.colPut(localEntry.getKey(), localEntry.getValue());
    }
    return i != this.a.colGetSize();
  }
  
  public void clear()
  {
    this.a.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    int i = this.a.colIndexOfKey(paramObject.getKey());
    if (i < 0) {
      return false;
    }
    return ContainerHelpers.equal(this.a.colGetEntry(i, 1), paramObject.getValue());
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
      Object localObject1 = this.a.colGetEntry(i, 0);
      Object localObject2 = this.a.colGetEntry(i, 1);
      int k;
      if (localObject1 == null) {
        k = 0;
      } else {
        k = localObject1.hashCode();
      }
      int m;
      if (localObject2 == null) {
        m = 0;
      } else {
        m = localObject2.hashCode();
      }
      j += (k ^ m);
      i -= 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return this.a.colGetSize() == 0;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new MapCollections.MapIterator(this.a);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.a.colGetSize();
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.EntrySet
 * JD-Core Version:    0.7.0.1
 */