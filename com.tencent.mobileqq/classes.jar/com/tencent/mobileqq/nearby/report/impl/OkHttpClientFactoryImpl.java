package com.tencent.mobileqq.nearby.report.impl;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.nearby.report.IOkHttpClientFactory;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

public class OkHttpClientFactoryImpl
  implements IOkHttpClientFactory
{
  private static final ConnectionPool mConnectionPool = new ConnectionPool(10, 60L, TimeUnit.SECONDS);
  private static final Dispatcher mDispatcher = new Dispatcher();
  private static volatile OkHttpClient requestClient;
  
  static
  {
    mDispatcher.setMaxRequests(64);
    mDispatcher.setMaxRequestsPerHost(8);
    init(30000L);
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
  
  private static void init(long paramLong)
  {
    requestClient = createClientWithTimeout(paramLong, ((IMiniAppService)QRoute.api(IMiniAppService.class)).enableHttp2()).build();
  }
  
  public OkHttpClient getRequestClient()
  {
    if (requestClient == null) {
      init(30000L);
    }
    return requestClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.impl.OkHttpClientFactoryImpl
 * JD-Core Version:    0.7.0.1
 */