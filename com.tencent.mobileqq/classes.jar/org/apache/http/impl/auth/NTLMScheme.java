package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.Credentials;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class NTLMScheme
  extends AuthSchemeBase
{
  public NTLMScheme(NTLMEngine paramNTLMEngine)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getParameter(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getRealm()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getSchemeName()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isComplete()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isConnectionBased()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.auth.NTLMScheme
 * JD-Core Version:    0.7.0.1
 */