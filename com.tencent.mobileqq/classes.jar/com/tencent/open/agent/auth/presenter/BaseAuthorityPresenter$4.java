package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.util.AuthorityUtil;

class BaseAuthorityPresenter$4
  implements Runnable
{
  BaseAuthorityPresenter$4(BaseAuthorityPresenter paramBaseAuthorityPresenter, int paramInt, String paramString) {}
  
  public void run()
  {
    String str = AuthorityUtil.b(new Object[] { "ret", Integer.valueOf(this.a), "msg", this.b });
    this.this$0.a(this.a, str, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.4
 * JD-Core Version:    0.7.0.1
 */