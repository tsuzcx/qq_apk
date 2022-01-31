package cooperation.qzone.util;

import bhor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
  
  public boolean contains(K paramK, V paramV)
  {
    if (paramV == null) {
      return false;
    }
    paramK = (HashSet)get(paramK);
    if ((paramK != null) && (paramK.contains(paramV))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Collection<K> get(K paramK, bhor<K> parambhor)
  {
    if (paramK == null) {
      try
      {
        throw new NullPointerException("key == null");
      }
      finally {}
    }
    if (parambhor == null) {
      throw new NullPointerException("keyMatcher == null");
    }
    Object localObject = keySet();
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Set)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        if (parambhor.a(paramK, localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    localObject = null;
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.MultiHashMap
 * JD-Core Version:    0.7.0.1
 */