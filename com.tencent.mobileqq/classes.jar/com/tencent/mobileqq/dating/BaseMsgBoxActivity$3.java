package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseMsgBoxActivity$3
  implements Runnable
{
  BaseMsgBoxActivity$3(BaseMsgBoxActivity paramBaseMsgBoxActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    ((MessageHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.3
 * JD-Core Version:    0.7.0.1
 */