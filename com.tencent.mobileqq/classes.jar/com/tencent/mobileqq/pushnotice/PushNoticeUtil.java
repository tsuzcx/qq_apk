package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotificationController;

public class PushNoticeUtil
{
  private static String a = "HPush";
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = b(paramInt1, paramInt2);
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
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
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getExtras() == null) {
        return false;
      }
      if (!a(paramIntent))
      {
        QLog.i(a, 1, "handlePushJumpIntent: isFromPush=false");
        return false;
      }
      QLog.i(a, 1, "handlePushJumpIntent: is from hw push.");
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
  
  private static String b(int paramInt1, int paramInt2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.PushNoticeUtil
 * JD-Core Version:    0.7.0.1
 */