package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectMemberActivity$2
  implements View.OnClickListener
{
  SelectMemberActivity$2(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    if (AppSetting.e) {
      this.a.mLeftBackBtn.post(new SelectMemberActivity.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.2
 * JD-Core Version:    0.7.0.1
 */