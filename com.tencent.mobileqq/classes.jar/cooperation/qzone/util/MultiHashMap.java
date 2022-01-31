package cooperation.qzone.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MultiHashMap
  extends HashMap
{
  public boolean add(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      return false;
    }
    HashSet localHashSet2 = (HashSet)get(paramObject1);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      put(paramObject1, localHashSet1);
    }
    return localHashSet1.add(paramObject2);
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      return false;
    }
    paramObject1 = (HashSet)get(paramObject1);
    if ((paramObject1 != null) && (paramObject1.contains(paramObject2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Collection get(Object paramObject, MultiHashMap.Matcher paramMatcher)
  {
    if (paramObject == null) {
      try
      {
        throw new NullPointerException("key == null");
      }
      finally {}
    }
    if (paramMatcher == null) {
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
        if (paramMatcher.a(paramObject, localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    localObject = null;
    return localObject;
  }
  
  public int sizeOf(Object paramObject)
  {
    paramObject = (Collection)get(paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.MultiHashMap
 * JD-Core Version:    0.7.0.1
 */