package org.apache.http.client;

import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract interface AuthenticationHandler
{
  public abstract Map<String, Header> getChallenges(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract boolean isAuthenticationRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  public abstract AuthScheme selectScheme(Map<String, Header> paramMap, HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.AuthenticationHandler
 * JD-Core Version:    0.7.0.1
 */