package com.tencent.mobileqq.forward;

import atpn;
import atqa;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(atpn paramatpn, String paramString) {}
  
  public void run()
  {
    atqa.a("KEY_STAGE_2_TOTAL", false);
    if (atpn.a(this.this$0) == null) {
      atpn.a(this.this$0, bfur.a(atpn.a(this.this$0), 230));
    }
    atpn.a(this.this$0).setMessage(this.a);
    atpn.a(this.this$0).setPositiveButton(2131694201, this.this$0.a);
    atpn.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */