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
    if (this.mUuidManager != null) {
      return;
    }
    throw new FailedException(4, "mUuidManager == null");
  }
  
  public static Application.ActivityLifecycleCallbacks getActivityHolder()
  {
    return sActivityHolder;
  }
  
  private void setUuid(String paramString)
  {
    if (this.mUuid.isEmpty())
    {
      this.mUuid = paramString;
      return;
    }
    if (this.mUuid.equals(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("已设置过uuid==");
    localStringBuilder.append(this.mUuid);
    localStringBuilder.append("试图设置uuid==");
    localStringBuilder.append(paramString);
    throw new FailedException(6, localStringBuilder.toString());
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
    String str = this.mUuid;
    boolean bool3 = this.mRuntimeLoaded;
    PluginLoaderImpl localPluginLoaderImpl = this.mPluginLoader;
    boolean bool2 = true;
    boolean bool1;
    if (localPluginLoaderImpl != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.mUuidManager == null) {
      bool2 = false;
    }
    return new PpsStatus(str, bool3, bool1, bool2);
  }
  
  void loadPluginLoader(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (this.mLogger.isInfoEnabled())
    {
      localObject1 = this.mLogger;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadPluginLoader uuid:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" mPluginLoader:");
      ((StringBuilder)localObject2).append(this.mPluginLoader);
      ((Logger)localObject1).info(((StringBuilder)localObject2).toString());
    }
    checkUuidManagerNotNull();
    setUuid(paramString);
    if (this.mPluginLoader == null) {}
    try
    {
      localObject1 = this.mUuidManager.getPluginLoader(paramString);
      if (this.mLogger.isInfoEnabled())
      {
        localObject2 = this.mLogger;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("取出uuid==");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("的Loader apk:");
        localStringBuilder2.append(((InstalledApk)localObject1).apkFilePath);
        ((Logger)localObject2).info(localStringBuilder2.toString());
      }
      localObject2 = new File(((InstalledApk)localObject1).apkFilePath);
      if (((File)localObject2).exists())
      {
        paramString = new LoaderImplLoader().load((InstalledApk)localObject1, paramString, getApplicationContext());
        paramString.setUuidManager(this.mUuidManager);
        this.mPluginLoader = paramString;
        return;
      }
      paramString = new StringBuilder();
      paramString.append(((File)localObject2).getAbsolutePath());
      paramString.append("文件不存在");
      throw new FailedException(3, paramString.toString());
    }
    catch (NotFoundException localNotFoundException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uuid==");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("的PluginLoader没有找到。cause:");
      ((StringBuilder)localObject2).append(localNotFoundException.getMessage());
      throw new FailedException(3, ((StringBuilder)localObject2).toString());
    }
    catch (RemoteException paramString)
    {
      if (this.mLogger.isErrorEnabled()) {
        this.mLogger.error("获取Loader Apk失败", paramString);
      }
      throw new FailedException(5, paramString.getMessage());
      if (this.mLogger.isErrorEnabled()) {
        this.mLogger.error("loadPluginLoader发生Exception", paramString);
      }
      if (paramString.getCause() != null) {
        paramString = paramString.getCause().getMessage();
      } else {
        paramString = paramString.getMessage();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("加载动态实现失败 cause：");
      localStringBuilder1.append(paramString);
      throw new FailedException(2, localStringBuilder1.toString());
      throw paramString;
      if (this.mLogger.isErrorEnabled()) {
        this.mLogger.error("loadPluginLoader发生RuntimeException", paramString);
      }
      throw new FailedException(paramString);
      throw new FailedException(8, "重复调用loadPluginLoader");
    }
    catch (Exception paramString)
    {
      break label339;
    }
    catch (FailedException paramString)
    {
      label420:
      label422:
      break label420;
    }
    catch (RuntimeException paramString)
    {
      label339:
      break label422;
    }
  }
  
  void loadRuntime(String paramString)
  {
    checkUuidManagerNotNull();
    setUuid(paramString);
    if (!this.mRuntimeLoaded) {
      try
      {
        Object localObject;
        StringBuilder localStringBuilder;
        if (this.mLogger.isInfoEnabled())
        {
          localObject = this.mLogger;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadRuntime uuid:");
          localStringBuilder.append(paramString);
          ((Logger)localObject).info(localStringBuilder.toString());
        }
        try
        {
          localObject = this.mUuidManager.getRuntime(paramString);
          paramString = new InstalledApk(((InstalledApk)localObject).apkFilePath, ((InstalledApk)localObject).oDexPath, ((InstalledApk)localObject).libraryPath);
          if (DynamicRuntime.loadRuntime(paramString)) {
            DynamicRuntime.saveLastRuntimeInfo(this, paramString);
          }
          this.mRuntimeLoaded = true;
          return;
        }
        catch (NotFoundException localNotFoundException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("uuid==");
          localStringBuilder.append(paramString);
          localStringBuilder.append("的Runtime没有找到。cause:");
          localStringBuilder.append(localNotFoundException.getMessage());
          throw new FailedException(3, localStringBuilder.toString());
        }
        catch (RemoteException paramString)
        {
          throw new FailedException(5, paramString.getMessage());
        }
        throw new FailedException(7, "重复调用loadRuntime");
      }
      catch (RuntimeException paramString)
      {
        if (this.mLogger.isErrorEnabled()) {
          this.mLogger.error("loadRuntime发生RuntimeException", paramString);
        }
        throw new FailedException(paramString);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.mLogger.isInfoEnabled())
    {
      paramIntent = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBind:");
      localStringBuilder.append(this);
      paramIntent.info(localStringBuilder.toString());
    }
    return this.mPpsControllerBinder;
  }
  
  void setUuidManager(UuidManager paramUuidManager)
  {
    if (this.mLogger.isInfoEnabled())
    {
      Logger localLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUuidManager uuidManager==");
      localStringBuilder.append(paramUuidManager);
      localLogger.info(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PluginProcessService
 * JD-Core Version:    0.7.0.1
 */