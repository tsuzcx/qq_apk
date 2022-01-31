package com.tencent.mobileqq.vashealth;

import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.tencent.qphone.base.util.QLog;

public class PathTraceService$KernelService
  extends Service
{
  private Notification a()
  {
    Notification localNotification = new Notification();
    localNotification.icon = 2130839189;
    localNotification.contentView = new RemoteViews(PathTraceService.a.getApplication().getPackageName(), 2130969244);
    startForeground(1, localNotification);
    return localNotification;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager.Service", 2, "KernelService.onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager.Service", 2, "KernelService.onDestroy");
    }
    try
    {
      super.stopForeground(true);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PathTraceManager.Service", 2, "destory failed");
        }
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (PathTraceService.a != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("PathTraceManager.Service", 2, "onStartCommand:");
      }
    }
    try
    {
      QLog.d("PathTraceManager.Service", 1, "PathTraceService startForeground");
      PathTraceService.a.startForeground(3216, a());
      super.startForeground(3216, a());
      super.stopForeground(true);
      return 2;
    }
    catch (Exception paramIntent)
    {
      QLog.d("PathTraceManager.Service", 1, "", paramIntent);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceService.KernelService
 * JD-Core Version:    0.7.0.1
 */