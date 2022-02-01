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
    if (localObject1 == FileExtension.ZIP) {
      localObject1 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream((InputStream)localObject2), this.url);
    } else {
      localObject1 = LottieCompositionFactory.fromJsonInputStreamSync((InputStream)localObject2, this.url);
    }
    if (((LottieResult)localObject1).getValue() != null) {
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Fetching ");
    ((StringBuilder)localObject1).append(this.url);
    L.debug(((StringBuilder)localObject1).toString());
    localObject1 = (HttpURLConnection)new URL(this.url).openConnection();
    ((HttpURLConnection)localObject1).setRequestMethod("GET");
    ((HttpURLConnection)localObject1).connect();
    if ((((HttpURLConnection)localObject1).getErrorStream() == null) && (((HttpURLConnection)localObject1).getResponseCode() == 200))
    {
      localObject2 = ((HttpURLConnection)localObject1).getContentType();
      int i = -1;
      int j = ((String)localObject2).hashCode();
      boolean bool = true;
      if (j != -1248325150)
      {
        if ((j == -43840953) && (((String)localObject2).equals("application/json"))) {
          i = 1;
        }
      }
      else if (((String)localObject2).equals("application/zip")) {
        i = 0;
      }
      if (i != 0)
      {
        L.debug("Received json response.");
        localObject2 = FileExtension.JSON;
        localObject1 = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(((HttpURLConnection)localObject1).getInputStream(), (FileExtension)localObject2).getAbsolutePath())), this.url);
      }
      else
      {
        L.debug("Handling zip response.");
        localObject2 = FileExtension.ZIP;
        localObject1 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(((HttpURLConnection)localObject1).getInputStream(), (FileExtension)localObject2))), this.url);
      }
      if (((LottieResult)localObject1).getValue() != null) {
        this.networkCache.renameTempFile((FileExtension)localObject2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Completed fetch from network. Success: ");
      if (((LottieResult)localObject1).getValue() == null) {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      L.debug(((StringBuilder)localObject2).toString());
      return localObject1;
    }
    Object localObject3 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getErrorStream()));
    Object localObject2 = new StringBuilder();
    for (;;)
    {
      String str = ((BufferedReader)localObject3).readLine();
      if (str == null) {
        break;
      }
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append('\n');
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Unable to fetch ");
    ((StringBuilder)localObject3).append(this.url);
    ((StringBuilder)localObject3).append(". Failed with ");
    ((StringBuilder)localObject3).append(((HttpURLConnection)localObject1).getResponseCode());
    ((StringBuilder)localObject3).append("\n");
    ((StringBuilder)localObject3).append(localObject2);
    return new LottieResult(new IllegalArgumentException(((StringBuilder)localObject3).toString()));
  }
  
  public static LottieResult<LottieComposition> fetchSync(Context paramContext, String paramString)
  {
    return new NetworkFetcher(paramContext, paramString).fetchSync();
  }
  
  @WorkerThread
  public LottieResult<LottieComposition> fetchSync()
  {
    Object localObject = fetchFromCache();
    if (localObject != null) {
      return new LottieResult(localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Animation for ");
    ((StringBuilder)localObject).append(this.url);
    ((StringBuilder)localObject).append(" not found in cache. Fetching from network.");
    L.debug(((StringBuilder)localObject).toString());
    return fetchFromNetwork();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkFetcher
 * JD-Core Version:    0.7.0.1
 */