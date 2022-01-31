package cooperation.comic.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SimpleBiMap
  implements Map
{
  private final HashMap a = new HashMap();
  private final HashMap b = new HashMap();
  
  public Object a(Object paramObject)
  {
    return this.b.get(paramObject);
  }
  
  public Object b(Object paramObject)
  {
    paramObject = this.b.remove(paramObject);
    if (paramObject != null) {
      this.a.remove(paramObject);
    }
    return paramObject;
  }
  
  public void clear()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.b.containsKey(paramObject);
  }
  
  public Set entrySet()
  {
    return this.a.entrySet();
  }
  
  public Object get(Object paramObject)
  {
    return this.a.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public Set keySet()
  {
    return this.a.keySet();
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return null;
    }
    Object localObject = remove(paramObject1);
    b(paramObject2);
    this.a.put(paramObject1, paramObject2);
    this.b.put(paramObject2, paramObject1);
    return localObject;
  }
  
  public void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject2 != null)) {
        put(localObject1, localObject2);
      }
    }
  }
  
  public Object remove(Object paramObject)
  {
    paramObject = this.a.remove(paramObject);
    if (paramObject != null) {
      this.b.remove(paramObject);
    }
    return paramObject;
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Collection values()
  {
    return this.a.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.utils.SimpleBiMap
 * JD-Core Version:    0.7.0.1
 */