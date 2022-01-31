package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.tencent.qapmsdk.common.logger.Logger;

public class QAPMOKhttp2Interceptor
  implements Interceptor
{
  private static final String TAG = "QAPM_Impl_QAPMOKhttp2Interceptor";
  
  private Request setQuitTime(Request paramRequest, long paramLong)
  {
    try
    {
      Request localRequest = paramRequest.newBuilder().addHeader("X-QAPM-Qt", String.valueOf(paramLong)).build();
      return localRequest;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMOKhttp2Interceptor", "ok2 add header failed:", localException.getMessage() });
    }
    return paramRequest;
  }
  
  private Response setQuitTime(Response paramResponse, long paramLong)
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
    return setQuitTime(paramChain.proceed(paramChain.request()), l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMOKhttp2Interceptor
 * JD-Core Version:    0.7.0.1
 */