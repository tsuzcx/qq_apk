package com.tencent.open.agent.strategy;

import android.os.Bundle;
import com.tencent.open.agent.auth.presenter.SSOPreAuthPresenter.PreAuthCallback;
import com.tencent.open.agent.util.SSOLog;

class SSOLoginAction$4
  implements SSOPreAuthPresenter.PreAuthCallback
{
  SSOLoginAction$4(SSOLoginAction paramSSOLoginAction, Bundle paramBundle, String paramString, int paramInt) {}
  
  public void a()
  {
    SSOLog.a("SSOLoginAction", new Object[] { "preAuth onSuccess" });
    SSOLoginAction.a(this.d);
    SSOLoginAction.a(this.d, this.a, this.b, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "preAuth onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    SSOLoginAction.a(this.d);
    SSOLoginAction.a(this.d, paramInt, paramString, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.4
 * JD-Core Version:    0.7.0.1
 */