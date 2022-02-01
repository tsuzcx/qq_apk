package com.tencent.mobileqq.now.netchannel.okhttp;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

public class OkHttpClientFactory
{
  private static volatile OkHttpClient a;
  private static final ConnectionPool b = new ConnectionPool(10, 60L, TimeUnit.SECONDS);
  private static final Dispatcher c = new Dispatcher();
  
  static
  {
    c.setMaxRequests(64);
    c.setMaxRequestsPerHost(8);
    a(30000L);
  }
  
  private static OkHttpClient.Builder a(long paramLong, boolean paramBoolean)
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    List localList;
    if (paramBoolean) {
      localList = Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
    } else {
      localList = Arrays.asList(new Protocol[] { Protocol.HTTP_1_1 });
    }
    return localBuilder.protocols(localList).connectTimeout(paramLong, TimeUnit.MILLISECONDS).readTimeout(paramLong, TimeUnit.MILLISECONDS).writeTimeout(paramLong, TimeUnit.MILLISECONDS).connectionPool(b).dispatcher(c);
  }
  
  public static OkHttpClient a()
  {
    if (a == null) {
      a(30000L);
    }
    return a;
  }
  
  private static void a(long paramLong)
  {
    a = a(paramLong, ((IMiniAppService)QRoute.api(IMiniAppService.class)).enableHttp2()).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.okhttp.OkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */