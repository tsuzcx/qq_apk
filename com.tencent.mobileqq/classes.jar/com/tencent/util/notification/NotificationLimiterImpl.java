package com.tencent.util.notification;

import com.tencent.commonsdk.util.notification.NotificationLimiter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

public class NotificationLimiterImpl
  implements NotificationLimiter
{
  private boolean a(int paramInt)
  {
    return (paramInt == 241) || (paramInt == 244) || (paramInt == 242) || (paramInt == 243);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= 528) && (paramInt <= 3000528);
  }
  
  private boolean c(int paramInt)
  {
    return paramInt == 3000530;
  }
  
  public boolean shouldNotify(int paramInt)
  {
    if (a(paramInt)) {
      return true;
    }
    if (b(paramInt)) {
      return true;
    }
    if (c(paramInt)) {
      return true;
    }
    boolean bool1;
    if (MiniChatActivity.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NotificationLimiterImpl", 2, "MiniMsgActForeGround");
      }
      bool1 = false;
    }
    else
    {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = StudyModeManager.a(paramInt) ^ true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NotificationLimiterImpl", 2, String.format("studymode_fightNotificationLimiterImpl ,shouldNotify1 = %b,", new Object[] { Boolean.valueOf(bool2) }));
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.notification.NotificationLimiterImpl
 * JD-Core Version:    0.7.0.1
 */