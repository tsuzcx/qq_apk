package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyProfileDisplayPanel$3
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$3(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a.onBackEvent())
    {
      this.a.a.finish();
      this.a.a.c(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.3
 * JD-Core Version:    0.7.0.1
 */