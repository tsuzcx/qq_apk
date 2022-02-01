package org.apache.http.message;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;

@Deprecated
public class BasicHttpResponse
  extends AbstractHttpMessage
  implements HttpResponse
{
  public BasicHttpResponse(ProtocolVersion paramProtocolVersion, int paramInt, String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpResponse(StatusLine paramStatusLine)
  {
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpResponse(StatusLine paramStatusLine, ReasonPhraseCatalog paramReasonPhraseCatalog, Locale paramLocale)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpEntity getEntity()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Locale getLocale()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected String getReason(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public StatusLine getStatusLine()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setEntity(HttpEntity paramHttpEntity)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLocale(Locale paramLocale)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setReasonPhrase(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setStatusCode(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setStatusLine(StatusLine paramStatusLine)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.message.BasicHttpResponse
 * JD-Core Version:    0.7.0.1
 */