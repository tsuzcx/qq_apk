package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract interface HttpRequestRetryHandler
{
  public abstract boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.HttpRequestRetryHandler
 * JD-Core Version:    0.7.0.1
 */