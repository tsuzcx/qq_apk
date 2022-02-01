package com.tencent.open.agent;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AppInfo;
import com.tencent.open.sdk.checker.BaseAccountChecker.DefaultAccountNotify;
import com.tencent.open.sdk.checker.BaseAccountChecker.IAccountCheckCallback;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$4
  implements BaseAccountChecker.IAccountCheckCallback
{
  AuthorityControlAppDetailsFragment$4(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment, AppInfo paramAppInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment) != null)
    {
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).isFinishing()) {
        return;
      }
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: timeout");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAccount: onError ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QLog.e("AuthorityControlAppDetailsActivity", 1, localStringBuilder.toString());
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment), HardCodeUtil.a(2131694647), 0).a();
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).finish();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment) != null)
    {
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).isFinishing()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAccount: onSuccess same=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("AuthorityControlAppDetailsActivity", 1, ((StringBuilder)localObject).toString());
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: timeout");
        return;
      }
      if (paramBoolean)
      {
        AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).runOnUiThread(new AuthorityControlAppDetailsFragment.4.1(this));
        return;
      }
      localObject = AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).getString(2131690220);
      new BaseAccountChecker.DefaultAccountNotify(AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment), String.format((String)localObject, new Object[] { this.jdField_a_of_type_ComTencentOpenModelAppInfo.b() }), 1).a(new AuthorityControlAppDetailsFragment.4.2(this));
      int i = this.jdField_a_of_type_ComTencentOpenModelAppInfo.a();
      localObject = this.jdField_a_of_type_ComTencentOpenModelAppInfo.b();
      AuthorityUtil.a(AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment), "0X800BAE1", 0, AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment), new String[] { String.valueOf(i), "", localObject, "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.4
 * JD-Core Version:    0.7.0.1
 */