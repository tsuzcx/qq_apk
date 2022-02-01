package okhttp3;

import java.util.concurrent.TimeUnit;

public final class CacheControl$Builder
{
  boolean immutable;
  int maxAgeSeconds = -1;
  int maxStaleSeconds = -1;
  int minFreshSeconds = -1;
  boolean noCache;
  boolean noStore;
  boolean noTransform;
  boolean onlyIfCached;
  
  public CacheControl build()
  {
    return new CacheControl(this);
  }
  
  public Builder immutable()
  {
    this.immutable = true;
    return this;
  }
  
  public Builder maxAge(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxAge < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = 2147483647;; paramInt = (int)l)
    {
      this.maxAgeSeconds = paramInt;
      return this;
    }
  }
  
  public Builder maxStale(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxStale < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = 2147483647;; paramInt = (int)l)
    {
      this.maxStaleSeconds = paramInt;
      return this;
    }
  }
  
  public Builder minFresh(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("minFresh < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = 2147483647;; paramInt = (int)l)
    {
      this.minFreshSeconds = paramInt;
      return this;
    }
  }
  
  public Builder noCache()
  {
    this.noCache = true;
    return this;
  }
  
  public Builder noStore()
  {
    this.noStore = true;
    return this;
  }
  
  public Builder noTransform()
  {
    this.noTransform = true;
    return this;
  }
  
  public Builder onlyIfCached()
  {
    this.onlyIfCached = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.CacheControl.Builder
 * JD-Core Version:    0.7.0.1
 */