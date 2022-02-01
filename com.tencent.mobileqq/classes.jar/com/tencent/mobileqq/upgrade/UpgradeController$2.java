package com.tencent.mobileqq.upgrade;

import android.content.Intent;
import ansg;
import bgvo;
import bgvx;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$2
  implements Runnable
{
  public UpgradeController$2(bgvx parambgvx, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((bgvx.a(this.this$0) == null) || (bgvx.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (bgvx.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {
      QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }
    Intent localIntent;
    do
    {
      return;
      Object localObject = bgvx.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog;
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((bgvo)localObject).jdField_b_of_type_JavaLangString);
      localIntent.putExtra("StrUpgradeDesc", ((bgvo)localObject).c);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("strDesc", ((bgvo)localObject).d);
      }
      localIntent.putExtra("lBtnText", ((bgvo)localObject).i);
      localIntent.putExtra("rBtnText", ((bgvo)localObject).j);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", bgvx.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("iTipsType", bgvx.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      localIntent.putExtra("strConfirmBtnText", bgvx.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", bgvx.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", bgvx.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      if ((bgvx.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig != null) && (bgvx.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog != null)) {
        localIntent.putExtra("rate", bgvx.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = ansg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData = localIntent;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.upgradeData = null;
    } while (BaseActivity.sTopActivity == null);
    BaseActivity.sTopActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.2
 * JD-Core Version:    0.7.0.1
 */