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
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        localObject1 = getKey();
        localObject2 = paramObject.getKey();
      } while ((localObject1 != localObject2) && ((localObject1 == null) || (!localObject1.equals(localObject2))));
      localObject1 = getValue();
      paramObject = paramObject.getValue();
    } while ((localObject1 != paramObject) && ((localObject1 == null) || (!localObject1.equals(paramObject))));
    return true;
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
    int j = 0;
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label36;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label36:
      j = localObject2.hashCode();
    }
  }
  
  public V setValue(V paramV)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = paramV;
    return localObject;
  }
  
  public String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap.Entry
 * JD-Core Version:    0.7.0.1
 */