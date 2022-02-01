package common.qzone.component.cache.common;

import android.support.v4.util.LruCache;

public class ExtendLruCache<K, V>
{
  private final LruCache<K, V> a;
  private int b;
  private int c;
  
  protected int a(K paramK, V paramV)
  {
    return 1;
  }
  
  protected V a(K paramK)
  {
    return null;
  }
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = this.b;
    float f2 = this.c + i;
    float f1 = 0.0F;
    if (f2 != 0.0F) {
      f1 = i * 100 / f2;
    }
    Object localObject = String.format("ExtendLruCache[hits=%d,misses=%d,hitRate=%s]", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), String.valueOf(f1) });
    this.b = 0;
    this.c = 0;
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.a.toString());
    i = this.a.size() / 1024;
    int j = this.a.maxSize() / 1024;
    localStringBuilder.append("\n");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Lru Size Info:");
    ((StringBuilder)localObject).append(String.valueOf(i));
    ((StringBuilder)localObject).append("kb/");
    ((StringBuilder)localObject).append(String.valueOf(j));
    ((StringBuilder)localObject).append("kb");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.qzone.component.cache.common.ExtendLruCache
 * JD-Core Version:    0.7.0.1
 */