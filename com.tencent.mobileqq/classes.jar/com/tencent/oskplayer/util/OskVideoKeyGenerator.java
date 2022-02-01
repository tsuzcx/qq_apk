package com.tencent.oskplayer.util;

import com.tencent.oskplayer.cache.CacheKeyGenerator;
import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;

public class OskVideoKeyGenerator
  implements VideoKeyGenerator
{
  private CacheKeyGenerator mCacheKeyGenerator;
  private VideoKeyGenerator mDefaultCacheKeyGenerator;
  
  public OskVideoKeyGenerator(CacheKeyGenerator paramCacheKeyGenerator)
  {
    this.mCacheKeyGenerator = paramCacheKeyGenerator;
    this.mDefaultCacheKeyGenerator = new DefaultVideoKeyGenerator();
  }
  
  public String generate(String paramString)
  {
    CacheKeyGenerator localCacheKeyGenerator = this.mCacheKeyGenerator;
    if (localCacheKeyGenerator != null) {
      return localCacheKeyGenerator.generate(paramString);
    }
    return this.mDefaultCacheKeyGenerator.generate(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.OskVideoKeyGenerator
 * JD-Core Version:    0.7.0.1
 */