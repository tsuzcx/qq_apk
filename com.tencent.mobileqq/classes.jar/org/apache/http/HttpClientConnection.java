package org.apache.http;

@Deprecated
public abstract interface HttpClientConnection
  extends HttpConnection
{
  public abstract void flush();
  
  public abstract boolean isResponseAvailable(int paramInt);
  
  public abstract void receiveResponseEntity(HttpResponse paramHttpResponse);
  
  public abstract HttpResponse receiveResponseHeader();
  
  public abstract void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest);
  
  public abstract void sendRequestHeader(HttpRequest paramHttpRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HttpClientConnection
 * JD-Core Version:    0.7.0.1
 */