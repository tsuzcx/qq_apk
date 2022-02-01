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
    if (paramInt >= 0)
    {
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {
        paramInt = 2147483647;
      } else {
        paramInt = (int)l;
      }
      this.maxAgeSeconds = paramInt;
      return this;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("maxAge < 0: ");
    paramTimeUnit.append(paramInt);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public Builder maxStale(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt >= 0)
    {
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {
        paramInt = 2147483647;
      } else {
        paramInt = (int)l;
      }
      this.maxStaleSeconds = paramInt;
      return this;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("maxStale < 0: ");
    paramTimeUnit.append(paramInt);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public Builder minFresh(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt >= 0)
    {
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {
        paramInt = 2147483647;
      } else {
        paramInt = (int)l;
      }
      this.minFreshSeconds = paramInt;
      return this;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("minFresh < 0: ");
    paramTimeUnit.append(paramInt);
    throw new IllegalArgumentException(paramTimeUnit.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.CacheControl.Builder
 * JD-Core Version:    0.7.0.1
 */