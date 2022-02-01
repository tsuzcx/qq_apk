package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage.GetTicketCallback;

class SelectPermissionPresenter$4
  implements AccountManage.GetTicketCallback
{
  SelectPermissionPresenter$4(SelectPermissionPresenter paramSelectPermissionPresenter) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshTicket success info.uin=");
    localStringBuilder.append(AuthorityUtil.a(paramAccountInfo.a));
    SSOLog.a("SelectPermissionPresenter", new Object[] { localStringBuilder.toString() });
    if (SelectPermissionPresenter.r(this.a))
    {
      SSOLog.a("SelectPermissionPresenter", new Object[] { "refreshTicket success Activity Finishing" });
      return;
    }
    AuthMemoryCache.a().a(SelectPermissionPresenter.b(this.a), paramAccountInfo);
    SelectPermissionPresenter.s(this.a);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    SSOLog.b("SelectPermissionPresenter", new Object[] { "refreshTicket onFail" });
    if (SelectPermissionPresenter.r(this.a))
    {
      SSOLog.a("SelectPermissionPresenter", new Object[] { "refreshTicket onFail Activity Finishing" });
      return;
    }
    SelectPermissionPresenter.p(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.4
 * JD-Core Version:    0.7.0.1
 */