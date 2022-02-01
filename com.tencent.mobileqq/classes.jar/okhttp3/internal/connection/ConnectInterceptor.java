package okhttp3.internal.connection;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

public final class ConnectInterceptor
  implements Interceptor
{
  public final OkHttpClient client;
  
  public ConnectInterceptor(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    RealInterceptorChain localRealInterceptorChain = (RealInterceptorChain)paramChain;
    Request localRequest = localRealInterceptorChain.request();
    StreamAllocation localStreamAllocation = localRealInterceptorChain.streamAllocation();
    boolean bool = localRequest.method().equals("GET");
    return localRealInterceptorChain.proceed(localRequest, localStreamAllocation, localStreamAllocation.newStream(this.client, paramChain, bool ^ true), localStreamAllocation.connection());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.connection.ConnectInterceptor
 * JD-Core Version:    0.7.0.1
 */