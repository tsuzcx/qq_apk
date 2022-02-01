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
import com.tencent.mobileqq.troop.utils.TroopUtils;

final class TroopBlockUtils$1
  implements DialogInterface.OnClickListener
{
  TroopBlockUtils$1(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo;
    if (paramDialogInterface != null)
    {
      localTroopInfo = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null)
      {
        if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label135;
        }
        paramDialogInterface = "0";
      }
    }
    for (;;)
    {
      paramDialogInterface = TroopBlockUtils.jdField_a_of_type_JavaLangString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$ROLE$", paramDialogInterface);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidAppActivity, paramDialogInterface, 2016, TroopUtils.a(localTroopInfo, this.jdField_a_of_type_JavaLangString), null);
      ReportController.b(null, "dc00898", "", "", "0X800B223", "0X800B223", 0, 0, "", "", "", "");
      return;
      label135:
      if (localTroopInfo.isAdmin()) {
        paramDialogInterface = "1";
      } else {
        paramDialogInterface = "2";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils.1
 * JD-Core Version:    0.7.0.1
 */