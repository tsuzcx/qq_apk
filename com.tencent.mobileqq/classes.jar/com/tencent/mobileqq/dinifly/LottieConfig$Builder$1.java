package com.tencent.mobileqq.dinifly;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.dinifly.network.LottieNetworkCacheProvider;
import java.io.File;

class LottieConfig$Builder$1
  implements LottieNetworkCacheProvider
{
  LottieConfig$Builder$1(LottieConfig.Builder paramBuilder, File paramFile) {}
  
  @NonNull
  public File getCacheDir()
  {
    if (this.val$file.isDirectory()) {
      return this.val$file;
    }
    throw new IllegalArgumentException("cache file must be a directory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieConfig.Builder.1
 * JD-Core Version:    0.7.0.1
 */