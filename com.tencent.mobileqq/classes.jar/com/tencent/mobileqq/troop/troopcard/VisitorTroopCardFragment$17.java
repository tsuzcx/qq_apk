package com.tencent.mobileqq.troop.troopcard;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class VisitorTroopCardFragment$17
  implements ActionSheet.OnButtonClickListener
{
  VisitorTroopCardFragment$17(VisitorTroopCardFragment paramVisitorTroopCardFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment) == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment;
      VisitorTroopCardFragment.a(paramView, new QQProgressNotifier(paramView.getActivity()));
    }
    paramView = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext())) && (paramView != null))
    {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).b(0, 2131692086, 0);
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    else if (paramView != null)
    {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).b(2, 2131694475, 1500);
    }
    else
    {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment).b(2, 2131692085, 1500);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardFragment.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.17
 * JD-Core Version:    0.7.0.1
 */