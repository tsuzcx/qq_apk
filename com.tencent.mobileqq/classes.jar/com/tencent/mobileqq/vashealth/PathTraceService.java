package com.tencent.mobileqq.vashealth;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class PathTraceService
  extends Service
{
  static PathTraceService jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService;
  public static String a;
  public static String b = "status";
  public static String c = "time";
  public static String d = "distance";
  private Notification jdField_a_of_type_AndroidAppNotification;
  private NotificationCompat.Builder jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder;
  private RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews;
  private QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  private PathTraceService.UpdateRunDataBroadCastReceiver jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver;
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.vashealth.PathTraceService.update";
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 58	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_0
    //   7: new 60	android/content/Intent
    //   10: dup
    //   11: aload_0
    //   12: ldc 2
    //   14: invokespecial 63	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 69	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: astore_0
    //   29: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -8 -> 24
    //   35: ldc 77
    //   37: iconst_2
    //   38: ldc 79
    //   40: aload_0
    //   41: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   44: goto -20 -> 24
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	13	0	localBaseApplicationImpl	com.tencent.common.app.BaseApplicationImpl
    //   28	13	0	localThrowable	Throwable
    //   47	5	0	localObject	java.lang.Object
    //   17	3	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   18	24	28	java/lang/Throwable
    //   3	18	47	finally
    //   18	24	47	finally
    //   29	44	47	finally
  }
  
  /* Error */
  public static void c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 60	android/content/Intent
    //   6: dup
    //   7: getstatic 58	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: ldc 2
    //   12: invokespecial 63	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_0
    //   16: invokestatic 86	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: invokevirtual 92	com/tencent/qphone/base/util/BaseApplication:stopService	(Landroid/content/Intent;)Z
    //   23: pop
    //   24: ldc 77
    //   26: iconst_1
    //   27: ldc 94
    //   29: invokestatic 98	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq -16 -> 24
    //   43: ldc 77
    //   45: iconst_2
    //   46: ldc 79
    //   48: aload_0
    //   49: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: goto -28 -> 24
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	5	0	localIntent	Intent
    //   36	13	0	localThrowable	Throwable
    //   55	5	0	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	24	36	java/lang/Throwable
    //   3	16	55	finally
    //   16	24	55	finally
    //   24	32	55	finally
    //   37	52	55	finally
  }
  
  public Notification a(Context paramContext, PendingIntent paramPendingIntent)
  {
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder = new NotificationCompat.Builder(paramContext);
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(paramContext.getPackageName(), 2131559399);
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContentIntent(paramPendingIntent);
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContentTitle("QQ运动");
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setSmallIcon(2130838247);
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130838247);
      if (paramContext != null) {
        this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon(paramContext);
      }
      this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setOngoing(true);
      this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContent(this.jdField_a_of_type_AndroidWidgetRemoteViews);
      this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setContentIntent(paramPendingIntent);
      this.jdField_a_of_type_AndroidAppNotification = this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.build();
      return this.jdField_a_of_type_AndroidAppNotification;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PathTraceManager.Service", 2, "Exception:" + paramContext.toString());
        }
        paramContext = null;
      }
    }
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
    if (Build.VERSION.SDK_INT < 18) {
      super.startForeground(237, new Notification());
    }
    while (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    Intent localIntent = new Intent(this, PathTraceService.KernelService.class);
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
    }
    for (;;)
    {
      super.onDestroy();
      jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService = null;
      return;
      a();
    }
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
        paramIntent = new IntentFilter(jdField_a_of_type_JavaLangString);
        registerReceiver(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceService$UpdateRunDataBroadCastReceiver, paramIntent);
      }
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      paramIntent = new Intent(this, SplashActivity.class);
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