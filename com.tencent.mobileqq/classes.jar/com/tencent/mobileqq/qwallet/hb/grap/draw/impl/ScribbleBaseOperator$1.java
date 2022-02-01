package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

class ScribbleBaseOperator$1
  implements Runnable
{
  ScribbleBaseOperator$1(ScribbleBaseOperator paramScribbleBaseOperator, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    ((IMessageFacade)this.this$0.a.getRuntimeService(IMessageFacade.class)).addMessage(this.a, this.this$0.a.getCurrentAccountUin());
    Object localObject = this.this$0;
    MessageForScribble localMessageForScribble = this.a;
    ((ScribbleBaseOperator)localObject).a(localMessageForScribble, localMessageForScribble.localFildPath, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("!!!addMessage uniseq:");
    ((StringBuilder)localObject).append(this.a.uniseq);
    QLog.i("SCRIBBLEMSG", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ScribbleBaseOperator.1
 * JD-Core Version:    0.7.0.1
 */