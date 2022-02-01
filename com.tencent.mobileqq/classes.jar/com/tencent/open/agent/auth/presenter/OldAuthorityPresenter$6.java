package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.agent.auth.IOldAuthorityContract.View;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;
import java.util.List;

class OldAuthorityPresenter$6
  implements OpensdkBusinessObserver
{
  OldAuthorityPresenter$6(OldAuthorityPresenter paramOldAuthorityPresenter, String paramString, List paramList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("ssoAccount");
    paramInt = paramBundle.getInt("code");
    this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter.e = (SystemClock.elapsedRealtime() - OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter));
    SSOLog.a("OldAuthorityPresenter", new Object[] { "doAuthorize-onReceive", ", ssoAccount=", AuthorityUtil.a(str), ", uin=", AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter.a.jdField_a_of_type_JavaLangString), ", code=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean), ", cmd=", this.jdField_a_of_type_JavaLangString, ", cost=", Long.valueOf(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter.e), ", mDoAuthorizeRetryCount=", Integer.valueOf(OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter)) });
    if (!this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter.a.jdField_a_of_type_JavaLangString.equals(str))
    {
      if ((paramInt == 1002) && (OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter) < 1))
      {
        OldAuthorityPresenter.b(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter);
        OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter, this.jdField_a_of_type_JavaUtilList, paramBundle);
        return;
      }
      OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter, 0);
      return;
    }
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter).a(true);
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter).c();
    if (paramBoolean)
    {
      OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter, paramBundle, this.jdField_a_of_type_JavaLangString);
      return;
    }
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter, paramInt, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.6
 * JD-Core Version:    0.7.0.1
 */