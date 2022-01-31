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
    if (this.index >= this.interceptors.size()) {
      throw new AssertionError();
    }
    this.calls += 1;
    if ((this.httpCodec != null) && (!this.connection.supportsUrl(paramRequest.url()))) {
      throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
    }
    if ((this.httpCodec != null) && (this.calls > 1)) {
      throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
    }
    paramRequest = new RealInterceptorChain(this.interceptors, paramStreamAllocation, paramHttpCodec, paramRealConnection, this.index + 1, paramRequest, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
    paramStreamAllocation = (Interceptor)this.interceptors.get(this.index);
    paramRealConnection = paramStreamAllocation.intercept(paramRequest);
    if ((paramHttpCodec != null) && (this.index + 1 < this.interceptors.size()) && (paramRequest.calls != 1)) {
      throw new IllegalStateException("network interceptor " + paramStreamAllocation + " must call proceed() exactly once");
    }
    if (paramRealConnection == null) {
      throw new NullPointerException("interceptor " + paramStreamAllocation + " returned null");
    }
    if (paramRealConnection.body() == null) {
      throw new IllegalStateException("interceptor " + paramStreamAllocation + " returned a response with no body");
    }
    return paramRealConnection;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http.RealInterceptorChain
 * JD-Core Version:    0.7.0.1
 */