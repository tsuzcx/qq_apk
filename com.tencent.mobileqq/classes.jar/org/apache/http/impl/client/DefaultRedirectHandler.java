package org.apache.http.impl.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultRedirectHandler
  implements RedirectHandler
{
  public DefaultRedirectHandler()
  {
    throw new RuntimeException("Stub!");
  }
  
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.client.DefaultRedirectHandler
 * JD-Core Version:    0.7.0.1
 */