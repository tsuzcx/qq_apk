package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class FastLruCache<K, V>
{
  private final int jdField_a_of_type_Int;
  private ReferenceQueue<V> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private final HashMap<K, V> jdField_a_of_type_JavaUtilHashMap;
  private final HashMap<K, FastLruCache.Entry<K, V>> b = new HashMap();
  
  public FastLruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaUtilHashMap = new FastLruCache.1(this, 16, 0.75F, true, paramInt);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a()
  {
    for (FastLruCache.Entry localEntry = (FastLruCache.Entry)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll(); localEntry != null; localEntry = (FastLruCache.Entry)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll()) {
      this.b.remove(localEntry.a);
    }
  }
  
  public final V a(K paramK)
  {
    try
    {
      a();
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.get(paramK);
      if (localObject != null) {
        return localObject;
      }
      paramK = (FastLruCache.Entry)this.b.get(paramK);
      if (paramK == null) {
        paramK = null;
      } else {
        paramK = paramK.get();
      }
      return paramK;
    }
    finally {}
  }
  
  public final V a(K paramK, V paramV)
  {
    try
    {
      a();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramK, paramV);
      paramK = (FastLruCache.Entry)this.b.put(paramK, new FastLruCache.Entry(paramK, paramV, this.jdField_a_of_type_JavaLangRefReferenceQueue));
      if (paramK == null) {
        paramK = null;
      } else {
        paramK = paramK.get();
      }
      return paramK;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.qzone.component.cache.common.FastLruCache
 * JD-Core Version:    0.7.0.1
 */