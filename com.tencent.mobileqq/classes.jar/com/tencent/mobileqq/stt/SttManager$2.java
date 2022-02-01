package com.tencent.mobileqq.stt;

import bdtt;
import bdtu;
import bdtx;
import com.tencent.mobileqq.data.MessageForPtt;

public class SttManager$2
  implements Runnable
{
  public SttManager$2(bdtt parambdtt, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    bdtt.a(this.this$0, this.a, this.a.getSttResult().c());
    if (this.this$0.a != null) {
      this.this$0.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.2
 * JD-Core Version:    0.7.0.1
 */