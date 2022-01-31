package com.tencent.mobileqq.webprocess;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class WebCoreService
  extends Service
{
  private static final int jdField_a_of_type_Int = ;
  private static WebCoreService jdField_a_of_type_ComTencentMobileqqWebprocessWebCoreService;
  public static boolean a;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_0
    //   7: new 34	android/content/Intent
    //   10: dup
    //   11: aload_0
    //   12: ldc 2
    //   14: invokespecial 37	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   17: astore_1
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 43	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   23: pop
    //   24: iconst_1
    //   25: putstatic 45	com/tencent/mobileqq/webprocess/WebCoreService:jdField_a_of_type_Boolean	Z
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -8 -> 28
    //   39: ldc 53
    //   41: iconst_2
    //   42: ldc 55
    //   44: aload_0
    //   45: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -20 -> 28
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	13	0	localBaseApplicationImpl	BaseApplicationImpl
    //   32	13	0	localThrowable	Throwable
    //   51	5	0	localObject	java.lang.Object
    //   17	3	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   18	28	32	java/lang/Throwable
    //   3	18	51	finally
    //   18	28	51	finally
    //   33	48	51	finally
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 34	android/content/Intent
    //   6: dup
    //   7: getstatic 32	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: ldc 2
    //   12: invokespecial 37	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_0
    //   16: invokestatic 64	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: invokevirtual 70	com/tencent/qphone/base/util/BaseApplication:stopService	(Landroid/content/Intent;)Z
    //   23: pop
    //   24: iconst_0
    //   25: putstatic 45	com/tencent/mobileqq/webprocess/WebCoreService:jdField_a_of_type_Boolean	Z
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -8 -> 28
    //   39: ldc 53
    //   41: iconst_2
    //   42: ldc 55
    //   44: aload_0
    //   45: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -20 -> 28
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	5	0	localIntent	Intent
    //   32	13	0	localThrowable	Throwable
    //   51	5	0	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	28	32	java/lang/Throwable
    //   3	16	51	finally
    //   16	28	51	finally
    //   33	48	51	finally
  }
  
  public static void c()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication, WebCoreService.KernelService.class);
      try
      {
        BaseApplicationImpl.getContext().startService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebCoreService", 2, "", localThrowable);
  }
  
  public static void d()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication, WebCoreService.KernelService.class);
      try
      {
        BaseApplicationImpl.getContext().stopService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebCoreService", 2, "", localThrowable);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    jdField_a_of_type_ComTencentMobileqqWebprocessWebCoreService = this;
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "WebCoreService.onCreate " + Build.VERSION.SDK_INT);
    }
    super.onCreate();
    d();
    if (Build.VERSION.SDK_INT < 18) {
      super.startForeground(jdField_a_of_type_Int, new Notification());
    }
    while (Build.VERSION.SDK_INT >= 25) {
      return;
    }
    c();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebCoreService", 2, "WebCoreService.onDestroy");
    }
    if (Build.VERSION.SDK_INT < 18) {
      super.stopForeground(true);
    }
    for (;;)
    {
      super.onDestroy();
      jdField_a_of_type_ComTencentMobileqqWebprocessWebCoreService = null;
      return;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebCoreService
 * JD-Core Version:    0.7.0.1
 */