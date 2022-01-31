package com.tencent.tvkbeacon.core.b;

import java.io.IOException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

final class e$a$1
  implements HttpRequestRetryHandler
{
  e$a$1(e.a parama) {}
  
  public final boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    if (paramInt >= 3) {}
    do
    {
      return false;
      if ((paramIOException instanceof NoHttpResponseException)) {
        return true;
      }
    } while (!(paramIOException instanceof ClientProtocolException));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.e.a.1
 * JD-Core Version:    0.7.0.1
 */