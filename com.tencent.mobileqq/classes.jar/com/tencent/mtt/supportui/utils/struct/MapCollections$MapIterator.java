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
    boolean bool = true;
    if (!this.c) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    if ((ContainerHelpers.equal(paramObject.getKey(), this.d.colGetEntry(this.b, 0))) && (ContainerHelpers.equal(paramObject.getValue(), this.d.colGetEntry(this.b, 1)))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public K getKey()
  {
    if (!this.c) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.d.colGetEntry(this.b, 0);
  }
  
  public V getValue()
  {
    if (!this.c) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.d.colGetEntry(this.b, 1);
  }
  
  public boolean hasNext()
  {
    return this.b < this.a;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!this.c) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = this.d.colGetEntry(this.b, 0);
    Object localObject2 = this.d.colGetEntry(this.b, 1);
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label69;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label69:
      j = localObject2.hashCode();
    }
  }
  
  public Map.Entry<K, V> next()
  {
    this.b += 1;
    this.c = true;
    return this;
  }
  
  public void remove()
  {
    if (!this.c) {
      throw new IllegalStateException();
    }
    this.d.colRemoveAt(this.b);
    this.b -= 1;
    this.a -= 1;
    this.c = false;
  }
  
  public V setValue(V paramV)
  {
    if (!this.c) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.d.colSetValue(this.b, paramV);
  }
  
  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.MapIterator
 * JD-Core Version:    0.7.0.1
 */