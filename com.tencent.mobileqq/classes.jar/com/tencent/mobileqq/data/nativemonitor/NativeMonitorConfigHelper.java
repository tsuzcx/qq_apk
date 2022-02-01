package com.tencent.mobileqq.data.nativemonitor;

import android.app.Application;
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
  public static final String TAG = "NativeMonitorConfig";
  private static boolean configInited = false;
  private static String configUin;
  private static boolean isHooked = false;
  private static boolean isHookedNativeThreadCreated = false;
  private static boolean isHookedSoLoad = false;
  private static NativeMonitorConfig sConfig = new NativeMonitorConfig();
  
  static
  {
    configUin = "";
  }
  
  private static NativeMonitorConfig getConfig(SharedPreferences paramSharedPreferences, String paramString)
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
  
  public static NativeMonitorConfig getConfig(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!configInited) || (!configUin.equals(str)))
      {
        paramAppRuntime = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append("native_monitor_config_version");
        if (paramAppRuntime.contains(localStringBuilder.toString()))
        {
          paramAppRuntime = getConfig(paramAppRuntime, str);
          if (paramAppRuntime != null) {
            updateConfig(paramAppRuntime);
          }
        }
        configUin = str;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("NativeMonitorConfig:");
      paramAppRuntime.append(sConfig.toString());
      QLog.d("NativeMonitorConfig", 2, paramAppRuntime.toString());
    }
    configInited = true;
    return sConfig;
  }
  
  public static NativeMonitorConfig getConfigWithoutUin(Application paramApplication)
  {
    paramApplication = PreferenceManager.getDefaultSharedPreferences(paramApplication);
    if (paramApplication != null) {
      return getConfig(paramApplication, "");
    }
    return null;
  }
  
  /* Error */
  private static String getFileMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 150	java/io/File:isFile	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: sipush 4096
    //   12: newarray byte
    //   14: astore 4
    //   16: ldc 152
    //   18: invokestatic 158	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   21: astore_3
    //   22: new 160	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_0
    //   33: aload_2
    //   34: aload 4
    //   36: iconst_0
    //   37: aload 4
    //   39: arraylength
    //   40: invokevirtual 167	java/io/FileInputStream:read	([BII)I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_m1
    //   46: if_icmpeq +16 -> 62
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_1
    //   56: invokevirtual 171	java/security/MessageDigest:update	([BII)V
    //   59: goto -28 -> 31
    //   62: aload_2
    //   63: invokevirtual 174	java/io/FileInputStream:close	()V
    //   66: new 176	java/math/BigInteger
    //   69: dup
    //   70: iconst_1
    //   71: aload_3
    //   72: invokevirtual 180	java/security/MessageDigest:digest	()[B
    //   75: invokespecial 183	java/math/BigInteger:<init>	(I[B)V
    //   78: bipush 16
    //   80: invokevirtual 186	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   83: areturn
    //   84: astore_3
    //   85: goto +12 -> 97
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: goto +30 -> 121
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_0
    //   99: ldc 8
    //   101: iconst_1
    //   102: aload_3
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 174	java/io/FileInputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_2
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 174	java/io/FileInputStream:close	()V
    //   129: goto +5 -> 134
    //   132: aload_2
    //   133: athrow
    //   134: goto -2 -> 132
    //   137: astore_0
    //   138: goto -72 -> 66
    //   141: astore_0
    //   142: aconst_null
    //   143: areturn
    //   144: astore_0
    //   145: goto -16 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramFile	java.io.File
    //   43	13	1	i	int
    //   30	33	2	localFileInputStream	java.io.FileInputStream
    //   88	1	2	localObject1	Object
    //   96	19	2	localObject2	Object
    //   120	13	2	localObject3	Object
    //   21	51	3	localMessageDigest	java.security.MessageDigest
    //   84	1	3	localException1	java.lang.Exception
    //   94	9	3	localException2	java.lang.Exception
    //   14	39	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	44	84	java/lang/Exception
    //   51	59	84	java/lang/Exception
    //   16	31	88	finally
    //   16	31	94	java/lang/Exception
    //   33	44	120	finally
    //   51	59	120	finally
    //   99	110	120	finally
    //   62	66	137	java/io/IOException
    //   114	118	141	java/io/IOException
    //   125	129	144	java/io/IOException
  }
  
  public static void handleNativeMonitorConfig(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = SharedPreUtils.bJ(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = SharedPreUtils.bK(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.d();
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 1, String.format("received nativeMonitorConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      SharedPreUtils.U(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
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
          updateConfig(new NativeMonitorConfig());
          SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
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
          updateConfig(paramConfig);
          SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, str);
          SharedPreUtils.t(paramQQAppInterface.getApp(), paramConfig.soHook);
        }
      }
      else
      {
        updateConfig(new NativeMonitorConfig());
        SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
        SharedPreUtils.t(paramQQAppInterface.getApp(), 0);
        QLog.d("NativeMonitorConfig", 1, "config is null, use default config");
      }
    }
    else
    {
      QLog.d("NativeMonitorConfig", 1, "config version not updated, nothing to do");
    }
    startToHookAfterConfigGet(true);
  }
  
  private static boolean isInProcessBlackList(@NonNull NativeMonitorConfig paramNativeMonitorConfig)
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
  
  public static void setupSoLoadHook()
  {
    try
    {
      if ((!isHookedSoLoad) && (Build.VERSION.SDK_INT >= 24) && (Build.VERSION.SDK_INT <= 29))
      {
        isHookedSoLoad = true;
        QLog.i("NativeMonitorConfig", 1, "setupSoLoadHook");
        NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupSoLoadHook(BaseApplicationImpl.getContext(), new NativeMonitorConfigHelper.1());
        return;
      }
      return;
    }
    finally {}
  }
  
  public static void startHook(Context paramContext, long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    try
    {
      boolean bool = isHooked;
      if (bool) {
        return;
      }
      isHooked = true;
      if (QLog.isColorLevel()) {
        QLog.i("NativeMonitorConfig", 2, "start hook native after config ready");
      }
      NativeMemoryMonitor.getInstance(paramContext).init(paramLong1, paramArrayOfString, paramLong2, paramLong3, paramLong4);
      return;
    }
    finally {}
  }
  
  public static void startHookThreadCreate()
  {
    try
    {
      if ((!isHookedNativeThreadCreated) && (Build.VERSION.SDK_INT >= 21))
      {
        isHookedNativeThreadCreated = true;
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
  
  public static void startToHookAfterConfigGet(boolean paramBoolean)
  {
    if (AppSetting.i)
    {
      NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupASanCallback();
      return;
    }
    paramBoolean = CPUReport.c();
    Object localObject1;
    if ((paramBoolean) && (Build.VERSION.SDK_INT <= 27) && (Build.VERSION.SDK_INT > 15) && (!AppSetting.i))
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        QLog.i("NativeMonitorConfig", 1, "skip in release");
        return;
      }
      NativeMonitorConfig localNativeMonitorConfig = getConfig(BaseApplicationImpl.getApplication().getRuntime());
      if (localNativeMonitorConfig != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("open: ");
        ((StringBuilder)localObject1).append(localNativeMonitorConfig.getNativeMonitorOpened());
        ((StringBuilder)localObject1).append(", flag: ");
        ((StringBuilder)localObject1).append(localNativeMonitorConfig.getSwitchFlag());
        BaseApplicationImpl.sNativeMonitorEscapedMsg = ((StringBuilder)localObject1).toString();
        ThreadManagerInitialler.initShotChanceForPublicVersion(sConfig.getTmChance());
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
        if (isInProcessBlackList(localNativeMonitorConfig))
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
        startHook(BaseApplicationImpl.getContext(), 0xFFFFFFFF & l2 & 0x7FFFFFFF & 0xFFFFFFFD, null, localNativeMonitorConfig.getTimeLimited(), localNativeMonitorConfig.getCountLimted(), localNativeMonitorConfig.getMemoryLimited());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("arm: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", useASan: ");
      ((StringBuilder)localObject1).append(AppSetting.i);
      QLog.i("NativeMonitorConfig", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void updateConfig(NativeMonitorConfig paramNativeMonitorConfig)
  {
    configInited = true;
    sConfig.update(paramNativeMonitorConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper
 * JD-Core Version:    0.7.0.1
 */