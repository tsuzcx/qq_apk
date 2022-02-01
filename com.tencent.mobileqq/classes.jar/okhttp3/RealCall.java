package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

final class RealCall
  implements Call
{
  final OkHttpClient client;
  @Nullable
  private EventListener eventListener;
  private boolean executed;
  final boolean forWebSocket;
  final Request originalRequest;
  final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
  final AsyncTimeout timeout;
  
  private RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(paramOkHttpClient, paramBoolean);
    this.timeout = new RealCall.1(this);
    this.timeout.timeout(paramOkHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
  }
  
  private void captureCallStackTrace()
  {
    Object localObject = Platform.get().getStackTraceForCloseable("response.body().close()");
    this.retryAndFollowUpInterceptor.setCallStackTrace(localObject);
  }
  
  static RealCall newRealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    paramRequest = new RealCall(paramOkHttpClient, paramRequest, paramBoolean);
    paramRequest.eventListener = paramOkHttpClient.eventListenerFactory().create(paramRequest);
    return paramRequest;
  }
  
  public void cancel()
  {
    this.retryAndFollowUpInterceptor.cancel();
  }
  
  public RealCall clone()
  {
    return newRealCall(this.client, this.originalRequest, this.forWebSocket);
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    captureCallStackTrace();
    this.eventListener.callStart(this);
    this.client.dispatcher().enqueue(new RealCall.AsyncCall(this, paramCallback));
  }
  
  public Response execute()
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    captureCallStackTrace();
    this.timeout.enter();
    this.eventListener.callStart(this);
    try
    {
      this.client.dispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain();
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = timeoutExit(localIOException1);
      this.eventListener.callFailed(this, localIOException2);
      throw localIOException2;
    }
    finally
    {
      this.client.dispatcher().finished(this);
    }
    this.client.dispatcher().finished(this);
    return localResponse2;
  }
  
  Response getResponseWithInterceptorChain()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.client.interceptors());
    ((List)localObject).add(this.retryAndFollowUpInterceptor);
    ((List)localObject).add(new BridgeInterceptor(this.client.cookieJar()));
    ((List)localObject).add(new CacheInterceptor(this.client.internalCache()));
    ((List)localObject).add(new ConnectInterceptor(this.client));
    if (!this.forWebSocket) {
      ((List)localObject).addAll(this.client.networkInterceptors());
    }
    ((List)localObject).add(new CallServerInterceptor(this.forWebSocket));
    localObject = new RealInterceptorChain((List)localObject, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    if (this.retryAndFollowUpInterceptor.isCanceled())
    {
      Util.closeQuietly((Closeable)localObject);
      throw new IOException("Canceled");
    }
    return localObject;
  }
  
  public boolean isCanceled()
  {
    return this.retryAndFollowUpInterceptor.isCanceled();
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  String redactedUrl()
  {
    return this.originalRequest.url().redact();
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  StreamAllocation streamAllocation()
  {
    return this.retryAndFollowUpInterceptor.streamAllocation();
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  @Nullable
  IOException timeoutExit(@Nullable IOException paramIOException)
  {
    if (!this.timeout.exit()) {
      return paramIOException;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  String toLoggableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.forWebSocket) {
        break label65;
      }
    }
    label65:
    for (String str = "web socket";; str = "call")
    {
      return str + " to " + redactedUrl();
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.RealCall
 * JD-Core Version:    0.7.0.1
 */