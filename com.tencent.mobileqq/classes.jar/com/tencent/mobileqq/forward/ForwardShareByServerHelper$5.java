package com.tencent.mobileqq.forward;

import asdt;
import aseh;
import bdgm;
import bdjz;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(asdt paramasdt, String paramString) {}
  
  public void run()
  {
    aseh.a("KEY_STAGE_2_TOTAL", false);
    if (asdt.a(this.this$0) == null) {
      asdt.a(this.this$0, bdgm.a(asdt.a(this.this$0), 230));
    }
    asdt.a(this.this$0).setMessage(this.a);
    asdt.a(this.this$0).setPositiveButton(2131694953, this.this$0.a);
    asdt.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */