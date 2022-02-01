package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor
  implements Interceptor
{
  private static final int MAX_FOLLOW_UPS = 20;
  private Object callStackTrace;
  private volatile boolean canceled;
  private final OkHttpClient client;
  private final boolean forWebSocket;
  private volatile StreamAllocation streamAllocation;
  
  public RetryAndFollowUpInterceptor(OkHttpClient paramOkHttpClient, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.forWebSocket = paramBoolean;
  }
  
  private Address createAddress(HttpUrl paramHttpUrl)
  {
    Object localObject2;
    Object localObject1;
    CertificatePinner localCertificatePinner;
    Object localObject3;
    if (paramHttpUrl.isHttps())
    {
      localObject2 = this.client.sslSocketFactory();
      localObject1 = this.client.hostnameVerifier();
      localCertificatePinner = this.client.certificatePinner();
      localObject3 = localCertificatePinner;
    }
    else
    {
      localCertificatePinner = null;
      localObject1 = localCertificatePinner;
      localObject3 = localObject1;
      localObject2 = localCertificatePinner;
    }
    return new Address(paramHttpUrl.host(), paramHttpUrl.port(), this.client.dns(), this.client.socketFactory(), (SSLSocketFactory)localObject2, (HostnameVerifier)localObject1, (CertificatePinner)localObject3, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
  }
  
  private Request followUpRequest(Response paramResponse, Route paramRoute)
  {
    if (paramResponse != null)
    {
      int i = paramResponse.code();
      String str = paramResponse.request().method();
      Object localObject = null;
      if ((i != 307) && (i != 308)) {
        if (i != 401) {
          if (i != 503) {
            if (i != 407) {
              if (i == 408) {}
            }
          }
        }
      }
      switch (i)
      {
      default: 
        return null;
        if (!this.client.retryOnConnectionFailure()) {
          return null;
        }
        if ((paramResponse.request().body() instanceof UnrepeatableRequestBody)) {
          return null;
        }
        if ((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 408)) {
          return null;
        }
        if (retryAfter(paramResponse, 0) > 0) {
          return null;
        }
        return paramResponse.request();
        if (paramRoute.proxy().type() == Proxy.Type.HTTP) {
          return this.client.proxyAuthenticator().authenticate(paramRoute, paramResponse);
        }
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
        if ((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 503)) {
          return null;
        }
        if (retryAfter(paramResponse, 2147483647) == 0) {
          return paramResponse.request();
        }
        return null;
        return this.client.authenticator().authenticate(paramRoute, paramResponse);
        if ((!str.equals("GET")) && (!str.equals("HEAD"))) {
          return null;
        }
        break;
      }
      if (!this.client.followRedirects()) {
        return null;
      }
      paramRoute = paramResponse.header("Location");
      if (paramRoute == null) {
        return null;
      }
      HttpUrl localHttpUrl = paramResponse.request().url().resolve(paramRoute);
      if (localHttpUrl == null) {
        return null;
      }
      if ((!localHttpUrl.scheme().equals(paramResponse.request().url().scheme())) && (!this.client.followSslRedirects())) {
        return null;
      }
      Request.Builder localBuilder = paramResponse.request().newBuilder();
      if (HttpMethod.permitsRequestBody(str))
      {
        boolean bool = HttpMethod.redirectsWithBody(str);
        if (HttpMethod.redirectsToGet(str))
        {
          localBuilder.method("GET", null);
        }
        else
        {
          paramRoute = localObject;
          if (bool) {
            paramRoute = paramResponse.request().body();
          }
          localBuilder.method(str, paramRoute);
        }
        if (!bool)
        {
          localBuilder.removeHeader("Transfer-Encoding");
          localBuilder.removeHeader("Content-Length");
          localBuilder.removeHeader("Content-Type");
        }
      }
      if (!sameConnection(paramResponse, localHttpUrl)) {
        localBuilder.removeHeader("Authorization");
      }
      return localBuilder.url(localHttpUrl).build();
    }
    throw new IllegalStateException();
  }
  
  private boolean isRecoverable(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool1 = paramIOException instanceof ProtocolException;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException))
    {
      bool1 = bool2;
      if ((paramIOException instanceof SocketTimeoutException))
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    return !(paramIOException instanceof SSLPeerUnverifiedException);
  }
  
  private boolean recover(IOException paramIOException, StreamAllocation paramStreamAllocation, boolean paramBoolean, Request paramRequest)
  {
    paramStreamAllocation.streamFailed(paramIOException);
    if (!this.client.retryOnConnectionFailure()) {
      return false;
    }
    if ((paramBoolean) && (requestIsUnrepeatable(paramIOException, paramRequest))) {
      return false;
    }
    if (!isRecoverable(paramIOException, paramBoolean)) {
      return false;
    }
    return paramStreamAllocation.hasMoreRoutes();
  }
  
  private boolean requestIsUnrepeatable(IOException paramIOException, Request paramRequest)
  {
    return ((paramRequest.body() instanceof UnrepeatableRequestBody)) || ((paramIOException instanceof FileNotFoundException));
  }
  
  private int retryAfter(Response paramResponse, int paramInt)
  {
    paramResponse = paramResponse.header("Retry-After");
    if (paramResponse == null) {
      return paramInt;
    }
    if (paramResponse.matches("\\d+")) {
      return Integer.valueOf(paramResponse).intValue();
    }
    return 2147483647;
  }
  
  private boolean sameConnection(Response paramResponse, HttpUrl paramHttpUrl)
  {
    paramResponse = paramResponse.request().url();
    return (paramResponse.host().equals(paramHttpUrl.host())) && (paramResponse.port() == paramHttpUrl.port()) && (paramResponse.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void cancel()
  {
    this.canceled = true;
    StreamAllocation localStreamAllocation = this.streamAllocation;
    if (localStreamAllocation != null) {
      localStreamAllocation.cancel();
    }
  }
  
  /* Error */
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 301 1 0
    //   6: astore 6
    //   8: aload_1
    //   9: checkcast 303	okhttp3/internal/http/RealInterceptorChain
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 307	okhttp3/internal/http/RealInterceptorChain:call	()Lokhttp3/Call;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 311	okhttp3/internal/http/RealInterceptorChain:eventListener	()Lokhttp3/EventListener;
    //   26: astore 9
    //   28: new 256	okhttp3/internal/connection/StreamAllocation
    //   31: dup
    //   32: aload_0
    //   33: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   36: invokevirtual 315	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   39: aload_0
    //   40: aload 6
    //   42: invokevirtual 178	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   45: invokespecial 317	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 319	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   56: invokespecial 322	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   59: astore 4
    //   61: aload_0
    //   62: aload 4
    //   64: putfield 292	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   67: aconst_null
    //   68: astore 5
    //   70: iconst_0
    //   71: istore_2
    //   72: aload 6
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 290	okhttp3/internal/http/RetryAndFollowUpInterceptor:canceled	Z
    //   79: ifne +368 -> 447
    //   82: aload 7
    //   84: aload_1
    //   85: aload 4
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 326	okhttp3/internal/http/RealInterceptorChain:proceed	(Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpCodec;Lokhttp3/internal/connection/RealConnection;)Lokhttp3/Response;
    //   92: astore 6
    //   94: aload 6
    //   96: astore_1
    //   97: aload 5
    //   99: ifnull +27 -> 126
    //   102: aload 6
    //   104: invokevirtual 329	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   107: aload 5
    //   109: invokevirtual 329	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   112: aconst_null
    //   113: invokevirtual 334	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   116: invokevirtual 336	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   119: invokevirtual 339	okhttp3/Response$Builder:priorResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   122: invokevirtual 336	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   125: astore_1
    //   126: aload_0
    //   127: aload_1
    //   128: aload 4
    //   130: invokevirtual 343	okhttp3/internal/connection/StreamAllocation:route	()Lokhttp3/Route;
    //   133: invokespecial 345	okhttp3/internal/http/RetryAndFollowUpInterceptor:followUpRequest	(Lokhttp3/Response;Lokhttp3/Route;)Lokhttp3/Request;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnonnull +10 -> 150
    //   143: aload 4
    //   145: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   148: aload_1
    //   149: areturn
    //   150: aload_1
    //   151: invokevirtual 351	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   154: invokestatic 357	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   157: iload_2
    //   158: iconst_1
    //   159: iadd
    //   160: istore_2
    //   161: iload_2
    //   162: bipush 20
    //   164: if_icmpgt +158 -> 322
    //   167: aload 6
    //   169: invokevirtual 113	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   172: instanceof 115
    //   175: ifne +127 -> 302
    //   178: aload_0
    //   179: aload_1
    //   180: aload 6
    //   182: invokevirtual 178	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   185: invokespecial 223	okhttp3/internal/http/RetryAndFollowUpInterceptor:sameConnection	(Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
    //   188: ifne +50 -> 238
    //   191: aload 4
    //   193: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   196: new 256	okhttp3/internal/connection/StreamAllocation
    //   199: dup
    //   200: aload_0
    //   201: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   204: invokevirtual 315	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   207: aload_0
    //   208: aload 6
    //   210: invokevirtual 178	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   213: invokespecial 317	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   216: aload 8
    //   218: aload 9
    //   220: aload_0
    //   221: getfield 319	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   224: invokespecial 322	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   227: astore 4
    //   229: aload_0
    //   230: aload 4
    //   232: putfield 292	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   235: goto +11 -> 246
    //   238: aload 4
    //   240: invokevirtual 361	okhttp3/internal/connection/StreamAllocation:codec	()Lokhttp3/internal/http/HttpCodec;
    //   243: ifnonnull +12 -> 255
    //   246: aload_1
    //   247: astore 5
    //   249: aload 6
    //   251: astore_1
    //   252: goto -177 -> 75
    //   255: new 363	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   262: astore 4
    //   264: aload 4
    //   266: ldc_w 366
    //   269: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 4
    //   275: aload_1
    //   276: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 4
    //   282: ldc_w 375
    //   285: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: new 233	java/lang/IllegalStateException
    //   292: dup
    //   293: aload 4
    //   295: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokespecial 379	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   301: athrow
    //   302: aload 4
    //   304: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   307: new 381	java/net/HttpRetryException
    //   310: dup
    //   311: ldc_w 383
    //   314: aload_1
    //   315: invokevirtual 97	okhttp3/Response:code	()I
    //   318: invokespecial 386	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   321: athrow
    //   322: aload 4
    //   324: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   327: new 363	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   334: astore_1
    //   335: aload_1
    //   336: ldc_w 388
    //   339: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_1
    //   344: iload_2
    //   345: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: new 146	java/net/ProtocolException
    //   352: dup
    //   353: aload_1
    //   354: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokespecial 151	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   360: athrow
    //   361: astore_1
    //   362: aload 4
    //   364: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   367: aload_1
    //   368: athrow
    //   369: astore_1
    //   370: goto +64 -> 434
    //   373: astore 6
    //   375: aload 6
    //   377: instanceof 393
    //   380: ifne +91 -> 471
    //   383: iconst_1
    //   384: istore_3
    //   385: goto +3 -> 388
    //   388: aload_0
    //   389: aload 6
    //   391: aload 4
    //   393: iload_3
    //   394: aload_1
    //   395: invokespecial 395	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   398: ifeq +6 -> 404
    //   401: goto -326 -> 75
    //   404: aload 6
    //   406: athrow
    //   407: astore 6
    //   409: aload_0
    //   410: aload 6
    //   412: invokevirtual 399	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   415: aload 4
    //   417: iconst_0
    //   418: aload_1
    //   419: invokespecial 395	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   422: ifeq +6 -> 428
    //   425: goto -350 -> 75
    //   428: aload 6
    //   430: invokevirtual 402	okhttp3/internal/connection/RouteException:getFirstConnectException	()Ljava/io/IOException;
    //   433: athrow
    //   434: aload 4
    //   436: aconst_null
    //   437: invokevirtual 260	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   440: aload 4
    //   442: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   445: aload_1
    //   446: athrow
    //   447: aload 4
    //   449: invokevirtual 348	okhttp3/internal/connection/StreamAllocation:release	()V
    //   452: new 244	java/io/IOException
    //   455: dup
    //   456: ldc_w 404
    //   459: invokespecial 405	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   462: astore_1
    //   463: goto +5 -> 468
    //   466: aload_1
    //   467: athrow
    //   468: goto -2 -> 466
    //   471: iconst_0
    //   472: istore_3
    //   473: goto -85 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	RetryAndFollowUpInterceptor
    //   0	476	1	paramChain	okhttp3.Interceptor.Chain
    //   71	274	2	i	int
    //   384	89	3	bool	boolean
    //   59	389	4	localObject1	Object
    //   68	180	5	localChain	okhttp3.Interceptor.Chain
    //   6	244	6	localObject2	Object
    //   373	32	6	localIOException	IOException
    //   407	22	6	localRouteException	okhttp3.internal.connection.RouteException
    //   12	71	7	localRealInterceptorChain	RealInterceptorChain
    //   19	198	8	localCall	okhttp3.Call
    //   26	193	9	localEventListener	okhttp3.EventListener
    // Exception table:
    //   from	to	target	type
    //   126	138	361	java/io/IOException
    //   82	94	369	finally
    //   375	383	369	finally
    //   388	401	369	finally
    //   404	407	369	finally
    //   409	425	369	finally
    //   428	434	369	finally
    //   82	94	373	java/io/IOException
    //   82	94	407	okhttp3/internal/connection/RouteException
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public void setCallStackTrace(Object paramObject)
  {
    this.callStackTrace = paramObject;
  }
  
  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http.RetryAndFollowUpInterceptor
 * JD-Core Version:    0.7.0.1
 */