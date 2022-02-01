package com.tencent.mobileqq.gamecenter.share;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class GameShareNetHelper$2$1
  implements Runnable
{
  GameShareNetHelper$2$1(GameShareNetHelper.2 param2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b.a.frienduin, this.b.a.istroop, this.b.a.uniseq, "extStr", this.b.a.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2.1
 * JD-Core Version:    0.7.0.1
 */