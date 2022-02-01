package com.tencent.mobileqq.stt;

import bcmt;
import bcmu;
import bcmx;
import com.tencent.mobileqq.data.MessageForPtt;

public class SttManager$3
  implements Runnable
{
  public SttManager$3(bcmt parambcmt, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    bcmt.a(this.this$0, this.a, this.a.getSttResult().c());
    if (this.this$0.a != null) {
      this.this$0.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.3
 * JD-Core Version:    0.7.0.1
 */