package com.tencent.mobileqq.troop.blocktroop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;

final class TroopBlockUtils$1
  implements DialogInterface.OnClickListener
{
  TroopBlockUtils$1(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramDialogInterface != null)
    {
      TroopInfo localTroopInfo = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null)
      {
        if (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          paramDialogInterface = "0";
        } else if (localTroopInfo.isAdmin()) {
          paramDialogInterface = "1";
        } else {
          paramDialogInterface = "2";
        }
        paramDialogInterface = TroopBlockUtils.jdField_a_of_type_JavaLangString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$ROLE$", paramDialogInterface);
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, 2016, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).createEntryModel(localTroopInfo, this.jdField_a_of_type_JavaLangString), null);
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800B223", "0X800B223", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils.1
 * JD-Core Version:    0.7.0.1
 */