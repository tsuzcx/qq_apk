package com.tencent.mobileqq.forward;

import aqft;
import aqgh;
import bbcv;
import bbgg;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(aqft paramaqft, String paramString) {}
  
  public void run()
  {
    aqgh.a("KEY_STAGE_2_TOTAL", false);
    if (aqft.a(this.this$0) == null) {
      aqft.a(this.this$0, bbcv.a(aqft.a(this.this$0), 230));
    }
    aqft.a(this.this$0).setMessage(this.a);
    aqft.a(this.this$0).setPositiveButton(2131694793, this.this$0.a);
    aqft.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */