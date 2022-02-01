package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhoneContactTabView$1
  implements View.OnClickListener
{
  PhoneContactTabView$1(PhoneContactTabView paramPhoneContactTabView) {}
  
  public void onClick(View paramView)
  {
    PhoneContactTabView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.1
 * JD-Core Version:    0.7.0.1
 */