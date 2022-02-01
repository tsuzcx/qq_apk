package com.tencent.mobileqq.forward;

import avcj;
import avcw;
import bhlq;
import bhpc;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(avcj paramavcj, String paramString) {}
  
  public void run()
  {
    avcw.a("KEY_STAGE_2_TOTAL", false);
    if (avcj.a(this.this$0) == null) {
      avcj.a(this.this$0, bhlq.a(avcj.a(this.this$0), 230));
    }
    avcj.a(this.this$0).setMessage(this.a);
    avcj.a(this.this$0).setPositiveButton(2131694098, this.this$0.a);
    avcj.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */