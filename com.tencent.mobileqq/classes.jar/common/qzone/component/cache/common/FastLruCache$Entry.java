package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class FastLruCache$Entry<K, V>
  extends WeakReference<V>
{
  K a;
  
  public FastLruCache$Entry(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
  {
    super(paramV, paramReferenceQueue);
    this.a = paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.qzone.component.cache.common.FastLruCache.Entry
 * JD-Core Version:    0.7.0.1
 */