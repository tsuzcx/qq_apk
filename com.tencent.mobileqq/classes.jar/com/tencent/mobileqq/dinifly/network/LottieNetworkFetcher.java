package com.tencent.mobileqq.dinifly.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

public abstract interface LottieNetworkFetcher
{
  @NonNull
  @WorkerThread
  public abstract LottieFetchResult fetchSync(@NonNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.LottieNetworkFetcher
 * JD-Core Version:    0.7.0.1
 */