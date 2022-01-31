package com.tencent.shadow.proguard;

import android.app.Service;
import android.content.Intent;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

public abstract class c
  extends Service
{
  private static Object b = null;
  protected final Logger a = LoggerFactory.getLogger(getClass());
  
  public void onCreate()
  {
    if (b == null)
    {
      b = new Object();
      super.onCreate();
      if (this.a.isInfoEnabled()) {
        this.a.info("onCreate:" + this);
      }
      return;
    }
    throw new IllegalStateException("PPS出现多实例");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a.isInfoEnabled()) {
      this.a.info("onDestroy:" + this);
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    if (this.a.isInfoEnabled()) {
      this.a.info("onRebind:" + this);
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (this.a.isInfoEnabled()) {
      this.a.info("onTaskRemoved:" + this);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.a.isInfoEnabled()) {
      this.a.info("onUnbind:" + this);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.proguard.c
 * JD-Core Version:    0.7.0.1
 */