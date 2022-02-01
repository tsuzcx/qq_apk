package com.tencent.mtt.supportui.utils.struct;

import java.util.Iterator;
import java.util.Map.Entry;

final class MapCollections$MapIterator
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int a;
  int b;
  boolean c = false;
  
  MapCollections$MapIterator(MapCollections paramMapCollections)
  {
    this.a = (paramMapCollections.colGetSize() - 1);
    this.b = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this.c)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      bool1 = bool2;
      if (ContainerHelpers.equal(paramObject.getKey(), this.d.colGetEntry(this.b, 0)))
      {
        bool1 = bool2;
        if (ContainerHelpers.equal(paramObject.getValue(), this.d.colGetEntry(this.b, 1))) {
          bool1 = true;
        }
      }
      return bool1;
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public K getKey()
  {
    if (this.c) {
      return this.d.colGetEntry(this.b, 0);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public V getValue()
  {
    if (this.c) {
      return this.d.colGetEntry(this.b, 1);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public boolean hasNext()
  {
    return this.b < this.a;
  }
  
  public final int hashCode()
  {
    if (this.c)
    {
      Object localObject1 = this.d;
      int i = this.b;
      int j = 0;
      localObject1 = ((MapCollections)localObject1).colGetEntry(i, 0);
      Object localObject2 = this.d.colGetEntry(this.b, 1);
      if (localObject1 == null) {
        i = 0;
      } else {
        i = localObject1.hashCode();
      }
      if (localObject2 != null) {
        j = localObject2.hashCode();
      }
      return i ^ j;
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public Map.Entry<K, V> next()
  {
    this.b += 1;
    this.c = true;
    return this;
  }
  
  public void remove()
  {
    if (this.c)
    {
      this.d.colRemoveAt(this.b);
      this.b -= 1;
      this.a -= 1;
      this.c = false;
      return;
    }
    throw new IllegalStateException();
  }
  
  public V setValue(V paramV)
  {
    if (this.c) {
      return this.d.colSetValue(this.b, paramV);
    }
    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.MapIterator
 * JD-Core Version:    0.7.0.1
 */