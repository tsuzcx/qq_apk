package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;

class QVipTroopFileConfig$4
  implements DialogInterface.OnClickListener
{
  QVipTroopFileConfig$4(QVipTroopFileConfig paramQVipTroopFileConfig, Runnable paramRunnable, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_JavaLangRunnable.run();
    if (this.jdField_a_of_type_Boolean) {
      paramDialogInterface = "0X800AE6B";
    } else {
      paramDialogInterface = "0X800AE65";
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    String str;
    if (this.b) {
      str = "size";
    } else {
      str = "full";
    }
    QVipTroopFileConfig.a(paramDialogInterface, (String)localObject, str);
    localObject = (IMobileReportManager)QRoute.api(IMobileReportManager.class);
    if (this.jdField_a_of_type_Boolean) {
      paramDialogInterface = "2";
    } else {
      paramDialogInterface = "3";
    }
    if (this.jdField_a_of_type_Boolean) {
      str = "2";
    } else {
      str = "1";
    }
    ((IMobileReportManager)localObject).reportAction("Later", "4", "platform898", paramDialogInterface, str, 102, 1, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig.4
 * JD-Core Version:    0.7.0.1
 */