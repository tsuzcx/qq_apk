package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class JumpAction$16
  extends ProtoUtils.TroopProtocolObserver
{
  JumpAction$16(JumpAction paramJumpAction, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ForwardStatisticsReporter.a("KEY_STAGE_2_CONNECT_MINI_D55", bool);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.i)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.i = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.d();
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.h) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_AndroidContentContext, 1, 2131699301, 1).a();
      paramArrayOfByte = new Intent(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      paramArrayOfByte.addFlags(67108864);
      paramArrayOfByte.addFlags(268435456);
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_AndroidContentContext.startActivity(paramArrayOfByte);
      JumpAction.c(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    paramBundle = JumpAction.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction);
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51A", "0X800A51A", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, this.b);
      paramBundle.putExtra("mini_app_id", this.b);
      paramBundle.putExtra("mini_app_path", this.c);
      paramBundle.putExtra("mini_app_type", this.d);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_AndroidContentContext.startActivity(paramBundle);
      JumpAction.c(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction);
      return;
      if (paramInt == 25501)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "Account not the same");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51A", "0X800A51A", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, this.b);
        paramBundle.putExtra("mini_app_id", this.b);
        paramBundle.putExtra("mini_app_path", this.c);
        paramBundle.putExtra("mini_app_type", this.d);
        paramBundle.putExtra("openid", this.e);
        paramBundle.putExtra("appid", this.jdField_a_of_type_JavaLangString);
        paramBundle.putExtra("pull_show_open_id_diff_main", true);
      }
      else
      {
        paramArrayOfByte = ForwardMiniAppThirdPartyHelper.a(paramArrayOfByte);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, paramInt, "", "", this.jdField_a_of_type_JavaLangString, this.b);
        if (paramInt == 25601)
        {
          paramBundle.putExtra("pull_mini_app_not_privilege_not_bind", true);
          paramBundle.putExtra("pull_mini_app_not_privilege_not_bind_app_name", this.f);
        }
        paramBundle.putExtra("pull_mini_app_not_privilege", true);
        paramBundle.putExtra("pull_mini_app_not_privilege_string", paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.16
 * JD-Core Version:    0.7.0.1
 */