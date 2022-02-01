package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileContentSignComponent$7
  implements View.OnClickListener
{
  ProfileContentSignComponent$7(ProfileContentSignComponent paramProfileContentSignComponent, View paramView) {}
  
  public void onClick(View paramView)
  {
    SigTopicManager.a().c(ProfileContentSignComponent.access$2900(this.this$0));
    this.val$root.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.7
 * JD-Core Version:    0.7.0.1
 */