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
    SSOLog.a("NewAuthorityPresenter", new Object[] { localStringBuilder.toString(), ", triggerReason=", Integer.valueOf(this.a) });
    if (!NewAuthorityPresenter.c(this.b))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "refreshTicketBySSOFailed success Activity Finishing" });
      return;
    }
    AuthMemoryCache.a().a(this.b.l(), paramAccountInfo);
    int i = this.a;
    if (i == 1)
    {
      long l = NewAuthorityPresenter.b(this.b).d();
      paramAccountInfo = NewAuthorityPresenter.e(this.b);
      new SSOSdkAuthApiPresenter().a(this.b.o, NewAuthorityPresenter.f(this.b), NewAuthorityPresenter.g(this.b), paramAccountInfo, l, NewAuthorityPresenter.h(this.b), AuthParamUtil.a(this.b.A));
      return;
    }
    if (i == 2)
    {
      NewAuthorityPresenter.i(this.b);
      return;
    }
    if (i == 3) {
      NewAuthorityPresenter.j(this.b);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (!NewAuthorityPresenter.c(this.b))
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "refreshTicket onFail Activity Finishing" });
      return;
    }
    NewAuthorityPresenter.b(this.b).a(HardCodeUtil.a(2131905669), false);
    this.b.c(paramString);
    if (this.a == 1) {
      AuthReporter.a(this.b.v, "0X800B65F");
    }
    boolean bool = AuthModelUtil.c(paramBundle);
    SSOLog.b("NewAuthorityPresenter", new Object[] { "refreshTicketBySSOFailed triggerReason=", Integer.valueOf(this.a), ", isIMBlock=", Boolean.valueOf(bool), ", uin=", AuthorityUtil.a(paramString) });
    if (bool) {
      BaseOpenSdkQIPCClient.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.5
 * JD-Core Version:    0.7.0.1
 */