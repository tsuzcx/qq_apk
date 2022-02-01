package okhttp3;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Request
{
  @Nullable
  final RequestBody body;
  @Nullable
  private volatile CacheControl cacheControl;
  final Headers headers;
  final String method;
  final Map<Class<?>, Object> tags;
  final HttpUrl url;
  
  Request(Request.Builder paramBuilder)
  {
    this.url = paramBuilder.url;
    this.method = paramBuilder.method;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.tags = Util.immutableMap(paramBuilder.tags);
  }
  
  @Nullable
  public RequestBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = this.cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  @Nullable
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public boolean isHttps()
  {
    return this.url.isHttps();
  }
  
  public String method()
  {
    return this.method;
  }
  
  public Request.Builder newBuilder()
  {
    return new Request.Builder(this);
  }
  
  @Nullable
  public Object tag()
  {
    return tag(Object.class);
  }
  
  @Nullable
  public <T> T tag(Class<? extends T> paramClass)
  {
    return paramClass.cast(this.tags.get(paramClass));
  }
  
  public String toString()
  {
    return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.Request
 * JD-Core Version:    0.7.0.1
 */