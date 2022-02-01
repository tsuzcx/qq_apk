package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ScribbleBaseOperator$1
  implements Runnable
{
  ScribbleBaseOperator$1(ScribbleBaseOperator paramScribbleBaseOperator, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    Object localObject = (IMessageFacade)this.this$0.a.getRuntimeService(IMessageFacade.class, "");
    if (localObject == null) {
      return;
    }
    ((IMessageFacade)localObject).addMessage(this.a, this.this$0.a.getCurrentAccountUin());
    localObject = this.this$0;
    MessageForScribble localMessageForScribble = this.a;
    ((ScribbleBaseOperator)localObject).a(localMessageForScribble, localMessageForScribble.localFildPath, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("!!!addMessage uniseq:");
    ((StringBuilder)localObject).append(this.a.uniseq);
    QLog.i("SCRIBBLEMSG", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleBaseOperator.1
 * JD-Core Version:    0.7.0.1
 */