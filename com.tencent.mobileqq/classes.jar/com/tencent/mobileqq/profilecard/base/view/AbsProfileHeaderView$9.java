package com.tencent.mobileqq.profilecard.base.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsProfileHeaderView$9
  implements View.OnClickListener
{
  AbsProfileHeaderView$9(AbsProfileHeaderView paramAbsProfileHeaderView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(View paramView)
  {
    AbsProfileHeaderView.access$500(this.this$0, this.val$cardInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.9
 * JD-Core Version:    0.7.0.1
 */