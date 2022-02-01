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
      if (!this.executed)
      {
        this.executed = true;
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new RealCall.AsyncCall(this, paramCallback));
        return;
      }
      throw new IllegalStateException("Already Executed");
    }
    finally {}
  }
  
  /* Error */
  public Response execute()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 113	okhttp3/RealCall:executed	Z
    //   6: ifne +107 -> 113
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 113	okhttp3/RealCall:executed	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: invokespecial 115	okhttp3/RealCall:captureCallStackTrace	()V
    //   20: aload_0
    //   21: getfield 45	okhttp3/RealCall:timeout	Lokio/AsyncTimeout;
    //   24: invokevirtual 149	okio/AsyncTimeout:enter	()V
    //   27: aload_0
    //   28: getfield 67	okhttp3/RealCall:eventListener	Lokhttp3/EventListener;
    //   31: aload_0
    //   32: invokevirtual 121	okhttp3/EventListener:callStart	(Lokhttp3/Call;)V
    //   35: aload_0
    //   36: getfield 27	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   39: invokevirtual 125	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   42: aload_0
    //   43: invokevirtual 151	okhttp3/Dispatcher:executed	(Lokhttp3/RealCall;)V
    //   46: aload_0
    //   47: invokevirtual 154	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +16 -> 68
    //   55: aload_0
    //   56: getfield 27	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   59: invokevirtual 125	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   62: aload_0
    //   63: invokevirtual 157	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall;)V
    //   66: aload_1
    //   67: areturn
    //   68: new 146	java/io/IOException
    //   71: dup
    //   72: ldc 159
    //   74: invokespecial 160	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: astore_1
    //   79: goto +21 -> 100
    //   82: astore_1
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 164	okhttp3/RealCall:timeoutExit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 67	okhttp3/RealCall:eventListener	Lokhttp3/EventListener;
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 168	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   98: aload_1
    //   99: athrow
    //   100: aload_0
    //   101: getfield 27	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   104: invokevirtual 125	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   107: aload_0
    //   108: invokevirtual 157	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall;)V
    //   111: aload_1
    //   112: athrow
    //   113: new 137	java/lang/IllegalStateException
    //   116: dup
    //   117: ldc 139
    //   119: invokespecial 142	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	RealCall
    //   50	17	1	localResponse	Response
    //   78	1	1	localObject1	Object
    //   82	3	1	localIOException1	IOException
    //   88	24	1	localIOException2	IOException
    //   123	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	51	78	finally
    //   68	78	78	finally
    //   83	100	78	finally
    //   35	51	82	java/io/IOException
    //   68	78	82	java/io/IOException
    //   2	16	123	finally
    //   113	123	123	finally
    //   124	126	123	finally
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
    if (!this.retryAndFollowUpInterceptor.isCanceled()) {
      return localObject;
    }
    Util.closeQuietly((Closeable)localObject);
    throw new IOException("Canceled");
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
    String str;
    if (isCanceled()) {
      str = "canceled ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    if (this.forWebSocket) {
      str = "web socket";
    } else {
      str = "call";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" to ");
    localStringBuilder.append(redactedUrl());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.RealCall
 * JD-Core Version:    0.7.0.1
 */