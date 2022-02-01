package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;
import java.util.List;

class SSOSdkAuthApiPresenter$1
  implements OpensdkBusinessObserver
{
  SSOSdkAuthApiPresenter$1(SSOSdkAuthApiPresenter paramSSOSdkAuthApiPresenter, long paramLong1, String paramString1, AccountInfo paramAccountInfo, String paramString2, boolean paramBoolean, String paramString3, List paramList, long paramLong2, AuthCallback paramAuthCallback, String paramString4) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    String str = paramBundle.getString("ssoAccount");
    paramInt = paramBundle.getInt("code");
    SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { "doAuthorize onReceive ssoAccount=", AuthorityUtil.a(str), ", timeCost=", Long.valueOf(l), ", cmd=", this.jdField_a_of_type_JavaLangString, ", code=", Integer.valueOf(paramInt) });
    if (!this.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString.equals(str))
    {
      SSOSdkAuthApiPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSSOSdkAuthApiPresenter, paramInt, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.c, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback, this.d);
      return;
    }
    if (paramBoolean)
    {
      SSOSdkAuthApiPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSSOSdkAuthApiPresenter, paramBundle, l, paramInt, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenModelAccountInfo, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback);
      return;
    }
    SSOSdkAuthApiPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSSOSdkAuthApiPresenter, paramInt, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.c, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback, this.d, this.jdField_a_of_type_ComTencentOpenModelAccountInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SSOSdkAuthApiPresenter.1
 * JD-Core Version:    0.7.0.1
 */