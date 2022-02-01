package okhttp3.internal.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain
  implements Interceptor.Chain
{
  private final Call call;
  private int calls;
  private final int connectTimeout;
  private final RealConnection connection;
  private final EventListener eventListener;
  private final HttpCodec httpCodec;
  private final int index;
  private final List<Interceptor> interceptors;
  private final int readTimeout;
  private final Request request;
  private final StreamAllocation streamAllocation;
  private final int writeTimeout;
  
  public RealInterceptorChain(List<Interceptor> paramList, StreamAllocation paramStreamAllocation, HttpCodec paramHttpCodec, RealConnection paramRealConnection, int paramInt1, Request paramRequest, Call paramCall, EventListener paramEventListener, int paramInt2, int paramInt3, int paramInt4)
  {
    this.interceptors = paramList;
    this.connection = paramRealConnection;
    this.streamAllocation = paramStreamAllocation;
    this.httpCodec = paramHttpCodec;
    this.index = paramInt1;
    this.request = paramRequest;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    this.connectTimeout = paramInt2;
    this.readTimeout = paramInt3;
    this.writeTimeout = paramInt4;
  }
  
  public Call call()
  {
    return this.call;
  }
  
  public int connectTimeoutMillis()
  {
    return this.connectTimeout;
  }
  
  public Connection connection()
  {
    return this.connection;
  }
  
  public EventListener eventListener()
  {
    return this.eventListener;
  }
  
  public HttpCodec httpStream()
  {
    return this.httpCodec;
  }
  
  public Response proceed(Request paramRequest)
  {
    return proceed(paramRequest, this.streamAllocation, this.httpCodec, this.connection);
  }
  
  public Response proceed(Request paramRequest, StreamAllocation paramStreamAllocation, HttpCodec paramHttpCodec, RealConnection paramRealConnection)
  {
    if (this.index < this.interceptors.size())
    {
      this.calls += 1;
      if ((this.httpCodec != null) && (!this.connection.supportsUrl(paramRequest.url())))
      {
        paramRequest = new StringBuilder();
        paramRequest.append("network interceptor ");
        paramRequest.append(this.interceptors.get(this.index - 1));
        paramRequest.append(" must retain the same host and port");
        throw new IllegalStateException(paramRequest.toString());
      }
      if ((this.httpCodec != null) && (this.calls > 1))
      {
        paramRequest = new StringBuilder();
        paramRequest.append("network interceptor ");
        paramRequest.append(this.interceptors.get(this.index - 1));
        paramRequest.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramRequest.toString());
      }
      paramStreamAllocation = new RealInterceptorChain(this.interceptors, paramStreamAllocation, paramHttpCodec, paramRealConnection, this.index + 1, paramRequest, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
      paramRequest = (Interceptor)this.interceptors.get(this.index);
      paramRealConnection = paramRequest.intercept(paramStreamAllocation);
      if ((paramHttpCodec != null) && (this.index + 1 < this.interceptors.size()) && (paramStreamAllocation.calls != 1))
      {
        paramStreamAllocation = new StringBuilder();
        paramStreamAllocation.append("network interceptor ");
        paramStreamAllocation.append(paramRequest);
        paramStreamAllocation.append(" must call proceed() exactly once");
        throw new IllegalStateException(paramStreamAllocation.toString());
      }
      if (paramRealConnection != null)
      {
        if (paramRealConnection.body() != null) {
          return paramRealConnection;
        }
        paramStreamAllocation = new StringBuilder();
        paramStreamAllocation.append("interceptor ");
        paramStreamAllocation.append(paramRequest);
        paramStreamAllocation.append(" returned a response with no body");
        throw new IllegalStateException(paramStreamAllocation.toString());
      }
      paramStreamAllocation = new StringBuilder();
      paramStreamAllocation.append("interceptor ");
      paramStreamAllocation.append(paramRequest);
      paramStreamAllocation.append(" returned null");
      throw new NullPointerException(paramStreamAllocation.toString());
    }
    throw new AssertionError();
  }
  
  public int readTimeoutMillis()
  {
    return this.readTimeout;
  }
  
  public Request request()
  {
    return this.request;
  }
  
  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }
  
  public Interceptor.Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    paramInt = Util.checkDuration("timeout", paramInt, paramTimeUnit);
    return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, paramInt, this.readTimeout, this.writeTimeout);
  }
  
  public Interceptor.Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    paramInt = Util.checkDuration("timeout", paramInt, paramTimeUnit);
    return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, paramInt, this.writeTimeout);
  }
  
  public Interceptor.Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    paramInt = Util.checkDuration("timeout", paramInt, paramTimeUnit);
    return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, paramInt);
  }
  
  public int writeTimeoutMillis()
  {
    return this.writeTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.http.RealInterceptorChain
 * JD-Core Version:    0.7.0.1
 */