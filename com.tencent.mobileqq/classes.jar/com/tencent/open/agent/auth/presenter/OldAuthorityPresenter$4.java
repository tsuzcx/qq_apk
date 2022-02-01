package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import com.tencent.open.agent.auth.IOldAuthorityContract.View;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;

class OldAuthorityPresenter$4
  implements OpensdkBusinessObserver
{
  OldAuthorityPresenter$4(OldAuthorityPresenter paramOldAuthorityPresenter, String paramString, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfo observer onReceive isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    SSOLog.b("OldAuthorityPresenter", ((StringBuilder)localObject).toString());
    AuthReporter.a("KEY_GET_APP_INFO_REQUEST", this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter.a, paramBoolean);
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter).c();
    localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter.a.jdField_a_of_type_JavaLangString.equals(localObject))
    {
      SSOLog.b("OldAuthorityPresenter", new Object[] { "mAccount.uin != ssoAccount" });
      return;
    }
    if (!paramBoolean) {
      return;
    }
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter, paramBundle, this.jdField_a_of_type_JavaLangString, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.4
 * JD-Core Version:    0.7.0.1
 */