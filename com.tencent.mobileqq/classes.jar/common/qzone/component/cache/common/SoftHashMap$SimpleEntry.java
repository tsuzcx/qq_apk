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
    if (!(paramObject instanceof Map.Entry)) {}
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
    } while ((!a(this.a, paramObject.getKey())) || (!a(this.b, paramObject.getValue())));
    return true;
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
    int j = 0;
    int i;
    if (this.a == null)
    {
      i = 0;
      if (this.b != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.a.hashCode();
      break;
      label33:
      j = this.b.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.b;
    this.b = paramV;
    return localObject;
  }
  
  public String toString()
  {
    return this.a + "=" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.SimpleEntry
 * JD-Core Version:    0.7.0.1
 */