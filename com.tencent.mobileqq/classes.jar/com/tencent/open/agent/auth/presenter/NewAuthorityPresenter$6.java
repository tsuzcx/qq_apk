package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.agent.auth.INewAuthorityContract.View;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;

class NewAuthorityPresenter$6
  implements AuthCallback
{
  NewAuthorityPresenter$6(NewAuthorityPresenter paramNewAuthorityPresenter) {}
  
  public void a(boolean paramBoolean, int paramInt, AuthResponse paramAuthResponse)
  {
    AuthReporter.a("KEY_AUTHORIZE_REQUEST", this.a.w, paramBoolean);
    if ((paramBoolean) && (paramAuthResponse != null))
    {
      Message.obtain(NewAuthorityPresenter.d(this.a), 6, paramAuthResponse).sendToTarget();
      return;
    }
    if (paramInt == 110509)
    {
      if (NewAuthorityPresenter.k(this.a) >= 2)
      {
        NewAuthorityPresenter.b(this.a).a(HardCodeUtil.a(2131905669), false);
        paramAuthResponse = AuthMemoryCache.a().d(this.a.l());
        NewAuthorityPresenter localNewAuthorityPresenter = this.a;
        if (paramAuthResponse == null) {
          paramAuthResponse = null;
        } else {
          paramAuthResponse = paramAuthResponse.a;
        }
        localNewAuthorityPresenter.c(paramAuthResponse);
        AuthReporter.a(this.a.v, "0X800B65F");
        return;
      }
      NewAuthorityPresenter.l(this.a);
      NewAuthorityPresenter.a(this.a, 1);
      return;
    }
    if (paramInt == 110537)
    {
      SSOLog.a("NewAuthorityPresenter", new Object[] { "onDoAuthorize 110537" });
      NewAuthorityPresenter.b(this.a).a(HardCodeUtil.a(2131905671), false);
      paramAuthResponse = this.a;
      paramAuthResponse.c(paramAuthResponse.v);
      return;
    }
    AuthReporter.a(this.a.v, "0X800B65F");
    paramAuthResponse = AuthorityUtil.a(paramAuthResponse, this.a.A.getResources(), paramInt);
    NewAuthorityPresenter.b(this.a).a(paramAuthResponse, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.6
 * JD-Core Version:    0.7.0.1
 */