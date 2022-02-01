package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.utils.TroopReportor;
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
    paramInt = paramView.action;
    if (paramInt != 9)
    {
      if (paramInt == 12)
      {
        paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.a.troopUin, 5);
        ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.getActivity(), paramView);
        TroopReportor.a("grpProfile", "grpProfile_clk", "search_upgrade_actionsheet_click_set", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.a.troopUin });
      }
    }
    else {
      VisitorTroopCardFragment.f(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.16
 * JD-Core Version:    0.7.0.1
 */