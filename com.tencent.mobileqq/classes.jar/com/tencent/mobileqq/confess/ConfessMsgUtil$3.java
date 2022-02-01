package com.tencent.mobileqq.confess;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

final class ConfessMsgUtil$3
  implements Runnable
{
  ConfessMsgUtil$3(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b, this.c, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */