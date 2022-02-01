package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;

class SttManager$3
  implements Runnable
{
  SttManager$3(SttManager paramSttManager, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    SttManager localSttManager = this.this$0;
    MessageForPtt localMessageForPtt = this.a;
    SttManager.a(localSttManager, localMessageForPtt, localMessageForPtt.getSttResult().h());
    if (this.this$0.b != null) {
      this.this$0.b.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.3
 * JD-Core Version:    0.7.0.1
 */