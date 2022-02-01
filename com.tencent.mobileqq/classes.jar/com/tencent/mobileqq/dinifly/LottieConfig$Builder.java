package com.tencent.mobileqq.dinifly;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.network.LottieNetworkCacheProvider;
import com.tencent.mobileqq.dinifly.network.LottieNetworkFetcher;
import java.io.File;

public final class LottieConfig$Builder
{
  @Nullable
  private LottieNetworkCacheProvider cacheProvider;
  private boolean enableSystraceMarkers = false;
  @Nullable
  private LottieNetworkFetcher networkFetcher;
  
  @NonNull
  public LottieConfig build()
  {
    return new LottieConfig(this.networkFetcher, this.cacheProvider, this.enableSystraceMarkers, null);
  }
  
  @NonNull
  public Builder setEnableSystraceMarkers(boolean paramBoolean)
  {
    this.enableSystraceMarkers = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setNetworkCacheDir(@NonNull File paramFile)
  {
    if (this.cacheProvider == null)
    {
      this.cacheProvider = new LottieConfig.Builder.1(this, paramFile);
      return this;
    }
    throw new IllegalStateException("There is already a cache provider!");
  }
  
  @NonNull
  public Builder setNetworkCacheProvider(@NonNull LottieNetworkCacheProvider paramLottieNetworkCacheProvider)
  {
    if (this.cacheProvider == null)
    {
      this.cacheProvider = new LottieConfig.Builder.2(this, paramLottieNetworkCacheProvider);
      return this;
    }
    throw new IllegalStateException("There is already a cache provider!");
  }
  
  @NonNull
  public Builder setNetworkFetcher(@NonNull LottieNetworkFetcher paramLottieNetworkFetcher)
  {
    this.networkFetcher = paramLottieNetworkFetcher;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieConfig.Builder
 * JD-Core Version:    0.7.0.1
 */