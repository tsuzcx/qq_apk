package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map.Entry;

class SoftHashMap$Entry<K, V>
  extends SoftReference<K>
  implements Map.Entry<K, V>
{
  private final int jdField_a_of_type_Int;
  private Entry<K, V> jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry;
  private V jdField_a_of_type_JavaLangObject;
  
  SoftHashMap$Entry(K paramK, V paramV, ReferenceQueue<K> paramReferenceQueue, int paramInt, Entry<K, V> paramEntry)
  {
    super(paramK, paramReferenceQueue);
    this.jdField_a_of_type_JavaLangObject = paramV;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CommonQzoneComponentCacheCommonSoftHashMap$Entry = paramEntry;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    Object localObject1 = getKey();
    Object localObject2 = paramObject.getKey();
    if ((localObject1 == localObject2) || ((localObject1 != null) && (localObject1.equals(localObject2))))
    {
      localObject1 = getValue();
      paramObject = paramObject.getValue();
    }
    return (localObject1 == paramObject) || ((localObject1 != null) && (localObject1.equals(paramObject)));
  }
  
  public K getKey()
  {
    return SoftHashMap.a(get());
  }
  
  public V getValue()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public int hashCode()
  {
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int j = 0;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = localObject1.hashCode();
    }
    if (localObject2 != null) {
      j = localObject2.hashCode();
    }
    return i ^ j;
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = paramV;
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.Entry
 * JD-Core Version:    0.7.0.1
 */