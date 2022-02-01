package okhttp3;

import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.InternalCache;

class Cache$1
  implements InternalCache
{
  Cache$1(Cache paramCache) {}
  
  public Response get(Request paramRequest)
  {
    return this.this$0.get(paramRequest);
  }
  
  public CacheRequest put(Response paramResponse)
  {
    return this.this$0.put(paramResponse);
  }
  
  public void remove(Request paramRequest)
  {
    this.this$0.remove(paramRequest);
  }
  
  public void trackConditionalCacheHit()
  {
    this.this$0.trackConditionalCacheHit();
  }
  
  public void trackResponse(CacheStrategy paramCacheStrategy)
  {
    this.this$0.trackResponse(paramCacheStrategy);
  }
  
  public void update(Response paramResponse1, Response paramResponse2)
  {
    this.this$0.update(paramResponse1, paramResponse2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Cache.1
 * JD-Core Version:    0.7.0.1
 */