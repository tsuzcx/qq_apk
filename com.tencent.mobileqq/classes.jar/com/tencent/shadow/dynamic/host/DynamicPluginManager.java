package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;

public final class DynamicPluginManager
  implements PluginManager
{
  private static final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
  private long mLastModified;
  private PluginManagerImpl mManagerImpl;
  private final PluginManagerUpdater mUpdater;
  
  public DynamicPluginManager(PluginManagerUpdater paramPluginManagerUpdater)
  {
    if (paramPluginManagerUpdater.getLatest() != null)
    {
      this.mUpdater = paramPluginManagerUpdater;
      return;
    }
    throw new IllegalArgumentException("构造DynamicPluginManager时传入的PluginManagerUpdater必须已经已有本地文件，即getLatest()!=null");
  }
  
  private void updateManagerImpl(Context paramContext)
  {
    Object localObject = this.mUpdater.getLatest();
    long l = ((File)localObject).lastModified();
    if (mLogger.isInfoEnabled())
    {
      Logger localLogger = mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLastModified != lastModified : ");
      boolean bool;
      if (this.mLastModified != l) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localLogger.info(localStringBuilder.toString());
    }
    if (this.mLastModified != l)
    {
      localObject = new ManagerImplLoader(paramContext, (File)localObject).load();
      if (this.mManagerImpl != null)
      {
        paramContext = new Bundle();
        this.mManagerImpl.onSaveInstanceState(paramContext);
        this.mManagerImpl.onDestroy();
      }
      else
      {
        paramContext = null;
      }
      ((PluginManagerImpl)localObject).onCreate(paramContext);
      this.mManagerImpl = ((PluginManagerImpl)localObject);
      this.mLastModified = l;
    }
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (mLogger.isInfoEnabled())
    {
      Logger localLogger = mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter fromId:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" callback:");
      localStringBuilder.append(paramEnterCallback);
      localLogger.info(localStringBuilder.toString());
    }
    updateManagerImpl(paramContext);
    if (mLogger.isInfoEnabled()) {
      mLogger.info("realEnter");
    }
    this.mManagerImpl.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    this.mUpdater.update();
  }
  
  public PluginManager getManagerImpl()
  {
    return this.mManagerImpl;
  }
  
  public void release()
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("release");
    }
    PluginManagerImpl localPluginManagerImpl = this.mManagerImpl;
    if (localPluginManagerImpl != null)
    {
      localPluginManagerImpl.onDestroy();
      this.mManagerImpl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicPluginManager
 * JD-Core Version:    0.7.0.1
 */