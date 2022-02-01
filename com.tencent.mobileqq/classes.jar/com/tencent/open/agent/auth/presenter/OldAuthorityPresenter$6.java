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
    this.c.f = (SystemClock.elapsedRealtime() - OldAuthorityPresenter.c(this.c));
    SSOLog.a("OldAuthorityPresenter", new Object[] { "doAuthorize-onReceive", ", ssoAccount=", AuthorityUtil.a(str), ", uin=", AuthorityUtil.a(this.c.w.a), ", code=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean), ", cmd=", this.a, ", cost=", Long.valueOf(this.c.f), ", mDoAuthorizeRetryCount=", Integer.valueOf(OldAuthorityPresenter.d(this.c)) });
    if (!this.c.w.a.equals(str))
    {
      if ((paramInt == 1002) && (OldAuthorityPresenter.d(this.c) < 1))
      {
        OldAuthorityPresenter.e(this.c);
        OldAuthorityPresenter.a(this.c, this.b, paramBundle);
        return;
      }
      OldAuthorityPresenter.a(this.c, 0);
      return;
    }
    OldAuthorityPresenter.a(this.c).a(true);
    OldAuthorityPresenter.a(this.c).c();
    if (paramBoolean)
    {
      OldAuthorityPresenter.a(this.c, paramBundle, this.a);
      return;
    }
    OldAuthorityPresenter.a(this.c, paramInt, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.6
 * JD-Core Version:    0.7.0.1
 */