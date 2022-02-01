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
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl == null) {
      return null;
    }
    return localServiceImpl.onBind(paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl != null) {
      localServiceImpl.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl != null) {
      localServiceImpl.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl != null) {
      localServiceImpl.onLowMemory();
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl != null) {
      localServiceImpl.onRebind(paramIntent);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str = paramIntent.getStringExtra("implClassName");
    if (!TextUtils.isEmpty(str))
    {
      TBSOneStandaloneService.ServiceImpl localServiceImpl2 = this.a;
      if ((localServiceImpl2 == null) || (!localServiceImpl2.getClass().getName().equals(str)))
      {
        localServiceImpl2 = this.a;
        if (localServiceImpl2 != null)
        {
          localServiceImpl2.onDestroy();
          this.a = null;
        }
        try
        {
          this.a = ((TBSOneStandaloneService.ServiceImpl)Class.forName(str).newInstance());
          this.a.setBaseService(this);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        localServiceImpl1 = this.a;
        if (localServiceImpl1 != null) {
          localServiceImpl1.onCreate();
        }
      }
    }
    TBSOneStandaloneService.ServiceImpl localServiceImpl1 = this.a;
    if (localServiceImpl1 != null) {
      return localServiceImpl1.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl != null) {
      localServiceImpl.onTaskRemoved(paramIntent);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl != null) {
      localServiceImpl.onTrimMemory(paramInt);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    TBSOneStandaloneService.ServiceImpl localServiceImpl = this.a;
    if (localServiceImpl == null) {
      return super.onUnbind(paramIntent);
    }
    return localServiceImpl.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneStandaloneService
 * JD-Core Version:    0.7.0.1
 */