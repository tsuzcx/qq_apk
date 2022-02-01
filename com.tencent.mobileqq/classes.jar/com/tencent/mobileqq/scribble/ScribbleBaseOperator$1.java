package com.tencent.mobileqq.scribble;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

class ScribbleBaseOperator$1
  implements Runnable
{
  ScribbleBaseOperator$1(ScribbleBaseOperator paramScribbleBaseOperator, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    this.this$0.a.getMessageFacade().a(this.a, this.this$0.a.getCurrentAccountUin());
    this.this$0.a(this.a, this.a.localFildPath, null);
    QLog.i("SCRIBBLEMSG", 2, "!!!addMessage uniseq:" + this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleBaseOperator.1
 * JD-Core Version:    0.7.0.1
 */