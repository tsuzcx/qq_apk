package common.qzone.component.cache.common;

import java.util.Map.Entry;

class SoftHashMap$SimpleEntry<K, V>
  implements Map.Entry<K, V>
{
  private final K a;
  private V b;
  
  public SoftHashMap$SimpleEntry(Map.Entry<K, V> paramEntry)
  {
    this.a = paramEntry.getKey();
    this.b = paramEntry.getValue();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    bool1 = bool2;
    if (a(this.a, paramObject.getKey()))
    {
      bool1 = bool2;
      if (a(this.b, paramObject.getValue())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public K getKey()
  {
    return this.a;
  }
  
  public V getValue()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.b;
    this.b = paramV;
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.SimpleEntry
 * JD-Core Version:    0.7.0.1
 */