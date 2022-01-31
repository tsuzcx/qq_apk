package com.tencent.qqmini.sdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import begs;
import beox;
import bepk;
import besf;
import besl;

public class AppMainService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mini_process_name");
    paramIntent = (Messenger)paramIntent.getParcelableExtra("mini_process_messenger");
    besl.c("minisdk-start_AppMainService", "AppBrandMainService Service Binded. pName=" + str + " messenger:" + paramIntent);
    bepk.a().a().registerClientMessenger(str, paramIntent);
    return new beox(this, str);
  }
  
  public void onCreate()
  {
    besl.c("minisdk-start_AppMainService", "AppMainService Service onCreate~~~");
    begs.a(getApplicationContext());
    super.onCreate();
  }
  
  public void onDestroy()
  {
    besl.c("minisdk-start_AppMainService", "AppMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    besl.c("minisdk-start_AppMainService", "AppMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    besl.c("minisdk-start_AppMainService", "AppMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppMainService
 * JD-Core Version:    0.7.0.1
 */