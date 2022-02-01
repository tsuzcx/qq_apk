package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import java.net.URL;

public class f
  extends Request.Builder
{
  private Request.Builder a;
  
  public f(Request.Builder paramBuilder)
  {
    this.a = paramBuilder;
  }
  
  public Request.Builder addHeader(String paramString1, String paramString2)
  {
    return this.a.addHeader(paramString1, paramString2);
  }
  
  public Request build()
  {
    return this.a.build();
  }
  
  public Request.Builder cacheControl(CacheControl paramCacheControl)
  {
    return this.a.cacheControl(paramCacheControl);
  }
  
  public Request.Builder delete()
  {
    return this.a.delete();
  }
  
  public Request.Builder get()
  {
    return this.a.get();
  }
  
  public Request.Builder head()
  {
    return this.a.head();
  }
  
  public Request.Builder header(String paramString1, String paramString2)
  {
    return this.a.header(paramString1, paramString2);
  }
  
  public Request.Builder headers(Headers paramHeaders)
  {
    return this.a.headers(paramHeaders);
  }
  
  public Request.Builder method(String paramString, RequestBody paramRequestBody)
  {
    return this.a.method(paramString, paramRequestBody);
  }
  
  public Request.Builder patch(RequestBody paramRequestBody)
  {
    return this.a.patch(paramRequestBody);
  }
  
  public Request.Builder post(RequestBody paramRequestBody)
  {
    return this.a.post(paramRequestBody);
  }
  
  public Request.Builder put(RequestBody paramRequestBody)
  {
    return this.a.put(paramRequestBody);
  }
  
  public Request.Builder removeHeader(String paramString)
  {
    return this.a.removeHeader(paramString);
  }
  
  public Request.Builder tag(Object paramObject)
  {
    return this.a.tag(paramObject);
  }
  
  public Request.Builder url(String paramString)
  {
    return this.a.url(paramString);
  }
  
  public Request.Builder url(URL paramURL)
  {
    return this.a.url(paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.f
 * JD-Core Version:    0.7.0.1
 */