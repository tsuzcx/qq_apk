package com.tencent.mobileqq.mini.network.http;

import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
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
  public static final String TAG = "MiniOkHttpClientFactory";
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
    init(60000L, 60000L, 60000L);
  }
  
  private static OkHttpClient.Builder createClientWithTimeout(long paramLong, boolean paramBoolean)
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    List localList;
    if (paramBoolean) {
      localList = Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
    } else {
      localList = Arrays.asList(new Protocol[] { Protocol.HTTP_1_1 });
    }
    return localBuilder.protocols(localList).connectTimeout(paramLong, TimeUnit.MILLISECONDS).readTimeout(paramLong, TimeUnit.MILLISECONDS).writeTimeout(paramLong, TimeUnit.MILLISECONDS).connectionPool(mConnectionPool).dispatcher(mDispatcher);
  }
  
  public static OkHttpClient getDownloadClient(boolean paramBoolean)
  {
    if (downloadClient != null)
    {
      if (!paramBoolean) {
        return downloadClient;
      }
      return downloadClientWithCache;
    }
    throw new RuntimeException("client has not been initialized");
  }
  
  public static OkHttpClient getRequestClient()
  {
    if (requestClient != null) {
      return requestClient;
    }
    throw new RuntimeException("client has not been initialized");
  }
  
  public static OkHttpClient getUploadClient()
  {
    if (uploadClient != null) {
      return uploadClient;
    }
    throw new RuntimeException("client has not been initialized");
  }
  
  public static void init(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = GameWnsUtils.enableHttp2();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MiniOkHttpClientFactory init requestTimeOut:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" uploadTimeOut:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" downloadTimeout:");
    ((StringBuilder)localObject).append(paramLong3);
    QLog.e("MiniOkHttpClientFactory", 1, ((StringBuilder)localObject).toString());
    try
    {
      requestClient = createClientWithTimeout(paramLong1, bool).build();
      uploadClient = createClientWithTimeout(paramLong2, bool).build();
      downloadClient = createClientWithTimeout(paramLong3, bool).build();
      localObject = new Cache(new File(MiniAppGlobal.getMiniCacheFilePath(), "http_cache"), 10485760L);
      downloadClientWithCache = createClientWithTimeout(paramLong3, bool).cache((Cache)localObject).build();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniOkHttpClientFactory", 1, "MiniOkHttpClientFactory init failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */