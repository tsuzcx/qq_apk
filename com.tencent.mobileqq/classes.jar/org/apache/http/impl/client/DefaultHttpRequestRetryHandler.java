package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultHttpRequestRetryHandler
  implements HttpRequestRetryHandler
{
  public DefaultHttpRequestRetryHandler()
  {
    throw new RuntimeException("Stub!");
  }
  
  public DefaultHttpRequestRetryHandler(int paramInt, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getRetryCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRequestSentRetryEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.client.DefaultHttpRequestRetryHandler
 * JD-Core Version:    0.7.0.1
 */