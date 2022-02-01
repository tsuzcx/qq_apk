package com.tencent.shadow.dynamic.host;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import java.io.File;

public class PluginProcessService
  extends BasePluginProcessService
{
  static final BasePluginProcessService.ActivityHolder sActivityHolder = new BasePluginProcessService.ActivityHolder();
  private PluginLoaderImpl mPluginLoader;
  private final PpsBinder mPpsControllerBinder = new PpsBinder(this);
  private boolean mRuntimeLoaded = false;
  private String mUuid = "";
  private UuidManager mUuidManager;
  
  private void checkUuidManagerNotNull()
  {
    if (this.mUuidManager == null) {
      throw new FailedException(4, "mUuidManager == null");
    }
  }
  
  public static Application.ActivityLifecycleCallbacks getActivityHolder()
  {
    return sActivityHolder;
  }
  
  private void setUuid(String paramString)
  {
    if (this.mUuid.isEmpty()) {
      this.mUuid = paramString;
    }
    while (this.mUuid.equals(paramString)) {
      return;
    }
    throw new FailedException(6, "已设置过uuid==" + this.mUuid + "试图设置uuid==" + paramString);
  }
  
  public static PpsController wrapBinder(IBinder paramIBinder)
  {
    return new PpsController(paramIBinder);
  }
  
  void exit()
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("exit ");
    }
    sActivityHolder.finishAll();
    System.exit(0);
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  IBinder getPluginLoader()
  {
    return this.mPluginLoader;
  }
  
  PpsStatus getPpsStatus()
  {
    boolean bool2 = true;
    String str = this.mUuid;
    boolean bool3 = this.mRuntimeLoaded;
    boolean bool1;
    if (this.mPluginLoader != null)
    {
      bool1 = true;
      if (this.mUuidManager == null) {
        break label47;
      }
    }
    for (;;)
    {
      return new PpsStatus(str, bool3, bool1, bool2);
      bool1 = false;
      break;
      label47:
      bool2 = false;
    }
  }
  
  void loadPluginLoader(String paramString)
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("loadPluginLoader uuid:" + paramString + " mPluginLoader:" + this.mPluginLoader);
    }
    checkUuidManagerNotNull();
    setUuid(paramString);
    if (this.mPluginLoader != null) {
      throw new FailedException(8, "重复调用loadPluginLoader");
    }
    try
    {
      InstalledApk localInstalledApk = this.mUuidManager.getPluginLoader(paramString);
      if (this.mLogger.isInfoEnabled()) {
        this.mLogger.info("取出uuid==" + paramString + "的Loader apk:" + localInstalledApk.apkFilePath);
      }
      File localFile = new File(localInstalledApk.apkFilePath);
      if (!localFile.exists()) {
        throw new FailedException(3, localFile.getAbsolutePath() + "文件不存在");
      }
    }
    catch (RuntimeException paramString)
    {
      if (this.mLogger.isErrorEnabled()) {
        this.mLogger.error("loadPluginLoader发生RuntimeException", paramString);
      }
      throw new FailedException(paramString);
    }
    catch (RemoteException paramString)
    {
      if (this.mLogger.isErrorEnabled()) {
        this.mLogger.error("获取Loader Apk失败", paramString);
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
      if (this.mLogger.isErrorEnabled()) {
        this.mLogger.error("loadPluginLoader发生Exception", paramString);
      }
      if (paramString.getCause() == null) {}
    }
    for (paramString = paramString.getCause().getMessage();; paramString = paramString.getMessage())
    {
      throw new FailedException(2, "加载动态实现失败 cause：" + paramString);
      paramString = new LoaderImplLoader().load(localNotFoundException, paramString, getApplicationContext());
      paramString.setUuidManager(this.mUuidManager);
      this.mPluginLoader = paramString;
      return;
    }
  }
  
  /* Error */
  void loadRuntime(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 145	com/tencent/shadow/dynamic/host/PluginProcessService:checkUuidManagerNotNull	()V
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 147	com/tencent/shadow/dynamic/host/PluginProcessService:setUuid	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 36	com/tencent/shadow/dynamic/host/PluginProcessService:mRuntimeLoaded	Z
    //   13: ifeq +15 -> 28
    //   16: new 45	com/tencent/shadow/dynamic/host/FailedException
    //   19: dup
    //   20: bipush 7
    //   22: ldc 229
    //   24: invokespecial 50	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   27: athrow
    //   28: aload_0
    //   29: getfield 93	com/tencent/shadow/dynamic/host/PluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   32: invokeinterface 98 1 0
    //   37: ifeq +31 -> 68
    //   40: aload_0
    //   41: getfield 93	com/tencent/shadow/dynamic/host/PluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   44: new 66	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   51: ldc 231
    //   53: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokeinterface 103 2 0
    //   68: aload_0
    //   69: getfield 43	com/tencent/shadow/dynamic/host/PluginProcessService:mUuidManager	Lcom/tencent/shadow/dynamic/host/UuidManager;
    //   72: aload_1
    //   73: invokeinterface 234 2 0
    //   78: astore_2
    //   79: new 160	com/tencent/shadow/core/common/InstalledApk
    //   82: dup
    //   83: aload_2
    //   84: getfield 163	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   87: aload_2
    //   88: getfield 237	com/tencent/shadow/core/common/InstalledApk:oDexPath	Ljava/lang/String;
    //   91: aload_2
    //   92: getfield 240	com/tencent/shadow/core/common/InstalledApk:libraryPath	Ljava/lang/String;
    //   95: invokespecial 243	com/tencent/shadow/core/common/InstalledApk:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 248	com/tencent/shadow/dynamic/host/DynamicRuntime:loadRuntime	(Lcom/tencent/shadow/core/common/InstalledApk;)Z
    //   103: ifeq +8 -> 111
    //   106: aload_0
    //   107: aload_1
    //   108: invokestatic 252	com/tencent/shadow/dynamic/host/DynamicRuntime:saveLastRuntimeInfo	(Landroid/content/Context;Lcom/tencent/shadow/core/common/InstalledApk;)V
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 36	com/tencent/shadow/dynamic/host/PluginProcessService:mRuntimeLoaded	Z
    //   116: return
    //   117: astore_1
    //   118: new 45	com/tencent/shadow/dynamic/host/FailedException
    //   121: dup
    //   122: iconst_5
    //   123: aload_1
    //   124: invokevirtual 192	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   127: invokespecial 50	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: getfield 93	com/tencent/shadow/dynamic/host/PluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   136: invokeinterface 178 1 0
    //   141: ifeq +15 -> 156
    //   144: aload_0
    //   145: getfield 93	com/tencent/shadow/dynamic/host/PluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   148: ldc 254
    //   150: aload_1
    //   151: invokeinterface 184 3 0
    //   156: new 45	com/tencent/shadow/dynamic/host/FailedException
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 187	com/tencent/shadow/dynamic/host/FailedException:<init>	(Ljava/lang/RuntimeException;)V
    //   164: athrow
    //   165: astore_2
    //   166: new 45	com/tencent/shadow/dynamic/host/FailedException
    //   169: dup
    //   170: iconst_3
    //   171: new 66	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   178: ldc 194
    //   180: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 256
    //   190: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_2
    //   194: invokevirtual 197	com/tencent/shadow/dynamic/host/NotFoundException:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokespecial 50	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	PluginProcessService
    //   0	207	1	paramString	String
    //   78	14	2	localInstalledApk	InstalledApk
    //   165	29	2	localNotFoundException	NotFoundException
    // Exception table:
    //   from	to	target	type
    //   68	79	117	android/os/RemoteException
    //   28	68	131	java/lang/RuntimeException
    //   68	79	131	java/lang/RuntimeException
    //   79	111	131	java/lang/RuntimeException
    //   111	116	131	java/lang/RuntimeException
    //   118	131	131	java/lang/RuntimeException
    //   166	207	131	java/lang/RuntimeException
    //   68	79	165	com/tencent/shadow/dynamic/host/NotFoundException
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("onBind:" + this);
    }
    return this.mPpsControllerBinder;
  }
  
  void setUuidManager(UuidManager paramUuidManager)
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("setUuidManager uuidManager==" + paramUuidManager);
    }
    this.mUuidManager = paramUuidManager;
    if (this.mPluginLoader != null)
    {
      if (this.mLogger.isInfoEnabled()) {
        this.mLogger.info("更新mPluginLoader的uuidManager");
      }
      this.mPluginLoader.setUuidManager(paramUuidManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PluginProcessService
 * JD-Core Version:    0.7.0.1
 */