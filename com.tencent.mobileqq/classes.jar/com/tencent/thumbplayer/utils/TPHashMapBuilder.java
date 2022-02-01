package com.tencent.thumbplayer.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TPHashMapBuilder<K, V>
{
  private Map<K, V> map = new HashMap();
  
  public Map<K, V> build()
  {
    return this.map;
  }
  
  public TPHashMapBuilder<K, V> put(K paramK, V paramV)
  {
    this.map.put(paramK, paramV);
    return this;
  }
  
  public Map<K, V> readOnly()
  {
    return Collections.unmodifiableMap(this.map);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPHashMapBuilder
 * JD-Core Version:    0.7.0.1
 */