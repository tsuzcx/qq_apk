package okhttp3;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public class Request$Builder
{
  @Nullable
  RequestBody body;
  Headers.Builder headers;
  String method;
  Map<Class<?>, Object> tags = Collections.emptyMap();
  @Nullable
  HttpUrl url;
  
  public Request$Builder()
  {
    this.method = "GET";
    this.headers = new Headers.Builder();
  }
  
  Request$Builder(Request paramRequest)
  {
    this.url = paramRequest.url;
    this.method = paramRequest.method;
    this.body = paramRequest.body;
    Object localObject;
    if (paramRequest.tags.isEmpty()) {
      localObject = Collections.emptyMap();
    } else {
      localObject = new LinkedHashMap(paramRequest.tags);
    }
    this.tags = ((Map)localObject);
    this.headers = paramRequest.headers.newBuilder();
  }
  
  public Builder addHeader(String paramString1, String paramString2)
  {
    this.headers.add(paramString1, paramString2);
    return this;
  }
  
  public Request build()
  {
    if (this.url != null) {
      return new Request(this);
    }
    throw new IllegalStateException("url == null");
  }
  
  public Builder cacheControl(CacheControl paramCacheControl)
  {
    paramCacheControl = paramCacheControl.toString();
    if (paramCacheControl.isEmpty()) {
      return removeHeader("Cache-Control");
    }
    return header("Cache-Control", paramCacheControl);
  }
  
  public Builder delete()
  {
    return delete(Util.EMPTY_REQUEST);
  }
  
  public Builder delete(@Nullable RequestBody paramRequestBody)
  {
    return method("DELETE", paramRequestBody);
  }
  
  public Builder get()
  {
    return method("GET", null);
  }
  
  public Builder head()
  {
    return method("HEAD", null);
  }
  
  public Builder header(String paramString1, String paramString2)
  {
    this.headers.set(paramString1, paramString2);
    return this;
  }
  
  public Builder headers(Headers paramHeaders)
  {
    this.headers = paramHeaders.newBuilder();
    return this;
  }
  
  public Builder method(String paramString, @Nullable RequestBody paramRequestBody)
  {
    if (paramString != null)
    {
      if (paramString.length() != 0)
      {
        if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString)))
        {
          paramRequestBody = new StringBuilder();
          paramRequestBody.append("method ");
          paramRequestBody.append(paramString);
          paramRequestBody.append(" must not have a request body.");
          throw new IllegalArgumentException(paramRequestBody.toString());
        }
        if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString)))
        {
          paramRequestBody = new StringBuilder();
          paramRequestBody.append("method ");
          paramRequestBody.append(paramString);
          paramRequestBody.append(" must have a request body.");
          throw new IllegalArgumentException(paramRequestBody.toString());
        }
        this.method = paramString;
        this.body = paramRequestBody;
        return this;
      }
      throw new IllegalArgumentException("method.length() == 0");
    }
    throw new NullPointerException("method == null");
  }
  
  public Builder patch(RequestBody paramRequestBody)
  {
    return method("PATCH", paramRequestBody);
  }
  
  public Builder post(RequestBody paramRequestBody)
  {
    return method("POST", paramRequestBody);
  }
  
  public Builder put(RequestBody paramRequestBody)
  {
    return method("PUT", paramRequestBody);
  }
  
  public Builder removeHeader(String paramString)
  {
    this.headers.removeAll(paramString);
    return this;
  }
  
  public <T> Builder tag(Class<? super T> paramClass, @Nullable T paramT)
  {
    if (paramClass != null)
    {
      if (paramT == null)
      {
        this.tags.remove(paramClass);
        return this;
      }
      if (this.tags.isEmpty()) {
        this.tags = new LinkedHashMap();
      }
      this.tags.put(paramClass, paramClass.cast(paramT));
      return this;
    }
    throw new NullPointerException("type == null");
  }
  
  public Builder tag(@Nullable Object paramObject)
  {
    return tag(Object.class, paramObject);
  }
  
  public Builder url(String paramString)
  {
    if (paramString != null)
    {
      Object localObject;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("http:");
        ((StringBuilder)localObject).append(paramString.substring(3));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https:");
          ((StringBuilder)localObject).append(paramString.substring(4));
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      return url(HttpUrl.get((String)localObject));
    }
    throw new NullPointerException("url == null");
  }
  
  public Builder url(URL paramURL)
  {
    if (paramURL != null) {
      return url(HttpUrl.get(paramURL.toString()));
    }
    throw new NullPointerException("url == null");
  }
  
  public Builder url(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl != null)
    {
      this.url = paramHttpUrl;
      return this;
    }
    throw new NullPointerException("url == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Request.Builder
 * JD-Core Version:    0.7.0.1
 */