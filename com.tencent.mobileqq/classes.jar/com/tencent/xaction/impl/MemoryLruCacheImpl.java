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
  private static long jdField_a_of_type_Long;
  public static final MemoryLruCacheImpl.Companion a;
  private static long jdField_b_of_type_Long;
  private static long c;
  private int jdField_a_of_type_Int = (int)Runtime.getRuntime().maxMemory();
  private MemoryLruCacheImpl.cache.1 jdField_a_of_type_ComTencentXactionImplMemoryLruCacheImpl$cache$1;
  private final int jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComTencentXactionImplMemoryLruCacheImpl$Companion = new MemoryLruCacheImpl.Companion(null);
  }
  
  public MemoryLruCacheImpl(long paramLong)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = (i / 6);
    if (paramLong == 0L) {
      i /= this.jdField_b_of_type_Int;
    } else {
      i = (int)paramLong;
    }
    this.jdField_a_of_type_ComTencentXactionImplMemoryLruCacheImpl$cache$1 = new MemoryLruCacheImpl.cache.1(this, paramLong, i);
  }
  
  @Nullable
  public Bitmap a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return (Bitmap)this.jdField_a_of_type_ComTencentXactionImplMemoryLruCacheImpl$cache$1.get(paramString);
  }
  
  public void a(@NotNull String paramString, @NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramBitmap, "obj");
    this.jdField_a_of_type_ComTencentXactionImplMemoryLruCacheImpl$cache$1.put(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.MemoryLruCacheImpl
 * JD-Core Version:    0.7.0.1
 */