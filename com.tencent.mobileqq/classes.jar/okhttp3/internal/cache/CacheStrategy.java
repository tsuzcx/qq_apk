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
    int i = paramResponse.code();
    boolean bool2 = false;
    if ((i != 200) && (i != 410) && (i != 414) && (i != 501) && (i != 203) && (i != 204)) {
      if (i != 307)
      {
        if ((i == 308) || (i == 404) || (i == 405)) {}
      }
      else {
        switch (i)
        {
        default: 
          return false;
        case 302: 
          if ((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) {
            return false;
          }
          break;
        }
      }
    }
    boolean bool1 = bool2;
    if (!paramResponse.cacheControl().noStore())
    {
      bool1 = bool2;
      if (!paramRequest.cacheControl().noStore()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.cache.CacheStrategy
 * JD-Core Version:    0.7.0.1
 */