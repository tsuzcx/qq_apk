package com.tencent.mobileqq.vashealth;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;

public class PathTraceService
  extends Service
{
  static PathTraceService jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService;
  public static String a = "com.tencent.mobileqq.vashealth.PathTraceService.update";
  public static String b = "status";
  public static String c = "time";
  public static String d = "distance";
  private Notification jdField_a_of_type_AndroidAppNotification;
  private NotificationCompat.Builder jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder;
  private RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews;
  private QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  private PathTraceService.UpdateRunDataBroadCastReceiver jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver;
  
  public Notification a(Context paramContext, PendingIntent paramPendingIntent)
  {
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder = new NotificationCompat.Builder(paramContext);
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(paramContext.getPackageName(), 2131559506);
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContentIntent(paramPendingIntent);
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContentTitle("QQ运动");
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setSmallIcon(2130838319);
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130838319);
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception:");
        localStringBuilder.append(paramContext.toString());
        QLog.e("PathTraceManager.Service", 2, localStringBuilder.toString());
      }
      paramContext = null;
    }
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon(paramContext);
    }
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setOngoing(true);
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContent(this.jdField_a_of_type_AndroidWidgetRemoteViews);
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContentIntent(paramPendingIntent);
    this.jdField_a_of_type_AndroidAppNotification = this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.build();
    return this.jdField_a_of_type_AndroidAppNotification;
  }
  
  void a()
  {
    Intent localIntent = new Intent(this, PathTraceService.KernelService.class);
    try
    {
      stopService(localIntent);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService = this;
    QLog.d("PathTraceManager.Service", 1, "onCreate");
    a();
    if (Build.VERSION.SDK_INT < 18)
    {
      super.startForeground(237, new Notification());
      return;
    }
    Intent localIntent;
    if (Build.VERSION.SDK_INT < 25) {
      localIntent = new Intent(this, PathTraceService.KernelService.class);
    }
    try
    {
      startService(localIntent);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onDestroy()
  {
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    } else {
      a();
    }
    super.onDestroy();
    jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (Build.VERSION.SDK_INT >= 25)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver = new PathTraceService.UpdateRunDataBroadCastReceiver(this);
        localObject = new IntentFilter(jdField_a_of_type_JavaLangString);
        registerReceiver(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver, (IntentFilter)localObject);
      }
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      Object localObject = new ActivityURIRequest(this, "/base/start/splash");
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        ((ActivityURIRequest)localObject).extra().putAll(paramIntent);
      }
      QRoute.startUri((URIRequest)localObject, null);
      paramIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      paramIntent.putExtra("param_notifyid", 237);
      super.startForeground(237, a(this, PendingIntent.getActivity(this, 1, paramIntent, 268435456)));
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceService
 * JD-Core Version:    0.7.0.1
 */