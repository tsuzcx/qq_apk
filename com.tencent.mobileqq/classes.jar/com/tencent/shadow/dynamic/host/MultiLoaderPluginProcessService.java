package com.tencent.shadow.dynamic.host;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.proguard.c;
import com.tencent.shadow.proguard.d;
import com.tencent.shadow.proguard.j;
import com.tencent.shadow.proguard.m;
import java.io.File;
import java.util.HashMap;

public class MultiLoaderPluginProcessService
  extends c
{
  private static d b = new d();
  private final m c = new m(this);
  private HashMap d = new HashMap();
  private HashMap e = new HashMap();
  private HashMap f = new HashMap();
  private HashMap g = new HashMap();
  
  private UuidManager c(String paramString)
  {
    paramString = (UuidManager)this.e.get(paramString);
    if (paramString == null) {
      throw new FailedException(4, "mUuidManager == null");
    }
    return paramString;
  }
  
  private void c(String paramString1, String paramString2)
  {
    String str = (String)this.d.get(paramString1);
    if ((str != null) && (!TextUtils.equals(paramString2, str))) {
      throw new FailedException(6, "Plugin=" + paramString1 + "已设置过uuid==" + str + ", 试图设置uuid==" + paramString2);
    }
    if (str == null) {
      this.d.put(paramString1, paramString2);
    }
  }
  
  private boolean d(String paramString)
  {
    paramString = (Boolean)this.g.get(paramString);
    return (paramString != null) && (paramString.booleanValue());
  }
  
  public static Application.ActivityLifecycleCallbacks getActivityHolder()
  {
    return b;
  }
  
  public static MultiLoaderPpsController wrapBinder(IBinder paramIBinder)
  {
    return new MultiLoaderPpsController(paramIBinder);
  }
  
  /* Error */
  public final PpsStatus a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 36	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:d	Ljava/util/HashMap;
    //   8: aload_1
    //   9: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast 59	java/lang/String
    //   15: astore 5
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 108	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:d	(Ljava/lang/String;)Z
    //   22: istore 4
    //   24: aload_0
    //   25: getfield 40	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:f	Ljava/util/HashMap;
    //   28: aload_1
    //   29: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: ifnull +34 -> 66
    //   35: iconst_1
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 38	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:e	Ljava/util/HashMap;
    //   41: aload_1
    //   42: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: ifnull +26 -> 71
    //   48: new 110	com/tencent/shadow/dynamic/host/PpsStatus
    //   51: dup
    //   52: aload 5
    //   54: iload 4
    //   56: iload_2
    //   57: iload_3
    //   58: invokespecial 113	com/tencent/shadow/dynamic/host/PpsStatus:<init>	(Ljava/lang/String;ZZZ)V
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: iconst_0
    //   67: istore_2
    //   68: goto -31 -> 37
    //   71: iconst_0
    //   72: istore_3
    //   73: goto -25 -> 48
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	MultiLoaderPluginProcessService
    //   0	81	1	paramString	String
    //   36	32	2	bool1	boolean
    //   1	72	3	bool2	boolean
    //   22	33	4	bool3	boolean
    //   15	38	5	str	String
    // Exception table:
    //   from	to	target	type
    //   4	35	76	finally
    //   37	48	76	finally
    //   48	62	76	finally
  }
  
  public final void a()
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("exit ");
    }
    b.a();
    System.exit(0);
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public final void a(String paramString, UuidManager paramUuidManager)
  {
    try
    {
      if (this.a.isInfoEnabled()) {
        this.a.info("setUuidManagerForPlugin pluginKey=" + paramString + ", uuidManager==" + paramUuidManager);
      }
      this.e.put(paramString, paramUuidManager);
      paramString = (PluginLoaderImpl)this.f.get(paramString);
      if (paramString != null)
      {
        if (this.a.isInfoEnabled()) {
          this.a.info("更新PluginLoader的uuidManager");
        }
        paramString.setUuidManager(paramUuidManager);
      }
      return;
    }
    finally {}
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject;
    UuidManager localUuidManager;
    try
    {
      localObject = "pluginKey=" + paramString1 + "|uuid=" + paramString2;
      if (this.a.isInfoEnabled()) {
        this.a.info("loadRuntimeForPlugin:" + (String)localObject);
      }
      localUuidManager = c(paramString1);
      c(paramString1, paramString2);
      if (d(paramString1)) {
        throw new FailedException(7, "重复调用loadRuntime," + (String)localObject);
      }
    }
    finally {}
    try
    {
      localObject = localUuidManager.getRuntime(paramString2);
      MultiDynamicContainer.loadContainerApk(paramString1, new InstalledApk(((InstalledApk)localObject).apkFilePath, ((InstalledApk)localObject).oDexPath, ((InstalledApk)localObject).libraryPath));
      this.g.put(paramString1, Boolean.valueOf(true));
      return;
    }
    catch (RemoteException paramString1)
    {
      Log.i("PluginProcessService", "uuidManager.getRuntime new FailedException");
      throw new FailedException(5, paramString1.getMessage());
    }
    catch (RuntimeException paramString1)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("loadRuntimeForPlugin发生RuntimeException", paramString1);
      }
      throw new FailedException(paramString1);
    }
    catch (NotFoundException localNotFoundException)
    {
      Log.i("PluginProcessService", "uuidManager.getRuntime new NotFoundException");
      throw new FailedException(3, "pluginKey=" + paramString1 + ", uuid=" + paramString2 + "的Runtime没有找到。cause:" + localNotFoundException.getMessage());
    }
  }
  
  public final IBinder b(String paramString)
  {
    try
    {
      paramString = (IBinder)this.f.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    Object localObject;
    UuidManager localUuidManager;
    try
    {
      localObject = "pluginKey=" + paramString1 + "|uuid=" + paramString2;
      if (this.a.isInfoEnabled()) {
        this.a.info("loadPluginLoader:" + (String)localObject);
      }
      localUuidManager = c(paramString1);
      c(paramString1, paramString2);
      if (this.f.get(paramString1) != null) {
        throw new FailedException(8, "重复调用loadPluginLoader");
      }
    }
    finally {}
    InstalledApk localInstalledApk;
    try
    {
      localInstalledApk = localUuidManager.getPluginLoader(paramString2);
      if (this.a.isInfoEnabled()) {
        this.a.info("取出" + (String)localObject + "的Loader apk:" + localInstalledApk.apkFilePath);
      }
      localObject = new File(localInstalledApk.apkFilePath);
      if (!((File)localObject).exists()) {
        throw new FailedException(3, ((File)localObject).getAbsolutePath() + "文件不存在");
      }
    }
    catch (RuntimeException paramString1)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("loadPluginLoader发生RuntimeException", paramString1);
      }
      throw new FailedException(paramString1);
    }
    catch (RemoteException paramString1)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("获取Loader Apk失败", paramString1);
      }
      throw new FailedException(5, paramString1.getMessage());
    }
    catch (FailedException paramString1)
    {
      throw paramString1;
    }
    catch (NotFoundException paramString1)
    {
      throw new FailedException(3, (String)localObject + "的PluginLoader没有找到。cause:" + paramString1.getMessage());
    }
    catch (Exception paramString1)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("loadPluginLoader发生Exception", paramString1);
      }
      if (paramString1.getCause() == null) {}
    }
    for (paramString1 = paramString1.getCause().getMessage();; paramString1 = paramString1.getMessage())
    {
      throw new FailedException(2, "加载动态实现失败 cause：" + paramString1);
      paramString2 = new j().a(localInstalledApk, paramString2, getApplicationContext());
      paramString2.setUuidManager(localUuidManager);
      this.f.put(paramString1, paramString2);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("onBind:" + this);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiLoaderPluginProcessService
 * JD-Core Version:    0.7.0.1
 */