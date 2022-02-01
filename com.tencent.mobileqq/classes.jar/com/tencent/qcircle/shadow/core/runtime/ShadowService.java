package com.tencent.qcircle.shadow.core.runtime;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

public abstract class ShadowService
  extends ShadowContext
{
  public final ShadowApplication getApplication()
  {
    return this.mShadowApplication;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onLowMemory() {}
  
  public void onRebind(Intent paramIntent) {}
  
  @Deprecated
  public void onStart(Intent paramIntent, int paramInt) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  public void onTaskRemoved(Intent paramIntent) {}
  
  public void onTrimMemory(int paramInt) {}
  
  public boolean onUnbind(Intent paramIntent)
  {
    return false;
  }
  
  @Deprecated
  public final void setForeground(boolean paramBoolean) {}
  
  public final void setHostContextAsBase(Context paramContext)
  {
    attachBaseContext(paramContext);
  }
  
  public final void startForeground(int paramInt, Notification paramNotification) {}
  
  public final void stopForeground(int paramInt) {}
  
  public final void stopForeground(boolean paramBoolean) {}
  
  public final void stopSelf()
  {
    stopService(new Intent(this, getClass()));
  }
  
  public final void stopSelf(int paramInt)
  {
    stopSelf();
  }
  
  public final boolean stopSelfResult(int paramInt)
  {
    stopSelf();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowService
 * JD-Core Version:    0.7.0.1
 */