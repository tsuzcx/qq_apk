import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mqr
{
  public static int a(int paramInt)
  {
    if (paramInt == 3000) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    return 0;
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent != null) {}
  }
  
  public static void a(String paramString, int paramInt)
  {
    int j = 2;
    Object localObject = VideoController.a();
    int i = j;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if (((lgf)localObject).d != 3)
      {
        i = j;
        if (((lgf)localObject).d != 4) {}
      }
      else
      {
        i = 4;
      }
    }
    a(paramString, i, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    axqw.b(null, "dc00898", "", "", paramString1, paramString1, paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mqr
 * JD-Core Version:    0.7.0.1
 */