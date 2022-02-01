package com.tencent.mobileqq.upgrade;

import android.content.Intent;
import anvl;
import bhdl;
import bhdu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$2
  implements Runnable
{
  public UpgradeController$2(bhdu parambhdu, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((bhdu.a(this.this$0) == null) || (bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {
      QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }
    Intent localIntent;
    do
    {
      return;
      Object localObject = bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog;
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((bhdl)localObject).jdField_b_of_type_JavaLangString);
      localIntent.putExtra("StrUpgradeDesc", ((bhdl)localObject).c);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("strDesc", ((bhdl)localObject).d);
      }
      localIntent.putExtra("lBtnText", ((bhdl)localObject).i);
      localIntent.putExtra("rBtnText", ((bhdl)localObject).j);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("iTipsType", bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      localIntent.putExtra("strConfirmBtnText", bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      if ((bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig != null) && (bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog != null)) {
        localIntent.putExtra("rate", bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_b_of_type_Int);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = localIntent;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = null;
    } while (BaseActivity.sTopActivity == null);
    BaseActivity.sTopActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.2
 * JD-Core Version:    0.7.0.1
 */