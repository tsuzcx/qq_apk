package com.tencent.shadow.dynamic.host;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.proguard.c;
import com.tencent.shadow.proguard.d;
import com.tencent.shadow.proguard.j;
import com.tencent.shadow.proguard.o;
import java.io.File;

public class PluginProcessService
  extends c
{
  private static d g = new d();
  public UuidManager b;
  public PluginLoaderImpl c;
  public boolean d = false;
  public String e = "";
  private final o f = new o(this);
  
  private void b()
  {
    if (this.b == null) {
      throw new FailedException(4, "mUuidManager == null");
    }
  }
  
  private void c(String paramString)
  {
    if (this.e.isEmpty()) {
      this.e = paramString;
    }
    while (this.e.equals(paramString)) {
      return;
    }
    throw new FailedException(6, "已设置过uuid==" + this.e + "试图设置uuid==" + paramString);
  }
  
  public static Application.ActivityLifecycleCallbacks getActivityHolder()
  {
    return g;
  }
  
  public static PpsController wrapBinder(IBinder paramIBinder)
  {
    return new PpsController(paramIBinder);
  }
  
  public final void a()
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("exit ");
    }
    g.a();
    System.exit(0);
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public final void a(UuidManager paramUuidManager)
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("setUuidManager uuidManager==" + paramUuidManager);
    }
    this.b = paramUuidManager;
    if (this.c != null)
    {
      if (this.a.isInfoEnabled()) {
        this.a.info("更新mPluginLoader的uuidManager");
      }
      this.c.setUuidManager(paramUuidManager);
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: ldc 137
    //   2: new 62	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 139
    //   8: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   21: pop
    //   22: aload_0
    //   23: invokespecial 147	com/tencent/shadow/dynamic/host/PluginProcessService:b	()V
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 149	com/tencent/shadow/dynamic/host/PluginProcessService:c	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 36	com/tencent/shadow/dynamic/host/PluginProcessService:d	Z
    //   35: ifeq +15 -> 50
    //   38: new 44	com/tencent/shadow/dynamic/host/FailedException
    //   41: dup
    //   42: bipush 7
    //   44: ldc 151
    //   46: invokespecial 49	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   49: athrow
    //   50: aload_0
    //   51: getfield 91	com/tencent/shadow/dynamic/host/PluginProcessService:a	Lcom/tencent/shadow/core/common/Logger;
    //   54: invokeinterface 96 1 0
    //   59: ifeq +28 -> 87
    //   62: aload_0
    //   63: getfield 91	com/tencent/shadow/dynamic/host/PluginProcessService:a	Lcom/tencent/shadow/core/common/Logger;
    //   66: new 62	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 153
    //   72: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_1
    //   76: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokeinterface 101 2 0
    //   87: ldc 137
    //   89: ldc 155
    //   91: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload_0
    //   96: getfield 42	com/tencent/shadow/dynamic/host/PluginProcessService:b	Lcom/tencent/shadow/dynamic/host/UuidManager;
    //   99: aload_1
    //   100: invokeinterface 161 2 0
    //   105: astore_2
    //   106: new 163	com/tencent/shadow/core/common/InstalledApk
    //   109: dup
    //   110: aload_2
    //   111: getfield 166	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   114: aload_2
    //   115: getfield 169	com/tencent/shadow/core/common/InstalledApk:oDexPath	Ljava/lang/String;
    //   118: aload_2
    //   119: getfield 172	com/tencent/shadow/core/common/InstalledApk:libraryPath	Ljava/lang/String;
    //   122: invokespecial 175	com/tencent/shadow/core/common/InstalledApk:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 181	com/tencent/shadow/dynamic/host/DynamicRuntime:loadRuntime	(Lcom/tencent/shadow/core/common/InstalledApk;)Z
    //   130: ifeq +8 -> 138
    //   133: aload_0
    //   134: aload_1
    //   135: invokestatic 185	com/tencent/shadow/dynamic/host/DynamicRuntime:saveLastRuntimeInfo	(Landroid/content/Context;Lcom/tencent/shadow/core/common/InstalledApk;)V
    //   138: aload_0
    //   139: iconst_1
    //   140: putfield 36	com/tencent/shadow/dynamic/host/PluginProcessService:d	Z
    //   143: return
    //   144: astore_1
    //   145: ldc 137
    //   147: ldc 187
    //   149: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: new 44	com/tencent/shadow/dynamic/host/FailedException
    //   156: dup
    //   157: iconst_5
    //   158: aload_1
    //   159: invokevirtual 190	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   162: invokespecial 49	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   165: athrow
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 91	com/tencent/shadow/dynamic/host/PluginProcessService:a	Lcom/tencent/shadow/core/common/Logger;
    //   171: invokeinterface 193 1 0
    //   176: ifeq +15 -> 191
    //   179: aload_0
    //   180: getfield 91	com/tencent/shadow/dynamic/host/PluginProcessService:a	Lcom/tencent/shadow/core/common/Logger;
    //   183: ldc 195
    //   185: aload_1
    //   186: invokeinterface 199 3 0
    //   191: new 44	com/tencent/shadow/dynamic/host/FailedException
    //   194: dup
    //   195: aload_1
    //   196: invokespecial 202	com/tencent/shadow/dynamic/host/FailedException:<init>	(Ljava/lang/RuntimeException;)V
    //   199: athrow
    //   200: astore_2
    //   201: ldc 137
    //   203: ldc 204
    //   205: invokestatic 145	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   208: pop
    //   209: new 44	com/tencent/shadow/dynamic/host/FailedException
    //   212: dup
    //   213: iconst_3
    //   214: new 62	java/lang/StringBuilder
    //   217: dup
    //   218: ldc 206
    //   220: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 208
    //   229: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_2
    //   233: invokevirtual 209	com/tencent/shadow/dynamic/host/NotFoundException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 49	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PluginProcessService
    //   0	246	1	paramString	String
    //   105	14	2	localInstalledApk	InstalledApk
    //   200	33	2	localNotFoundException	NotFoundException
    // Exception table:
    //   from	to	target	type
    //   87	106	144	android/os/RemoteException
    //   50	87	166	java/lang/RuntimeException
    //   87	106	166	java/lang/RuntimeException
    //   106	138	166	java/lang/RuntimeException
    //   138	143	166	java/lang/RuntimeException
    //   145	166	166	java/lang/RuntimeException
    //   201	246	166	java/lang/RuntimeException
    //   87	106	200	com/tencent/shadow/dynamic/host/NotFoundException
  }
  
  public final void b(String paramString)
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("loadPluginLoader uuid:" + paramString + " mPluginLoader:" + this.c);
    }
    b();
    c(paramString);
    if (this.c != null) {
      throw new FailedException(8, "重复调用loadPluginLoader");
    }
    try
    {
      InstalledApk localInstalledApk = this.b.getPluginLoader(paramString);
      if (this.a.isInfoEnabled()) {
        this.a.info("取出uuid==" + paramString + "的Loader apk:" + localInstalledApk.apkFilePath);
      }
      File localFile = new File(localInstalledApk.apkFilePath);
      if (!localFile.exists()) {
        throw new FailedException(3, localFile.getAbsolutePath() + "文件不存在");
      }
    }
    catch (RuntimeException paramString)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("loadPluginLoader发生RuntimeException", paramString);
      }
      throw new FailedException(paramString);
    }
    catch (RemoteException paramString)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("获取Loader Apk失败", paramString);
      }
      throw new FailedException(5, paramString.getMessage());
    }
    catch (FailedException paramString)
    {
      throw paramString;
    }
    catch (NotFoundException localNotFoundException)
    {
      throw new FailedException(3, "uuid==" + paramString + "的PluginLoader没有找到。cause:" + localNotFoundException.getMessage());
    }
    catch (Exception paramString)
    {
      if (this.a.isErrorEnabled()) {
        this.a.error("loadPluginLoader发生Exception", paramString);
      }
      if (paramString.getCause() == null) {}
    }
    for (paramString = paramString.getCause().getMessage();; paramString = paramString.getMessage())
    {
      throw new FailedException(2, "加载动态实现失败 cause：" + paramString);
      paramString = new j().a(localNotFoundException, paramString, getApplicationContext());
      paramString.setUuidManager(this.b);
      this.c = paramString;
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("onBind:" + this);
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PluginProcessService
 * JD-Core Version:    0.7.0.1
 */