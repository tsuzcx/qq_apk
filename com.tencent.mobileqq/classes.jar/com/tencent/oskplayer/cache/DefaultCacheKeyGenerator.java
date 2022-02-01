package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;

public class DefaultCacheKeyGenerator
  implements CacheKeyGenerator
{
  private VideoKeyGenerator mVideoKeyGenerator = new DefaultVideoKeyGenerator();
  
  public String generate(String paramString)
  {
    return this.mVideoKeyGenerator.generate(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.DefaultCacheKeyGenerator
 * JD-Core Version:    0.7.0.1
 */