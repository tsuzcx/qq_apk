package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

@Deprecated
public abstract interface HttpRequestHandler
{
  public abstract void handle(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.protocol.HttpRequestHandler
 * JD-Core Version:    0.7.0.1
 */