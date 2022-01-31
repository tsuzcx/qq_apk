package com.tencent.plato.mqq.module;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.mqq.network.ProgressResponseBody;

class NetworkingModule$2
  implements Interceptor
{
  NetworkingModule$2(NetworkingModule paramNetworkingModule, IFunction paramIFunction) {}
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    paramChain = paramChain.proceed(paramChain.request());
    ProgressResponseBody localProgressResponseBody = new ProgressResponseBody(paramChain.body(), new NetworkingModule.2.1(this));
    return paramChain.newBuilder().body(localProgressResponseBody).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NetworkingModule.2
 * JD-Core Version:    0.7.0.1
 */