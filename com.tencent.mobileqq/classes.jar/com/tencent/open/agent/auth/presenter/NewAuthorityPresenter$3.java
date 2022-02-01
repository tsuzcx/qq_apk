package com.tencent.open.agent.auth.presenter;

import android.os.Message;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.GetVirtualListResult;

class NewAuthorityPresenter$3
  implements SSOPreAuthPresenter.PreAuthCallback
{
  NewAuthorityPresenter$3(NewAuthorityPresenter paramNewAuthorityPresenter) {}
  
  public void a()
  {
    GetVirtualListResult localGetVirtualListResult = AuthMemoryCache.a().c(this.a.l());
    Message.obtain(NewAuthorityPresenter.d(this.a), 3, localGetVirtualListResult).sendToTarget();
  }
  
  public void a(int paramInt, String paramString)
  {
    SSOLog.a("NewAuthorityPresenter", new Object[] { "getVirtualList onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    if (NewAuthorityPresenter.a(this.a, paramInt, true))
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "getVirtualList handle110537" });
      return;
    }
    if (NewAuthorityPresenter.a(this.a, paramInt, 2))
    {
      SSOLog.b("NewAuthorityPresenter", new Object[] { "getVirtualList handle110509" });
      return;
    }
    Message.obtain(NewAuthorityPresenter.d(this.a), 3, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.3
 * JD-Core Version:    0.7.0.1
 */