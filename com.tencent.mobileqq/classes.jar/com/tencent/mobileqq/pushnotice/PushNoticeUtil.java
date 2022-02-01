package com.tencent.mobileqq.pushnotice;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.push.HmsProfile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.notification.NotificationController;
import mqq.app.AppRuntime;

public class PushNoticeUtil
{
  public static String a = "";
  public static String b = "";
  private static String c = "HPush";
  
  public static int a()
  {
    int i;
    if (a()) {
      i = 3;
    } else {
      i = 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HPush_Huawei Push pushType : ");
      localStringBuilder.append(i);
      QLog.d("", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1041)
    {
      if (paramInt1 != 1042) {
        break label45;
      }
    }
    else
    {
      if (paramInt2 == 0) {
        break label62;
      }
      if (paramInt2 == 1) {
        break label59;
      }
      if (paramInt2 == 2) {
        break label56;
      }
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          label45:
          return null;
        }
        return "0X8009E0B";
      }
      return "0X8009E0A";
    }
    return "0X8009E09";
    label56:
    return "0X8009E08";
    label59:
    return "0X8009E07";
    label62:
    return "0X8009E06";
  }
  
  public static void a()
  {
    if (a()) {
      try
      {
        if (HmsProfile.getInstance(BaseApplicationImpl.getContext()).isSupportProfile())
        {
          e();
          return;
        }
        d();
        return;
      }
      catch (Exception localException)
      {
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerHuaweiPushTokenToServer : ");
        localStringBuilder.append(localException);
        QLog.e(str, 1, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(Context paramContext)
  {
    if (a()) {
      ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    }
  }
  
  public static void a(String paramString)
  {
    a = paramString;
    String str = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
    ThirdPushNotifyManager.a().a(3, str, paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      ((NotificationController)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).a(paramBoolean);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HPush_Huawei Push sendNewMsgSwitchToServer : ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("HPush", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean a()
  {
    return ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getExtras() == null) {
        return false;
      }
      if (!a(paramIntent))
      {
        QLog.i(c, 1, "handlePushJumpIntent: isFromPush=false");
        return false;
      }
      QLog.i(c, 1, "handlePushJumpIntent: is from hw push.");
      Intent localIntent = new Intent();
      localIntent.putExtra("from_third_push_jump", true);
      localIntent.putExtras(paramIntent.getExtras());
      RouteUtils.a(paramContext, localIntent, "/base/jump");
      return true;
    }
    return false;
  }
  
  public static boolean a(Intent paramIntent)
  {
    return (paramIntent.hasExtra("third_push_jump")) && (paramIntent.hasExtra("token"));
  }
  
  public static void b()
  {
    if (!TextUtils.isEmpty(a))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface.isLogin())
      {
        ((IOnlineStatusService)localQQAppInterface.getRuntimeService(IOnlineStatusService.class)).requestSetPushToken(localQQAppInterface, a, b);
        if (QLog.isColorLevel()) {
          QLog.d("HPush", 2, "HPush_Huawei Push Token-By sendTokenToServer : ");
        }
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    if ((a()) && (Build.VERSION.SDK_INT >= 26))
    {
      paramContext = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
      StatusBarNotification[] arrayOfStatusBarNotification = paramContext.getActiveNotifications();
      int j = arrayOfStatusBarNotification.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfStatusBarNotification[i];
        String str1 = ((StatusBarNotification)localObject).getNotification().getChannelId();
        Integer localInteger = Integer.valueOf(((StatusBarNotification)localObject).getId());
        String str2 = ((StatusBarNotification)localObject).getPackageName();
        String str3 = ReflectionUtil.a(localObject, localObject.getClass().getName(), "getOpPkg", null, new Object[0]).toString();
        localObject = ((StatusBarNotification)localObject).getKey();
        if ((str3.equals("com.huawei.android.pushagent")) && (str1.equals("CHANNEL_ID_SHOW_BADGE")))
        {
          paramContext.cancel(localInteger.intValue());
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, new Object[] { "HPush_mChannelId = ", str1, ", nId = ", localInteger, ",pkg = ", str2, ",key = ", localObject, ",opPkg = ", str3 });
          }
        }
        i += 1;
      }
    }
  }
  
  private static void d()
  {
    if (TextUtils.isEmpty(a))
    {
      ThreadManager.newFreeThread(new PushNoticeUtil.1(), "huawei_push_token_get", 5).start();
      return;
    }
    b();
    if (QLog.isColorLevel()) {
      QLog.d("HPush", 2, "HPush_Huawei Push Token-By not HmsInstanceId : ");
    }
  }
  
  private static void e()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      String str = MD5.toMD5(((AppRuntime)localObject).getCurrentUin());
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (str.length() > 8) {
          localObject = str.substring(0, 8);
        }
        HmsProfile.getInstance(BaseApplicationImpl.getApplication()).addProfile(2, (String)localObject).addOnCompleteListener(new PushNoticeUtil.2((String)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.PushNoticeUtil
 * JD-Core Version:    0.7.0.1
 */