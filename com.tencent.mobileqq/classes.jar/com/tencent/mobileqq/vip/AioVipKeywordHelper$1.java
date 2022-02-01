package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class AioVipKeywordHelper$1
  implements Runnable
{
  AioVipKeywordHelper$1(AioVipKeywordHelper paramAioVipKeywordHelper, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ChatMessage paramChatMessage, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.h != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
      }
      return;
    }
    if (!this.this$0.a(this.a, this.b)) {
      return;
    }
    String str = this.c.toLowerCase();
    AioVipKeywordHelper.a(this.this$0, AioVipKeywordHelper.a, str, this.d, this.e, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipKeywordHelper.1
 * JD-Core Version:    0.7.0.1
 */