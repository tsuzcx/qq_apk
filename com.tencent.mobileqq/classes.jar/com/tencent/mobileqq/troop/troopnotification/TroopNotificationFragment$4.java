package com.tencent.mobileqq.troop.troopnotification;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopNotificationFragment$4
  implements View.OnClickListener
{
  TroopNotificationFragment$4(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      TroopNotificationFragment.a(this.a).finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.4
 * JD-Core Version:    0.7.0.1
 */