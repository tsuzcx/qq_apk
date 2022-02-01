package com.tencent.mobileqq.scribble.impl;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.app.AppRuntime;

class ScribbleMsgUtilsImpl$1
  implements Runnable
{
  ScribbleMsgUtilsImpl$1(ScribbleMsgUtilsImpl paramScribbleMsgUtilsImpl, AppRuntime paramAppRuntime, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(this.b.frienduin, this.b.istroop, this.b.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleMsgUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */