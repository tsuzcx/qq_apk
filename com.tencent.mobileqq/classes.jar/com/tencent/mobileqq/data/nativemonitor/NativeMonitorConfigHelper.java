package com.tencent.mobileqq.data.nativemonitor;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeMonitorConfigHelper
{
  private static NativeMonitorConfig jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig = new NativeMonitorConfig();
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private static boolean c;
  
  public static NativeMonitorConfig a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!jdField_a_of_type_Boolean) || (!jdField_a_of_type_JavaLangString.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (paramQQAppInterface.contains(str + "_" + "native_monitor_config_version")) {
          a(paramQQAppInterface, str);
        }
        jdField_a_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 2, "NativeMonitorConfig:" + jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.toString());
    }
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig;
  }
  
  public static void a()
  {
    boolean bool = CPUReport.b();
    if ((!bool) || (Build.VERSION.SDK_INT >= 27) || (AppSetting.f)) {
      if (QLog.isColorLevel()) {
        QLog.i("NativeMonitorConfig", 2, "arm: " + bool + ", useASan: " + AppSetting.f);
      }
    }
    NativeMonitorConfig localNativeMonitorConfig;
    Object localObject;
    label182:
    long l1;
    do
    {
      do
      {
        return;
        localNativeMonitorConfig = a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      } while ((localNativeMonitorConfig == null) || (localNativeMonitorConfig.getNativeMonitorOpened() != 1));
      localObject = localNativeMonitorConfig.getAndroidVersionBlackList();
      long l2 = localNativeMonitorConfig.getSwitchFlag();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject != null)
        {
          String str = Build.VERSION.SDK_INT + "";
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label182;
            }
            if (str.equals(localObject[i])) {
              break;
            }
            i += 1;
          }
        }
      }
      l1 = l2;
      if (Build.VERSION.SDK_INT >= 21) {
        l1 = l2 & 0xFFFFFFFB;
      }
      localObject = localNativeMonitorConfig.getSoWhiteList().split("\\|");
    } while (localObject == null);
    a(BaseApplicationImpl.getContext(), l1, (String[])localObject, localNativeMonitorConfig.getTimeLimited(), localNativeMonitorConfig.getCountLimted(), localNativeMonitorConfig.getMemoryLimited());
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 173	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:b	Z
    //   6: istore 10
    //   8: iload 10
    //   10: ifeq +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: iconst_1
    //   18: putstatic 173	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:b	Z
    //   21: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 81
    //   29: iconst_2
    //   30: ldc 175
    //   32: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: invokestatic 181	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   39: aload_0
    //   40: lload_1
    //   41: aload_3
    //   42: lload 4
    //   44: lload 6
    //   46: lload 8
    //   48: invokevirtual 184	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:init	(Landroid/content/Context;J[Ljava/lang/String;JJJ)V
    //   51: goto -38 -> 13
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramContext	android.content.Context
    //   0	60	1	paramLong1	long
    //   0	60	3	paramArrayOfString	String[]
    //   0	60	4	paramLong2	long
    //   0	60	6	paramLong3	long
    //   0	60	8	paramLong4	long
    //   6	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	54	finally
    //   17	35	54	finally
    //   35	51	54	finally
  }
  
  private static void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString + "_" + "native_monitor_config_content", "");
    if (!TextUtils.isEmpty(paramSharedPreferences)) {}
    try
    {
      paramSharedPreferences = new JSONObject(paramSharedPreferences);
      paramSharedPreferences = (NativeMonitorConfig)JSONUtils.a(paramSharedPreferences, NativeMonitorConfig.class);
      if (paramSharedPreferences != null) {
        a(paramSharedPreferences);
      }
      return;
    }
    catch (JSONException paramSharedPreferences)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramSharedPreferences.printStackTrace();
        }
        paramSharedPreferences = null;
      }
    }
  }
  
  public static void a(NativeMonitorConfig paramNativeMonitorConfig)
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.update(paramNativeMonitorConfig);
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 216	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:c	Z
    //   6: ifne +13 -> 19
    //   9: getstatic 98	android/os/Build$VERSION:SDK_INT	I
    //   12: istore_0
    //   13: iload_0
    //   14: bipush 21
    //   16: if_icmpge +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 216	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:c	Z
    //   27: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +11 -> 41
    //   33: ldc 81
    //   35: iconst_2
    //   36: ldc 218
    //   38: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: invokestatic 159	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: invokestatic 181	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   47: ldc 220
    //   49: invokevirtual 223	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:initThreadHook	(Ljava/lang/String;)V
    //   52: goto -33 -> 19
    //   55: astore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	5	0	i	int
    //   55	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	55	finally
    //   23	41	55	finally
    //   41	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper
 * JD-Core Version:    0.7.0.1
 */