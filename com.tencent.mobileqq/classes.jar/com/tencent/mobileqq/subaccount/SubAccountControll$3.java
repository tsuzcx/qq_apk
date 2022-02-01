package com.tencent.mobileqq.subaccount;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;

final class SubAccountControll$3
  implements DialogInterface.OnClickListener
{
  SubAccountControll$3(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SubAccountAssistantForward.b(this.jdField_a_of_type_MqqAppAppRuntime);
    SubAccountAssistantForward.a(this.jdField_a_of_type_MqqAppAppRuntime);
    SubAccountAssistantForward.c(this.jdField_a_of_type_MqqAppAppRuntime);
    SubAccountAssistantForward.d(this.jdField_a_of_type_MqqAppAppRuntime);
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", FrameControllerUtil.a);
    paramDialogInterface.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControll.3
 * JD-Core Version:    0.7.0.1
 */