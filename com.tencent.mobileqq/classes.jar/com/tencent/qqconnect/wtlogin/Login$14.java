package com.tencent.qqconnect.wtlogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;

class Login$14
  implements DialogInterface.OnClickListener
{
  Login$14(Login paramLogin, ISafeBlockApi paramISafeBlockApi, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqsecApiISafeBlockApi.reportFrozenDlg(null, this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_ComTencentMobileqqQqsecApiISafeBlockApi.unBlockWithMiniAppFromCnt(this.jdField_a_of_type_ComTencentQqconnectWtloginLogin, this.b))
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqQqsecApiISafeBlockApi.getJumpAQH5Url(this.b, this.c, false);
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentQqconnectWtloginLogin.getActivity(), QQBrowserActivity.class);
      this.jdField_a_of_type_ComTencentQqconnectWtloginLogin.startActivity(localIntent.putExtra("url", paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.14
 * JD-Core Version:    0.7.0.1
 */