package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultHttpResponseFactory
  implements HttpResponseFactory
{
  protected final ReasonPhraseCatalog reasonCatalog;
  
  public DefaultHttpResponseFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  public DefaultHttpResponseFactory(ReasonPhraseCatalog paramReasonPhraseCatalog)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected Locale determineLocale(HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpResponse newHttpResponse(ProtocolVersion paramProtocolVersion, int paramInt, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpResponse newHttpResponse(StatusLine paramStatusLine, HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.DefaultHttpResponseFactory
 * JD-Core Version:    0.7.0.1
 */