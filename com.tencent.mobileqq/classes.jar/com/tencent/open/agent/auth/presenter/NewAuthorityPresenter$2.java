package com.tencent.open.agent.auth.presenter;

import android.os.Message;
import com.tencent.open.agent.auth.INewAuthorityContract.View;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;

class NewAuthorityPresenter$2
  implements SSOPreAuthPresenter.PreAuthCallback
{
  NewAuthorityPresenter$2(NewAuthorityPresenter paramNewAuthorityPresenter) {}
  
  public void a()
  {
    if (!NewAuthorityPresenter.a(this.a))
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer onSuccess for activity is finished" });
      return;
    }
    Object localObject = AuthMemoryCache.a().a(this.a.a());
    SSOLog.a("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer use cached realAppId=", this.a.a(), ", appInfo=", localObject });
    Message.obtain(NewAuthorityPresenter.a(this.a), 5, localObject);
    localObject = AuthMemoryCache.a().a(this.a.a());
    SSOLog.a("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer back, virtualResult=", localObject });
    Message.obtain(NewAuthorityPresenter.a(this.a), 3, localObject).sendToTarget();
    if (!this.a.e) {
      NewAuthorityPresenter.a(this.a).a(true);
    }
    localObject = AuthMemoryCache.a().a(this.a.a());
    Message.obtain(NewAuthorityPresenter.a(this.a), 4, localObject).sendToTarget();
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updatePreAuthFromServer | onFail: | uin : *");
    localStringBuilder.append(AuthorityUtil.a(this.a.a.a));
    SSOLog.a("NewAuthorityPresenter", new Object[] { localStringBuilder.toString(), ", errorCode=", Integer.valueOf(paramInt), ", errorMsg=", paramString });
    if (!NewAuthorityPresenter.a(this.a))
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer onFail for activity is finished" });
      return;
    }
    if (NewAuthorityPresenter.a(this.a, paramInt, false))
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer handle110537" });
      return;
    }
    if (NewAuthorityPresenter.a(this.a, paramInt, 3))
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "updatePreAuthFromServer handle110509" });
      return;
    }
    Message.obtain(NewAuthorityPresenter.a(this.a), 3, null).sendToTarget();
    this.a.a(3001, 2131694639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.2
 * JD-Core Version:    0.7.0.1
 */