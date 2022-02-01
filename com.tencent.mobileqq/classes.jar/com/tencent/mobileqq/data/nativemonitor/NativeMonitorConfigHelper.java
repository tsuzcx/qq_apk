package com.tencent.mobileqq.data.nativemonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeMonitorConfigHelper
{
  private static NativeMonitorConfig jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig = new NativeMonitorConfig();
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean = false;
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = false;
  
  private static NativeMonitorConfig a(SharedPreferences paramSharedPreferences, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("native_monitor_config_content");
    paramSharedPreferences = paramSharedPreferences.getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty(paramSharedPreferences))
    {
      try
      {
        paramSharedPreferences = new JSONObject(paramSharedPreferences);
      }
      catch (JSONException paramSharedPreferences)
      {
        if (QLog.isDevelopLevel()) {
          paramSharedPreferences.printStackTrace();
        }
        paramSharedPreferences = null;
      }
      return (NativeMonitorConfig)JSONConverter.a(paramSharedPreferences, NativeMonitorConfig.class);
    }
    return null;
  }
  
  public static NativeMonitorConfig a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!jdField_a_of_type_Boolean) || (!jdField_a_of_type_JavaLangString.equals(str)))
      {
        paramAppRuntime = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("native_monitor_config_version");
        if (paramAppRuntime.contains(localStringBuilder.toString()))
        {
          paramAppRuntime = a(paramAppRuntime, str);
          if (paramAppRuntime != null) {
            a(paramAppRuntime);
          }
        }
        jdField_a_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("NativeMonitorConfig:");
      paramAppRuntime.append(jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.toString());
      QLog.d("NativeMonitorConfig", 2, paramAppRuntime.toString());
    }
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig;
  }
  
  public static void a()
  {
    try
    {
      if ((!c) && (Build.VERSION.SDK_INT >= 21))
      {
        c = true;
        if (QLog.isColorLevel()) {
          QLog.i("NativeMonitorConfig", 2, "startHookThreadCreate");
        }
        NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).initThreadHook("com/tencent/mobileqq/app/JobReporter");
        return;
      }
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext, long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    try
    {
      boolean bool = b;
      if (bool) {
        return;
      }
      b = true;
      if (QLog.isColorLevel()) {
        QLog.i("NativeMonitorConfig", 2, "start hook native after config ready");
      }
      NativeMemoryMonitor.getInstance(paramContext).init(paramLong1, paramArrayOfString, paramLong2, paramLong3, paramLong4);
      return;
    }
    finally {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = SharedPreUtils.aA(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = SharedPreUtils.aB(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 1, String.format("received nativeMonitorConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      SharedPreUtils.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
      i = 0;
    }
    if (j != i)
    {
      String str = ConfigServlet.b(paramConfig, i, paramInt);
      if (!TextUtils.isEmpty(str))
      {
        paramConfig = new StringBuilder();
        paramConfig.append("receiveAllConfigs|type: ");
        paramConfig.append(paramInt);
        paramConfig.append(",content: ");
        paramConfig.append(str);
        paramConfig.append(",version: ");
        paramConfig.append(j);
        QLog.d("NativeMonitorConfig", 1, paramConfig.toString());
        StringBuilder localStringBuilder = null;
        try
        {
          paramConfig = new JSONObject(str);
        }
        catch (JSONException localJSONException)
        {
          paramConfig = localStringBuilder;
          if (QLog.isDevelopLevel())
          {
            localJSONException.printStackTrace();
            paramConfig = localStringBuilder;
          }
        }
        paramConfig = (NativeMonitorConfig)JSONConverter.a(paramConfig, NativeMonitorConfig.class);
        if (paramConfig == null)
        {
          a(new NativeMonitorConfig());
          SharedPreUtils.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
          SharedPreUtils.t(paramQQAppInterface.getApp(), 0);
          QLog.d("NativeMonitorConfig", 1, "Resolve Config failure, use default config");
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("start to update config:");
          localStringBuilder.append(paramConfig.toString());
          QLog.d("NativeMonitorConfig", 1, localStringBuilder.toString());
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
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("soHook = ");
            localStringBuilder.append(paramConfig.soHook);
            QLog.d("NativeMonitorConfig", 2, localStringBuilder.toString());
          }
          a(paramConfig);
          SharedPreUtils.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, str);
          SharedPreUtils.t(paramQQAppInterface.getApp(), paramConfig.soHook);
        }
      }
      else
      {
        a(new NativeMonitorConfig());
        SharedPreUtils.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
        SharedPreUtils.t(paramQQAppInterface.getApp(), 0);
        QLog.d("NativeMonitorConfig", 1, "config is null, use default config");
      }
    }
    else
    {
      QLog.d("NativeMonitorConfig", 1, "config version not updated, nothing to do");
    }
    a(true);
  }
  
  public static void a(NativeMonitorConfig paramNativeMonitorConfig)
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.update(paramNativeMonitorConfig);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (AppSetting.h)
    {
      NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupASanCallback();
      return;
    }
    paramBoolean = CPUReport.b();
    Object localObject1;
    if ((paramBoolean) && (Build.VERSION.SDK_INT <= 27) && (Build.VERSION.SDK_INT > 15) && (!AppSetting.h))
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        QLog.i("NativeMonitorConfig", 1, "skip in release");
        return;
      }
      NativeMonitorConfig localNativeMonitorConfig = a(BaseApplicationImpl.getApplication().getRuntime());
      if (localNativeMonitorConfig != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("open: ");
        ((StringBuilder)localObject1).append(localNativeMonitorConfig.getNativeMonitorOpened());
        ((StringBuilder)localObject1).append(", flag: ");
        ((StringBuilder)localObject1).append(localNativeMonitorConfig.getSwitchFlag());
        BaseApplicationImpl.sNativeMonitorEscapedMsg = ((StringBuilder)localObject1).toString();
        ThreadManagerInitialler.initShotChanceForPublicVersion(jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.getTmChance());
      }
      if ((localNativeMonitorConfig != null) && (localNativeMonitorConfig.getNativeMonitorOpened() == 1))
      {
        localObject1 = localNativeMonitorConfig.getAndroidVersionBlackList();
        long l2 = localNativeMonitorConfig.getSwitchFlag();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              if (((String)localObject2).equals(localObject1[i])) {
                return;
              }
              i += 1;
            }
          }
        }
        if (a(localNativeMonitorConfig))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("process id:");
          ((StringBuilder)localObject1).append(BaseApplicationImpl.sProcessId);
          ((StringBuilder)localObject1).append("  is in black list");
          QLog.i("NativeMonitorConfig", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("process id:");
        ((StringBuilder)localObject1).append(BaseApplicationImpl.sProcessId);
        ((StringBuilder)localObject1).append("  not in black list");
        QLog.i("NativeMonitorConfig", 1, ((StringBuilder)localObject1).toString());
        long l1 = l2;
        if (Build.VERSION.SDK_INT >= 21) {
          l1 = l2 & 0xFFFFFFFB;
        }
        l2 = l1;
        if (Build.VERSION.SDK_INT != 21)
        {
          l2 = l1;
          if (Build.VERSION.SDK_INT != 22) {
            l2 = l1 & 0xFFFFFFBF;
          }
        }
        Object localObject2 = localNativeMonitorConfig.getSoWhiteList();
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = ((String)localObject2).trim();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((String)localObject1).split("\\|");
        }
        a(BaseApplicationImpl.getContext(), 0xFFFFFFFF & l2 & 0x7FFFFFFF & 0xFFFFFFFD, null, localNativeMonitorConfig.getTimeLimited(), localNativeMonitorConfig.getCountLimted(), localNativeMonitorConfig.getMemoryLimited());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arm: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", useASan: ");
      ((StringBuilder)localObject1).append(AppSetting.h);
      QLog.i("NativeMonitorConfig", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private static boolean a(@NonNull NativeMonitorConfig paramNativeMonitorConfig)
  {
    paramNativeMonitorConfig = paramNativeMonitorConfig.getProcessBlackList();
    if (TextUtils.isEmpty(paramNativeMonitorConfig)) {
      paramNativeMonitorConfig = null;
    } else {
      paramNativeMonitorConfig = paramNativeMonitorConfig.split("\\|");
    }
    if (paramNativeMonitorConfig != null)
    {
      int j = paramNativeMonitorConfig.length;
      int i = 0;
      while (i < j)
      {
        String str = paramNativeMonitorConfig[i];
        try
        {
          int k = Integer.valueOf(str).intValue();
          if (k == BaseApplicationImpl.sProcessId) {
            return true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, localNumberFormatException, new Object[0]);
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  /* Error */
  private static String b(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 396	java/io/File:isFile	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: sipush 4096
    //   12: newarray byte
    //   14: astore 4
    //   16: ldc_w 398
    //   19: invokestatic 403	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore_3
    //   23: new 405	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 408	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_0
    //   34: aload_2
    //   35: aload 4
    //   37: iconst_0
    //   38: aload 4
    //   40: arraylength
    //   41: invokevirtual 412	java/io/FileInputStream:read	([BII)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +16 -> 63
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_1
    //   57: invokevirtual 415	java/security/MessageDigest:update	([BII)V
    //   60: goto -28 -> 32
    //   63: aload_2
    //   64: invokevirtual 418	java/io/FileInputStream:close	()V
    //   67: new 420	java/math/BigInteger
    //   70: dup
    //   71: iconst_1
    //   72: aload_3
    //   73: invokevirtual 424	java/security/MessageDigest:digest	()[B
    //   76: invokespecial 427	java/math/BigInteger:<init>	(I[B)V
    //   79: bipush 16
    //   81: invokevirtual 430	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   84: areturn
    //   85: astore_3
    //   86: goto +12 -> 98
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_0
    //   92: goto +30 -> 122
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_2
    //   99: astore_0
    //   100: ldc 124
    //   102: iconst_1
    //   103: aload_3
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 418	java/io/FileInputStream:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 418	java/io/FileInputStream:close	()V
    //   130: goto +5 -> 135
    //   133: aload_2
    //   134: athrow
    //   135: goto -2 -> 133
    //   138: astore_0
    //   139: goto -72 -> 67
    //   142: astore_0
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: goto -16 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramFile	java.io.File
    //   44	13	1	i	int
    //   31	33	2	localFileInputStream	java.io.FileInputStream
    //   89	1	2	localObject1	Object
    //   97	19	2	localObject2	Object
    //   121	13	2	localObject3	Object
    //   22	51	3	localMessageDigest	java.security.MessageDigest
    //   85	1	3	localException1	java.lang.Exception
    //   95	9	3	localException2	java.lang.Exception
    //   14	40	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   34	45	85	java/lang/Exception
    //   52	60	85	java/lang/Exception
    //   16	32	89	finally
    //   16	32	95	java/lang/Exception
    //   34	45	121	finally
    //   52	60	121	finally
    //   100	111	121	finally
    //   63	67	138	java/io/IOException
    //   115	119	142	java/io/IOException
    //   126	130	145	java/io/IOException
  }
  
  public static void b()
  {
    try
    {
      if ((!d) && (Build.VERSION.SDK_INT >= 24) && (Build.VERSION.SDK_INT <= 29))
      {
        d = true;
        if (QLog.isColorLevel()) {
          QLog.i("NativeMonitorConfig", 2, "setupSoLoadHook");
        }
        NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupSoLoadHook(BaseApplicationImpl.getContext(), new NativeMonitorConfigHelper.1());
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper
 * JD-Core Version:    0.7.0.1
 */