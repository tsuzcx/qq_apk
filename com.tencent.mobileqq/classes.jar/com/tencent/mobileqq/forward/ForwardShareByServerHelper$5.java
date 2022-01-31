package com.tencent.mobileqq.forward;

import apmf;
import apmt;
import babr;
import bafb;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(apmf paramapmf, String paramString) {}
  
  public void run()
  {
    apmt.a("KEY_STAGE_2_TOTAL", false);
    if (apmf.a(this.this$0) == null) {
      apmf.a(this.this$0, babr.a(apmf.a(this.this$0), 230));
    }
    apmf.a(this.this$0).setMessage(this.a);
    apmf.a(this.this$0).setPositiveButton(2131629116, this.this$0.a);
    apmf.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */