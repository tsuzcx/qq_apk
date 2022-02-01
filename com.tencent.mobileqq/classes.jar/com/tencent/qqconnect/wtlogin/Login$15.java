package com.tencent.qqconnect.wtlogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;

class Login$15
  implements DialogInterface.OnClickListener
{
  Login$15(Login paramLogin, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FrozenNotifyDlgHelper.a().a(null, this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_JavaLangString);
    if (!FrozenNotifyDlgHelper.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginLogin, this.b))
    {
      paramDialogInterface = FrozenNotifyDlgHelper.a().a(this.b, this.c, false);
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentQqconnectWtloginLogin.getActivity(), QQBrowserActivity.class);
      this.jdField_a_of_type_ComTencentQqconnectWtloginLogin.startActivity(localIntent.putExtra("url", paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.15
 * JD-Core Version:    0.7.0.1
 */