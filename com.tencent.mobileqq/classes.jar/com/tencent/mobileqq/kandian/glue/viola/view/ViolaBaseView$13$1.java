package com.tencent.mobileqq.kandian.glue.viola.view;

import android.os.Handler;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$13$1
  implements FPSCalculator.GetFPSListener
{
  ViolaBaseView$13$1(ViolaBaseView.13 param13) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (ViolaBaseView.a(this.a.this$0) == 0.0D)
    {
      ViolaBaseView.a(this.a.this$0, paramDouble);
      ViolaBaseView.a(this.a.this$0).addReportData(ViolaEnvironment.KEY_FRAME_PAGE, String.format("%.2f", new Object[] { Double.valueOf(ViolaBaseView.a(this.a.this$0)) }));
    }
    new Handler().postDelayed(new ViolaBaseView.13.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.13.1
 * JD-Core Version:    0.7.0.1
 */