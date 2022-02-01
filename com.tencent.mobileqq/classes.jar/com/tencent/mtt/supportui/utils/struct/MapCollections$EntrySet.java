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
    if (!(paramObject instanceof Map.Entry)) {}
    int i;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      i = this.a.colIndexOfKey(paramObject.getKey());
    } while (i < 0);
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
    int j = this.a.colGetSize() - 1;
    int i = 0;
    if (j >= 0)
    {
      Object localObject1 = this.a.colGetEntry(j, 0);
      Object localObject2 = this.a.colGetEntry(j, 1);
      int k;
      if (localObject1 == null)
      {
        k = 0;
        label45:
        if (localObject2 != null) {
          break label76;
        }
      }
      label76:
      for (int m = 0;; m = localObject2.hashCode())
      {
        j -= 1;
        i += (m ^ k);
        break;
        k = localObject1.hashCode();
        break label45;
      }
    }
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.EntrySet
 * JD-Core Version:    0.7.0.1
 */