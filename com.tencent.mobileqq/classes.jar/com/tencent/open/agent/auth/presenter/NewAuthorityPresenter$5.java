package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.BaseOpenSdkQIPCClient;
import com.tencent.open.agent.auth.INewAuthorityContract.View;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage.GetTicketCallback;

class NewAuthorityPresenter$5
  implements AccountManage.GetTicketCallback
{
  NewAuthorityPresenter$5(NewAuthorityPresenter paramNewAuthorityPresenter, int paramInt) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshTicketBySSOFailed success info.uin=");
    localStringBuilder.append(AuthorityUtil.a(paramAccountInfo.a));
    SSOLog.a("NewAuthorityPresenter", new Object[] { localStringBuilder.toString(), ", triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (!NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "refreshTicketBySSOFailed success Activity Finishing" });
      return;
    }
    AuthMemoryCache.a().a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter.a(), paramAccountInfo);
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      long l = NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter).a();
      paramAccountInfo = NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter);
      new SSOSdkAuthApiPresenter().a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter.f, NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter), NewAuthorityPresenter.b(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter), paramAccountInfo, l, NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter), AuthParamUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter.a));
      return;
    }
    if (i == 2)
    {
      NewAuthorityPresenter.b(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter);
      return;
    }
    if (i == 3) {
      NewAuthorityPresenter.c(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (!NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "refreshTicket onFail Activity Finishing" });
      return;
    }
    NewAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter).a(HardCodeUtil.a(2131707855), false);
    this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter.c(paramString);
    if (this.jdField_a_of_type_Int == 1) {
      AuthReporter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterNewAuthorityPresenter.d, "0X800B65F");
    }
    boolean bool = AuthModelUtil.a(paramBundle);
    SSOLog.b("NewAuthorityPresenter", new Object[] { "refreshTicketBySSOFailed triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int), ", isIMBlock=", Boolean.valueOf(bool), ", uin=", AuthorityUtil.a(paramString) });
    if (bool) {
      BaseOpenSdkQIPCClient.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.5
 * JD-Core Version:    0.7.0.1
 */