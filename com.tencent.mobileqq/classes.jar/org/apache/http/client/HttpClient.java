package org.apache.http.client;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract interface HttpClient
{
  public abstract <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler);
  
  public abstract <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext);
  
  public abstract <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler);
  
  public abstract <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext);
  
  public abstract HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest);
  
  public abstract HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext);
  
  public abstract HttpResponse execute(HttpUriRequest paramHttpUriRequest);
  
  public abstract HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext);
  
  public abstract ClientConnectionManager getConnectionManager();
  
  public abstract HttpParams getParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.HttpClient
 * JD-Core Version:    0.7.0.1
 */