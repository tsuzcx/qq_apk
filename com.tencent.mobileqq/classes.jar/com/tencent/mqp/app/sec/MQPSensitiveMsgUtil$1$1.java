package com.tencent.mqp.app.sec;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

class MQPSensitiveMsgUtil$1$1
  implements Runnable
{
  MQPSensitiveMsgUtil$1$1(MQPSensitiveMsgUtil.1 param1) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.d.a(this.this$0.e, this.this$0.f, this.this$0.g);
    if (localMessageRecord == null) {
      return;
    }
    MQPSensitiveMsgUtil.a(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.this$0.d.a(this.this$0.e, this.this$0.f, this.this$0.g, "extStr", localMessageRecord.extStr);
      this.this$0.d.a(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1.1
 * JD-Core Version:    0.7.0.1
 */