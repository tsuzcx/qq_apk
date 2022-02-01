package com.tencent.mobileqq.troop.troopnotification;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;

class TroopNotificationFragment$19
  implements DialogInterface.OnClickListener
{
  TroopNotificationFragment$19(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.c();
    this.a.i();
    if (TroopNotificationFragment.b(this.a) != null) {
      TroopNotificationFragment.b(this.a).setVisibility(8);
    }
    ReportController.b(TroopNotificationFragment.a(this.a), "dc00899", "Grp_contacts_news", "", "notice", "clear_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.19
 * JD-Core Version:    0.7.0.1
 */