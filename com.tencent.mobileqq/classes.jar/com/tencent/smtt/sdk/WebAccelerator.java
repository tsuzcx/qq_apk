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
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext, null);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createCacheWebView", new Class[] { Context.class }, new Object[] { paramContext });
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
      SDKEngine.getInstance(true).init(paramContext, false, false, null);
    }
    for (;;)
    {
      bool = X5CoreEngine.getInstance().isX5Core();
      return bool;
      label31:
      if (paramInt == 2) {
        X5CoreEngine.getInstance().init(paramContext, null);
      }
    }
  }
  
  public static void preConnect(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext, null);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "preConnect", new Class[] { Context.class, String.class, Integer.TYPE }, new Object[] { paramContext, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public static void prefetchResource(Context paramContext, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext, null);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "prefetchResource", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString, paramMap });
    }
  }
  
  public static void setWebViewPoolSize(Context paramContext, int paramInt, boolean paramBoolean)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if (paramBoolean) {
      localX5CoreEngine.init(paramContext, null);
    }
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setWebViewPoolSize", new Class[] { Context.class, Integer.TYPE }, new Object[] { paramContext, Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebAccelerator
 * JD-Core Version:    0.7.0.1
 */