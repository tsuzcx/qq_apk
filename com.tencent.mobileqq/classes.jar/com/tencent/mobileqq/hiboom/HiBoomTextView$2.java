package com.tencent.mobileqq.hiboom;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForHiBoom;

class HiBoomTextView$2
  implements Runnable
{
  HiBoomTextView$2(HiBoomTextView paramHiBoomTextView) {}
  
  public void run()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getMessageFacade().a(HiBoomTextView.a(this.this$0).jdField_a_of_type_JavaLangString, HiBoomTextView.a(this.this$0).jdField_a_of_type_Int, HiBoomTextView.a(this.this$0).uniseq, "extStr", HiBoomTextView.a(this.this$0).extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.2
 * JD-Core Version:    0.7.0.1
 */