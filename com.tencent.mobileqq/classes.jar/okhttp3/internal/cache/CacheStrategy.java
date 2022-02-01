package okhttp3.internal.cache;

import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;

public final class CacheStrategy
{
  @Nullable
  public final Response cacheResponse;
  @Nullable
  public final Request networkRequest;
  
  CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    switch (paramResponse.code())
    {
    }
    do
    {
      return false;
    } while (((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) || (paramResponse.cacheControl().noStore()) || (paramRequest.cacheControl().noStore()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.cache.CacheStrategy
 * JD-Core Version:    0.7.0.1
 */