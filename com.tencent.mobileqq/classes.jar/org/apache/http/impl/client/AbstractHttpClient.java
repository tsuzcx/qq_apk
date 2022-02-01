package org.apache.http.impl.client;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

@Deprecated
public abstract class AbstractHttpClient
  implements HttpClient
{
  protected AbstractHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void clearRequestInterceptors()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void clearResponseInterceptors()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  protected abstract AuthSchemeRegistry createAuthSchemeRegistry();
  
  protected abstract ClientConnectionManager createClientConnectionManager();
  
  protected RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();
  
  protected abstract ConnectionReuseStrategy createConnectionReuseStrategy();
  
  protected abstract CookieSpecRegistry createCookieSpecRegistry();
  
  protected abstract CookieStore createCookieStore();
  
  protected abstract CredentialsProvider createCredentialsProvider();
  
  protected abstract HttpContext createHttpContext();
  
  protected abstract HttpParams createHttpParams();
  
  protected abstract BasicHttpProcessor createHttpProcessor();
  
  protected abstract HttpRequestRetryHandler createHttpRequestRetryHandler();
  
  protected abstract HttpRoutePlanner createHttpRoutePlanner();
  
  protected abstract AuthenticationHandler createProxyAuthenticationHandler();
  
  protected abstract RedirectHandler createRedirectHandler();
  
  protected abstract HttpRequestExecutor createRequestExecutor();
  
  protected abstract AuthenticationHandler createTargetAuthenticationHandler();
  
  protected abstract UserTokenHandler createUserTokenHandler();
  
  protected HttpParams determineParams(HttpRequest paramHttpRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    throw new RuntimeException("Stub!");
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    throw new RuntimeException("Stub!");
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final AuthSchemeRegistry getAuthSchemes()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final ClientConnectionManager getConnectionManager()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final ConnectionReuseStrategy getConnectionReuseStrategy()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final CookieSpecRegistry getCookieSpecs()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final CookieStore getCookieStore()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final CredentialsProvider getCredentialsProvider()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  protected final BasicHttpProcessor getHttpProcessor()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final HttpRequestRetryHandler getHttpRequestRetryHandler()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final HttpParams getParams()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final AuthenticationHandler getProxyAuthenticationHandler()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final RedirectHandler getRedirectHandler()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final HttpRequestExecutor getRequestExecutor()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public HttpRequestInterceptor getRequestInterceptor(int paramInt)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public int getRequestInterceptorCount()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public HttpResponseInterceptor getResponseInterceptor(int paramInt)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public int getResponseInterceptorCount()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final HttpRoutePlanner getRoutePlanner()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final AuthenticationHandler getTargetAuthenticationHandler()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public final UserTokenHandler getUserTokenHandler()
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAuthSchemes(AuthSchemeRegistry paramAuthSchemeRegistry)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setCookieSpecs(CookieSpecRegistry paramCookieSpecRegistry)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setCookieStore(CookieStore paramCookieStore)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setCredentialsProvider(CredentialsProvider paramCredentialsProvider)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setHttpRequestRetryHandler(HttpRequestRetryHandler paramHttpRequestRetryHandler)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setKeepAliveStrategy(ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setParams(HttpParams paramHttpParams)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setProxyAuthenticationHandler(AuthenticationHandler paramAuthenticationHandler)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setRedirectHandler(RedirectHandler paramRedirectHandler)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setReuseStrategy(ConnectionReuseStrategy paramConnectionReuseStrategy)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setRoutePlanner(HttpRoutePlanner paramHttpRoutePlanner)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setTargetAuthenticationHandler(AuthenticationHandler paramAuthenticationHandler)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
  
  public void setUserTokenHandler(UserTokenHandler paramUserTokenHandler)
  {
    try
    {
      throw new RuntimeException("Stub!");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.client.AbstractHttpClient
 * JD-Core Version:    0.7.0.1
 */