package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

final class MapEntry<K, V>
  implements Serializable
{
  public final K key;
  public final V value;
  
  public MapEntry(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MapEntry;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (MapEntry)paramObject;
    Object localObject = this.key;
    if (localObject == null)
    {
      bool1 = bool2;
      if (paramObject.key != null) {
        return bool1;
      }
    }
    else
    {
      bool1 = bool2;
      if (!localObject.equals(paramObject.key)) {
        return bool1;
      }
    }
    localObject = this.value;
    if (localObject == null)
    {
      bool1 = bool2;
      if (paramObject.value != null) {
        return bool1;
      }
    }
    else
    {
      bool1 = bool2;
      if (!localObject.equals(paramObject.value)) {
        return bool1;
      }
    }
    bool1 = true;
    return bool1;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.key);
    localStringBuilder.append("=");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.pcollections.MapEntry
 * JD-Core Version:    0.7.0.1
 */