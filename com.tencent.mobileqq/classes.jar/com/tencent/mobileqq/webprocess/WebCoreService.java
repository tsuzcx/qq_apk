package com.tencent.mobileqq.webprocess;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class WebCoreService
  extends Service
{
  private static final int jdField_a_of_type_Int = ;
  private static WebCoreService jdField_a_of_type_ComTencentMobileqqWebprocessWebCoreService = null;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      Intent localIntent = new Intent(localBaseApplication, WebCoreService.class);
      try
      {
        localBaseApplication.startService(localIntent);
        jdField_a_of_type_Boolean = true;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreService", 2, "", localThrowable);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void b()
  {
    try
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), WebCoreService.class);
      try
      {
        BaseApplication.getContext().stopService(localIntent);
        jdField_a_of_type_Boolean = false;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreService", 2, "", localThrowable);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void c()
  {
    if (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), WebCoreService.KernelService.class);
    try
    {
      BaseApplication.getContext().startService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreService", 2, "", localThrowable);
      }
    }
  }
  
  public static void d()
  {
    if (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), WebCoreService.KernelService.class);
    try
    {
      BaseApplication.getContext().stopService(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreService", 2, "", localThrowable);
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    jdField_a_of_type_ComTencentMobileqqWebprocessWebCoreService = this;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebCoreService.onCreate ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.d("WebCoreService", 2, localStringBuilder.toString());
    }
    super.onCreate();
    d();
    if (Build.VERSION.SDK_INT < 18)
    {
      super.startForeground(jdField_a_of_type_Int, new Notification());
      return;
    }
    if (Build.VERSION.SDK_INT < 25) {
      c();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "WebCoreService.onDestroy");
    }
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    } else {
      d();
    }
    super.onDestroy();
    jdField_a_of_type_ComTencentMobileqqWebprocessWebCoreService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebCoreService
 * JD-Core Version:    0.7.0.1
 */