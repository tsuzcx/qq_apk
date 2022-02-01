package com.tencent.mobileqq.troop.troopnotification;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopNotificationFragment$2
  implements View.OnClickListener
{
  TroopNotificationFragment$2(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i = paramView.getId();
      if (i == 2131378189) {
        TroopNotificationFragment.a(this.a);
      } else if (i == 2131378184) {
        TroopNotificationFragment.b(this.a);
      } else if (i == 2131378193) {
        TroopNotificationFragment.c(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.2
 * JD-Core Version:    0.7.0.1
 */