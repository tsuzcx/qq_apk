package com.tencent.open.agent;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$2
  implements AuthorityControlAppDetailsFragment.IGetAppInfoCallback
{
  AuthorityControlAppDetailsFragment$2(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment, BasicSdkJumpInfo paramBasicSdkJumpInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment) != null)
    {
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).isFinishing()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppInfo: error code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.e("AuthorityControlAppDetailsActivity", 1, localStringBuilder.toString());
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: timeout");
        return;
      }
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment, 0);
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment), 2131690222, 0).a();
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).finish();
    }
  }
  
  public void a(com.tencent.mobileqq.forward.AppInfo paramAppInfo)
  {
    if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment) != null)
    {
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).isFinishing()) {
        return;
      }
      QLog.i("AuthorityControlAppDetailsActivity", 1, "getAppInfo: success");
      if (AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: timeout");
        return;
      }
      paramAppInfo = new com.tencent.open.model.AppInfo((int)this.jdField_a_of_type_ComTencentOpenSdkDataBasicSdkJumpInfo.a(), paramAppInfo.c(), paramAppInfo.a());
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment).runOnUiThread(new AuthorityControlAppDetailsFragment.2.1(this, paramAppInfo));
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment, paramAppInfo.a(), paramAppInfo.b());
      AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityControlAppDetailsFragment, paramAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.2
 * JD-Core Version:    0.7.0.1
 */