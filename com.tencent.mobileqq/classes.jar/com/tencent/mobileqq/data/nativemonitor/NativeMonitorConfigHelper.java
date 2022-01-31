package com.tencent.mobileqq.data.nativemonitor;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeMonitorConfigHelper
{
  private static NativeMonitorConfig jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig = new NativeMonitorConfig();
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private static boolean c;
  
  public static NativeMonitorConfig a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!jdField_a_of_type_Boolean) || (!jdField_a_of_type_JavaLangString.equals(str)))
      {
        paramAppRuntime = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        if (paramAppRuntime.contains(str + "_" + "native_monitor_config_version")) {
          a(paramAppRuntime, str);
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
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 90	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:c	Z
    //   6: ifne +13 -> 19
    //   9: getstatic 96	android/os/Build$VERSION:SDK_INT	I
    //   12: istore_0
    //   13: iload_0
    //   14: bipush 21
    //   16: if_icmpge +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 90	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:c	Z
    //   27: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +11 -> 41
    //   33: ldc 81
    //   35: iconst_2
    //   36: ldc 98
    //   38: invokestatic 101	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: invokestatic 113	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   47: ldc 115
    //   49: invokevirtual 119	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:initThreadHook	(Ljava/lang/String;)V
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
  
  /* Error */
  public static void a(android.content.Context paramContext, long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 122	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:b	Z
    //   6: istore 10
    //   8: iload 10
    //   10: ifeq +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: iconst_1
    //   18: putstatic 122	com/tencent/mobileqq/data/nativemonitor/NativeMonitorConfigHelper:b	Z
    //   21: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 81
    //   29: iconst_2
    //   30: ldc 124
    //   32: invokestatic 101	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: invokestatic 113	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   39: aload_0
    //   40: lload_1
    //   41: aload_3
    //   42: lload 4
    //   44: lload 6
    //   46: lload 8
    //   48: invokevirtual 127	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:init	(Landroid/content/Context;J[Ljava/lang/String;JJJ)V
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
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = SharedPreUtils.aW(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = SharedPreUtils.aX(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.a;
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 1, String.format("received nativeMonitorConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      SharedPreUtils.ai(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
      i = 0;
    }
    String str;
    if (j != i)
    {
      str = ConfigServlet.b(paramConfig, i, paramInt);
      if (!TextUtils.isEmpty(str)) {
        QLog.d("NativeMonitorConfig", 1, "receiveAllConfigs|type: " + paramInt + ",content: " + str + ",version: " + j);
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(str);
        paramConfig = (NativeMonitorConfig)JSONUtils.a(paramConfig, NativeMonitorConfig.class);
        if (paramConfig == null)
        {
          a(new NativeMonitorConfig());
          SharedPreUtils.d(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
          QLog.d("NativeMonitorConfig", 1, "Resolve Config failure, use default config");
          a(true);
          return;
        }
      }
      catch (JSONException paramConfig)
      {
        if (QLog.isDevelopLevel()) {
          paramConfig.printStackTrace();
        }
        paramConfig = null;
        continue;
        QLog.d("NativeMonitorConfig", 1, "start to update config:" + paramConfig.toString());
        if (paramConfig.getTimeLimited() <= 0L)
        {
          paramConfig.setTimeLimitedDefault();
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "time limited is too small, setToDefault");
          }
        }
        if (paramConfig.getMemoryLimited() <= 0L)
        {
          paramConfig.setMemoryLimitedDefault();
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "memory limited is too small, setToDefault");
          }
        }
        if (paramConfig.getCountLimted() <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "count limited is too small, setToDefault");
          }
          paramConfig.setCountLimitedDefault();
        }
        a(paramConfig);
        SharedPreUtils.d(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, str);
        continue;
      }
      a(new NativeMonitorConfig());
      SharedPreUtils.d(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
      QLog.d("NativeMonitorConfig", 1, "config is null, use default config");
      continue;
      QLog.d("NativeMonitorConfig", 1, "config version not updated, nothing to do");
    }
  }
  
  public static void a(NativeMonitorConfig paramNativeMonitorConfig)
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.update(paramNativeMonitorConfig);
  }
  
  public static void a(boolean paramBoolean)
  {
    paramBoolean = CPUReport.b();
    if ((!paramBoolean) || (Build.VERSION.SDK_INT > 27) || (Build.VERSION.SDK_INT <= 15) || (AppSetting.f)) {
      if (QLog.isColorLevel()) {
        QLog.i("NativeMonitorConfig", 2, "arm: " + paramBoolean + ", useASan: " + AppSetting.f);
      }
    }
    NativeMonitorConfig localNativeMonitorConfig;
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 21)
      {
        QLog.i("NativeMonitorConfig", 1, "skip in release");
        return;
      }
      localNativeMonitorConfig = a(BaseApplicationImpl.getApplication().getRuntime());
    } while ((localNativeMonitorConfig == null) || (localNativeMonitorConfig.getNativeMonitorOpened() != 1));
    Object localObject = localNativeMonitorConfig.getAndroidVersionBlackList();
    long l2 = localNativeMonitorConfig.getSwitchFlag();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject != null)
      {
        str = Build.VERSION.SDK_INT + "";
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label208;
          }
          if (str.equals(localObject[i])) {
            break;
          }
          i += 1;
        }
      }
    }
    label208:
    if (a(localNativeMonitorConfig))
    {
      QLog.i("NativeMonitorConfig", 1, "process id:" + BaseApplicationImpl.sProcessId + "  is in black list");
      return;
    }
    QLog.i("NativeMonitorConfig", 1, "process id:" + BaseApplicationImpl.sProcessId + "  not in black list");
    long l1 = l2;
    if (Build.VERSION.SDK_INT >= 21) {
      l1 = l2 & 0xFFFFFFFB;
    }
    String str = localNativeMonitorConfig.getSoWhiteList();
    localObject = str;
    if (str != null) {
      localObject = str.trim();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (localObject = null;; localObject = ((String)localObject).split("\\|"))
    {
      a(BaseApplicationImpl.getContext(), l1, (String[])localObject, localNativeMonitorConfig.getTimeLimited(), localNativeMonitorConfig.getCountLimted(), localNativeMonitorConfig.getMemoryLimited());
      return;
    }
  }
  
  private static boolean a(@NonNull NativeMonitorConfig paramNativeMonitorConfig)
  {
    boolean bool2 = false;
    paramNativeMonitorConfig = paramNativeMonitorConfig.getProcessBlackList();
    boolean bool1;
    int j;
    int i;
    if (TextUtils.isEmpty(paramNativeMonitorConfig))
    {
      paramNativeMonitorConfig = null;
      bool1 = bool2;
      if (paramNativeMonitorConfig != null)
      {
        j = paramNativeMonitorConfig.length;
        i = 0;
      }
    }
    label97:
    for (;;)
    {
      bool1 = bool2;
      String str;
      if (i < j) {
        str = paramNativeMonitorConfig[i];
      }
      try
      {
        int k = Integer.valueOf(str).intValue();
        if (k != BaseApplicationImpl.sProcessId) {
          break label97;
        }
        bool1 = true;
        return bool1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (!QLog.isColorLevel()) {
          break label97;
        }
        QLog.d("NativeMonitorConfig", 2, localNumberFormatException, new Object[0]);
        i += 1;
      }
      paramNativeMonitorConfig = paramNativeMonitorConfig.split("\\|");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper
 * JD-Core Version:    0.7.0.1
 */