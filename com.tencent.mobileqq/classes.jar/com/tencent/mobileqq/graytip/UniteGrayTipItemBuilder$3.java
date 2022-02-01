package com.tencent.mobileqq.graytip;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UniteGrayTipItemBuilder$3
  implements View.OnClickListener
{
  UniteGrayTipItemBuilder$3(UniteGrayTipItemBuilder paramUniteGrayTipItemBuilder, UniteGrayTipItemBuilder.Holder paramHolder) {}
  
  public void onClick(View paramView)
  {
    UniteGrayTipItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder, this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder$Holder.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */