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
  private TBSOneStandaloneService.ServiceImpl a;
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.onBind(paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.a != null) {
      this.a.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.a != null) {
      this.a.onLowMemory();
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    if (this.a != null) {
      this.a.onRebind(paramIntent);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str = paramIntent.getStringExtra("implClassName");
    if ((!TextUtils.isEmpty(str)) && ((this.a == null) || (!this.a.getClass().getName().equals(str)))) {
      if (this.a != null)
      {
        this.a.onDestroy();
        this.a = null;
      }
    }
    try
    {
      this.a = ((TBSOneStandaloneService.ServiceImpl)Class.forName(str).newInstance());
      this.a.setBaseService(this);
      if (this.a != null) {
        this.a.onCreate();
      }
      if (this.a != null) {
        return this.a.onStartCommand(paramIntent, paramInt1, paramInt2);
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
    if (this.a != null) {
      this.a.onTaskRemoved(paramIntent);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.a != null) {
      this.a.onTrimMemory(paramInt);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.a == null) {
      return super.onUnbind(paramIntent);
    }
    return this.a.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneStandaloneService
 * JD-Core Version:    0.7.0.1
 */