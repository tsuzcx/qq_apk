package org.apache.http;

import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract interface HttpResponseInterceptor
{
  public abstract void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HttpResponseInterceptor
 * JD-Core Version:    0.7.0.1
 */