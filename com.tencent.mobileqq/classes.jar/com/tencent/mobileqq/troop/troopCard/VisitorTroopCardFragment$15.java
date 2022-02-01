package com.tencent.mobileqq.troop.troopCard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class VisitorTroopCardFragment$15
  implements View.OnClickListener
{
  VisitorTroopCardFragment$15(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.a.isOwnerOrAdim())
    {
      TroopReportor.a("grpProfile", "grpProfile_clk", "search_upgrade_actionsheet_click_cancel", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.a.troopUin });
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.15
 * JD-Core Version:    0.7.0.1
 */