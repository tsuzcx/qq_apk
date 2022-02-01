package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCardEditActivity$8
  implements View.OnClickListener
{
  BusinessCardEditActivity$8(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    BusinessCardEditActivity.ItemHolder localItemHolder = (BusinessCardEditActivity.ItemHolder)paramView.getTag();
    this.a.a(localItemHolder.jdField_a_of_type_JavaLangString, localItemHolder.b, localItemHolder.jdField_a_of_type_Boolean);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.8
 * JD-Core Version:    0.7.0.1
 */