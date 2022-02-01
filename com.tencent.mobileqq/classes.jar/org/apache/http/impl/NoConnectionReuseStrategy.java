package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class NoConnectionReuseStrategy
  implements ConnectionReuseStrategy
{
  public NoConnectionReuseStrategy()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.NoConnectionReuseStrategy
 * JD-Core Version:    0.7.0.1
 */