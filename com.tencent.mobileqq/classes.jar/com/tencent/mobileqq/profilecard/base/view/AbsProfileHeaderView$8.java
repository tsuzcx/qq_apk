package com.tencent.mobileqq.profilecard.base.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsProfileHeaderView$8
  implements View.OnClickListener
{
  AbsProfileHeaderView$8(AbsProfileHeaderView paramAbsProfileHeaderView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(View paramView)
  {
    AbsProfileHeaderView.access$500(this.this$0, this.val$cardInfo);
    PrettyAccountUtil.a(this.this$0.mApp, this.val$cardInfo, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.8
 * JD-Core Version:    0.7.0.1
 */