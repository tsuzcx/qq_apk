package cooperation.qzone.util;

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
    boolean bool2 = false;
    if (paramV == null) {
      return false;
    }
    paramK = (HashSet)get(paramK);
    boolean bool1 = bool2;
    if (paramK != null)
    {
      bool1 = bool2;
      if (paramK.contains(paramV)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Collection<K> get(K paramK, MultiHashMap.Matcher<K> paramMatcher)
  {
    if ((paramK == null) || (paramMatcher != null)) {}
    try
    {
      Object localObject1 = keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (paramMatcher.match(paramK, localObject2)) {
            localArrayList.add(localObject2);
          }
        }
        return localArrayList;
      }
      return null;
    }
    finally
    {
      break label127;
    }
    throw new NullPointerException("keyMatcher == null");
    throw new NullPointerException("key == null");
    label127:
    for (;;)
    {
      throw paramK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.MultiHashMap
 * JD-Core Version:    0.7.0.1
 */