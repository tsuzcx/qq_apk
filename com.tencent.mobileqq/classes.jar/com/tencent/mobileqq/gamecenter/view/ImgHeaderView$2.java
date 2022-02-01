package com.tencent.mobileqq.gamecenter.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImgHeaderView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewImgHeaderView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ImgHeaderView.2
 * JD-Core Version:    0.7.0.1
 */