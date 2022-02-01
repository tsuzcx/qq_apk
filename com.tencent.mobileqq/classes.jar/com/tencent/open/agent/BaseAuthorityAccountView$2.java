package com.tencent.open.agent;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.util.SSOLog;
import mqq.os.MqqHandler;

class BaseAuthorityAccountView$2
  implements Runnable
{
  BaseAuthorityAccountView$2(BaseAuthorityAccountView paramBaseAuthorityAccountView) {}
  
  public void run()
  {
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "--> handler message UPDATE_DROP_DOWN_VIEWS" });
    this.this$0.h();
    ThreadManager.getUIHandler().post(new BaseAuthorityAccountView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.2
 * JD-Core Version:    0.7.0.1
 */