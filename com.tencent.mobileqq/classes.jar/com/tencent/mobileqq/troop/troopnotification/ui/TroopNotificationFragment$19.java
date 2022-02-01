package com.tencent.mobileqq.troop.troopnotification.ui;

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
    this.a.d();
    this.a.k();
    if (TroopNotificationFragment.x(this.a) != null) {
      TroopNotificationFragment.x(this.a).setVisibility(8);
    }
    ReportController.b(TroopNotificationFragment.f(this.a), "dc00899", "Grp_contacts_news", "", "notice", "clear_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.19
 * JD-Core Version:    0.7.0.1
 */