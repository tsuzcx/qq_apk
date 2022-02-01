package com.tencent.mobileqq.qassistant.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItemFactory;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AssistantUtils
{
  public static IVoiceAssistantCore a()
  {
    return (IVoiceAssistantCore)c().getRuntimeService(IVoiceAssistantCore.class, "");
  }
  
  public static String a(int paramInt)
  {
    return MobileQQ.sMobileQQ.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, CommandInfo paramCommandInfo)
  {
    if ((paramActivity != null) && (paramCommandInfo != null) && (paramCommandInfo.f != null))
    {
      if (paramCommandInfo.f.a == 115)
      {
        a(paramActivity, paramCommandInfo.f.b, paramCommandInfo.f.c, paramCommandInfo.f.d);
        return;
      }
      paramCommandInfo = QAssistantConfigItemFactory.a(paramCommandInfo.f.a);
      if (TextUtils.isEmpty(paramCommandInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssistantUtils", 2, "executeJumpAction openAction is null");
        }
        return;
      }
      a(paramActivity, paramCommandInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("executeJumpAction jump params is null activity = ");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append(", commandInformation = ");
      localStringBuilder.append(paramCommandInfo);
      QLog.d("AssistantUtils", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqaudioassistant://mqq.jump.qq/default?jumpaction=");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse(paramString));
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramActivity = BaseAIOUtils.a(new ActivityURIRequest(paramActivity, "/base/start/splash"), null);
      paramActivity.extra().putString("uin", paramString1);
      paramActivity.extra().putString("uinname", paramString2);
      paramActivity.extra().putInt("uintype", paramInt);
      paramActivity.extra().putBoolean("isNeedUpdate", true);
      QRoute.startUri(paramActivity, null);
    }
  }
  
  public static void a(String paramString)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = a();
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setPerformanceText(paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("echo_android_id", DeviceInfoUtil.j());
    localHashMap.put("echo_manufacturer", Build.MANUFACTURER);
    localHashMap.put("echo_brand", Build.BRAND);
    localHashMap.put("echo_model", Build.MODEL);
    localHashMap.put("echo_fingerprint", Build.FINGERPRINT);
    StatisticCollector.getInstance(d()).collectPerformance(c().getCurrentAccountUin(), "AcousticEchoCanceler", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      localHashMap.put("downloadError", localStringBuilder.toString());
    }
    StatisticCollector.getInstance(d()).collectPerformance(c().getCurrentAccountUin(), "WakeDataDownloadMonitor", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("voiceId", paramString);
    localHashMap.put("stCode", String.valueOf(paramInt1));
    localHashMap.put("wxCode", String.valueOf(paramInt2));
    localHashMap.put("lpCode", String.valueOf(paramInt3));
    StatisticCollector.getInstance(d()).collectPerformance(c().getCurrentAccountUin(), "VoiceRequestMonitor", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt1));
    localHashMap.put("totalTime", String.valueOf(paramLong1));
    localHashMap.put("voiceId", paramString1);
    localHashMap.put("voiceText", paramString2);
    localHashMap.put("voiceIntent", paramString3);
    localHashMap.put("avBeanTime", String.valueOf(paramLong2));
    localHashMap.put("durationAsr", String.valueOf(paramLong3));
    localHashMap.put("durationNlp", String.valueOf(paramLong4));
    localHashMap.put("tailorSum", String.valueOf(paramLong5));
    localHashMap.put("tailorLoc", String.valueOf(paramLong6));
    localHashMap.put("tailorNet", String.valueOf(paramLong7));
    localHashMap.put("contactCount", String.valueOf(paramInt2));
    StatisticCollector.getInstance(d()).collectPerformance(c().getCurrentAccountUin(), "VoiceTimeMonitor", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static AppInterface b()
  {
    AppRuntime localAppRuntime = c();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static void b(String paramString)
  {
    a("AssistantUtils", paramString);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.substring(paramString.indexOf("_") + 1);
  }
  
  public static AppRuntime c()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static BaseApplication d()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c().getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append((int)(Math.random() * 900.0D) + 100);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String e(String paramString)
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: new 352	java/io/BufferedReader
    //   16: dup
    //   17: new 354	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 356	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 359	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 362	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +37 -> 72
    //   38: new 87	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: bipush 10
    //   55: invokevirtual 365	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: aload_2
    //   62: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -40 -> 29
    //   72: aload_0
    //   73: invokevirtual 368	java/io/BufferedReader:close	()V
    //   76: aload_0
    //   77: invokevirtual 368	java/io/BufferedReader:close	()V
    //   80: goto +44 -> 124
    //   83: astore_1
    //   84: goto +46 -> 130
    //   87: astore_2
    //   88: goto +14 -> 102
    //   91: astore_2
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: astore_1
    //   96: goto +34 -> 130
    //   99: astore_2
    //   100: aload_3
    //   101: astore_0
    //   102: aload_0
    //   103: astore_1
    //   104: aload_2
    //   105: invokevirtual 371	java/lang/Exception:printStackTrace	()V
    //   108: aload_0
    //   109: ifnull +15 -> 124
    //   112: aload_0
    //   113: invokevirtual 368	java/io/BufferedReader:close	()V
    //   116: goto +8 -> 124
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 372	java/io/IOException:printStackTrace	()V
    //   124: aload 4
    //   126: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: areturn
    //   130: aload_0
    //   131: ifnull +15 -> 146
    //   134: aload_0
    //   135: invokevirtual 368	java/io/BufferedReader:close	()V
    //   138: goto +8 -> 146
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 372	java/io/IOException:printStackTrace	()V
    //   146: goto +5 -> 151
    //   149: aload_1
    //   150: athrow
    //   151: goto -2 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   12	36	1	str	String
    //   83	10	1	localObject1	Object
    //   95	55	1	localObject2	Object
    //   45	17	2	localStringBuilder1	StringBuilder
    //   87	1	2	localException1	java.lang.Exception
    //   91	4	2	localObject3	Object
    //   99	6	2	localException2	java.lang.Exception
    //   10	91	3	localObject4	Object
    //   7	118	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	34	83	finally
    //   38	69	83	finally
    //   72	76	83	finally
    //   29	34	87	java/lang/Exception
    //   38	69	87	java/lang/Exception
    //   72	76	87	java/lang/Exception
    //   13	29	91	finally
    //   104	108	91	finally
    //   13	29	99	java/lang/Exception
    //   76	80	119	java/io/IOException
    //   112	116	119	java/io/IOException
    //   134	138	141	java/io/IOException
  }
  
  public static String f()
  {
    String str = TransFileUtil.getTransferFilePath(c().getCurrentAccountUin(), null, 327697, null, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.substring(0, str.lastIndexOf(File.separator)));
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.AssistantUtils
 * JD-Core Version:    0.7.0.1
 */