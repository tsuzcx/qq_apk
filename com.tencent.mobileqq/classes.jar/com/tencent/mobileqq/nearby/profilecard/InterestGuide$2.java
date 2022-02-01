package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class InterestGuide$2
  implements Runnable
{
  InterestGuide$2(InterestGuide paramInterestGuide) {}
  
  public void run()
  {
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.this$0.d, "interest_guide_key", Boolean.FALSE);
    Context localContext = this.this$0.g.getContext();
    if ((localContext instanceof BaseActivity)) {
      ReportController.b(((BaseActivity)localContext).app, "dc00898", "", "", "0X8006991", "0X8006991", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.2
 * JD-Core Version:    0.7.0.1
 */