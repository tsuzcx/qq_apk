package com.tencent.mobileqq.scribble;

import aygh;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class ScribbleBaseOperator$1
  implements Runnable
{
  public ScribbleBaseOperator$1(aygh paramaygh, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    this.this$0.a.a().a(this.a, this.this$0.a.getCurrentAccountUin());
    this.this$0.a(this.a, this.a.localFildPath, null);
    QLog.i("SCRIBBLEMSG", 2, "!!!addMessage uniseq:" + this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleBaseOperator.1
 * JD-Core Version:    0.7.0.1
 */