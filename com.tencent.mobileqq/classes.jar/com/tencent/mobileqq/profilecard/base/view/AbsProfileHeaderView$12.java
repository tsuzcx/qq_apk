package com.tencent.mobileqq.profilecard.base.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsProfileHeaderView$12
  implements View.OnClickListener
{
  AbsProfileHeaderView$12(AbsProfileHeaderView paramAbsProfileHeaderView, View paramView) {}
  
  public void onClick(View paramView)
  {
    SigTopicManager.a().c(this.this$0.mApp);
    this.val$topicView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.12
 * JD-Core Version:    0.7.0.1
 */