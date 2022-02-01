package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyPeopleProfileActivity$6
  implements View.OnClickListener
{
  NearbyPeopleProfileActivity$6(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!this.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.6
 * JD-Core Version:    0.7.0.1
 */