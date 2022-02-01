package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.qqlive.mediaplayer.sdkupdate.a;
import com.tencent.qqlive.mediaplayer.sdkupdate.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TVK_SDKMgr
{
  public static final boolean DOWNLOAD_PLUGIN_FOR_OTHER_APP = false;
  public static final int ERROR_FACTORY_NULL = 105;
  public static final int ERROR_INVALID_FILE = 103;
  public static final int ERROR_IO = 104;
  public static final int ERROR_NETWORK = 101;
  public static final int ERROR_OTHERS = 100;
  public static final int ERROR_SERVER_RESPONSE = 102;
  public static String SDK_Ver = "V4.3.000.0138";
  private static ClassLoader a = null;
  private static boolean b = false;
  private static Context c = null;
  private static boolean d = false;
  private static boolean e = false;
  private static TVK_SDKMgr.InstallListener f = null;
  private static String g = "";
  private static String h = "";
  private static boolean i = false;
  private static String j = null;
  private static boolean k = false;
  private static boolean l = false;
  private static TVK_SDKMgr.OnLogListener m = null;
  private static TVK_SDKMgr.OnLogReportListener n = null;
  private static String o = "";
  private static String p = "";
  private static int q = 0;
  private static TVK_SDKMgr.InstallListener r = new TVK_SDKMgr.1();
  private static TVK_IProxyFactory s = null;
  
  /* Error */
  private static void b(float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:f	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   6: ifnonnull +34 -> 40
    //   9: iconst_3
    //   10: ldc 114
    //   12: ldc 116
    //   14: new 118	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   21: ldc 121
    //   23: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: fload_0
    //   27: invokevirtual 128	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   30: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: getstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:f	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   43: fload_0
    //   44: invokeinterface 142 2 0
    //   49: goto -13 -> 36
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramFloat	float
    //   52	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	36	52	finally
    //   40	49	52	finally
  }
  
  private static void b(int paramInt)
  {
    String str1 = "others";
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        if (f == null)
        {
          d.a(4, "TVK_SDKMgr.java", "MediaPlayerMgr", "notify install failed,but listener is null , error :" + str1);
          return;
          str1 = "ERROR_NETWORK";
          continue;
        }
        f.onInstalledFailed(paramInt);
        f = null;
        d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "notify install failed ,error :" + str1);
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", String.valueOf(paramInt));
        localHashMap.put("errorMsg", String.valueOf(str1));
        UserAction.onUserAction("actVideoSDKInstallPlugin", false, -1L, -1L, localHashMap, true);
        continue;
        continue;
      }
      finally {}
      String str2 = "ERROR_SERVER_RESPONSE";
      continue;
      str2 = "ERROR_INVALID_FILE";
      continue;
      str2 = "ERROR_IO";
      continue;
      str2 = "ERROR_FACTORY_NULL";
    }
  }
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 57	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   6: ifne +120 -> 126
    //   9: getstatic 59	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   12: invokestatic 193	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   15: invokevirtual 195	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	()Ljava/lang/String;
    //   18: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +18 -> 39
    //   24: getstatic 59	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   27: invokestatic 193	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   30: invokevirtual 203	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	()Ljava/lang/String;
    //   33: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +25 -> 61
    //   39: getstatic 89	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:q	I
    //   42: iconst_1
    //   43: if_icmpge +18 -> 61
    //   46: getstatic 89	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:q	I
    //   49: iconst_1
    //   50: iadd
    //   51: putstatic 89	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:q	I
    //   54: iconst_0
    //   55: istore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: iload_1
    //   60: ireturn
    //   61: aload_0
    //   62: invokestatic 208	com/tencent/qqlive/mediaplayer/dex/Dexloader:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/dex/Dexloader;
    //   65: getstatic 59	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   68: invokestatic 193	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   71: invokevirtual 203	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	()Ljava/lang/String;
    //   74: getstatic 59	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   77: invokestatic 193	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   80: invokevirtual 195	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	()Ljava/lang/String;
    //   83: invokevirtual 211	com/tencent/qqlive/mediaplayer/dex/Dexloader:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   86: putstatic 55	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:a	Ljava/lang/ClassLoader;
    //   89: getstatic 55	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:a	Ljava/lang/ClassLoader;
    //   92: ifnull +41 -> 133
    //   95: iconst_1
    //   96: putstatic 57	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   99: iconst_3
    //   100: ldc 114
    //   102: ldc 116
    //   104: ldc 213
    //   106: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   109: ldc 215
    //   111: getstatic 57	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   114: ldc2_w 177
    //   117: ldc2_w 177
    //   120: aconst_null
    //   121: iconst_1
    //   122: invokestatic 184	com/tencent/beacon/event/UserAction:onUserAction	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   125: pop
    //   126: getstatic 57	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   129: istore_1
    //   130: goto -74 -> 56
    //   133: iconst_5
    //   134: ldc 114
    //   136: ldc 116
    //   138: ldc 217
    //   140: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -34 -> 109
    //   146: astore_0
    //   147: ldc 2
    //   149: monitorexit
    //   150: aload_0
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramContext	Context
    //   55	75	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	39	146	finally
    //   39	54	146	finally
    //   61	109	146	finally
    //   109	126	146	finally
    //   126	130	146	finally
    //   133	143	146	finally
  }
  
  public static int clearStorage(Context paramContext)
  {
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().cleanStorage(paramContext);
    }
    return -1;
  }
  
  /* Error */
  private static void d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:f	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   6: ifnonnull +17 -> 23
    //   9: iconst_3
    //   10: ldc 114
    //   12: ldc 116
    //   14: ldc 238
    //   16: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: getstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:f	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   26: invokeinterface 241 1 0
    //   31: aconst_null
    //   32: putstatic 65	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:f	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   35: iconst_3
    //   36: ldc 114
    //   38: ldc 116
    //   40: ldc 243
    //   42: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 176
    //   47: iconst_1
    //   48: ldc2_w 177
    //   51: ldc2_w 177
    //   54: aconst_null
    //   55: iconst_1
    //   56: invokestatic 184	com/tencent/beacon/event/UserAction:onUserAction	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   59: pop
    //   60: goto -41 -> 19
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   63	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	63	finally
    //   23	60	63	finally
  }
  
  public static void deInit()
  {
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().deInit();
    }
  }
  
  private static void e()
  {
    for (;;)
    {
      try
      {
        boolean bool = isPluginMode();
        if (bool)
        {
          try
          {
            if (a == null) {
              d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "createProxyFactory, dexClassloader == null! ");
            }
            Method localMethod = a.loadClass("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
            localMethod.setAccessible(true);
            s = (TVK_IProxyFactory)localMethod.invoke(null, new Object[0]);
            if (s == null) {
              d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "createProxyFactory, invoke get failed! ");
            }
          }
          catch (Throwable localThrowable1)
          {
            d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "createProxyFactory, exception failed!, error: " + localThrowable1.getMessage());
            continue;
          }
          d.a(1, "TVK_SDKMgr.java", "MediaPlayerMgr", "createProxyFactory mProxyFactory: " + s);
          return;
        }
      }
      finally {}
      Object localObject2 = s;
      if (localObject2 == null) {
        try
        {
          localObject2 = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
          ((Method)localObject2).setAccessible(true);
          s = (TVK_IProxyFactory)((Method)localObject2).invoke(null, new Object[0]);
        }
        catch (Throwable localThrowable2)
        {
          d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "createProxyFactory reflect factory failed: " + localThrowable2.toString());
        }
      }
    }
  }
  
  private static void f()
  {
    if (e) {}
    do
    {
      return;
      e = true;
      e();
      if ((s != null) && (s.getSdkMgrInstance() != null)) {
        break;
      }
      d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "initSDK failed, cannot get instance");
      e = false;
      s = null;
    } while ((!isPluginMode()) || (a.a(c) == null));
    a.a(c).a();
    return;
    if (isPluginMode())
    {
      String[] arrayOfString1 = s.getSdkMgrInstance().getSdkVersion().split("\\.");
      String[] arrayOfString2 = SDK_Ver.split("\\.");
      if ((arrayOfString2.length > 1) && (arrayOfString1.length > 1) && (arrayOfString2[0].equalsIgnoreCase(arrayOfString1[0])) && (arrayOfString2[1].equalsIgnoreCase(arrayOfString1[1]))) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label210;
        }
        e = false;
        s = null;
        d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "initSDK failed, match sdk version failed");
        if ((!isPluginMode()) || (a.a(c) == null)) {
          break;
        }
        a.a(c).a();
        return;
        b = false;
        a = null;
      }
    }
    label210:
    if (!TextUtils.isEmpty(o)) {
      s.getSdkMgrInstance().setGuid(o);
    }
    if (!TextUtils.isEmpty(p)) {
      s.getSdkMgrInstance().setUpc(p);
    }
    if (i) {
      s.getSdkMgrInstance().useFileConfigBeforeInitSDK(c);
    }
    if (j != null) {
      s.getSdkMgrInstance().setHostConfigBeforeInitSDK(j);
    }
    s.getSdkMgrInstance().setDebugEnable(k);
    if (m != null) {
      s.getSdkMgrInstance().setOnLogListener(m);
    }
    if (n != null) {
      s.getSdkMgrInstance().setOnLogReportListener(n);
    }
    s.getSdkMgrInstance().initSdk(c, g, h);
    if ((isPluginMode()) && (a.a(c) != null))
    {
      s.getSdkMgrInstance().setExtraMapInfo("assetPath", a.a(c).c());
      a.a(c).a();
    }
    d = true;
  }
  
  public static String getAdChid()
  {
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().getAdChid();
    }
    return "";
  }
  
  public static Context getAppContext()
  {
    return c;
  }
  
  public static int getHevcHwMaxResolution()
  {
    if ((d) && (e) && ((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().getHevcHwMaxResolution();
    }
    return -1;
  }
  
  public static int getHevcSwMaxResolution()
  {
    if ((d) && (e) && ((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().getHevcSwMaxResolution();
    }
    return -1;
  }
  
  public static String getHostConfig()
  {
    return j;
  }
  
  public static String getPlatform()
  {
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().getPlatform();
    }
    return "";
  }
  
  public static TVK_IProxyFactory getProxyFactory()
  {
    try
    {
      if (s == null) {
        e();
      }
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      return localTVK_IProxyFactory;
    }
    finally {}
  }
  
  public static String getSdkVersion()
  {
    if (((!isPluginMode()) || (b)) && (getProxyFactory() != null) && (getProxyFactory().getSdkMgrInstance() != null)) {
      return getProxyFactory().getSdkMgrInstance().getSdkVersion();
    }
    return SDK_Ver;
  }
  
  public static void initSdk(Context paramContext, String paramString1, String paramString2)
  {
    if (d) {
      return;
    }
    d = true;
    try
    {
      Class localClass = Class.forName("com.tencent.common.config.AppSetting");
      if (localClass != null)
      {
        Field localField = localClass.getField("useASan");
        if (localField != null) {
          l = localField.getBoolean(localClass);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "checkASanMode failure! " + localThrowable.getMessage());
      }
      if ((!a.a(c).b()) || (!b(c))) {
        break label190;
      }
      f();
      return;
      startUpdate(true);
    }
    d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "checkASanMode, mUseASan=" + l);
    c = paramContext.getApplicationContext();
    g = paramString1;
    h = paramString2;
    d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "initSdk... ver: " + SDK_Ver);
    if (!isPluginMode())
    {
      f();
      return;
    }
    label190:
  }
  
  public static void initSdkWithGuid(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    o = paramString3;
    initSdk(paramContext, paramString1, paramString2);
  }
  
  public static void installPlugin(Context paramContext, TVK_SDKMgr.InstallListener paramInstallListener)
  {
    if (paramContext == null) {
      return;
    }
    c = paramContext.getApplicationContext();
    f = paramInstallListener;
    if (f == null) {
      throw new IllegalArgumentException("Install listener can not be null");
    }
    if (getProxyFactory() != null)
    {
      d();
      return;
    }
    if (!isPluginMode())
    {
      if (getProxyFactory() == null)
      {
        b(105);
        return;
      }
      d();
      return;
    }
    if ((a.a(c).b()) && (b(c)))
    {
      f();
      b(1.0F);
      if (getProxyFactory() == null)
      {
        b(105);
        return;
      }
      d();
      return;
    }
    startUpdate(false);
  }
  
  public static boolean isASanEnable()
  {
    return l;
  }
  
  public static boolean isInstalled(Context paramContext)
  {
    if ((!d) || (!e)) {}
    while (getProxyFactory() == null) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean isPluginMode()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_1
    //   3: istore_0
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 98	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:s	Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   10: ifnull +19 -> 29
    //   13: iconst_3
    //   14: ldc 114
    //   16: ldc 116
    //   18: ldc_w 417
    //   21: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_0
    //   28: ireturn
    //   29: ldc 252
    //   31: invokestatic 291	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: ldc_w 260
    //   37: iconst_0
    //   38: anewarray 262	java/lang/Class
    //   41: invokevirtual 266	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   44: astore_2
    //   45: aload_2
    //   46: iconst_1
    //   47: invokevirtual 272	java/lang/reflect/Method:setAccessible	(Z)V
    //   50: aload_2
    //   51: aconst_null
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokevirtual 276	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 227	com/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory
    //   62: putstatic 98	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:s	Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   65: getstatic 98	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:s	Lcom/tencent/qqlive/mediaplayer/api/TVK_IProxyFactory;
    //   68: astore_2
    //   69: aload_2
    //   70: ifnonnull +42 -> 112
    //   73: iconst_1
    //   74: istore_0
    //   75: iconst_3
    //   76: ldc 114
    //   78: ldc 116
    //   80: new 118	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 419
    //   90: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_0
    //   94: invokevirtual 388	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   97: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 137	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   103: goto -79 -> 24
    //   106: astore_2
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    //   112: iconst_0
    //   113: istore_0
    //   114: goto -39 -> 75
    //   117: astore_2
    //   118: iload_1
    //   119: istore_0
    //   120: goto -45 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	117	0	bool1	boolean
    //   1	118	1	bool2	boolean
    //   44	26	2	localObject1	Object
    //   106	5	2	localObject2	Object
    //   117	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	24	106	finally
    //   29	69	106	finally
    //   75	103	106	finally
    //   29	69	117	java/lang/Throwable
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    k = paramBoolean;
    d.a(paramBoolean);
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setDebugEnable(paramBoolean);
    }
  }
  
  public static void setHostConfigBeforeInitSDK(String paramString)
  {
    j = paramString;
  }
  
  public static void setOnLogListener(TVK_SDKMgr.OnLogListener paramOnLogListener)
  {
    m = paramOnLogListener;
    d.a(paramOnLogListener);
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setOnLogListener(paramOnLogListener);
    }
  }
  
  public static void setOnLogReportListener(TVK_SDKMgr.OnLogReportListener paramOnLogReportListener)
  {
    n = paramOnLogReportListener;
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setOnLogReportListener(paramOnLogReportListener);
    }
  }
  
  public static void setPreloadMaxStorageSize(long paramLong)
  {
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setPreloadMaxStorageSize(c, paramLong);
    }
  }
  
  public static void setUpc(String paramString)
  {
    p = paramString;
    if (((!isPluginMode()) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setUpc(paramString);
    }
  }
  
  public static void startUpdate(boolean paramBoolean)
  {
    a.a(c).a(r);
    a.a(c).a(paramBoolean);
  }
  
  public static void useFileConfigBeforeInitSDK(Context paramContext)
  {
    i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr
 * JD-Core Version:    0.7.0.1
 */