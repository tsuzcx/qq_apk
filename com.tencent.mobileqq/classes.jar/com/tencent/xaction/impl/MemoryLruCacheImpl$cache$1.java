package com.tencent.xaction.impl;

import android.graphics.Bitmap;
import android.util.LruCache;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/impl/MemoryLruCacheImpl$cache$1", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "sizeOf", "", "key", "value", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class MemoryLruCacheImpl$cache$1
  extends LruCache<String, Bitmap>
{
  MemoryLruCacheImpl$cache$1(long paramLong, int paramInt)
  {
    super(i);
  }
  
  protected int a(@Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getByteCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.MemoryLruCacheImpl.cache.1
 * JD-Core Version:    0.7.0.1
 */