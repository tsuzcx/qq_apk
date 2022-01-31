package com.tencent.mobileqq.mini.http;

import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

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
  
  private static OkHttpClient.Builder createClientWithTimeout(long paramLong, boolean paramBoolean)
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    if (paramBoolean) {}
    for (List localList = Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });; localList = Arrays.asList(new Protocol[] { Protocol.HTTP_1_1 })) {
      return localBuilder.protocols(localList).connectTimeout(paramLong, TimeUnit.MILLISECONDS).readTimeout(paramLong, TimeUnit.MILLISECONDS).writeTimeout(paramLong, TimeUnit.MILLISECONDS).connectionPool(mConnectionPool).dispatcher(mDispatcher);
    }
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
    boolean bool = GameWnsUtils.enableHttp2();
    requestClient = createClientWithTimeout(paramLong1, bool).build();
    uploadClient = createClientWithTimeout(paramLong2, bool).build();
    downloadClient = createClientWithTimeout(paramLong3, bool).build();
    Cache localCache = new Cache(new File(MiniAppGlobal.getMiniCacheFilePath(), "http_cache"), 10485760L);
    downloadClientWithCache = createClientWithTimeout(paramLong3, bool).cache(localCache).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */