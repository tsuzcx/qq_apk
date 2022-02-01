package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;

class SttManager$1
  implements Runnable
{
  SttManager$1(SttManager paramSttManager, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    SttManager.a(this.this$0, this.a, this.a.getSttResult().c());
    if (this.this$0.a != null) {
      this.this$0.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.1
 * JD-Core Version:    0.7.0.1
 */