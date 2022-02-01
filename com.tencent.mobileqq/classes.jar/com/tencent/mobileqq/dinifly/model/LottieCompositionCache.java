package com.tencent.mobileqq.dinifly.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.tencent.mobileqq.dinifly.LottieComposition;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class LottieCompositionCache
{
  private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
  private final LruCache<String, LottieComposition> cache = new LruCache(20);
  
  public static LottieCompositionCache getInstance()
  {
    return INSTANCE;
  }
  
  public void clear()
  {
    this.cache.evictAll();
  }
  
  @Nullable
  public LottieComposition get(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (LottieComposition)this.cache.get(paramString);
  }
  
  public void put(@Nullable String paramString, LottieComposition paramLottieComposition)
  {
    if (paramString == null) {
      return;
    }
    this.cache.put(paramString, paramLottieComposition);
  }
  
  public void removeCacheByKey(String paramString)
  {
    if (paramString != null) {
      this.cache.remove(paramString);
    }
  }
  
  public void resize(int paramInt)
  {
    this.cache.resize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.LottieCompositionCache
 * JD-Core Version:    0.7.0.1
 */