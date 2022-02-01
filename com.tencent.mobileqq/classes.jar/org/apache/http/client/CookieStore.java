package org.apache.http.client;

import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

@Deprecated
public abstract interface CookieStore
{
  public abstract void addCookie(Cookie paramCookie);
  
  public abstract void clear();
  
  public abstract boolean clearExpired(Date paramDate);
  
  public abstract List<Cookie> getCookies();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.CookieStore
 * JD-Core Version:    0.7.0.1
 */