package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.qqlive.mediaplayer.dex.Dexloader;
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
  private static ClassLoader a;
  private static boolean b = false;
  private static Context c;
  private static boolean d = false;
  private static boolean e = false;
  private static TVK_SDKMgr.InstallListener f;
  private static String g = "";
  private static String h = "";
  private static boolean i = false;
  private static String j;
  private static boolean k = false;
  private static boolean l = false;
  private static TVK_SDKMgr.OnLogListener m;
  private static TVK_SDKMgr.OnLogReportListener n;
  private static String o = "";
  private static String p = "";
  private static int q;
  private static TVK_SDKMgr.InstallListener r = new TVK_SDKMgr.1();
  private static TVK_IProxyFactory s = null;
  
  private static void b(float paramFloat)
  {
    try
    {
      if (f == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notify install progress , but listener is null .percent :");
        localStringBuilder.append(paramFloat);
        d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", localStringBuilder.toString());
        return;
      }
      f.onInstallProgress(paramFloat);
      return;
    }
    finally {}
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
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("notify install failed,but listener is null , error :");
          ((StringBuilder)localObject2).append(str1);
          d.a(4, "TVK_SDKMgr.java", "MediaPlayerMgr", ((StringBuilder)localObject2).toString());
          return;
        }
        f.onInstalledFailed(paramInt);
        f = null;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notify install failed ,error :");
        ((StringBuilder)localObject2).append(str1);
        d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", ((StringBuilder)localObject2).toString());
        localObject2 = new HashMap();
        ((Map)localObject2).put("errorCode", String.valueOf(paramInt));
        ((Map)localObject2).put("errorMsg", str1);
        UserAction.onUserAction("actVideoSDKInstallPlugin", false, -1L, -1L, (Map)localObject2, true);
        return;
      }
      finally {}
      continue;
      String str2 = "ERROR_FACTORY_NULL";
      continue;
      str2 = "ERROR_IO";
      continue;
      str2 = "ERROR_INVALID_FILE";
      continue;
      str2 = "ERROR_SERVER_RESPONSE";
      continue;
      str2 = "ERROR_NETWORK";
    }
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      if (!b)
      {
        if (((TextUtils.isEmpty(a.a(c).d())) || (TextUtils.isEmpty(a.a(c).c()))) && (q < 1))
        {
          q += 1;
          return false;
        }
        a = Dexloader.a(paramContext).a(a.a(c).c(), a.a(c).d());
        if (a != null)
        {
          b = true;
          d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "Get dexClassloader successfully");
        }
        else
        {
          d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "loadDexFile failed! ");
        }
        UserAction.onUserAction("actVideoSDKLoadDex", b, -1L, -1L, null, true);
      }
      boolean bool = b;
      return bool;
    }
    finally {}
  }
  
  public static int clearStorage(Context paramContext)
  {
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        return s.getSdkMgrInstance().cleanStorage(paramContext);
      }
    }
    return -1;
  }
  
  private static void d()
  {
    try
    {
      if (f == null)
      {
        d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "notify install success , but listener is null .");
        return;
      }
      f.onInstalledSuccessed();
      f = null;
      d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "notify install success .");
      UserAction.onUserAction("actVideoSDKInstallPlugin", true, -1L, -1L, null, true);
      return;
    }
    finally {}
  }
  
  public static void deInit()
  {
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        s.getSdkMgrInstance().deInit();
      }
    }
  }
  
  private static void e()
  {
    try
    {
      boolean bool = isPluginMode();
      StringBuilder localStringBuilder2;
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
          if (s != null) {
            break label208;
          }
          d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "createProxyFactory, invoke get failed! ");
        }
        catch (Throwable localThrowable1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("createProxyFactory, exception failed!, error: ");
          localStringBuilder2.append(localThrowable1.getMessage());
          d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", localStringBuilder2.toString());
        }
      }
      else
      {
        Object localObject1 = s;
        if (localObject1 == null) {
          try
          {
            localObject1 = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
            ((Method)localObject1).setAccessible(true);
            s = (TVK_IProxyFactory)((Method)localObject1).invoke(null, new Object[0]);
          }
          catch (Throwable localThrowable2)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("createProxyFactory reflect factory failed: ");
            localStringBuilder2.append(localThrowable2.toString());
            d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", localStringBuilder2.toString());
          }
        }
      }
      label208:
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("createProxyFactory mProxyFactory: ");
      localStringBuilder1.append(s);
      d.a(1, "TVK_SDKMgr.java", "MediaPlayerMgr", localStringBuilder1.toString());
      return;
    }
    finally {}
  }
  
  private static void f()
  {
    if (e) {
      return;
    }
    e = true;
    e();
    Object localObject = s;
    if ((localObject != null) && (((TVK_IProxyFactory)localObject).getSdkMgrInstance() != null))
    {
      if (isPluginMode())
      {
        localObject = s.getSdkMgrInstance().getSdkVersion().split("\\.");
        String[] arrayOfString = SDK_Ver.split("\\.");
        int i1;
        if ((arrayOfString.length > 1) && (localObject.length > 1) && (arrayOfString[0].equalsIgnoreCase(localObject[0])) && (arrayOfString[1].equalsIgnoreCase(localObject[1])))
        {
          i1 = 1;
        }
        else
        {
          b = false;
          a = null;
          i1 = 0;
        }
        if (i1 == 0)
        {
          e = false;
          s = null;
          d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "initSDK failed, match sdk version failed");
          if ((isPluginMode()) && (a.a(c) != null)) {
            a.a(c).a();
          }
          return;
        }
      }
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
      return;
    }
    d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", "initSDK failed, cannot get instance");
    e = false;
    s = null;
    if ((isPluginMode()) && (a.a(c) != null)) {
      a.a(c).a();
    }
  }
  
  public static String getAdChid()
  {
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        return s.getSdkMgrInstance().getAdChid();
      }
    }
    return "";
  }
  
  public static Context getAppContext()
  {
    return c;
  }
  
  public static int getHevcHwMaxResolution()
  {
    if ((d) && (e) && ((!isPluginMode()) || (b)))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        return s.getSdkMgrInstance().getHevcHwMaxResolution();
      }
    }
    return -1;
  }
  
  public static int getHevcSwMaxResolution()
  {
    if ((d) && (e) && ((!isPluginMode()) || (b)))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        return s.getSdkMgrInstance().getHevcSwMaxResolution();
      }
    }
    return -1;
  }
  
  public static String getHostConfig()
  {
    return j;
  }
  
  public static String getPlatform()
  {
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        return s.getSdkMgrInstance().getPlatform();
      }
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
        localObject = localClass.getField("useASan");
        if (localObject != null) {
          l = ((Field)localObject).getBoolean(localClass);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkASanMode failure! ");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      d.a(5, "TVK_SDKMgr.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkASanMode, mUseASan=");
    localStringBuilder.append(l);
    d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", localStringBuilder.toString());
    c = paramContext.getApplicationContext();
    g = paramString1;
    h = paramString2;
    paramContext = new StringBuilder();
    paramContext.append("initSdk... ver: ");
    paramContext.append(SDK_Ver);
    d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", paramContext.toString());
    if (!isPluginMode())
    {
      f();
      return;
    }
    if ((a.a(c).b()) && (b(c)))
    {
      f();
      return;
    }
    startUpdate(true);
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
    if (f != null)
    {
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
      return;
    }
    throw new IllegalArgumentException("Install listener can not be null");
  }
  
  public static boolean isASanEnable()
  {
    return l;
  }
  
  public static boolean isInstalled(Context paramContext)
  {
    boolean bool2 = d;
    boolean bool1 = false;
    if (bool2)
    {
      if (!e) {
        return false;
      }
      if (getProxyFactory() == null) {
        return false;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isPluginMode()
  {
    boolean bool;
    label77:
    try
    {
      localObject1 = s;
      bool = true;
      if (localObject1 != null)
      {
        d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", "isPluginMode() false, mProxyFactory not null");
        return true;
      }
    }
    finally {}
    try
    {
      localObject1 = Class.forName("com.tencent.qqlive.mediaplayer.wrapper.MediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      s = (TVK_IProxyFactory)((Method)localObject1).invoke(null, new Object[0]);
      localObject1 = s;
      if (localObject1 != null) {
        bool = false;
      }
    }
    catch (Throwable localThrowable)
    {
      break label77;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isPluginMode() ");
    ((StringBuilder)localObject1).append(bool);
    d.a(3, "TVK_SDKMgr.java", "MediaPlayerMgr", ((StringBuilder)localObject1).toString());
    return bool;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    k = paramBoolean;
    d.a(paramBoolean);
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        s.getSdkMgrInstance().setDebugEnable(paramBoolean);
      }
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
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        s.getSdkMgrInstance().setOnLogListener(paramOnLogListener);
      }
    }
  }
  
  public static void setOnLogReportListener(TVK_SDKMgr.OnLogReportListener paramOnLogReportListener)
  {
    n = paramOnLogReportListener;
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        s.getSdkMgrInstance().setOnLogReportListener(paramOnLogReportListener);
      }
    }
  }
  
  public static void setPreloadMaxStorageSize(long paramLong)
  {
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        s.getSdkMgrInstance().setPreloadMaxStorageSize(c, paramLong);
      }
    }
  }
  
  public static void setUpc(String paramString)
  {
    p = paramString;
    if ((!isPluginMode()) || (b))
    {
      TVK_IProxyFactory localTVK_IProxyFactory = s;
      if ((localTVK_IProxyFactory != null) && (localTVK_IProxyFactory.getSdkMgrInstance() != null)) {
        s.getSdkMgrInstance().setUpc(paramString);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr
 * JD-Core Version:    0.7.0.1
 */