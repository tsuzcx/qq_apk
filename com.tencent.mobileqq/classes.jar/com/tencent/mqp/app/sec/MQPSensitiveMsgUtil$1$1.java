package com.tencent.mqp.app.sec;

import bfam;
import bfan;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class MQPSensitiveMsgUtil$1$1
  implements Runnable
{
  public MQPSensitiveMsgUtil$1$1(bfan parambfan) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.this$0.b, this.this$0.c, this.this$0.jdField_a_of_type_Long);
    if (localMessageRecord == null) {
      return;
    }
    bfam.a(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.this$0.b, this.this$0.c, this.this$0.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1.1
 * JD-Core Version:    0.7.0.1
 */