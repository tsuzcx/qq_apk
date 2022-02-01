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
  private static final ConnectionPool jdField_a_of_type_Okhttp3ConnectionPool = new ConnectionPool(10, 60L, TimeUnit.SECONDS);
  private static final Dispatcher jdField_a_of_type_Okhttp3Dispatcher = new Dispatcher();
  private static volatile OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  
  static
  {
    jdField_a_of_type_Okhttp3Dispatcher.setMaxRequests(64);
    jdField_a_of_type_Okhttp3Dispatcher.setMaxRequestsPerHost(8);
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
    return localBuilder.protocols(localList).connectTimeout(paramLong, TimeUnit.MILLISECONDS).readTimeout(paramLong, TimeUnit.MILLISECONDS).writeTimeout(paramLong, TimeUnit.MILLISECONDS).connectionPool(jdField_a_of_type_Okhttp3ConnectionPool).dispatcher(jdField_a_of_type_Okhttp3Dispatcher);
  }
  
  public static OkHttpClient a()
  {
    if (jdField_a_of_type_Okhttp3OkHttpClient == null) {
      a(30000L);
    }
    return jdField_a_of_type_Okhttp3OkHttpClient;
  }
  
  private static void a(long paramLong)
  {
    jdField_a_of_type_Okhttp3OkHttpClient = a(paramLong, ((IMiniAppService)QRoute.api(IMiniAppService.class)).enableHttp2()).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.okhttp.OkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */