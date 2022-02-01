package com.tencent.shadow.dynamic.host;

import android.app.Service;
import android.content.Intent;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

public abstract class BasePluginProcessService
  extends Service
{
  private static Object sSingleInstanceFlag;
  protected final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
  
  public void onCreate()
  {
    if (sSingleInstanceFlag == null)
    {
      sSingleInstanceFlag = new Object();
      super.onCreate();
      if (this.mLogger.isInfoEnabled())
      {
        Logger localLogger = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate:");
        localStringBuilder.append(this);
        localLogger.info(localStringBuilder.toString());
      }
      return;
    }
    throw new IllegalStateException("PPS出现多实例");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mLogger.isInfoEnabled())
    {
      Logger localLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy:");
      localStringBuilder.append(this);
      localLogger.info(localStringBuilder.toString());
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    if (this.mLogger.isInfoEnabled())
    {
      paramIntent = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRebind:");
      localStringBuilder.append(this);
      paramIntent.info(localStringBuilder.toString());
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (this.mLogger.isInfoEnabled())
    {
      paramIntent = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTaskRemoved:");
      localStringBuilder.append(this);
      paramIntent.info(localStringBuilder.toString());
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.mLogger.isInfoEnabled())
    {
      Logger localLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUnbind:");
      localStringBuilder.append(this);
      localLogger.info(localStringBuilder.toString());
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.BasePluginProcessService
 * JD-Core Version:    0.7.0.1
 */