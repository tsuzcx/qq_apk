package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.sdkupdate.a;
import com.tencent.qqlive.mediaplayer.sdkupdate.d;
import java.lang.reflect.Method;
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
  public static String SDK_Ver = "V4.3.000.0021";
  private static ClassLoader a = null;
  private static boolean b = false;
  private static Context c = null;
  private static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  private static InstallListener g = null;
  private static String h = "";
  private static String i = "";
  private static boolean j = false;
  private static String k = null;
  private static boolean l = false;
  private static OnLogListener m = null;
  private static OnLogReportListener n = null;
  private static String o = "";
  private static String p = "";
  private static int q = 0;
  private static InstallListener r = new InstallListener()
  {
    public void onInstallProgress(float paramAnonymousFloat)
    {
      TVK_SDKMgr.a(paramAnonymousFloat);
    }
    
    public void onInstalledFailed(int paramAnonymousInt)
    {
      TVK_SDKMgr.a(paramAnonymousInt);
    }
    
    public void onInstalledSuccessed()
    {
      if (TVK_SDKMgr.a(TVK_SDKMgr.a()))
      {
        TVK_SDKMgr.b();
        if (TVK_SDKMgr.getProxyFactory() == null)
        {
          d.a(5, "", "MediaPlayerMgr", "loadDexFile succeed, but factory is null");
          TVK_SDKMgr.a(105);
          return;
        }
        d.a(3, "", "MediaPlayerMgr", "onInstalledSuccessed... ");
        TVK_SDKMgr.c();
        return;
      }
      d.a(5, "", "MediaPlayerMgr", "loadDexFile failed");
      TVK_SDKMgr.a(100);
    }
  };
  private static TVK_IProxyFactory s = null;
  
  /* Error */
  private static void b(float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 78	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:g	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   6: ifnonnull +34 -> 40
    //   9: iconst_3
    //   10: ldc 123
    //   12: ldc 125
    //   14: new 127	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   21: ldc 130
    //   23: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: fload_0
    //   27: invokevirtual 137	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   30: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 146	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: getstatic 78	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:g	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   43: fload_0
    //   44: invokeinterface 149 2 0
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
        if (g == null)
        {
          d.a(4, "SDKPlugin", "MediaPlayerMgr", "notify install failed,but listener is null , error :" + str1);
          return;
          str1 = "ERROR_NETWORK";
          continue;
        }
        g.onInstalledFailed(paramInt);
        g = null;
        d.a(4, "SDKPlugin", "MediaPlayerMgr", "notify install failed ,error :" + str1);
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
    //   3: getstatic 68	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   6: ifne +103 -> 109
    //   9: getstatic 70	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   12: invokestatic 168	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   15: invokevirtual 170	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	()Ljava/lang/String;
    //   18: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +18 -> 39
    //   24: getstatic 70	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   27: invokestatic 168	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   30: invokevirtual 178	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	()Ljava/lang/String;
    //   33: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +25 -> 61
    //   39: getstatic 100	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:q	I
    //   42: iconst_1
    //   43: if_icmpge +18 -> 61
    //   46: getstatic 100	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:q	I
    //   49: iconst_1
    //   50: iadd
    //   51: putstatic 100	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:q	I
    //   54: iconst_0
    //   55: istore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: iload_1
    //   60: ireturn
    //   61: aload_0
    //   62: invokestatic 183	com/tencent/qqlive/mediaplayer/dex/Dexloader:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/dex/Dexloader;
    //   65: getstatic 70	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   68: invokestatic 168	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   71: invokevirtual 178	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	()Ljava/lang/String;
    //   74: getstatic 70	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:c	Landroid/content/Context;
    //   77: invokestatic 168	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	(Landroid/content/Context;)Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   80: invokevirtual 170	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	()Ljava/lang/String;
    //   83: invokevirtual 186	com/tencent/qqlive/mediaplayer/dex/Dexloader:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   86: putstatic 66	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:a	Ljava/lang/ClassLoader;
    //   89: getstatic 66	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:a	Ljava/lang/ClassLoader;
    //   92: ifnull +24 -> 116
    //   95: iconst_1
    //   96: putstatic 68	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   99: iconst_3
    //   100: ldc 80
    //   102: ldc 125
    //   104: ldc 188
    //   106: invokestatic 146	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   109: getstatic 68	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:b	Z
    //   112: istore_1
    //   113: goto -57 -> 56
    //   116: iconst_5
    //   117: ldc 80
    //   119: ldc 125
    //   121: ldc 190
    //   123: invokestatic 146	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto -17 -> 109
    //   129: astore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramContext	Context
    //   55	58	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	39	129	finally
    //   39	54	129	finally
    //   61	109	129	finally
    //   109	113	129	finally
    //   116	126	129	finally
  }
  
  public static boolean checkSdkPluginMode()
  {
    for (;;)
    {
      try
      {
        Method localMethod = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
        localMethod.setAccessible(true);
        if ((TVK_IProxyFactory)localMethod.invoke(null, new Object[0]) != null) {
          continue;
        }
        bool = true;
        d = bool;
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        d = true;
        continue;
      }
      return d;
      bool = false;
    }
  }
  
  public static int clearStorage(Context paramContext)
  {
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
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
    //   3: getstatic 78	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:g	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   6: ifnonnull +17 -> 23
    //   9: iconst_3
    //   10: ldc 80
    //   12: ldc 125
    //   14: ldc 235
    //   16: invokestatic 146	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: getstatic 78	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:g	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   26: invokeinterface 238 1 0
    //   31: aconst_null
    //   32: putstatic 78	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:g	Lcom/tencent/qqlive/mediaplayer/api/TVK_SDKMgr$InstallListener;
    //   35: iconst_3
    //   36: ldc 123
    //   38: ldc 125
    //   40: ldc 240
    //   42: invokestatic 146	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   45: goto -26 -> 19
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	48	finally
    //   23	45	48	finally
  }
  
  public static void deInit()
  {
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().deInit();
    }
  }
  
  private static void e()
  {
    if (d) {
      try
      {
        Method localMethod1 = a.loadClass("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
        localMethod1.setAccessible(true);
        s = (TVK_IProxyFactory)localMethod1.invoke(null, new Object[0]);
        if (s == null) {
          d.a(5, "", "MediaPlayerMgr", "createProxyFactory, invoke get failed! ");
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        d.a(5, "", "MediaPlayerMgr", "createProxyFactory, exception failed! ");
        return;
      }
    }
    try
    {
      Method localMethod2 = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
      localMethod2.setAccessible(true);
      s = (TVK_IProxyFactory)localMethod2.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable2)
    {
      d.a(5, "", "MediaPlayerMgr", "tvk reflect factory failed: " + localThrowable2.toString());
    }
  }
  
  private static boolean f()
  {
    String[] arrayOfString1 = s.getSdkMgrInstance().getSdkVersion().split("\\.");
    String[] arrayOfString2 = SDK_Ver.split("\\.");
    if ((arrayOfString2.length > 1) && (arrayOfString1.length > 1) && (arrayOfString2[0].equalsIgnoreCase(arrayOfString1[0])) && (arrayOfString2[1].equalsIgnoreCase(arrayOfString1[1]))) {
      return true;
    }
    b = false;
    a = null;
    return false;
  }
  
  private static void g()
  {
    if (f) {}
    do
    {
      do
      {
        return;
        f = true;
        e();
        if ((s != null) && (s.getSdkMgrInstance() != null)) {
          break;
        }
        d.a(5, "", "MediaPlayerMgr", "initSDK failed, cannot get instance");
        f = false;
        s = null;
      } while ((!d) || (a.a(c) == null));
      a.a(c).b();
      return;
      if ((!d) || (f())) {
        break;
      }
      f = false;
      s = null;
      d.a(5, "", "MediaPlayerMgr", "initSDK failed, match sdk version failed");
    } while ((!d) || (a.a(c) == null));
    a.a(c).b();
    return;
    if (!TextUtils.isEmpty(o)) {
      s.getSdkMgrInstance().setGuid(o);
    }
    if (!TextUtils.isEmpty(p)) {
      s.getSdkMgrInstance().setUpc(p);
    }
    if (j) {
      s.getSdkMgrInstance().useFileConfigBeforeInitSDK(c);
    }
    if (k != null) {
      s.getSdkMgrInstance().setHostConfigBeforeInitSDK(k);
    }
    s.getSdkMgrInstance().setDebugEnable(l);
    if (m != null) {
      s.getSdkMgrInstance().setOnLogListener(m);
    }
    if (n != null) {
      s.getSdkMgrInstance().setOnLogReportListener(n);
    }
    s.getSdkMgrInstance().initSdk(c, h, i);
    if ((d) && (a.a(c) != null))
    {
      s.getSdkMgrInstance().setExtraMapInfo("assetPath", a.a(c).d());
      a.a(c).b();
    }
    e = true;
  }
  
  public static String getAdChid()
  {
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().getAdChid();
    }
    return "";
  }
  
  public static String getHostConfig()
  {
    return k;
  }
  
  public static String getPlatform()
  {
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      return s.getSdkMgrInstance().getPlatform();
    }
    return "";
  }
  
  public static TVK_IProxyFactory getProxyFactory()
  {
    if ((s == null) && (!d)) {
      e();
    }
    return s;
  }
  
  public static String getSdkVersion()
  {
    if (((!d) || (b)) && (getProxyFactory() != null) && (getProxyFactory().getSdkMgrInstance() != null)) {
      return getProxyFactory().getSdkMgrInstance().getSdkVersion();
    }
    return SDK_Ver;
  }
  
  public static void initSdk(Context paramContext, String paramString1, String paramString2)
  {
    if (e) {
      return;
    }
    e = true;
    checkSdkPluginMode();
    c = paramContext.getApplicationContext();
    h = paramString1;
    i = paramString2;
    d.a(3, "", "MediaPlayerMgr", "initSdk... ver: " + SDK_Ver);
    if (!d)
    {
      g();
      return;
    }
    if ((a.a(c).c()) && (b(c)))
    {
      g();
      return;
    }
    a.a(c).a(r);
    a.a(c).a(true);
  }
  
  public static void initSdkWithGuid(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    o = paramString3;
    initSdk(paramContext, paramString1, paramString2);
  }
  
  public static void installPlugin(Context paramContext, InstallListener paramInstallListener)
    throws IllegalArgumentException
  {
    if (paramContext == null) {
      return;
    }
    c = paramContext.getApplicationContext();
    g = paramInstallListener;
    if (g == null) {
      throw new IllegalArgumentException("Install listener can not be null");
    }
    if (getProxyFactory() != null)
    {
      d();
      return;
    }
    if (!d)
    {
      if (getProxyFactory() == null)
      {
        b(105);
        return;
      }
      d();
      return;
    }
    if ((a.a(c).c()) && (b(c)))
    {
      g();
      b(1.0F);
      if (getProxyFactory() == null)
      {
        b(105);
        return;
      }
      d();
      return;
    }
    a.a(c).a(r);
    a.a(c).a();
  }
  
  public static boolean isInstalled(Context paramContext)
  {
    if ((!e) || (!f)) {}
    while (getProxyFactory() == null) {
      return false;
    }
    return true;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    l = paramBoolean;
    d.a(paramBoolean);
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setDebugEnable(paramBoolean);
    }
  }
  
  public static void setHostConfigBeforeInitSDK(String paramString)
  {
    k = paramString;
  }
  
  public static void setOnLogListener(OnLogListener paramOnLogListener)
  {
    m = paramOnLogListener;
    d.a(paramOnLogListener);
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setOnLogListener(paramOnLogListener);
    }
  }
  
  public static void setOnLogReportListener(OnLogReportListener paramOnLogReportListener)
  {
    n = paramOnLogReportListener;
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setOnLogReportListener(paramOnLogReportListener);
    }
  }
  
  public static void setPreloadMaxStorageSize(long paramLong)
  {
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setPreloadMaxStorageSize(c, paramLong);
    }
  }
  
  public static void setUpc(String paramString)
  {
    p = paramString;
    if (((!d) || (b)) && (s != null) && (s.getSdkMgrInstance() != null)) {
      s.getSdkMgrInstance().setUpc(paramString);
    }
  }
  
  public static void useFileConfigBeforeInitSDK(Context paramContext)
  {
    j = true;
  }
  
  public static abstract interface InstallListener
  {
    public abstract void onInstallProgress(float paramFloat);
    
    public abstract void onInstalledFailed(int paramInt);
    
    public abstract void onInstalledSuccessed();
  }
  
  public static abstract interface OnLogListener
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
  
  public static abstract interface OnLogReportListener
  {
    public abstract void onLogReport(Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr
 * JD-Core Version:    0.7.0.1
 */