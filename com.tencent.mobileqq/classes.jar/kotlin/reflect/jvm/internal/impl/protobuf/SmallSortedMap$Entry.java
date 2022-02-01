package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Map.Entry;

class SmallSortedMap$Entry
  implements Comparable<SmallSortedMap<K, V>.Entry>, Map.Entry<K, V>
{
  private final K key;
  private V value;
  
  SmallSortedMap$Entry(K paramK, V paramV)
  {
    this.key = paramV;
    Object localObject;
    this.value = localObject;
  }
  
  SmallSortedMap$Entry(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)localObject.getKey(), localObject.getValue());
  }
  
  private boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public int compareTo(SmallSortedMap<K, V>.Entry paramSmallSortedMap)
  {
    return getKey().compareTo(paramSmallSortedMap.getKey());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (equals(this.key, paramObject.getKey())) && (equals(this.value, paramObject.getValue()));
  }
  
  public K getKey()
  {
    return this.key;
  }
  
  public V getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = this.key;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.value;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public V setValue(V paramV)
  {
    SmallSortedMap.access$200(this.this$0);
    Object localObject = this.value;
    this.value = paramV;
    return localObject;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(this.key));
    String str2 = String.valueOf(String.valueOf(this.value));
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap.Entry
 * JD-Core Version:    0.7.0.1
 */