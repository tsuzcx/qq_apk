package com.tencent.mobileqq.dinifly.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class NetworkFetcher
{
  private final Context appContext;
  private final NetworkCache networkCache;
  private final String url;
  
  private NetworkFetcher(Context paramContext, String paramString)
  {
    this.appContext = paramContext.getApplicationContext();
    this.url = paramString;
    this.networkCache = new NetworkCache(this.appContext, paramString);
  }
  
  @Nullable
  @WorkerThread
  private LottieComposition fetchFromCache()
  {
    Object localObject2 = this.networkCache.fetch();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = (FileExtension)((Pair)localObject2).first;
    localObject2 = (InputStream)((Pair)localObject2).second;
    if (localObject1 == FileExtension.ZIP) {}
    for (localObject1 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream((InputStream)localObject2), this.url); ((LottieResult)localObject1).getValue() != null; localObject1 = LottieCompositionFactory.fromJsonInputStreamSync((InputStream)localObject2, this.url)) {
      return (LottieComposition)((LottieResult)localObject1).getValue();
    }
    return null;
  }
  
  @WorkerThread
  private LottieResult<LottieComposition> fetchFromNetwork()
  {
    try
    {
      LottieResult localLottieResult = fetchFromNetworkInternal();
      return localLottieResult;
    }
    catch (IOException localIOException)
    {
      return new LottieResult(localIOException);
    }
  }
  
  @WorkerThread
  private LottieResult fetchFromNetworkInternal()
  {
    L.debug("Fetching " + this.url);
    Object localObject1 = (HttpURLConnection)new URL(this.url).openConnection();
    ((HttpURLConnection)localObject1).setRequestMethod("GET");
    ((HttpURLConnection)localObject1).connect();
    if ((((HttpURLConnection)localObject1).getErrorStream() != null) || (((HttpURLConnection)localObject1).getResponseCode() != 200))
    {
      localObject2 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getErrorStream()));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = ((BufferedReader)localObject2).readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str).append('\n');
      }
      return new LottieResult(new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + ((HttpURLConnection)localObject1).getResponseCode() + "\n" + localStringBuilder));
    }
    Object localObject2 = ((HttpURLConnection)localObject1).getContentType();
    int i = -1;
    switch (((String)localObject2).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        L.debug("Received json response.");
        localObject2 = FileExtension.JSON;
        localObject1 = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(((HttpURLConnection)localObject1).getInputStream(), (FileExtension)localObject2).getAbsolutePath())), this.url);
        label292:
        if (((LottieResult)localObject1).getValue() != null) {
          this.networkCache.renameTempFile((FileExtension)localObject2);
        }
        localObject2 = new StringBuilder().append("Completed fetch from network. Success: ");
        if (((LottieResult)localObject1).getValue() == null) {}
        break;
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      L.debug(bool);
      return localObject1;
      if (!((String)localObject2).equals("application/zip")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject2).equals("application/json")) {
        break;
      }
      i = 1;
      break;
      L.debug("Handling zip response.");
      localObject2 = FileExtension.ZIP;
      localObject1 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(((HttpURLConnection)localObject1).getInputStream(), (FileExtension)localObject2))), this.url);
      break label292;
    }
  }
  
  public static LottieResult<LottieComposition> fetchSync(Context paramContext, String paramString)
  {
    return new NetworkFetcher(paramContext, paramString).fetchSync();
  }
  
  @WorkerThread
  public LottieResult<LottieComposition> fetchSync()
  {
    LottieComposition localLottieComposition = fetchFromCache();
    if (localLottieComposition != null) {
      return new LottieResult(localLottieComposition);
    }
    L.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
    return fetchFromNetwork();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkFetcher
 * JD-Core Version:    0.7.0.1
 */