package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnRouteParams
  implements ConnRoutePNames
{
  public static final HttpHost NO_HOST;
  public static final HttpRoute NO_ROUTE;
  
  ConnRouteParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static HttpHost getDefaultProxy(HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static HttpRoute getForcedRoute(HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static InetAddress getLocalAddress(HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void setDefaultProxy(HttpParams paramHttpParams, HttpHost paramHttpHost)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void setForcedRoute(HttpParams paramHttpParams, HttpRoute paramHttpRoute)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void setLocalAddress(HttpParams paramHttpParams, InetAddress paramInetAddress)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.params.ConnRouteParams
 * JD-Core Version:    0.7.0.1
 */