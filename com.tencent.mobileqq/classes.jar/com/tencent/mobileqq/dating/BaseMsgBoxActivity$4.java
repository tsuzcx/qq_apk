package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseMsgBoxActivity$4
  implements Runnable
{
  BaseMsgBoxActivity$4(BaseMsgBoxActivity paramBaseMsgBoxActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    ((MessageHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(this.a, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.4
 * JD-Core Version:    0.7.0.1
 */