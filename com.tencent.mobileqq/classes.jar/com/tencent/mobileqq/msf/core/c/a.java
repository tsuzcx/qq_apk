package com.tencent.mobileqq.msf.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.report.IMTAReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.util.Map;
import java.util.Properties;

public class a
  implements IMTAReporter
{
  public static boolean a = false;
  private static final String b = "MTAReportManager";
  private static volatile a d;
  private Context c;
  private StatSpecifyReportedInfo e = new StatSpecifyReportedInfo();
  private volatile String f;
  private boolean g;
  
  private a(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.g = a(this.c, true);
    a(false);
    initMtaConfig(MsfSdkUtils.getAppChannelId(), "AGU36HSC29K4");
  }
  
  public static a a(Context paramContext)
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new a(paramContext);
      }
      return d;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 4).getBoolean("SUPPORT_MTA", paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, Map paramMap)
  {
    try
    {
      Properties localProperties = new Properties();
      if ((paramMap != null) && (paramMap.size() > 0)) {
        localProperties.putAll(paramMap);
      }
      reportKVEvent(paramString, localProperties);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, Map paramMap, int paramInt)
  {
    if (!this.g) {
      return;
    }
    try
    {
      Properties localProperties = new Properties();
      if ((paramMap != null) && (paramMap.size() > 0)) {
        localProperties.putAll(paramMap);
      }
      reportTimeKVEvent(paramString, localProperties, paramInt);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportTimeKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StatConfig.setDebugEnable(paramBoolean);
  }
  
  /* Error */
  public void initMtaConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/msf/core/c/a:e	Lcom/tencent/stat/StatSpecifyReportedInfo;
    //   4: aload_2
    //   5: invokevirtual 128	com/tencent/stat/StatSpecifyReportedInfo:setAppKey	(Ljava/lang/String;)V
    //   8: aload_1
    //   9: ifnonnull +152 -> 161
    //   12: invokestatic 134	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc 136
    //   17: invokevirtual 140	com/tencent/qphone/base/util/BaseApplication:getAppData	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +212 -> 234
    //   25: aload_1
    //   26: instanceof 142
    //   29: ifeq +205 -> 234
    //   32: aload_1
    //   33: checkcast 142	java/lang/String
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 31	com/tencent/mobileqq/msf/core/c/a:e	Lcom/tencent/stat/StatSpecifyReportedInfo;
    //   41: aload_1
    //   42: invokevirtual 145	com/tencent/stat/StatSpecifyReportedInfo:setInstallChannel	(Ljava/lang/String;)V
    //   45: goto +186 -> 231
    //   48: iconst_1
    //   49: invokestatic 148	com/tencent/stat/StatConfig:setEnableConcurrentProcess	(Z)V
    //   52: iconst_0
    //   53: invokestatic 151	com/tencent/stat/StatConfig:setAutoExceptionCaught	(Z)V
    //   56: aload_0
    //   57: getfield 39	com/tencent/mobileqq/msf/core/c/a:c	Landroid/content/Context;
    //   60: invokestatic 156	com/tencent/stat/StatServiceImpl:setContext	(Landroid/content/Context;)V
    //   63: getstatic 162	com/tencent/stat/StatReportStrategy:PERIOD	Lcom/tencent/stat/StatReportStrategy;
    //   66: invokestatic 166	com/tencent/stat/StatConfig:setStatSendStrategy	(Lcom/tencent/stat/StatReportStrategy;)V
    //   69: bipush 30
    //   71: invokestatic 170	com/tencent/stat/StatConfig:setSendPeriodMinutes	(I)V
    //   74: iconst_1
    //   75: invokestatic 173	com/tencent/stat/StatConfig:setEnableSmartReporting	(Z)V
    //   78: ldc 175
    //   80: invokestatic 178	com/tencent/stat/StatConfig:setStatReportUrl	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: invokestatic 184	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   87: ldc 186
    //   89: invokevirtual 192	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   92: putfield 82	com/tencent/mobileqq/msf/core/c/a:f	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 82	com/tencent/mobileqq/msf/core/c/a:f	Ljava/lang/String;
    //   99: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +14 -> 116
    //   105: aload_0
    //   106: getfield 39	com/tencent/mobileqq/msf/core/c/a:c	Landroid/content/Context;
    //   109: aload_0
    //   110: getfield 82	com/tencent/mobileqq/msf/core/c/a:f	Ljava/lang/String;
    //   113: invokestatic 202	com/tencent/stat/StatConfig:setCustomUserId	(Landroid/content/Context;Ljava/lang/String;)V
    //   116: iconst_1
    //   117: putstatic 204	com/tencent/mobileqq/msf/core/c/a:a	Z
    //   120: ldc 13
    //   122: iconst_1
    //   123: new 206	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   130: ldc 209
    //   132: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 215
    //   141: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 82	com/tencent/mobileqq/msf/core/c/a:f	Ljava/lang/String;
    //   148: invokestatic 218	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 225	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: return
    //   161: aload_0
    //   162: getfield 31	com/tencent/mobileqq/msf/core/c/a:e	Lcom/tencent/stat/StatSpecifyReportedInfo;
    //   165: aload_1
    //   166: invokevirtual 145	com/tencent/stat/StatSpecifyReportedInfo:setInstallChannel	(Ljava/lang/String;)V
    //   169: goto -121 -> 48
    //   172: astore_1
    //   173: ldc 13
    //   175: iconst_1
    //   176: ldc 227
    //   178: aload_1
    //   179: invokestatic 229	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_1
    //   183: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   186: iconst_0
    //   187: putstatic 204	com/tencent/mobileqq/msf/core/c/a:a	Z
    //   190: return
    //   191: astore_2
    //   192: ldc 13
    //   194: iconst_1
    //   195: ldc 231
    //   197: aload_2
    //   198: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: new 235	java/util/Random
    //   204: dup
    //   205: invokespecial 236	java/util/Random:<init>	()V
    //   208: bipush 100
    //   210: invokevirtual 240	java/util/Random:nextInt	(I)I
    //   213: iconst_1
    //   214: if_icmpge -119 -> 95
    //   217: invokestatic 246	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   220: aload_2
    //   221: ldc 248
    //   223: aconst_null
    //   224: invokestatic 254	com/tencent/feedback/eup/CrashReport:handleCatchException	(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;[B)Z
    //   227: pop
    //   228: goto -133 -> 95
    //   231: goto -183 -> 48
    //   234: ldc_w 256
    //   237: astore_1
    //   238: goto -7 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	a
    //   0	241	1	paramString1	String
    //   0	241	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   0	8	172	java/lang/Exception
    //   12	21	172	java/lang/Exception
    //   25	45	172	java/lang/Exception
    //   48	83	172	java/lang/Exception
    //   83	95	172	java/lang/Exception
    //   95	116	172	java/lang/Exception
    //   116	160	172	java/lang/Exception
    //   161	169	172	java/lang/Exception
    //   192	228	172	java/lang/Exception
    //   83	95	191	java/lang/UnsatisfiedLinkError
  }
  
  public boolean isMtaSupported()
  {
    return this.g;
  }
  
  public void reportKVEvent(String paramString, Properties paramProperties)
  {
    if (!this.g) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportManager", 2, "reportKVEvent " + paramString + " \n\t\t" + paramProperties);
    }
    try
    {
      StatServiceImpl.trackCustomKVEvent(this.c, paramString, paramProperties, this.e);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void reportTimeKVEvent(String paramString, Properties paramProperties, int paramInt)
  {
    if (!this.g) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportManager", 2, "reportTimeKVEvent " + paramString + " " + paramInt + "\n\t\t" + paramProperties);
    }
    try
    {
      StatServiceImpl.trackCustomKVTimeIntervalEvent(this.c, paramString, paramProperties, paramInt, this.e);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportTimeKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void trackBeginPage(String paramString) {}
  
  public void trackEndPage(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.a
 * JD-Core Version:    0.7.0.1
 */