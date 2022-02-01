package com.tencent.mobileqq.dinifly;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.dinifly.network.LottieNetworkCacheProvider;
import java.io.File;

class LottieConfig$Builder$2
  implements LottieNetworkCacheProvider
{
  LottieConfig$Builder$2(LottieConfig.Builder paramBuilder, LottieNetworkCacheProvider paramLottieNetworkCacheProvider) {}
  
  @NonNull
  public File getCacheDir()
  {
    File localFile = this.val$fileCacheProvider.getCacheDir();
    if (localFile.isDirectory()) {
      return localFile;
    }
    throw new IllegalArgumentException("cache file must be a directory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieConfig.Builder.2
 * JD-Core Version:    0.7.0.1
 */