package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopSettingActivity$19
  implements ActionSheet.OnButtonClickListener
{
  TroopSettingActivity$19(TroopSettingActivity paramTroopSettingActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(paramView);
    }
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity))
    {
      paramView = (ITroopMngHandler)TroopSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity).getBusinessHandler(TroopMngHandler.class.getName());
      if (paramView != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.i & 0x1) == 0)
        {
          TroopSettingActivity localTroopSettingActivity = this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity;
          localTroopSettingActivity.i |= 0x1;
          paramView.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131692090, 1000);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692085, 1500);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694475, 1500);
    }
    ReportController.b(TroopSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity), "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.19
 * JD-Core Version:    0.7.0.1
 */