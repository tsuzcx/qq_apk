package com.tencent.mobileqq.troop.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class TroopFileUtils$1
  implements Runnable
{
  TroopFileUtils$1(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b, this.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUtils.1
 * JD-Core Version:    0.7.0.1
 */