package com.tencent.mqp.app.sec;

import biyt;
import biyu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class MQPSensitiveMsgUtil$1$1
  implements Runnable
{
  public MQPSensitiveMsgUtil$1$1(biyu parambiyu) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getMsgItemByUniseq(this.this$0.b, this.this$0.c, this.this$0.jdField_a_of_type_Long);
    if (localMessageRecord == null) {
      return;
    }
    biyt.a(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.updateMsgFieldByUniseq(this.this$0.b, this.this$0.c, this.this$0.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1.1
 * JD-Core Version:    0.7.0.1
 */