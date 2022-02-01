package org.apache.http.impl;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractHttpServerConnection
  implements HttpServerConnection
{
  public AbstractHttpServerConnection()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract void assertOpen();
  
  protected EntityDeserializer createEntityDeserializer()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected EntitySerializer createEntitySerializer()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HttpRequestFactory createHttpRequestFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HttpMessageParser createRequestParser(SessionInputBuffer paramSessionInputBuffer, HttpRequestFactory paramHttpRequestFactory, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HttpMessageWriter createResponseWriter(SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void doFlush()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void flush()
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void init(SessionInputBuffer paramSessionInputBuffer, SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStale()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpRequest receiveRequestHeader()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendResponseEntity(HttpResponse paramHttpResponse)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendResponseHeader(HttpResponse paramHttpResponse)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.AbstractHttpServerConnection
 * JD-Core Version:    0.7.0.1
 */