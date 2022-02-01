package org.apache.http.client.params;

import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
public class ClientParamBean
  extends HttpAbstractParamBean
{
  public ClientParamBean(HttpParams paramHttpParams)
  {
    super((HttpParams)null);
    throw new RuntimeException("Stub!");
  }
  
  public void setAllowCircularRedirects(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setConnectionManagerFactory(ClientConnectionManagerFactory paramClientConnectionManagerFactory)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setConnectionManagerFactoryClassName(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCookiePolicy(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDefaultHeaders(Collection<Header> paramCollection)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDefaultHost(HttpHost paramHttpHost)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHandleAuthentication(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHandleRedirects(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMaxRedirects(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setRejectRelativeRedirect(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setVirtualHost(HttpHost paramHttpHost)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.params.ClientParamBean
 * JD-Core Version:    0.7.0.1
 */