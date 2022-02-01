package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.util.SSOLog;

class SelectPermissionPresenter$3
  implements AuthCallback
{
  SelectPermissionPresenter$3(SelectPermissionPresenter paramSelectPermissionPresenter) {}
  
  public void a(boolean paramBoolean, int paramInt, AuthResponse paramAuthResponse)
  {
    SSOLog.a("SelectPermissionPresenter", new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (SelectPermissionPresenter.a(this.a) == null)
    {
      SSOLog.b("SelectPermissionPresenter", new Object[] { "onDoAuthorize activity is null" });
      return;
    }
    SelectPermissionPresenter.a(this.a).runOnUiThread(new SelectPermissionPresenter.3.1(this, paramBoolean, paramAuthResponse, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.3
 * JD-Core Version:    0.7.0.1
 */