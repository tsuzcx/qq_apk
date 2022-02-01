package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
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
    if (paramCacheRequest == null) {}
    do
    {
      return paramResponse;
      localObject = paramCacheRequest.body();
    } while (localObject == null);
    paramCacheRequest = new CacheInterceptor.1(this, paramResponse.body().source(), paramCacheRequest, Okio.buffer((Sink)localObject));
    Object localObject = paramResponse.header("Content-Type");
    long l = paramResponse.body().contentLength();
    return paramResponse.newBuilder().body(new RealResponseBody((String)localObject, l, Okio.buffer(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
  {
    int j = 0;
    Headers.Builder localBuilder = new Headers.Builder();
    int k = paramHeaders1.size();
    int i = 0;
    if (i < k)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((isContentSpecificHeader(str1)) || (!isEndToEnd(str1)) || (paramHeaders2.get(str1) == null)) {
          Internal.instance.addLenient(localBuilder, str1, str2);
        }
      }
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
  
  public Response intercept(Interceptor.Chain paramChain)
  {
    Response localResponse1;
    Request localRequest;
    Response localResponse2;
    if (this.cache != null)
    {
      localResponse1 = this.cache.get(paramChain.request());
      CacheStrategy localCacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), paramChain.request(), localResponse1).get();
      localRequest = localCacheStrategy.networkRequest;
      localResponse2 = localCacheStrategy.cacheResponse;
      if (this.cache != null) {
        this.cache.trackResponse(localCacheStrategy);
      }
      if ((localResponse1 != null) && (localResponse2 == null)) {
        Util.closeQuietly(localResponse1.body());
      }
      if ((localRequest != null) || (localResponse2 != null)) {
        break label163;
      }
      paramChain = new Response.Builder().request(paramChain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
    }
    label163:
    label331:
    do
    {
      do
      {
        return paramChain;
        localResponse1 = null;
        break;
        if (localRequest == null) {
          return localResponse2.newBuilder().cacheResponse(stripBody(localResponse2)).build();
        }
        try
        {
          paramChain = paramChain.proceed(localRequest);
          if ((paramChain == null) && (localResponse1 != null)) {
            Util.closeQuietly(localResponse1.body());
          }
          if (localResponse2 == null) {
            break label331;
          }
          if (paramChain.code() == 304)
          {
            localResponse1 = localResponse2.newBuilder().headers(combine(localResponse2.headers(), paramChain.headers())).sentRequestAtMillis(paramChain.sentRequestAtMillis()).receivedResponseAtMillis(paramChain.receivedResponseAtMillis()).cacheResponse(stripBody(localResponse2)).networkResponse(stripBody(paramChain)).build();
            paramChain.body().close();
            this.cache.trackConditionalCacheHit();
            this.cache.update(localResponse2, localResponse1);
            return localResponse1;
          }
        }
        finally
        {
          if ((0 == 0) && (localResponse1 != null)) {
            Util.closeQuietly(localResponse1.body());
          }
        }
        Util.closeQuietly(localResponse2.body());
        localResponse1 = paramChain.newBuilder().cacheResponse(stripBody(localResponse2)).networkResponse(stripBody(paramChain)).build();
        paramChain = localResponse1;
      } while (this.cache == null);
      if ((HttpHeaders.hasBody(localResponse1)) && (CacheStrategy.isCacheable(localResponse1, localRequest))) {
        return cacheWritingResponse(this.cache.put(localResponse1), localResponse1);
      }
      paramChain = localResponse1;
    } while (!HttpMethod.invalidatesCache(localRequest.method()));
    try
    {
      this.cache.remove(localRequest);
      return localResponse1;
    }
    catch (IOException paramChain) {}
    return localResponse1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.cache.CacheInterceptor
 * JD-Core Version:    0.7.0.1
 */