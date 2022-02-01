package com.tencent.mobileqq.troop.troopnotification.ui;

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
      if (i == 2131446706) {
        TroopNotificationFragment.c(this.a);
      } else if (i == 2131446701) {
        TroopNotificationFragment.d(this.a);
      } else if (i == 2131446710) {
        TroopNotificationFragment.e(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.2
 * JD-Core Version:    0.7.0.1
 */