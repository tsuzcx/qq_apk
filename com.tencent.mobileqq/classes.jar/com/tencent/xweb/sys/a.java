package com.tencent.xweb.sys;

import android.webkit.CookieManager;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public class a
  implements CookieInternal.ICookieManagerInternal
{
  CookieManager a = CookieManager.getInstance();
  
  public void a()
  {
    this.a.removeAllCookie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.a
 * JD-Core Version:    0.7.0.1
 */