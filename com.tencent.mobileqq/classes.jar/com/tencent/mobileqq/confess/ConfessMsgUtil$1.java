package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

final class ConfessMsgUtil$1
  implements Runnable
{
  ConfessMsgUtil$1(ConfessManager paramConfessManager, String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = this.a;
    String str = this.b;
    ConfessManager.GroupChatExtra localGroupChatExtra = this.c;
    long l = this.d;
    ((ConfessManager)localObject).a(str, localGroupChatExtra, l, l, this.e);
    if (QLog.isColorLevel())
    {
      l = MessageCache.c();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeConfessMsgElem 1 strConfessorDesc:");
      ((StringBuilder)localObject).append(this.c.j);
      ((StringBuilder)localObject).append(" msgTime:");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" msgSeq:");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" nowTime");
      ((StringBuilder)localObject).append(l);
      QLog.i("ConfessMsgUtil", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */