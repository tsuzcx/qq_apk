package com.tencent.mobileqq.register;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqMaskQQLogin;

public class RegisterLimitHelperImpl
  implements RegisterLimitHelperInterface
{
  private static volatile RegisterLimitHelperImpl jdField_a_of_type_ComTencentMobileqqRegisterRegisterLimitHelperImpl;
  private RegisterWithNickAndPwdInfo jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo;
  
  public static RegisterLimitHelperImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRegisterRegisterLimitHelperImpl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqRegisterRegisterLimitHelperImpl == null) {
          jdField_a_of_type_ComTencentMobileqqRegisterRegisterLimitHelperImpl = new RegisterLimitHelperImpl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqRegisterRegisterLimitHelperImpl;
  }
  
  public void a(Context paramContext, String paramString, RegisterWithNickAndPwdInfo paramRegisterWithNickAndPwdInfo)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpWithPhoneProtectUinsUrl, phoneProtectUinsUrl: ");
      localStringBuilder.append(paramString);
      QLog.d("RegisterLimitHelperImpl", 1, localStringBuilder.toString());
      ReportController.a(null, "dc00898", "", "", "0X800B336", "0X800B336", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo = paramRegisterWithNickAndPwdInfo;
      paramRegisterWithNickAndPwdInfo = new Intent();
      paramRegisterWithNickAndPwdInfo.putExtra("url", paramString);
      LoginUtils.a(paramContext, paramRegisterWithNickAndPwdInfo, "/base/browser");
      return;
    }
    QLog.e("RegisterLimitHelperImpl", 1, "jumpWithPhoneProtectUinsUrl error: params invalid");
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo != null))
    {
      QLog.d("RegisterLimitHelperImpl", 1, "recoverIntentFromPhoneProtectReg");
      paramIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("key_register_smscode", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_a_of_type_Boolean);
      paramIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_b_of_type_Boolean);
      paramIntent.putExtra("key_register_from", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("key_register_nick", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_register_password", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.f);
      paramIntent.putExtra("key_register_phonenum_bindnewqq", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_c_of_type_Boolean);
      paramIntent.putExtra("key_register_from_send_sms", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_d_of_type_Boolean);
      paramIntent.putExtra("key_register_from_friend_verify", this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNickAndPwdInfo.jdField_e_of_type_Boolean);
      return;
    }
    QLog.e("RegisterLimitHelperImpl", 1, "recoverIntentFromPhoneProtectReg error: params invalid");
  }
  
  public boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = new StringBuilder();
      paramString2.append("shouldLoginWithMask: true， isNeedLoginFlagFromJsApi: true,  uinEditTextValue: ");
      paramString2.append(paramString1);
      QLog.d("RegisterLimitHelperImpl", 1, paramString2.toString());
      return true;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "shouldLoginWithMask: false");
    return false;
  }
  
  public byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RegisterLimitHelperImpl", 1, "createUinEncryptData error: uinEncrypt invalid");
      return null;
    }
    QLog.d("RegisterLimitHelperImpl", 1, "createUinEncryptData");
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    localReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.set(Utils.a(paramString));
    localReqBody.msg_req_mask_qq_login.setHasFlag(true);
    localReqBody.setHasFlag(true);
    return localReqBody.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterLimitHelperImpl
 * JD-Core Version:    0.7.0.1
 */