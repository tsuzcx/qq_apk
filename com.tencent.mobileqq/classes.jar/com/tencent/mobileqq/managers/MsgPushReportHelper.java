package com.tencent.mobileqq.managers;

import android.content.Intent;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;

public class MsgPushReportHelper
{
  static NotificationReportController a;
  
  public static int a(String paramString, int paramInt, Intent paramIntent)
  {
    int j = 0;
    boolean bool;
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    } else {
      bool = false;
    }
    int i;
    if (paramInt == 1008) {
      i = 267;
    } else if ((bool) && (paramInt == 1010)) {
      i = 272;
    } else if (((bool) && (paramInt == 1001)) || (paramInt == 10002)) {
      i = 268;
    } else if ((paramIntent != null) && (paramIntent.getBooleanExtra("qav_notify_flag", false))) {
      i = 236;
    } else if (paramInt == 3001) {
      i = 271;
    } else if ((paramInt != 1044) && (paramInt != 1045))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("activepull_push_flag", false)))
      {
        i = 269;
      }
      else
      {
        if (paramInt == 1030)
        {
          if (paramIntent != null)
          {
            i = paramIntent.getIntExtra("campus_notice_id", 0);
            break label273;
          }
        }
        else
        {
          if ((paramInt != 1035) && (paramInt != 1041) && (paramInt != 1042))
          {
            if (paramInt == 1012)
            {
              i = 240;
              break label273;
            }
            if (paramInt == 7225)
            {
              i = 526;
              break label273;
            }
            if (paramInt == 10007)
            {
              i = 527;
              break label273;
            }
            i = 265;
            break label273;
          }
          if (paramIntent != null)
          {
            i = paramIntent.getIntExtra("param_notifyid", 0);
            break label273;
          }
        }
        i = -1;
      }
    }
    else {
      i = 266;
    }
    label273:
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNotifyID: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", for uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" and type: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  intent: ");
      paramInt = j;
      if (paramIntent != null) {
        paramInt = 1;
      }
      localStringBuilder.append(paramInt);
      QLog.d("MsgPushReportHelper", 4, localStringBuilder.toString());
    }
    return i;
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    NotificationReportController localNotificationReportController = a;
    if (localNotificationReportController != null) {
      localNotificationReportController.report(3, paramInt1, paramString, paramInt2);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        int i = paramIntent.getIntExtra("param_notifyid", 0);
        String str = paramIntent.getStringExtra("param_fromuin");
        int j = paramIntent.getIntExtra("param_uinType", 0);
        paramIntent.removeExtra("param_notifyid");
        paramIntent.removeExtra("param_fromuin");
        paramIntent.removeExtra("param_uinType");
        if ((QQNotificationManager.getInstance().isIdValid("MsgPushReportHelper", i)) && (a != null))
        {
          a.report(2, i, str, j);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgPushReportHelper", 2, paramIntent, new Object[0]);
        }
      }
    }
  }
  
  public static void a(NotificationReportController paramNotificationReportController)
  {
    a = paramNotificationReportController;
  }
  
  public static void b(int paramInt1, String paramString, int paramInt2)
  {
    NotificationReportController localNotificationReportController = a;
    if (localNotificationReportController != null) {
      localNotificationReportController.report(4, paramInt1, paramString, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.MsgPushReportHelper
 * JD-Core Version:    0.7.0.1
 */