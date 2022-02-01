package okhttp3.internal.cache;

import okio.Sink;

public abstract interface CacheRequest
{
  public abstract void abort();
  
  public abstract Sink body();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.cache.CacheRequest
 * JD-Core Version:    0.7.0.1
 */