package com.tencent.qqmini.sdk.launcher;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppMainService
  extends Service
{
  public static final String BUNDLE_KEY_MESSENGER = "mini_process_messenger";
  public static final String BUNDLE_KEY_PROCESS_NAME = "mini_process_name";
  private static final String TAG = "minisdk-start_AppMainService";
  
  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mini_process_name");
    paramIntent = (Messenger)paramIntent.getParcelableExtra("mini_process_messenger");
    QMLog.w("minisdk-start_AppMainService", "AppBrandMainService Service Binded. pName=" + str + " messenger:" + paramIntent);
    AppLoaderFactory.g().getLaunchManager().registerClientMessenger(str, paramIntent);
    return AppLoaderFactory.g().createMainServiceBinder(this, str);
  }
  
  public void onCreate()
  {
    QMLog.w("minisdk-start_AppMainService", "AppMainService Service onCreate~~~");
    MiniSDK.init(getApplicationContext());
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QMLog.w("minisdk-start_AppMainService", "AppMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    QMLog.w("minisdk-start_AppMainService", "AppMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QMLog.w("minisdk-start_AppMainService", "AppMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppMainService
 * JD-Core Version:    0.7.0.1
 */