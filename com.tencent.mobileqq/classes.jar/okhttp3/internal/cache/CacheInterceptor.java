package okhttp3.internal.cache;

import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;

public final class CacheInterceptor
  implements Interceptor
{
  final InternalCache cache;
  
  public CacheInterceptor(InternalCache paramInternalCache)
  {
    this.cache = paramInternalCache;
  }
  
  private Response cacheWritingResponse(CacheRequest paramCacheRequest, Response paramResponse)
  {
    if (paramCacheRequest == null) {
      return paramResponse;
    }
    Object localObject = paramCacheRequest.body();
    if (localObject == null) {
      return paramResponse;
    }
    paramCacheRequest = new CacheInterceptor.1(this, paramResponse.body().source(), paramCacheRequest, Okio.buffer((Sink)localObject));
    localObject = paramResponse.header("Content-Type");
    long l = paramResponse.body().contentLength();
    return paramResponse.newBuilder().body(new RealResponseBody((String)localObject, l, Okio.buffer(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int k = paramHeaders1.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((isContentSpecificHeader(str1)) || (!isEndToEnd(str1)) || (paramHeaders2.get(str1) == null))) {
        Internal.instance.addLenient(localBuilder, str1, str2);
      }
      i += 1;
    }
    k = paramHeaders2.size();
    i = j;
    while (i < k)
    {
      paramHeaders1 = paramHeaders2.name(i);
      if ((!isContentSpecificHeader(paramHeaders1)) && (isEndToEnd(paramHeaders1))) {
        Internal.instance.addLenient(localBuilder, paramHeaders1, paramHeaders2.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  static boolean isContentSpecificHeader(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }
  
  static boolean isEndToEnd(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  /* Error */
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +19 -> 25
    //   9: aload_2
    //   10: aload_1
    //   11: invokeinterface 162 1 0
    //   16: invokeinterface 167 2 0
    //   21: astore_2
    //   22: goto +5 -> 27
    //   25: aconst_null
    //   26: astore_2
    //   27: new 169	okhttp3/internal/cache/CacheStrategy$Factory
    //   30: dup
    //   31: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   34: aload_1
    //   35: invokeinterface 162 1 0
    //   40: aload_2
    //   41: invokespecial 177	okhttp3/internal/cache/CacheStrategy$Factory:<init>	(JLokhttp3/Request;Lokhttp3/Response;)V
    //   44: invokevirtual 180	okhttp3/internal/cache/CacheStrategy$Factory:get	()Lokhttp3/internal/cache/CacheStrategy;
    //   47: astore 5
    //   49: aload 5
    //   51: getfield 186	okhttp3/internal/cache/CacheStrategy:networkRequest	Lokhttp3/Request;
    //   54: astore_3
    //   55: aload 5
    //   57: getfield 190	okhttp3/internal/cache/CacheStrategy:cacheResponse	Lokhttp3/Response;
    //   60: astore 4
    //   62: aload_0
    //   63: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   66: astore 6
    //   68: aload 6
    //   70: ifnull +12 -> 82
    //   73: aload 6
    //   75: aload 5
    //   77: invokeinterface 194 2 0
    //   82: aload_2
    //   83: ifnull +15 -> 98
    //   86: aload 4
    //   88: ifnonnull +10 -> 98
    //   91: aload_2
    //   92: invokevirtual 31	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   95: invokestatic 200	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   98: aload_3
    //   99: ifnonnull +63 -> 162
    //   102: aload 4
    //   104: ifnonnull +58 -> 162
    //   107: new 70	okhttp3/Response$Builder
    //   110: dup
    //   111: invokespecial 201	okhttp3/Response$Builder:<init>	()V
    //   114: aload_1
    //   115: invokeinterface 162 1 0
    //   120: invokevirtual 204	okhttp3/Response$Builder:request	(Lokhttp3/Request;)Lokhttp3/Response$Builder;
    //   123: getstatic 210	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   126: invokevirtual 214	okhttp3/Response$Builder:protocol	(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;
    //   129: sipush 504
    //   132: invokevirtual 218	okhttp3/Response$Builder:code	(I)Lokhttp3/Response$Builder;
    //   135: ldc 220
    //   137: invokevirtual 224	okhttp3/Response$Builder:message	(Ljava/lang/String;)Lokhttp3/Response$Builder;
    //   140: getstatic 228	okhttp3/internal/Util:EMPTY_RESPONSE	Lokhttp3/ResponseBody;
    //   143: invokevirtual 73	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   146: ldc2_w 229
    //   149: invokevirtual 234	okhttp3/Response$Builder:sentRequestAtMillis	(J)Lokhttp3/Response$Builder;
    //   152: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   155: invokevirtual 237	okhttp3/Response$Builder:receivedResponseAtMillis	(J)Lokhttp3/Response$Builder;
    //   158: invokevirtual 77	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   161: areturn
    //   162: aload_3
    //   163: ifnonnull +20 -> 183
    //   166: aload 4
    //   168: invokevirtual 60	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   171: aload 4
    //   173: invokestatic 239	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   176: invokevirtual 242	okhttp3/Response$Builder:cacheResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   179: invokevirtual 77	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   182: areturn
    //   183: aload_1
    //   184: aload_3
    //   185: invokeinterface 245 2 0
    //   190: astore_1
    //   191: aload_1
    //   192: ifnonnull +14 -> 206
    //   195: aload_2
    //   196: ifnull +10 -> 206
    //   199: aload_2
    //   200: invokevirtual 31	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   203: invokestatic 200	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   206: aload 4
    //   208: ifnull +104 -> 312
    //   211: aload_1
    //   212: invokevirtual 247	okhttp3/Response:code	()I
    //   215: sipush 304
    //   218: if_icmpne +86 -> 304
    //   221: aload 4
    //   223: invokevirtual 60	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   226: aload 4
    //   228: invokevirtual 250	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   231: aload_1
    //   232: invokevirtual 250	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   235: invokestatic 252	okhttp3/internal/cache/CacheInterceptor:combine	(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;
    //   238: invokevirtual 255	okhttp3/Response$Builder:headers	(Lokhttp3/Headers;)Lokhttp3/Response$Builder;
    //   241: aload_1
    //   242: invokevirtual 257	okhttp3/Response:sentRequestAtMillis	()J
    //   245: invokevirtual 234	okhttp3/Response$Builder:sentRequestAtMillis	(J)Lokhttp3/Response$Builder;
    //   248: aload_1
    //   249: invokevirtual 259	okhttp3/Response:receivedResponseAtMillis	()J
    //   252: invokevirtual 237	okhttp3/Response$Builder:receivedResponseAtMillis	(J)Lokhttp3/Response$Builder;
    //   255: aload 4
    //   257: invokestatic 239	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   260: invokevirtual 242	okhttp3/Response$Builder:cacheResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   263: aload_1
    //   264: invokestatic 239	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   267: invokevirtual 262	okhttp3/Response$Builder:networkResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   270: invokevirtual 77	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   273: astore_2
    //   274: aload_1
    //   275: invokevirtual 31	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   278: invokevirtual 265	okhttp3/ResponseBody:close	()V
    //   281: aload_0
    //   282: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   285: invokeinterface 268 1 0
    //   290: aload_0
    //   291: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   294: aload 4
    //   296: aload_2
    //   297: invokeinterface 272 3 0
    //   302: aload_2
    //   303: areturn
    //   304: aload 4
    //   306: invokevirtual 31	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   309: invokestatic 200	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   312: aload_1
    //   313: invokevirtual 60	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   316: aload 4
    //   318: invokestatic 239	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   321: invokevirtual 242	okhttp3/Response$Builder:cacheResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   324: aload_1
    //   325: invokestatic 239	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   328: invokevirtual 262	okhttp3/Response$Builder:networkResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   331: invokevirtual 77	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   334: astore_1
    //   335: aload_0
    //   336: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   339: ifnull +54 -> 393
    //   342: aload_1
    //   343: invokestatic 278	okhttp3/internal/http/HttpHeaders:hasBody	(Lokhttp3/Response;)Z
    //   346: ifeq +27 -> 373
    //   349: aload_1
    //   350: aload_3
    //   351: invokestatic 282	okhttp3/internal/cache/CacheStrategy:isCacheable	(Lokhttp3/Response;Lokhttp3/Request;)Z
    //   354: ifeq +19 -> 373
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   362: aload_1
    //   363: invokeinterface 286 2 0
    //   368: aload_1
    //   369: invokespecial 288	okhttp3/internal/cache/CacheInterceptor:cacheWritingResponse	(Lokhttp3/internal/cache/CacheRequest;Lokhttp3/Response;)Lokhttp3/Response;
    //   372: areturn
    //   373: aload_3
    //   374: invokevirtual 294	okhttp3/Request:method	()Ljava/lang/String;
    //   377: invokestatic 299	okhttp3/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   380: ifeq +13 -> 393
    //   383: aload_0
    //   384: getfield 15	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   387: aload_3
    //   388: invokeinterface 303 2 0
    //   393: aload_1
    //   394: areturn
    //   395: astore_1
    //   396: aload_2
    //   397: ifnull +10 -> 407
    //   400: aload_2
    //   401: invokevirtual 31	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   404: invokestatic 200	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   407: aload_1
    //   408: athrow
    //   409: astore_2
    //   410: aload_1
    //   411: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	CacheInterceptor
    //   0	412	1	paramChain	okhttp3.Interceptor.Chain
    //   4	397	2	localObject	Object
    //   409	1	2	localIOException	java.io.IOException
    //   54	334	3	localRequest	okhttp3.Request
    //   60	257	4	localResponse	Response
    //   47	29	5	localCacheStrategy	CacheStrategy
    //   66	8	6	localInternalCache	InternalCache
    // Exception table:
    //   from	to	target	type
    //   183	191	395	finally
    //   383	393	409	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.cache.CacheInterceptor
 * JD-Core Version:    0.7.0.1
 */