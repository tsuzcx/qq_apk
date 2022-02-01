package com.tencent.xweb.sys;

import android.webkit.CookieManager;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import java.util.concurrent.Callable;

class SysWebFactory$1
  implements Callable<CookieInternal.ICookieManagerInternal>
{
  SysWebFactory$1(SysWebFactory paramSysWebFactory) {}
  
  public CookieInternal.ICookieManagerInternal a()
  {
    CookieManager.getInstance();
    return new a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory.1
 * JD-Core Version:    0.7.0.1
 */