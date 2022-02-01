package com.tencent.mobileqq.webprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.qphone.base.util.QLog;

public class WebCoreService$KernelService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "KernelService.onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "KernelService.onDestroy");
    }
    try
    {
      super.stopForeground(true);
      label19:
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (WebCoreService.a() != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreService", 2, "KernelService.onStartCommand");
      }
    }
    try
    {
      WebCoreService.a().startForeground(WebCoreService.a(), CoreService.fakeNotification(true));
      super.startForeground(WebCoreService.a(), CoreService.fakeNotification(false));
      WebCoreService.a().stopForeground(true);
      return 2;
    }
    catch (Exception paramIntent)
    {
      QLog.d("WebCoreService", 1, "", paramIntent);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebCoreService.KernelService
 * JD-Core Version:    0.7.0.1
 */