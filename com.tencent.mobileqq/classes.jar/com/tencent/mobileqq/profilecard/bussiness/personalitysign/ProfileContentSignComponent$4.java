package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileContentSignComponent$4
  implements View.OnClickListener
{
  ProfileContentSignComponent$4(ProfileContentSignComponent paramProfileContentSignComponent, View paramView) {}
  
  public void onClick(View paramView)
  {
    SigTopicManager.a().c(ProfileContentSignComponent.access$2500(this.this$0));
    this.val$topicView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.4
 * JD-Core Version:    0.7.0.1
 */