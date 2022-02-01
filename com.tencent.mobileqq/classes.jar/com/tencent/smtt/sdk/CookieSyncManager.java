package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Field;

@Deprecated
public class CookieSyncManager
{
  private static android.webkit.CookieSyncManager a;
  private static CookieSyncManager b;
  private static boolean c = false;
  
  private CookieSyncManager(Context paramContext)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      c = true;
    }
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      a = android.webkit.CookieSyncManager.createInstance(paramContext);
      if ((b == null) || (!c)) {
        b = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      if (b == null) {
        throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
      }
    }
    finally {}
    CookieSyncManager localCookieSyncManager = b;
    return localCookieSyncManager;
  }
  
  public void startSync()
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      ((x)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
      return;
    }
    a.startSync();
    try
    {
      localObject = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      ((Field)localObject).setAccessible(true);
      ((Thread)((Field)localObject).get(a)).setUncaughtExceptionHandler(new g());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopSync()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
      return;
    }
    a.stopSync();
  }
  
  public void sync()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
      return;
    }
    a.sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieSyncManager
 * JD-Core Version:    0.7.0.1
 */