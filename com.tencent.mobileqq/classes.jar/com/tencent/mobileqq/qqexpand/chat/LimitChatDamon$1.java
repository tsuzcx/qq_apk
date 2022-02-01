package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LimitChatDamon$1
  implements Runnable
{
  LimitChatDamon$1(LimitChatDamon paramLimitChatDamon, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      LimitChatDamon.a(this.this$0, null);
      ??? = new SessionInfo();
      String str = this.a;
      ((SessionInfo)???).b = str;
      ((SessionInfo)???).c = str;
      ((SessionInfo)???).a = 1044;
      ChatActivityFacade.a(this.b, (BaseSessionInfo)???);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("sendMessageReadConfirm , real send:");
        ((StringBuilder)???).append(this.a);
        QLog.d("LimitChatDamon", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.LimitChatDamon.1
 * JD-Core Version:    0.7.0.1
 */