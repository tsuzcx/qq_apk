package com.tencent.tbs.one.optional;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

public abstract class TBSOneStandaloneService$ServiceImpl
{
  protected Service mBaseService;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onLowMemory() {}
  
  public void onRebind(Intent paramIntent) {}
  
  public abstract int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
  
  public void onTaskRemoved(Intent paramIntent) {}
  
  public void onTrimMemory(int paramInt) {}
  
  public boolean onUnbind(Intent paramIntent)
  {
    return false;
  }
  
  public void setBaseService(Service paramService)
  {
    this.mBaseService = paramService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl
 * JD-Core Version:    0.7.0.1
 */