package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuideViewBuilder$1
  implements View.OnClickListener
{
  GuideViewBuilder$1(GuideViewBuilder paramGuideViewBuilder, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */