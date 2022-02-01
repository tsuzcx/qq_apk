package com.tencent.mobileqq.multiaio.widget;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TabPageIndicator$2
  implements View.OnClickListener
{
  TabPageIndicator$2(TabPageIndicator paramTabPageIndicator) {}
  
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
    TabPageIndicator.a(this.a, SystemClock.uptimeMillis());
    Object localObject2 = paramView.getTag();
    Object localObject1 = null;
    if ((localObject2 instanceof TabPageIndicator.MultiAIOHolder)) {
      localObject1 = (TabPageIndicator.MultiAIOHolder)localObject2;
    }
    if (localObject1 != null)
    {
      int i = TabPageIndicator.a(this.a).a();
      int j = ((TabPageIndicator.MultiAIOHolder)localObject1).jdField_a_of_type_Int;
      this.a.setCurrentItem(j);
      ((TabPageIndicator.MultiAIOHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      TabPageIndicator.a(this.a).setCurrentItem(j);
      if ((i == j) && (TabPageIndicator.a(this.a) != null)) {
        TabPageIndicator.a(this.a).a(j);
      }
      if (TabPageIndicator.a(this.a) != null) {
        TabPageIndicator.a(this.a).a(j);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.TabPageIndicator.2
 * JD-Core Version:    0.7.0.1
 */