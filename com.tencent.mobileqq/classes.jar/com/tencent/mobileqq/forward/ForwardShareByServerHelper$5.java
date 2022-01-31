package com.tencent.mobileqq.forward;

import arzk;
import arzy;
import bdcd;
import bdfq;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(arzk paramarzk, String paramString) {}
  
  public void run()
  {
    arzy.a("KEY_STAGE_2_TOTAL", false);
    if (arzk.a(this.this$0) == null) {
      arzk.a(this.this$0, bdcd.a(arzk.a(this.this$0), 230));
    }
    arzk.a(this.this$0).setMessage(this.a);
    arzk.a(this.this$0).setPositiveButton(2131694951, this.this$0.a);
    arzk.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */