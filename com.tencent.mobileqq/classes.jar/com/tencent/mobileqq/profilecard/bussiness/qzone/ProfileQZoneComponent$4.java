package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileQZoneComponent$4
  implements View.OnClickListener
{
  ProfileQZoneComponent$4(ProfileQZoneComponent paramProfileQZoneComponent) {}
  
  public void onClick(View paramView)
  {
    ProfileQZoneComponent.access$000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.4
 * JD-Core Version:    0.7.0.1
 */