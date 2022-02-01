package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.app.AppRuntime;

class GameShareUtilImpl$1
  implements Runnable
{
  GameShareUtilImpl$1(GameShareUtilImpl paramGameShareUtilImpl, AppRuntime paramAppRuntime, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(this.b.frienduin, this.b.istroop, this.b.uniseq, "extStr", this.b.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */