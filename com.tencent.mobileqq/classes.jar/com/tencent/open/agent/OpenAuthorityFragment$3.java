package com.tencent.open.agent;

import android.content.res.Resources;
import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.SSOLog;

class OpenAuthorityFragment$3
  implements Runnable
{
  OpenAuthorityFragment$3(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void run()
  {
    if (OpenAuthorityFragment.c(this.this$0))
    {
      SSOLog.b("OpenAuthorityFragment", new Object[] { " activity is isInvalid" });
      return;
    }
    OpenAuthorityFragment.d(this.this$0).d();
    this.this$0.b();
    this.this$0.a(true);
    AuthUIUtil.a(this.this$0.getQBaseActivity(), this.this$0.getResources().getString(2131892333), new OpenAuthorityFragment.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.3
 * JD-Core Version:    0.7.0.1
 */