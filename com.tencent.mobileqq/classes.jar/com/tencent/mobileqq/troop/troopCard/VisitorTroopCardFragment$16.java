package com.tencent.mobileqq.troop.troopCard;

import android.view.View;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$16
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$16(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getActionMenuItem(paramInt);
    if (paramView == null) {
      return;
    }
    switch (paramView.action)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.a.troopUin, 5);
      TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity(), paramView);
      TroopReportor.a("grpProfile", "grpProfile_clk", "search_upgrade_actionsheet_click_set", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.a.troopUin });
      continue;
      VisitorTroopCardFragment.f(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.16
 * JD-Core Version:    0.7.0.1
 */