package com.tencent.mobileqq.mini.http;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MiniOkHttpClientFactory
{
  private static final long HTTP_CACHE_SIZE = 10485760L;
  private static volatile OkHttpClient downloadClient;
  private static volatile OkHttpClient downloadClientWithCache;
  private static final ConnectionPool mConnectionPool = new ConnectionPool(10, 60L, TimeUnit.SECONDS);
  private static final Dispatcher mDispatcher = new Dispatcher();
  private static volatile OkHttpClient requestClient;
  private static volatile OkHttpClient uploadClient;
  
  static
  {
    mDispatcher.setMaxRequests(64);
    mDispatcher.setMaxRequestsPerHost(8);
    init(30000L, 30000L, 30000L);
  }
  
  private static OkHttpClient createClientWithTimeout(long paramLong)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.setProtocols(Arrays.asList(new Protocol[] { Protocol.HTTP_1_1 }));
    localOkHttpClient.setConnectTimeout(paramLong, TimeUnit.MILLISECONDS);
    localOkHttpClient.setReadTimeout(paramLong, TimeUnit.MILLISECONDS);
    localOkHttpClient.setWriteTimeout(paramLong, TimeUnit.MILLISECONDS);
    localOkHttpClient.setConnectionPool(mConnectionPool);
    localOkHttpClient.setDispatcher(mDispatcher);
    return localOkHttpClient;
  }
  
  public static OkHttpClient getDownloadClient(boolean paramBoolean)
  {
    if (downloadClient == null) {
      throw new RuntimeException("client has not been initialized");
    }
    if (!paramBoolean) {
      return downloadClient;
    }
    return downloadClientWithCache;
  }
  
  public static OkHttpClient getRequestClient()
  {
    if (requestClient == null) {
      throw new RuntimeException("client has not been initialized");
    }
    return requestClient;
  }
  
  public static OkHttpClient getUploadClient()
  {
    if (uploadClient == null) {
      throw new RuntimeException("client has not been initialized");
    }
    return uploadClient;
  }
  
  public static void init(long paramLong1, long paramLong2, long paramLong3)
  {
    requestClient = createClientWithTimeout(paramLong1);
    uploadClient = createClientWithTimeout(paramLong2);
    downloadClient = createClientWithTimeout(paramLong3);
    Cache localCache = new Cache(new File(MiniAppGlobal.getMiniCacheFilePath(), "http_cache"), 10485760L);
    downloadClientWithCache = downloadClient.clone();
    downloadClientWithCache.setCache(localCache);
  }
  
  public static void setTimeout(long paramLong1, long paramLong2, long paramLong3)
  {
    setTimeout(requestClient, paramLong1);
    setTimeout(uploadClient, paramLong2);
    setTimeout(downloadClient, paramLong3);
  }
  
  private static void setTimeout(OkHttpClient paramOkHttpClient, long paramLong)
  {
    paramOkHttpClient.setConnectTimeout(paramLong, TimeUnit.MILLISECONDS);
    paramOkHttpClient.setReadTimeout(paramLong, TimeUnit.MILLISECONDS);
    paramOkHttpClient.setWriteTimeout(paramLong, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */