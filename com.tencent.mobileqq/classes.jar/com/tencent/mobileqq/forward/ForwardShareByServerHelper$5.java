package com.tencent.mobileqq.forward;

import aukj;
import aukw;
import bglp;
import bgpa;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(aukj paramaukj, String paramString) {}
  
  public void run()
  {
    aukw.a("KEY_STAGE_2_TOTAL", false);
    if (aukj.a(this.this$0) == null) {
      aukj.a(this.this$0, bglp.a(aukj.a(this.this$0), 230));
    }
    aukj.a(this.this$0).setMessage(this.a);
    aukj.a(this.this$0).setPositiveButton(2131694081, this.this$0.a);
    aukj.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */