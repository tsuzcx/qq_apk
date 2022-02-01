package com.tencent.mobileqq.profile.lifeachivement;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LifeAchivementAdapter$2
  implements View.OnClickListener
{
  LifeAchivementAdapter$2(LifeAchivementAdapter paramLifeAchivementAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileLifeachivementLifeAchivementAdapter.a.b(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.lifeachivement.LifeAchivementAdapter.2
 * JD-Core Version:    0.7.0.1
 */