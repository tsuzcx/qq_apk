package com.tencent.mobileqq.troop.troopnotification.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopRequestActivity$9
  implements ActionSheet.OnButtonClickListener
{
  TroopRequestActivity$9(TroopRequestActivity paramTroopRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity);
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity, 2131719980, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity.getTitleBarHeight());
      }
      ReportController.b(TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity), "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity.a, this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationActivityTroopRequestActivity.u, "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.9
 * JD-Core Version:    0.7.0.1
 */