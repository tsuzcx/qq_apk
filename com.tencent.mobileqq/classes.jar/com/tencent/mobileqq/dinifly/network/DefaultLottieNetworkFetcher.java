package com.tencent.mobileqq.dinifly.network;

import androidx.annotation.NonNull;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultLottieNetworkFetcher
  implements LottieNetworkFetcher
{
  @NonNull
  public LottieFetchResult fetchSync(@NonNull String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setRequestMethod("GET");
    paramString.connect();
    return new DefaultLottieFetchResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.DefaultLottieNetworkFetcher
 * JD-Core Version:    0.7.0.1
 */