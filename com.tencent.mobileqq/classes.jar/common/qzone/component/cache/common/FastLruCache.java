package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class FastLruCache<K, V>
{
  private final int a;
  private final HashMap<K, V> b;
  private final HashMap<K, FastLruCache.Entry<K, V>> c = new HashMap();
  private ReferenceQueue<V> d = new ReferenceQueue();
  
  public FastLruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = paramInt;
      this.b = new FastLruCache.1(this, 16, 0.75F, true, paramInt);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a()
  {
    for (FastLruCache.Entry localEntry = (FastLruCache.Entry)this.d.poll(); localEntry != null; localEntry = (FastLruCache.Entry)this.d.poll()) {
      this.c.remove(localEntry.a);
    }
  }
  
  public final V a(K paramK)
  {
    try
    {
      a();
      Object localObject = this.b.get(paramK);
      if (localObject != null) {
        return localObject;
      }
      paramK = (FastLruCache.Entry)this.c.get(paramK);
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
      this.b.put(paramK, paramV);
      paramK = (FastLruCache.Entry)this.c.put(paramK, new FastLruCache.Entry(paramK, paramV, this.d));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.FastLruCache
 * JD-Core Version:    0.7.0.1
 */