package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;

class NewAuthorityPresenter$7
  implements CGICallback
{
  NewAuthorityPresenter$7(NewAuthorityPresenter paramNewAuthorityPresenter, AccountInfo paramAccountInfo) {}
  
  public boolean a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "deleteVirtual result=", paramString1, ", success=", Boolean.valueOf(paramBoolean) });
    AuthReporter.a("KEY_DELETE_VIRTUAL_D18", this.a, paramBoolean);
    if (paramBoolean)
    {
      NewAuthorityPresenter.a(this.b, paramString1, paramInt);
      return false;
    }
    this.b.a(paramInt);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.7
 * JD-Core Version:    0.7.0.1
 */