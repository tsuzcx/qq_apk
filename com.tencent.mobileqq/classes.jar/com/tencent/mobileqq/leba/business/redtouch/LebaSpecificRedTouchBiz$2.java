package com.tencent.mobileqq.leba.business.redtouch;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class LebaSpecificRedTouchBiz$2
  implements Runnable
{
  LebaSpecificRedTouchBiz$2(LebaSpecificRedTouchBiz paramLebaSpecificRedTouchBiz, QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    int i = MatchChatMsgUtil.b(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateExtendFriendRedTouch() : ");
      localStringBuilder.append(i);
      QLog.d("LebaSpecificRedTouchBiz", 2, localStringBuilder.toString());
    }
    if (this.b != null) {
      ThreadManager.getUIHandler().post(new LebaSpecificRedTouchBiz.2.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.2
 * JD-Core Version:    0.7.0.1
 */