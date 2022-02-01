package org.apache.http.impl.client;

import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;

@Deprecated
public class ClientParamsStack
  extends AbstractHttpParams
{
  protected final HttpParams applicationParams;
  protected final HttpParams clientParams;
  protected final HttpParams overrideParams;
  protected final HttpParams requestParams;
  
  public ClientParamsStack(ClientParamsStack paramClientParamsStack)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ClientParamsStack(ClientParamsStack paramClientParamsStack, HttpParams paramHttpParams1, HttpParams paramHttpParams2, HttpParams paramHttpParams3, HttpParams paramHttpParams4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ClientParamsStack(HttpParams paramHttpParams1, HttpParams paramHttpParams2, HttpParams paramHttpParams3, HttpParams paramHttpParams4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpParams copy()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpParams getApplicationParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpParams getClientParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpParams getOverrideParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object getParameter(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpParams getRequestParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean removeParameter(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpParams setParameter(String paramString, Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.client.ClientParamsStack
 * JD-Core Version:    0.7.0.1
 */