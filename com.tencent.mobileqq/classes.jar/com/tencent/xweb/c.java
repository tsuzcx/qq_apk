package com.tencent.xweb;

import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public class c
{
  private static c b;
  CookieInternal.ICookieManagerInternal a;
  
  public static c a()
  {
    try
    {
      if (b == null) {
        b = new c();
      }
      c localc = b;
      return localc;
    }
    finally {}
  }
  
  void a(CookieInternal.ICookieManagerInternal paramICookieManagerInternal)
  {
    this.a = paramICookieManagerInternal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.c
 * JD-Core Version:    0.7.0.1
 */