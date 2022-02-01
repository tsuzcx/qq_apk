package com.tencent.xweb.xwalk;

import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.XWalkCookieManager;

public class e
  implements CookieInternal.ICookieManagerInternal
{
  XWalkCookieManager a = new XWalkCookieManager();
  
  public void a()
  {
    this.a.removeAllCookie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e
 * JD-Core Version:    0.7.0.1
 */