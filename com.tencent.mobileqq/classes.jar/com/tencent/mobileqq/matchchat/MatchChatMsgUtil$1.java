package com.tencent.mobileqq.matchchat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class MatchChatMsgUtil$1
  implements Runnable
{
  MatchChatMsgUtil$1(BaseQQAppInterface paramBaseQQAppInterface, RedTouch paramRedTouch) {}
  
  public void run()
  {
    int i = MatchChatMsgUtil.b(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateExtendFriendRedTouch() : ");
      localStringBuilder.append(i);
      QLog.d("MatchChatMsgUtil", 2, localStringBuilder.toString());
    }
    if (this.b != null) {
      ThreadManager.getUIHandler().post(new MatchChatMsgUtil.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */