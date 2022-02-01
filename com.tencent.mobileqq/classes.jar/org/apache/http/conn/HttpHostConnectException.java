package org.apache.http.conn;

import java.net.ConnectException;
import org.apache.http.HttpHost;

@Deprecated
public class HttpHostConnectException
  extends ConnectException
{
  public HttpHostConnectException(HttpHost paramHttpHost, ConnectException paramConnectException)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpHost getHost()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.HttpHostConnectException
 * JD-Core Version:    0.7.0.1
 */