package com.tencent.mobileqq.troop.troopCard;

import android.view.View;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$14
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$14(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
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
      VisitorTroopCardFragment.d(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment);
      continue;
      TroopReportor.a("grpProfile", "grpProfile_clk", "more_tipoff_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      TroopReportor.a("grpProfile", "grpProfile_clk", "more_share_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      VisitorTroopCardFragment.e(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.14
 * JD-Core Version:    0.7.0.1
 */