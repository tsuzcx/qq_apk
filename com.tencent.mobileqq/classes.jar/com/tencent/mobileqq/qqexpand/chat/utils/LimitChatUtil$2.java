package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;

final class LimitChatUtil$2
  implements Runnable
{
  LimitChatUtil$2(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    IExpandHandler localIExpandHandler = (IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localIExpandHandler != null) {
      localIExpandHandler.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.2
 * JD-Core Version:    0.7.0.1
 */