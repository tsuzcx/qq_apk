package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;

@Deprecated
public abstract class CookieSpecBase
  extends AbstractCookieSpec
{
  public CookieSpecBase()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static String getDefaultDomain(CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static String getDefaultPath(CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected List<Cookie> parse(HeaderElement[] paramArrayOfHeaderElement, CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.cookie.CookieSpecBase
 * JD-Core Version:    0.7.0.1
 */