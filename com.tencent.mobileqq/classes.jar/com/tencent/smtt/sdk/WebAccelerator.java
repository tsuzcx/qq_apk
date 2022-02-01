package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.util.Map;

public class WebAccelerator
{
  public static final int INIT_TYPE_TBS = 1;
  public static final int INIT_TYPE_X5CORE = 2;
  
  public static void createCacheWebView(Context paramContext, boolean paramBoolean)
  {
    v localv = v.a();
    if (paramBoolean) {
      localv.a(paramContext, null);
    }
    if (localv.b()) {
      localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createCacheWebView", new Class[] { Context.class }, new Object[] { paramContext });
    }
  }
  
  public static boolean initTbsEnvironment(Context paramContext, int paramInt)
  {
    boolean bool = false;
    if (paramContext != null)
    {
      if (paramInt != 1) {
        break label31;
      }
      d.a(true).a(paramContext, false, false, null);
    }
    for (;;)
    {
      bool = v.a().b();
      return bool;
      label31:
      if (paramInt == 2) {
        v.a().a(paramContext, null);
      }
    }
  }
  
  public static void preConnect(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    v localv = v.a();
    if (paramBoolean) {
      localv.a(paramContext, null);
    }
    if (localv.b()) {
      localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "preConnect", new Class[] { Context.class, String.class, Integer.TYPE }, new Object[] { paramContext, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public static void prefetchResource(Context paramContext, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    v localv = v.a();
    if (paramBoolean) {
      localv.a(paramContext, null);
    }
    if (localv.b()) {
      localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "prefetchResource", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString, paramMap });
    }
  }
  
  public static void setWebViewPoolSize(Context paramContext, int paramInt, boolean paramBoolean)
  {
    v localv = v.a();
    if (paramBoolean) {
      localv.a(paramContext, null);
    }
    if (localv.b()) {
      localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setWebViewPoolSize", new Class[] { Context.class, Integer.TYPE }, new Object[] { paramContext, Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebAccelerator
 * JD-Core Version:    0.7.0.1
 */