package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileTitleContainer$4
  implements View.OnClickListener
{
  ProfileTitleContainer$4(ProfileTitleContainer paramProfileTitleContainer) {}
  
  public void onClick(View paramView)
  {
    ProfileTitleContainer.access$1100(this.this$0).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.4
 * JD-Core Version:    0.7.0.1
 */