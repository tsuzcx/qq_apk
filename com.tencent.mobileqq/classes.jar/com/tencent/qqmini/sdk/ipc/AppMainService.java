package com.tencent.qqmini.sdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import bdct;
import bdkt;
import bdnw;

public class AppMainService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("mini_process_name");
    bdnw.c("minisdk-start_AppMainService", "AppBrandMainService Service Binded. pName=" + paramIntent);
    return new bdkt(this, paramIntent);
  }
  
  public void onCreate()
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainService Service onCreate~~~");
    bdct.a(getApplicationContext(), null);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppMainService
 * JD-Core Version:    0.7.0.1
 */