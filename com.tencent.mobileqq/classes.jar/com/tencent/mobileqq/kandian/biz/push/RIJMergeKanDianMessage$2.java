package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class RIJMergeKanDianMessage$2
  implements Runnable
{
  RIJMergeKanDianMessage$2(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new SessionInfo();
    ((SessionInfo)localObject).b = this.a;
    ((SessionInfo)localObject).a = 1008;
    ChatActivityFacade.a(this.b, (BaseSessionInfo)localObject);
    this.b.getMessageFacade().a(this.a, 1008);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("puin<");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("> msg setRead !");
    QLog.d("RIJMergeKanDianMessage", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage.2
 * JD-Core Version:    0.7.0.1
 */