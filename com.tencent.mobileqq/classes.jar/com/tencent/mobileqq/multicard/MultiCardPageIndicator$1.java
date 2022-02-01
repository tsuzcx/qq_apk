package com.tencent.mobileqq.multicard;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnTabClickListener;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.OnTabReselectedListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiCardPageIndicator$1
  implements View.OnClickListener
{
  MultiCardPageIndicator$1(MultiCardPageIndicator paramMultiCardPageIndicator) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClick() called with: view = [");
      ((StringBuilder)localObject1).append(paramView);
      ((StringBuilder)localObject1).append("]");
      QLog.d("TabPageIndicator", 2, ((StringBuilder)localObject1).toString());
    }
    MultiCardPageIndicator.a(this.a, SystemClock.uptimeMillis());
    Object localObject2 = paramView.getTag();
    Object localObject1 = null;
    if ((localObject2 instanceof MultiCardPageIndicator.MultiAIOHolder)) {
      localObject1 = (MultiCardPageIndicator.MultiAIOHolder)localObject2;
    }
    if (localObject1 != null)
    {
      int i = MultiCardPageIndicator.a(this.a).getCurrentItem();
      int j = ((MultiCardPageIndicator.MultiAIOHolder)localObject1).b;
      this.a.setCurrentItem(j);
      ReportController.b(null, "dc00898", "", "", "0X800A216", "0X800A216", 0, 0, "", "", "", "");
      ((MultiCardPageIndicator.MultiAIOHolder)localObject1).a.setVisibility(0);
      MultiCardPageIndicator.a(this.a).setCurrentItem(j);
      if ((i == j) && (MultiCardPageIndicator.b(this.a) != null)) {
        MultiCardPageIndicator.b(this.a).a(j);
      }
      if (MultiCardPageIndicator.c(this.a) != null) {
        MultiCardPageIndicator.c(this.a).a(j);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPageIndicator.1
 * JD-Core Version:    0.7.0.1
 */