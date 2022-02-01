package common.qzone.component.cache.common;

import android.support.v4.util.LruCache;

class ExtendLruCache$1
  extends LruCache<K, V>
{
  public V create(K paramK)
  {
    return this.a.a(paramK);
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
    this.a.a(paramBoolean, paramK, paramV1, paramV2);
  }
  
  public int sizeOf(K paramK, V paramV)
  {
    return this.a.a(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.qzone.component.cache.common.ExtendLruCache.1
 * JD-Core Version:    0.7.0.1
 */