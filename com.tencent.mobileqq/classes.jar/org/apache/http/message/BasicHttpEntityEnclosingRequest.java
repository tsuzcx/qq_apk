package org.apache.http.message;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

@Deprecated
public class BasicHttpEntityEnclosingRequest
  extends BasicHttpRequest
  implements HttpEntityEnclosingRequest
{
  public BasicHttpEntityEnclosingRequest(String paramString1, String paramString2)
  {
    super((RequestLine)null);
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpEntityEnclosingRequest(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion)
  {
    super((RequestLine)null);
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpEntityEnclosingRequest(RequestLine paramRequestLine)
  {
    super((RequestLine)null);
    throw new RuntimeException("Stub!");
  }
  
  public boolean expectContinue()
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpEntity getEntity()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setEntity(HttpEntity paramHttpEntity)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.message.BasicHttpEntityEnclosingRequest
 * JD-Core Version:    0.7.0.1
 */