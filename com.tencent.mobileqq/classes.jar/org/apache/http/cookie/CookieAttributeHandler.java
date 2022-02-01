package org.apache.http.cookie;

@Deprecated
public abstract interface CookieAttributeHandler
{
  public abstract boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  public abstract void parse(SetCookie paramSetCookie, String paramString);
  
  public abstract void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.cookie.CookieAttributeHandler
 * JD-Core Version:    0.7.0.1
 */