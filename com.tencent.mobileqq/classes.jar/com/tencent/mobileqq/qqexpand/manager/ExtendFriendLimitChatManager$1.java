package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.match.LimitChatProtoStateMachine.LimitChatMachineListener;
import com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ExtendFriendLimitChatManager$1
  implements LimitChatProtoStateMachine.LimitChatMachineListener
{
  ExtendFriendLimitChatManager$1(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager) {}
  
  public void a(int paramInt, MatchInfo paramMatchInfo, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMatchingResult, result = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" nickName : ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
      if (paramMatchInfo != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" info：");
        ((StringBuilder)localObject).append(paramMatchInfo.toString());
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
      }
    }
    if ((ExtendFriendLimitChatManager.a(this.a) != null) && (ExtendFriendLimitChatManager.a(this.a).get() != null))
    {
      if (this.a.a() == 2)
      {
        if ((paramInt == 0) && (paramMatchInfo != null))
        {
          ExtendFriendLimitChatManager.a(this.a, paramMatchInfo.a());
          localObject = this.a;
          ((ExtendFriendLimitChatManager)localObject).a = paramString1;
          ((ExtendFriendLimitChatManager)localObject).a().a(105);
          if (!ExtendFriendLimitChatManager.a(this.a))
          {
            QQNotificationManager.getInstance().createLimitChatNotificationChannel();
            ExtendFriendLimitChatManager.a(this.a, true);
          }
        }
        else
        {
          this.a.a().a(104);
        }
        ((ExtendFriendLimitChatManager.LimitChatMatchListener)ExtendFriendLimitChatManager.a(this.a).get()).a(paramInt, paramMatchInfo, paramString1, paramString2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager.1
 * JD-Core Version:    0.7.0.1
 */