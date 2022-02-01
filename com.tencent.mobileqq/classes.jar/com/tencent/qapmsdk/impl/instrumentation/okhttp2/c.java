package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.tencent.qapmsdk.common.logger.Logger;

public class c
  implements Interceptor
{
  private Response a(Response paramResponse, long paramLong)
  {
    try
    {
      Response localResponse = paramResponse.newBuilder().addHeader("X-QAPM-Qt", String.valueOf(paramLong)).build();
      return localResponse;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMOKhttp2Interceptor", "setQueueTime error:", localException.getMessage() });
    }
    return paramResponse;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    long l = System.currentTimeMillis();
    return a(paramChain.proceed(paramChain.request()), l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.c
 * JD-Core Version:    0.7.0.1
 */