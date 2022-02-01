package org.apache.http;

@Deprecated
public abstract interface HttpServerConnection
  extends HttpConnection
{
  public abstract void flush();
  
  public abstract void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest);
  
  public abstract HttpRequest receiveRequestHeader();
  
  public abstract void sendResponseEntity(HttpResponse paramHttpResponse);
  
  public abstract void sendResponseHeader(HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HttpServerConnection
 * JD-Core Version:    0.7.0.1
 */