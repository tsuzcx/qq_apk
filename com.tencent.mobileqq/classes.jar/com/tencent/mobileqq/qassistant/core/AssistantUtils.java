package com.tencent.mobileqq.qassistant.core;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigItemFactory;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.JumpInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class AssistantUtils
{
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static VoiceAssistantManager a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return (VoiceAssistantManager)localQQAppInterface.getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER);
    }
    return null;
  }
  
  public static String a()
  {
    return System.currentTimeMillis() + "_" + ((int)(Math.random() * 900.0D) + 100);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.substring(paramString.indexOf("_") + 1);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return b() + paramString1 + "." + paramString2;
  }
  
  public static void a(Activity paramActivity, CommandInfo paramCommandInfo)
  {
    if ((paramActivity == null) || (paramCommandInfo == null) || (paramCommandInfo.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AssistantUtils", 2, "executeJumpAction jump params is null activity = " + paramActivity + ", commandInformation = " + paramCommandInfo);
      }
    }
    do
    {
      return;
      if (paramCommandInfo.a.jdField_a_of_type_Int == 115)
      {
        a(paramActivity, paramCommandInfo.a.jdField_a_of_type_JavaLangString, paramCommandInfo.a.jdField_b_of_type_JavaLangString, paramCommandInfo.a.jdField_b_of_type_Int);
        return;
      }
      paramCommandInfo = QAssistantConfigItemFactory.a(paramCommandInfo.a.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramCommandInfo)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AssistantUtils", 2, "executeJumpAction openAction is null");
    return;
    a(paramActivity, paramCommandInfo);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    paramString = "mqqaudioassistant://mqq.jump.qq/default?jumpaction=" + paramString;
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    localIntent.setFlags(268435456);
    localIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("isNeedUpdate", true);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(String paramString)
  {
    ((VoiceAssistantManager)a().getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER)).b(paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("echo_android_id", DeviceInfoUtil.f());
    localHashMap.put("echo_manufacturer", Build.MANUFACTURER);
    localHashMap.put("echo_brand", Build.BRAND);
    localHashMap.put("echo_model", Build.MODEL);
    localHashMap.put("echo_fingerprint", Build.FINGERPRINT);
    StatisticCollector.getInstance(localQQAppInterface.getApp()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "AcousticEchoCanceler", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (!paramBoolean) {
      localHashMap.put("downloadError", "" + paramInt);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      StatisticCollector.getInstance(localQQAppInterface.getApp()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "WakeDataDownloadMonitor", paramBoolean, 0L, 0L, localHashMap, null);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("voiceId", paramString);
    localHashMap.put("stCode", String.valueOf(paramInt1));
    localHashMap.put("wxCode", String.valueOf(paramInt2));
    localHashMap.put("lpCode", String.valueOf(paramInt3));
    StatisticCollector.getInstance(localQQAppInterface.getApp()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "VoiceRequestMonitor", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
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
    StatisticCollector.getInstance(localQQAppInterface.getApp()).collectPerformance(localQQAppInterface.getCurrentAccountUin(), "VoiceTimeMonitor", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static boolean a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      boolean bool = ((KeyguardManager)localQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION isBackgroundStop:" + localQQAppInterface.isBackgroundStop + ",isScreenLocked:" + bool);
      return (localQQAppInterface.isBackgroundStop) || (bool);
    }
    return false;
  }
  
  public static String b()
  {
    String str = BuddyTransfileProcessor.getTransferFilePath(a().getCurrentAccountUin(), null, 327697, null, false);
    return str.substring(0, str.lastIndexOf(File.separator)) + "/";
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return a().getCurrentAccountUin() + "_" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.AssistantUtils
 * JD-Core Version:    0.7.0.1
 */