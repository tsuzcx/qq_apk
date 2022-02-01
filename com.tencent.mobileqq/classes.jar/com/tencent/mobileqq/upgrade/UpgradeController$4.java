package com.tencent.mobileqq.upgrade;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

class UpgradeController$4
  implements Runnable
{
  UpgradeController$4(UpgradeController paramUpgradeController, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((UpgradeController.a(this.this$0) != null) && (UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig != null) && (UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog != null))
    {
      Object localObject = UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog;
      Intent localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((NewUpgradeConfig.Dialog)localObject).jdField_b_of_type_JavaLangString);
      localIntent.putExtra("StrUpgradeDesc", ((NewUpgradeConfig.Dialog)localObject).c);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("strDesc", ((NewUpgradeConfig.Dialog)localObject).d);
      }
      localIntent.putExtra("lBtnText", ((NewUpgradeConfig.Dialog)localObject).i);
      localIntent.putExtra("rBtnText", ((NewUpgradeConfig.Dialog)localObject).j);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("iTipsType", UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      localIntent.putExtra("strConfirmBtnText", UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      if ((UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig != null) && (UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog != null)) {
        localIntent.putExtra("rate", UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData = localIntent;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData = null;
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
      return;
    }
    QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.4
 * JD-Core Version:    0.7.0.1
 */