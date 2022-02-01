package com.tencent.open.agent;

import android.content.res.Resources;
import com.tencent.open.agent.auth.IOldAuthorityContract.Presenter;
import com.tencent.open.agent.util.AuthUIUtil;

class AuthorityActivity$3
  implements Runnable
{
  AuthorityActivity$3(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    this.this$0.b();
    this.this$0.a(true);
    AuthorityActivity.a(this.this$0).d();
    AuthorityActivity localAuthorityActivity = this.this$0;
    AuthUIUtil.a(localAuthorityActivity, localAuthorityActivity.getResources().getString(2131694647), new AuthorityActivity.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.3
 * JD-Core Version:    0.7.0.1
 */