package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.LimitChatProtoStateMachine.LimitChatMachineListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ExtendFriendLimitChatManager$2
  implements LimitChatProtoStateMachine.LimitChatMachineListener
{
  ExtendFriendLimitChatManager$2(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager) {}
  
  public void a(int paramInt, MatchInfo paramMatchInfo, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramMatchInfo != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramMatchInfo.toString());
      }
    }
    if ((ExtendFriendLimitChatManager.a(this.a) == null) || (ExtendFriendLimitChatManager.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.a() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramMatchInfo == null)) {
      this.a.a().a(104);
    }
    for (;;)
    {
      ((ExtendFriendLimitChatManager.LimitChatMatchListener)ExtendFriendLimitChatManager.a(this.a).get()).a(paramInt, paramMatchInfo, paramString1, paramString2);
      return;
      ExtendFriendLimitChatManager.a(this.a, paramMatchInfo.a());
      this.a.a = paramString1;
      this.a.a().a(105);
      if (!ExtendFriendLimitChatManager.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        ExtendFriendLimitChatManager.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager.2
 * JD-Core Version:    0.7.0.1
 */