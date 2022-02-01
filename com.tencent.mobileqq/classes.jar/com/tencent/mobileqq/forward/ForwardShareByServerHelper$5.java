package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardShareByServerHelper$5
  implements Runnable
{
  ForwardShareByServerHelper$5(ForwardShareByServerHelper paramForwardShareByServerHelper, String paramString) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    if (ForwardShareByServerHelper.f(this.this$0) == null)
    {
      ForwardShareByServerHelper localForwardShareByServerHelper = this.this$0;
      ForwardShareByServerHelper.a(localForwardShareByServerHelper, DialogUtil.a(ForwardShareByServerHelper.d(localForwardShareByServerHelper), 230));
    }
    ForwardShareByServerHelper.f(this.this$0).setMessage(this.a);
    ForwardShareByServerHelper.f(this.this$0).setPositiveButton(2131892267, this.this$0.d);
    ForwardShareByServerHelper.f(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */