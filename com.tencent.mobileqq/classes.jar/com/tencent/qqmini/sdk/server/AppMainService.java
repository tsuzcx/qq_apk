package com.tencent.qqmini.sdk.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;

@MiniKeep
public class AppMainService
  extends Service
{
  private static final String TAG = "AppMainService";
  
  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mini_process_name");
    paramIntent = (Messenger)paramIntent.getParcelableExtra("mini_process_messenger");
    QMLog.i("AppMainService", "AppBrandMainService Service Binded. pName=" + str + " messenger:" + paramIntent);
    IMiniServer localIMiniServer = AppLoaderFactory.g().getMiniServer();
    if (localIMiniServer != null)
    {
      localIMiniServer.registerClientMessenger(str, paramIntent);
      return localIMiniServer.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    MiniSDK.init(getApplicationContext());
    QMLog.i("AppMainService", "AppMainService Service onCreate~~~");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QMLog.i("AppMainService", "AppMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    QMLog.i("AppMainService", "AppMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QMLog.i("AppMainService", "AppMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.AppMainService
 * JD-Core Version:    0.7.0.1
 */