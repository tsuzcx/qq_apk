package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCardEditActivity$5
  implements View.OnClickListener
{
  BusinessCardEditActivity$5(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    BusinessCardEditActivity.ItemHolder localItemHolder = (BusinessCardEditActivity.ItemHolder)paramView.getTag();
    this.a.a(localItemHolder.a, localItemHolder.b, localItemHolder.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.5
 * JD-Core Version:    0.7.0.1
 */