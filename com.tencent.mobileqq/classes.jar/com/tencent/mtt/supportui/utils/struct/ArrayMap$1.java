package com.tencent.mtt.supportui.utils.struct;

import java.util.Map;

class ArrayMap$1
  extends MapCollections<K, V>
{
  ArrayMap$1(ArrayMap paramArrayMap) {}
  
  protected void colClear()
  {
    this.a.clear();
  }
  
  protected Object colGetEntry(int paramInt1, int paramInt2)
  {
    return this.a.g[((paramInt1 << 1) + paramInt2)];
  }
  
  protected Map<K, V> colGetMap()
  {
    return this.a;
  }
  
  protected int colGetSize()
  {
    return this.a.h;
  }
  
  protected int colIndexOfKey(Object paramObject)
  {
    if (paramObject == null) {
      return this.a.a();
    }
    return this.a.a(paramObject, paramObject.hashCode());
  }
  
  protected int colIndexOfValue(Object paramObject)
  {
    return this.a.a(paramObject);
  }
  
  protected void colPut(K paramK, V paramV)
  {
    this.a.put(paramK, paramV);
  }
  
  protected void colRemoveAt(int paramInt)
  {
    this.a.removeAt(paramInt);
  }
  
  protected V colSetValue(int paramInt, V paramV)
  {
    return this.a.setValueAt(paramInt, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.ArrayMap.1
 * JD-Core Version:    0.7.0.1
 */