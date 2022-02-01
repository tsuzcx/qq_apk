package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileAccountLevelComponent$2
  implements View.OnClickListener
{
  ProfileAccountLevelComponent$2(ProfileAccountLevelComponent paramProfileAccountLevelComponent, TextView paramTextView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.val$noticeTextView.setVisibility(8);
    VasH5PayUtil.a(paramView.getContext(), VasExtensionManager.b(this.val$noticeValue), VasExtensionManager.c(this.val$noticeValue), 3, false, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent.2
 * JD-Core Version:    0.7.0.1
 */