package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

@Deprecated
public abstract class AbstractCookieSpec
  implements CookieSpec
{
  public AbstractCookieSpec()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected CookieAttributeHandler findAttribHandler(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected CookieAttributeHandler getAttribHandler(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected Collection<CookieAttributeHandler> getAttribHandlers()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void registerAttribHandler(String paramString, CookieAttributeHandler paramCookieAttributeHandler)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.cookie.AbstractCookieSpec
 * JD-Core Version:    0.7.0.1
 */