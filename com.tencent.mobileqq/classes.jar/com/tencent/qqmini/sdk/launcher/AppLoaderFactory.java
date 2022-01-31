package com.tencent.qqmini.sdk.launcher;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import bgly;
import bgus;
import bgvb;
import bgvf;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IBuild;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.log.Log;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class AppLoaderFactory
{
  public static final String TAG = "minisdk-start";
  private static volatile AppLoaderFactory instance;
  private static volatile byte[] lock = new byte[0];
  @bgvb(a="com.tencent.qqmini.sdk.ipc.AppBrandProxy")
  private IAppBrandProxy appBrandProxy;
  @bgvb(a="com.tencent.qqmini.sdk.launcher.AppUIProxy")
  private IUIProxy appUIProxy;
  private BaselibLoader baselibLoader;
  @bgvb(a="com.tencent.qqmini.sdk.core.Build")
  private IBuild build;
  @bgvb(a="com.tencent.qqmini.sdk.minigame.ui.GameUIProxy")
  private IUIProxy gameUIProxy;
  @bgvb(a="com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager")
  private ILaunchManager launchManager;
  Context mContext;
  private String mProcessName;
  private Class mainServiceBinderClass;
  @bgvb(a="com.tencent.qqmini.sdk.core.MiniAppEnv")
  private IMiniAppEnv miniAppEnv;
  @bgvb(a="com.tencent.qqmini.sdk.core.log.LogImpl")
  private Log minilog;
  @bgvb(a="com.tencent.qqmini.sdk.core.proxy.FakeProxyManager")
  private bgly proxyManager;
  @bgvb(a="com.tencent.qqmini.sdk.receiver.MainReceiverProxy")
  private IReceiverProxy receiverProxy;
  
  /* Error */
  private void doAnnotation()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 68	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   7: astore_3
    //   8: aload_3
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: iload_2
    //   15: if_icmpge +25 -> 40
    //   18: aload_3
    //   19: iload_1
    //   20: aaload
    //   21: astore 4
    //   23: ldc 70
    //   25: aload 4
    //   27: invokevirtual 75	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   30: if_acmpne +82 -> 112
    //   33: aload_0
    //   34: aload 4
    //   36: invokespecial 79	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:processFieldAnnotation	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_3
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +25 -> 72
    //   50: aload_3
    //   51: iload_1
    //   52: aaload
    //   53: astore 4
    //   55: ldc 81
    //   57: aload 4
    //   59: invokevirtual 75	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   62: if_acmpne +68 -> 130
    //   65: aload_0
    //   66: aload 4
    //   68: invokespecial 79	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:processFieldAnnotation	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   71: pop
    //   72: aload_3
    //   73: arraylength
    //   74: istore_2
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: iload_2
    //   79: if_icmpge +90 -> 169
    //   82: aload_3
    //   83: iload_1
    //   84: aaload
    //   85: astore 4
    //   87: aload_0
    //   88: aload 4
    //   90: invokespecial 79	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:processFieldAnnotation	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   93: pop
    //   94: iload_1
    //   95: iconst_1
    //   96: iadd
    //   97: istore_1
    //   98: goto -21 -> 77
    //   101: astore 4
    //   103: ldc 8
    //   105: ldc 82
    //   107: aload 4
    //   109: invokestatic 88	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: iload_1
    //   113: iconst_1
    //   114: iadd
    //   115: istore_1
    //   116: goto -103 -> 13
    //   119: astore 4
    //   121: ldc 8
    //   123: ldc 90
    //   125: aload 4
    //   127: invokestatic 88	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -89 -> 45
    //   137: astore 5
    //   139: ldc 8
    //   141: new 92	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   148: ldc 95
    //   150: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: aload 5
    //   163: invokestatic 88	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: goto -72 -> 94
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	AppLoaderFactory
    //   12	122	1	i	int
    //   10	70	2	j	int
    //   7	76	3	arrayOfField	Field[]
    //   21	68	4	localField	Field
    //   101	7	4	localThrowable1	Throwable
    //   119	35	4	localThrowable2	Throwable
    //   137	25	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   23	40	101	java/lang/Throwable
    //   55	72	119	java/lang/Throwable
    //   87	94	137	java/lang/Throwable
  }
  
  public static AppLoaderFactory g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppLoaderFactory();
      }
      return instance;
    }
  }
  
  private Object processFieldAnnotation(Field paramField)
  {
    Object localObject = paramField.get(this);
    if (localObject != null) {
      return localObject;
    }
    if (paramField.isAnnotationPresent(bgvb.class))
    {
      paramField.setAccessible(true);
      localObject = ((bgvb)paramField.getAnnotation(bgvb.class)).a();
      localObject = bgvf.a().a((String)localObject);
      paramField.set(this, localObject);
      return localObject;
    }
    return null;
  }
  
  public IBinder createMainServiceBinder(Context paramContext, String paramString)
  {
    if (this.mainServiceBinderClass == null) {
      this.mainServiceBinderClass = findClass("com.tencent.qqmini.sdk.ipc.AppMainServiceBinder");
    }
    if (this.mainServiceBinderClass == null)
    {
      QMLog.e("minisdk-start", "mainServiceBinderClass is null!");
      return null;
    }
    try
    {
      paramContext = (IBinder)this.mainServiceBinderClass.getConstructor(new Class[] { Context.class, String.class }).newInstance(new Object[] { paramContext, paramString });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("minisdk-start", "exception when createMainServiceBinder", paramContext);
    }
    return null;
  }
  
  public Class findClass(String paramString)
  {
    return bgvf.a().a(paramString);
  }
  
  public IAppBrandProxy getAppBrandProxy()
  {
    return this.appBrandProxy;
  }
  
  public IUIProxy getAppUIProxy(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start", "Failed to getAppUIProxy, miniAppInfo is null");
      return null;
    }
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return this.gameUIProxy;
    }
    return this.appUIProxy;
  }
  
  public BaselibLoader getBaselibLoader()
  {
    return this.baselibLoader;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getCurrentProcessName()
  {
    int i = Process.myPid();
    String str1 = "";
    String str2 = str1;
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        str2 = str1;
        Object localObject = str1;
        if (localIterator.hasNext())
        {
          str2 = str1;
          localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          str2 = str1;
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i)
          {
            str2 = str1;
            str1 = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
        else
        {
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start", "getCurrentProcessName", localThrowable);
        localObject = str2;
      }
    }
  }
  
  public ILaunchManager getLaunchManager()
  {
    return this.launchManager;
  }
  
  public IMiniAppEnv getMiniAppEnv()
  {
    return this.miniAppEnv;
  }
  
  public String getProcessName()
  {
    if (!TextUtils.isEmpty(this.mProcessName)) {
      return this.mProcessName;
    }
    try
    {
      Object localObject = (ActivityManager)this.mContext.getSystemService("activity");
      int i = Process.myPid();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i) {
          this.mProcessName = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start", "getProcessName exception!", localThrowable);
      }
    }
    return this.mProcessName;
  }
  
  public bgly getProxyManager()
  {
    return this.proxyManager;
  }
  
  public IReceiverProxy getReceiverProxy()
  {
    return this.receiverProxy;
  }
  
  public IBuild getSDKBuild()
  {
    return this.build;
  }
  
  public void init(Context paramContext, bgus parambgus)
  {
    if (this.mContext != null) {
      return;
    }
    this.mContext = paramContext;
    bgvf localbgvf = bgvf.a();
    if (parambgus != null) {}
    for (boolean bool = parambgus.b;; bool = true)
    {
      localbgvf.a(paramContext, bool);
      bgvf.a().a();
      doAnnotation();
      QMLog.setLog(this.minilog);
      this.miniAppEnv.init(paramContext);
      this.appBrandProxy.init(paramContext);
      this.mainServiceBinderClass = findClass("com.tencent.qqmini.sdk.ipc.AppMainServiceBinder");
      return;
    }
  }
  
  public boolean isMainProcess()
  {
    return this.mContext.getPackageName().equals(getCurrentProcessName());
  }
  
  public void setBaselibLoader(BaselibLoader paramBaselibLoader)
  {
    if (paramBaselibLoader != null) {
      this.baselibLoader = paramBaselibLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppLoaderFactory
 * JD-Core Version:    0.7.0.1
 */