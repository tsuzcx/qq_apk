package com.tencent.mobileqq.dinifly;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.network.LottieNetworkCacheProvider;
import com.tencent.mobileqq.dinifly.network.LottieNetworkFetcher;

public class LottieConfig
{
  @Nullable
  final LottieNetworkCacheProvider cacheProvider;
  final boolean enableSystraceMarkers;
  @Nullable
  final LottieNetworkFetcher networkFetcher;
  
  private LottieConfig(@Nullable LottieNetworkFetcher paramLottieNetworkFetcher, @Nullable LottieNetworkCacheProvider paramLottieNetworkCacheProvider, boolean paramBoolean)
  {
    this.networkFetcher = paramLottieNetworkFetcher;
    this.cacheProvider = paramLottieNetworkCacheProvider;
    this.enableSystraceMarkers = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieConfig
 * JD-Core Version:    0.7.0.1
 */