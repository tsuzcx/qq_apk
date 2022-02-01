package com.tencent.xweb.sys;

import android.webkit.CookieSyncManager;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import java.util.concurrent.Callable;
import org.xwalk.core.XWalkEnvironment;

class SysWebFactory$2
  implements Callable<CookieInternal.ICookieSyncManagerInternal>
{
  SysWebFactory$2(SysWebFactory paramSysWebFactory) {}
  
  public CookieInternal.ICookieSyncManagerInternal a()
  {
    CookieSyncManager.createInstance(XWalkEnvironment.getApplicationContext());
    return new b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory.2
 * JD-Core Version:    0.7.0.1
 */