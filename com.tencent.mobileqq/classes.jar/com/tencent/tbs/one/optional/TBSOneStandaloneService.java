package com.tencent.tbs.one.optional;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class TBSOneStandaloneService
  extends Service
{
  public static final String IMPL_CLASS_NAME_KEY = "implClassName";
  private TBSOneStandaloneService.ServiceImpl mServiceImpl;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    if (this.mServiceImpl == null) {
      return null;
    }
    return this.mServiceImpl.onBind(paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mServiceImpl != null) {
      this.mServiceImpl.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    if (this.mServiceImpl != null) {
      this.mServiceImpl.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.mServiceImpl != null) {
      this.mServiceImpl.onLowMemory();
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    if (this.mServiceImpl != null) {
      this.mServiceImpl.onRebind(paramIntent);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str = paramIntent.getStringExtra("implClassName");
    if ((!TextUtils.isEmpty(str)) && ((this.mServiceImpl == null) || (!this.mServiceImpl.getClass().getName().equals(str)))) {
      if (this.mServiceImpl != null)
      {
        this.mServiceImpl.onDestroy();
        this.mServiceImpl = null;
      }
    }
    try
    {
      this.mServiceImpl = ((TBSOneStandaloneService.ServiceImpl)Class.forName(str).newInstance());
      this.mServiceImpl.setBaseService(this);
      if (this.mServiceImpl != null) {
        this.mServiceImpl.onCreate();
      }
      if (this.mServiceImpl != null) {
        return this.mServiceImpl.onStartCommand(paramIntent, paramInt1, paramInt2);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (this.mServiceImpl != null) {
      this.mServiceImpl.onTaskRemoved(paramIntent);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.mServiceImpl != null) {
      this.mServiceImpl.onTrimMemory(paramInt);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.mServiceImpl == null) {
      return super.onUnbind(paramIntent);
    }
    return this.mServiceImpl.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneStandaloneService
 * JD-Core Version:    0.7.0.1
 */