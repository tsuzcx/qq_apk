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
  static PathTraceService a;
  public static String b = "com.tencent.mobileqq.vashealth.PathTraceService.update";
  public static String c = "status";
  public static String d = "time";
  public static String e = "distance";
  private PathTraceService.UpdateRunDataBroadCastReceiver f;
  private RemoteViews g;
  private NotificationCompat.Builder h;
  private QQNotificationManager i;
  private Notification j;
  
  public Notification a(Context paramContext, PendingIntent paramPendingIntent)
  {
    this.h = new NotificationCompat.Builder(paramContext);
    this.g = new RemoteViews(paramContext.getPackageName(), 2131625528);
    this.h.setContentIntent(paramPendingIntent);
    this.h.setContentTitle("QQ运动");
    this.h.setSmallIcon(2130838367);
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130838367);
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
      this.h.setLargeIcon(paramContext);
    }
    this.h.setOngoing(true);
    this.h.setContent(this.g);
    this.h.setContentIntent(paramPendingIntent);
    this.j = this.h.build();
    return this.j;
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
    a = this;
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
    a = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    if (Build.VERSION.SDK_INT >= 25)
    {
      if (this.f == null)
      {
        this.f = new PathTraceService.UpdateRunDataBroadCastReceiver(this);
        localObject = new IntentFilter(b);
        registerReceiver(this.f, (IntentFilter)localObject);
      }
      this.i = QQNotificationManager.getInstance();
      Object localObject = new ActivityURIRequest(this, "/base/start/splash");
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceService
 * JD-Core Version:    0.7.0.1
 */