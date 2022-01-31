package com.tencent.qqmini.sdk.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import behj;
import bepo;
import beqb;
import besw;
import betc;

public class AppMainService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mini_process_name");
    paramIntent = (Messenger)paramIntent.getParcelableExtra("mini_process_messenger");
    betc.c("minisdk-start_AppMainService", "AppBrandMainService Service Binded. pName=" + str + " messenger:" + paramIntent);
    beqb.a().a().registerClientMessenger(str, paramIntent);
    return new bepo(this, str);
  }
  
  public void onCreate()
  {
    betc.c("minisdk-start_AppMainService", "AppMainService Service onCreate~~~");
    behj.a(getApplicationContext());
    super.onCreate();
  }
  
  public void onDestroy()
  {
    betc.c("minisdk-start_AppMainService", "AppMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    betc.c("minisdk-start_AppMainService", "AppMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    betc.c("minisdk-start_AppMainService", "AppMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppMainService
 * JD-Core Version:    0.7.0.1
 */