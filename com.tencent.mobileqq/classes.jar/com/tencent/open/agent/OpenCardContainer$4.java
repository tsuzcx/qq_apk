package com.tencent.open.agent;

import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.util.SSOLog;

class OpenCardContainer$4
  implements OpenCardContainer.AccountEventListener
{
  OpenCardContainer$4(OpenCardContainer paramOpenCardContainer) {}
  
  public void a()
  {
    OpenCardContainer.a(this.a).e();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    OpenCardContainer.a(this.a).a(paramString, paramBoolean);
  }
  
  public void b()
  {
    SSOLog.a("OpenCardContainer", new Object[] { "onAddAccount" });
    OpenCardContainer.a(this.a).f();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.4
 * JD-Core Version:    0.7.0.1
 */