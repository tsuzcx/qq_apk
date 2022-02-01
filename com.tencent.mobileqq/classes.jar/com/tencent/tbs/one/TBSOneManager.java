package com.tencent.tbs.one;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.impl.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class TBSOneManager
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  private static TBSOneManager c;
  private static Map<String, TBSOneManager> d;
  
  /* Error */
  public static TBSOneManager getDefaultInstance(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/tencent/tbs/one/TBSOneManager:a	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: getstatic 26	com/tencent/tbs/one/TBSOneManager:c	Lcom/tencent/tbs/one/TBSOneManager;
    //   12: ifnonnull +16 -> 28
    //   15: new 28	com/tencent/tbs/one/impl/c
    //   18: dup
    //   19: aload_0
    //   20: ldc 30
    //   22: invokespecial 33	com/tencent/tbs/one/impl/c:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   25: putstatic 26	com/tencent/tbs/one/TBSOneManager:c	Lcom/tencent/tbs/one/TBSOneManager;
    //   28: getstatic 26	com/tencent/tbs/one/TBSOneManager:c	Lcom/tencent/tbs/one/TBSOneManager;
    //   31: astore_0
    //   32: aload_1
    //   33: monitorexit
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   9	28	39	finally
    //   28	34	39	finally
    //   40	42	39	finally
    //   3	9	44	finally
    //   42	44	44	finally
  }
  
  public static TBSOneManager getInstance(Context paramContext, String paramString)
  {
    if (paramString.equals("default")) {
      return getDefaultInstance(paramContext);
    }
    synchronized (b)
    {
      if (d == null) {
        d = new HashMap();
      }
      TBSOneManager localTBSOneManager = (TBSOneManager)d.get(paramString);
      Object localObject1 = localTBSOneManager;
      if (localTBSOneManager == null)
      {
        localObject1 = new c(paramContext, paramString);
        d.put(paramString, localObject1);
      }
      return localObject1;
    }
  }
  
  public abstract void configure(String paramString, Object paramObject);
  
  public abstract String getBuildNumber();
  
  public abstract TBSOneDebugger getDebugger();
  
  public abstract int[] getInstalledVersionCodesOfComponent(String paramString);
  
  public abstract TBSOneComponent getLoadedComponent(String paramString);
  
  public abstract TBSOneOnlineService getOnlineService();
  
  public abstract int getVersionCode();
  
  public abstract String getVersionName();
  
  public abstract void installComponent(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback);
  
  public abstract void installComponent(String paramString, TBSOneCallback<File> paramTBSOneCallback);
  
  public abstract boolean isComponentInstalled(String paramString);
  
  public abstract void loadComponentAsync(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback);
  
  public abstract void loadComponentAsync(String paramString, TBSOneCallback<TBSOneComponent> paramTBSOneCallback);
  
  public abstract TBSOneComponent loadComponentSync(String paramString, long paramLong);
  
  public abstract TBSOneComponent loadComponentSync(String paramString, Bundle paramBundle, long paramLong);
  
  public abstract void setAutoUpdateEnabled(boolean paramBoolean);
  
  public abstract void setDelegate(TBSOneDelegate paramTBSOneDelegate);
  
  public abstract void setPolicy(TBSOneManager.Policy paramPolicy);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneManager
 * JD-Core Version:    0.7.0.1
 */