package com.tencent.mobileqq.config.business.qvip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import cooperation.qzone.mobilereport.MobileReportManager;

class QVipTroopFileConfig$3
  implements DialogInterface.OnClickListener
{
  QVipTroopFileConfig$3(QVipTroopFileConfig paramQVipTroopFileConfig, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (this.jdField_a_of_type_Boolean)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQvipQVipTroopFileConfig.h.a(this.jdField_a_of_type_JavaLangString);
      VasH5PayUtil.a((Context)localObject, str);
      paramDialogInterface.dismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label136;
      }
      paramDialogInterface = "0X800AE6A";
      label50:
      localObject = this.jdField_a_of_type_JavaLangString;
      if (!this.b) {
        break label142;
      }
      str = "size";
      label66:
      QVipTroopFileConfig.a(paramDialogInterface, (String)localObject, str);
      localObject = MobileReportManager.getInstance();
      if (!this.jdField_a_of_type_Boolean) {
        break label148;
      }
      paramDialogInterface = "2";
      label88:
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
    }
    label136:
    label142:
    label148:
    label154:
    for (String str = "2";; str = "1")
    {
      ((MobileReportManager)localObject).reportAction("Open", "4", "platform898", paramDialogInterface, str, 102, 1, System.currentTimeMillis());
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQvipQVipTroopFileConfig.i.a(this.jdField_a_of_type_JavaLangString);
      break;
      paramDialogInterface = "0X800AE64";
      break label50;
      str = "full";
      break label66;
      paramDialogInterface = "3";
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipTroopFileConfig.3
 * JD-Core Version:    0.7.0.1
 */