package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96.RspBody;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class SecurePhoneBannerManager$8
  extends LoginVerifyObserver
{
  SecurePhoneBannerManager$8(SecurePhoneBannerManager paramSecurePhoneBannerManager, QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void getSecurePhoneSuccess(oidb_0xe96.RspBody paramRspBody)
  {
    SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, paramRspBody.str_change_mibao_url.get());
    SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, paramRspBody.uint32_next_access_time.get());
    SecurePhoneBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, paramRspBody.str_tips_content.get());
    SecurePhoneBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, paramRspBody.uint32_display_flag.get());
    SecurePhoneBannerManager.c(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, paramRspBody.str_hori_bar_content.get());
    SecurePhoneBannerManager.d(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, paramRspBody.str_tips_header.get());
    QLog.d("SecurePhoneBannerManager", 1, new Object[] { "getSecurePhoneState, displayTag : ", Integer.valueOf(SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager)) });
    if (SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager) == 1)
    {
      BannerManager.a().a(SecurePhoneChangeNotifyBannerProcessor.a, 2, null);
      SecurePhoneBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B0C3", "0X800B0C3", 0, 0, "", "", "", "");
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009EDE", "0X8009EDE", 24, 0, "", "", "", "");
      return;
    }
    SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, true, "sp_key_secure_phone_notice_time", Integer.valueOf(SecurePhoneBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager.8
 * JD-Core Version:    0.7.0.1
 */