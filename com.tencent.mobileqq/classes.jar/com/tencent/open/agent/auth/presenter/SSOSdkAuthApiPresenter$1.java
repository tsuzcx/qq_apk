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
    long l = System.currentTimeMillis() - this.a;
    String str = paramBundle.getString("ssoAccount");
    paramInt = paramBundle.getInt("code");
    SSOLog.a("SSOSdkAuthApiPresenter", new Object[] { "doAuthorize onReceive ssoAccount=", AuthorityUtil.a(str), ", timeCost=", Long.valueOf(l), ", cmd=", this.b, ", code=", Integer.valueOf(paramInt) });
    if (!this.c.a.equals(str))
    {
      SSOSdkAuthApiPresenter.a(this.k, paramInt, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
      return;
    }
    if (paramBoolean)
    {
      SSOSdkAuthApiPresenter.a(this.k, paramBundle, l, paramInt, this.d, this.b, this.c, this.i);
      return;
    }
    SSOSdkAuthApiPresenter.a(this.k, paramInt, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SSOSdkAuthApiPresenter.1
 * JD-Core Version:    0.7.0.1
 */