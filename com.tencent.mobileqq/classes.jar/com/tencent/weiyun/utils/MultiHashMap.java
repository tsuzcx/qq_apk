package com.tencent.weiyun.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MultiHashMap<K, V>
  extends HashMap<K, HashSet<V>>
{
  public boolean add(K paramK, V paramV)
  {
    if (paramV == null) {
      return false;
    }
    HashSet localHashSet2 = (HashSet)get(paramK);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      put(paramK, localHashSet1);
    }
    return localHashSet1.add(paramV);
  }
  
  public boolean remove(K paramK, V paramV)
  {
    boolean bool = true;
    if (paramV == null) {
      return remove(paramK) != null;
    }
    Collection localCollection = (Collection)get(paramK);
    if ((localCollection != null) && (localCollection.remove(paramV))) {}
    for (;;)
    {
      if ((localCollection != null) && (localCollection.isEmpty())) {
        remove(paramK);
      }
      return bool;
      bool = false;
    }
  }
  
  public int sizeOf(K paramK)
  {
    paramK = (Collection)get(paramK);
    if (paramK == null) {
      return 0;
    }
    return paramK.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.utils.MultiHashMap
 * JD-Core Version:    0.7.0.1
 */