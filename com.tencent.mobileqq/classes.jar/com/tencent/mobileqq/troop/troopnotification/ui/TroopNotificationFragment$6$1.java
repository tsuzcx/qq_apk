package com.tencent.mobileqq.troop.troopnotification.ui;

import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;

class TroopNotificationFragment$6$1
  implements Runnable
{
  TroopNotificationFragment$6$1(TroopNotificationFragment.6 param6) {}
  
  public void run()
  {
    if (this.a.a.a != null) {
      this.a.a.a.notifyDataSetChanged();
    }
    if (TroopNotificationFragment.k(this.a.a) != null) {
      TroopNotificationFragment.k(this.a.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.6.1
 * JD-Core Version:    0.7.0.1
 */