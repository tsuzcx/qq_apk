package com.tencent.mobileqq.gamecenter.hippy;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class GamePubAccountMsgManager$1
  implements Runnable
{
  GamePubAccountMsgManager$1(GamePubAccountMsgManager paramGamePubAccountMsgManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    GamePubAccountMsgManager.a(this.this$0).getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountMsgManager.1
 * JD-Core Version:    0.7.0.1
 */