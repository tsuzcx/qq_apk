package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
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
    default: 
      break;
    case 11: 
      VisitorTroopCardFragment.d(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment);
      break;
    case 10: 
      TroopReportor.a("grpProfile", "grpProfile_clk", "more_tipoff_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).doReportTroop(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentCommonAppAppInterface);
      break;
    case 9: 
      TroopReportor.a("grpProfile", "grpProfile_clk", "more_share_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      VisitorTroopCardFragment.e(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.14
 * JD-Core Version:    0.7.0.1
 */