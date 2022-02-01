package com.tencent.mobileqq.dinifly;

import androidx.annotation.NonNull;

public class Lottie
{
  public static void initialize(@NonNull LottieConfig paramLottieConfig)
  {
    L.setFetcher(paramLottieConfig.networkFetcher);
    L.setCacheProvider(paramLottieConfig.cacheProvider);
    L.setTraceEnabled(paramLottieConfig.enableSystraceMarkers);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.Lottie
 * JD-Core Version:    0.7.0.1
 */