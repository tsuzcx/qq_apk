package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class VisitorTroopCardFragment$15
  implements View.OnClickListener
{
  VisitorTroopCardFragment$15(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    if (this.b.W.isOwnerOrAdim())
    {
      TroopReportor.a("grpProfile", "grpProfile_clk", "search_upgrade_actionsheet_click_cancel", 0, 0, new String[] { this.b.W.troopUin });
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.15
 * JD-Core Version:    0.7.0.1
 */