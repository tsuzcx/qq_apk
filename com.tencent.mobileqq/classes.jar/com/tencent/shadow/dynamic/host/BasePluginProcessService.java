package com.tencent.shadow.dynamic.host;

import android.app.Service;
import android.content.Intent;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

public abstract class BasePluginProcessService
  extends Service
{
  private static Object sSingleInstanceFlag = null;
  protected final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
  
  public void onCreate()
  {
    if (sSingleInstanceFlag == null)
    {
      sSingleInstanceFlag = new Object();
      super.onCreate();
      if (this.mLogger.isInfoEnabled()) {
        this.mLogger.info("onCreate:" + this);
      }
      return;
    }
    throw new IllegalStateException("PPS出现多实例");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("onDestroy:" + this);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("onRebind:" + this);
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("onTaskRemoved:" + this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("onUnbind:" + this);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.BasePluginProcessService
 * JD-Core Version:    0.7.0.1
 */