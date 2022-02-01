package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.auth.IBaseView;
import com.tencent.open.agent.util.AuthReporter;

class BaseAuthorityPresenter$6
  implements Runnable
{
  BaseAuthorityPresenter$6(BaseAuthorityPresenter paramBaseAuthorityPresenter, int paramInt, String paramString) {}
  
  public void run()
  {
    this.this$0.z.b();
    this.this$0.z.a(true);
    BaseAuthorityPresenter localBaseAuthorityPresenter = this.this$0;
    localBaseAuthorityPresenter.m = true;
    AuthReporter.a(localBaseAuthorityPresenter.A, this.a, this.b, this.this$0.v, this.this$0.l());
    AuthReporter.a(this.this$0.v, "0X800B65F");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.6
 * JD-Core Version:    0.7.0.1
 */