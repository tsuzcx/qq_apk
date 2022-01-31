package com.tencent.mobileqq.forward;

import aqfv;
import aqgj;
import bbdj;
import bbgu;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(aqfv paramaqfv, String paramString) {}
  
  public void run()
  {
    aqgj.a("KEY_STAGE_2_TOTAL", false);
    if (aqfv.a(this.this$0) == null) {
      aqfv.a(this.this$0, bbdj.a(aqfv.a(this.this$0), 230));
    }
    aqfv.a(this.this$0).setMessage(this.a);
    aqfv.a(this.this$0).setPositiveButton(2131694794, this.this$0.a);
    aqfv.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */