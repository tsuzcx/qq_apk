package com.tencent.mobileqq.mini.launch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

public class AppBrandMainService
  extends Service
{
  public static final String BUNDLE_KEY_PROCESS_NAME = "mini_process_name";
  private static final String TAG = "miniapp-process_AppBrandMainService";
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("mini_process_name");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService Service Binded. pName=");
    localStringBuilder.append(paramIntent);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    return new AppBrandMainService.AppBrandMainServiceBinder(this, paramIntent);
  }
  
  public void onCreate()
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onCreate~~~");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.w("miniapp-process_AppBrandMainService", 1, "AppBrandMainService Service onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandMainService
 * JD-Core Version:    0.7.0.1
 */