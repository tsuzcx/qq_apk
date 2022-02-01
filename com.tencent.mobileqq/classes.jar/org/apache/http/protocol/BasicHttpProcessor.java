package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public final class BasicHttpProcessor
  implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList
{
  protected List requestInterceptors;
  protected List responseInterceptors;
  
  public BasicHttpProcessor()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void addInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void addInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void addInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void addInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearInterceptors()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearRequestInterceptors()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearResponseInterceptors()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object clone()
  {
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpProcessor copy()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void copyInterceptors(BasicHttpProcessor paramBasicHttpProcessor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpRequestInterceptor getRequestInterceptor(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getRequestInterceptorCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpResponseInterceptor getResponseInterceptor(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getResponseInterceptorCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeRequestInterceptorByClass(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeResponseInterceptorByClass(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setInterceptors(List paramList)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.protocol.BasicHttpProcessor
 * JD-Core Version:    0.7.0.1
 */