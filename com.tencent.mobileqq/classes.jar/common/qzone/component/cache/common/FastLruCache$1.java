package common.qzone.component.cache.common;

import bilu;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FastLruCache$1
  extends LinkedHashMap<K, V>
{
  public FastLruCache$1(bilu parambilu, int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.val$maxSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     common.qzone.component.cache.common.FastLruCache.1
 * JD-Core Version:    0.7.0.1
 */