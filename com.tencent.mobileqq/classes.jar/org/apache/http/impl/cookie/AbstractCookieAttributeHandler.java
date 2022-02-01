package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;

@Deprecated
public abstract class AbstractCookieAttributeHandler
  implements CookieAttributeHandler
{
  public AbstractCookieAttributeHandler()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.cookie.AbstractCookieAttributeHandler
 * JD-Core Version:    0.7.0.1
 */