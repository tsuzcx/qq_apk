package com.tencent.mobileqq.forward;

import auui;
import auuv;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(auui paramauui, String paramString) {}
  
  public void run()
  {
    auuv.a("KEY_STAGE_2_TOTAL", false);
    if (auui.a(this.this$0) == null) {
      auui.a(this.this$0, bhdj.a(auui.a(this.this$0), 230));
    }
    auui.a(this.this$0).setMessage(this.a);
    auui.a(this.this$0).setPositiveButton(2131694399, this.this$0.a);
    auui.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */