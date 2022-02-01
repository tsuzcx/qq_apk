import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.utils.AVUtil.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class mqo
{
  public static int a()
  {
    ley localley = lbu.a().a();
    if (localley != null)
    {
      if (localley.d == 3) {
        return 3;
      }
      if (localley.d == 4) {
        return 4;
      }
      if (localley.d == 1) {
        return 1;
      }
      if (localley.d == 2) {
        return 2;
      }
    }
    return 2;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 3000) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 0) {
      return 3;
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.parseLong(paramString);
      }
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.fillInStackTrace();
    }
    return 0L;
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    while (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
      return;
    }
    ThreadManager.excute(new AVUtil.1(new WeakReference(paramActivity)), 16, null, true);
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent != null) {}
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, a(), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    bcst.b(null, "dc00898", "", "", paramString1, paramString1, paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("AVUtil", 2, "report tag[" + paramString1 + "], from[" + paramInt1 + "], r2[" + paramString2 + "]");
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(BaseApplicationImpl.getContext(), paramString, null, "qqsetting_avcall_notify_key", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("AVUtil", 2, "saveAllowAVNotify, isAllow[" + paramBoolean + "]");
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT > 28) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "isUseCompatMode [" + bool + "], SDK_INT[" + Build.VERSION.SDK_INT + "]");
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public static boolean a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str = "qqsetting_avcall_notify_key" + paramString;
    boolean bool2 = SettingCloneUtil.getSharedPreferences().contains(str);
    if (bool2) {}
    for (boolean bool1 = SettingCloneUtil.readValue(localBaseApplication, paramString, null, "qqsetting_avcall_notify_key", true);; bool1 = SettingCloneUtil.readValue(localBaseApplication, null, null, "qqsetting_avcall_notify_key", true))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVUtil", 2, "isAVNotifyEnable, av_enable[" + bool1 + "], isNewKeyExist[" + bool2 + "]");
      }
      return bool1;
    }
  }
  
  public static int b(int paramInt)
  {
    int i = 0;
    if (paramInt == 3000) {
      i = 1004;
    }
    do
    {
      return i;
      if (paramInt == 1) {
        return 1000;
      }
    } while (paramInt != 0);
    return 0;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    boolean bool2 = QQNotificationManager.getInstance().areNotificationsEnabled(localBaseApplication);
    boolean bool1;
    if (bool2) {
      bool1 = a(paramString);
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("AVUtil", 2, "isAllowAVNotify, system_enable[false]");
    return bool2;
  }
  
  public static int c(int paramInt)
  {
    int i = 1000;
    if (paramInt == 2) {
      i = 1004;
    }
    while (paramInt != 1) {
      return i;
    }
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqo
 * JD-Core Version:    0.7.0.1
 */