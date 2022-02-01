package com.tencent.xaction.impl;

import android.graphics.Bitmap;
import com.tencent.xaction.api.IMemoryLruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/MemoryLruCacheImpl;", "Lcom/tencent/xaction/api/IMemoryLruCache;", "cacheSize", "", "(J)V", "cache", "com/tencent/xaction/impl/MemoryLruCacheImpl$cache$1", "Lcom/tencent/xaction/impl/MemoryLruCacheImpl$cache$1;", "defaultCacheSize", "", "maxMemory", "evictAll", "", "get", "Landroid/graphics/Bitmap;", "key", "", "put", "obj", "remove", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class MemoryLruCacheImpl
  implements IMemoryLruCache
{
  public static final MemoryLruCacheImpl.Companion a = new MemoryLruCacheImpl.Companion(null);
  private static long e;
  private static long f;
  private static long g;
  private int b = (int)Runtime.getRuntime().maxMemory();
  private final int c;
  private MemoryLruCacheImpl.cache.1 d;
  
  public MemoryLruCacheImpl(long paramLong)
  {
    int i = this.b;
    this.c = (i / 6);
    if (paramLong == 0L) {
      i /= this.c;
    } else {
      i = (int)paramLong;
    }
    this.d = new MemoryLruCacheImpl.cache.1(this, paramLong, i);
  }
  
  @Nullable
  public Bitmap a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return (Bitmap)this.d.get(paramString);
  }
  
  public void a(@NotNull String paramString, @NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramBitmap, "obj");
    this.d.put(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.impl.MemoryLruCacheImpl
 * JD-Core Version:    0.7.0.1
 */