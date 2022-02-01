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
    if (paramPluginManagerUpdater.getLatest() == null) {
      throw new IllegalArgumentException("构造DynamicPluginManager时传入的PluginManagerUpdater必须已经已有本地文件，即getLatest()!=null");
    }
    this.mUpdater = paramPluginManagerUpdater;
  }
  
  private void updateManagerImpl(Context paramContext)
  {
    Object localObject = this.mUpdater.getLatest();
    long l = ((File)localObject).lastModified();
    boolean bool;
    if (mLogger.isInfoEnabled())
    {
      Logger localLogger = mLogger;
      StringBuilder localStringBuilder = new StringBuilder().append("mLastModified != lastModified : ");
      if (this.mLastModified != l)
      {
        bool = true;
        localLogger.info(bool);
      }
    }
    else if (this.mLastModified != l)
    {
      localObject = new ManagerImplLoader(paramContext, (File)localObject).load();
      if (this.mManagerImpl == null) {
        break label160;
      }
      paramContext = new Bundle();
      this.mManagerImpl.onSaveInstanceState(paramContext);
      this.mManagerImpl.onDestroy();
    }
    for (;;)
    {
      ((PluginManagerImpl)localObject).onCreate(paramContext);
      this.mManagerImpl = ((PluginManagerImpl)localObject);
      this.mLastModified = l;
      return;
      bool = false;
      break;
      label160:
      paramContext = null;
    }
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (mLogger.isInfoEnabled()) {
      mLogger.info("enter fromId:" + paramLong + " callback:" + paramEnterCallback);
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
    if (this.mManagerImpl != null)
    {
      this.mManagerImpl.onDestroy();
      this.mManagerImpl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicPluginManager
 * JD-Core Version:    0.7.0.1
 */