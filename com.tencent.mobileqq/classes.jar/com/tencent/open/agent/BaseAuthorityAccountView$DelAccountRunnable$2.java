package com.tencent.open.agent;

import com.tencent.mobileqq.utils.QQCustomDialog;

class BaseAuthorityAccountView$DelAccountRunnable$2
  implements Runnable
{
  BaseAuthorityAccountView$DelAccountRunnable$2(BaseAuthorityAccountView.DelAccountRunnable paramDelAccountRunnable) {}
  
  public void run()
  {
    this.a.this$0.f();
    if (this.a.this$0.a != null)
    {
      this.a.this$0.a.dismiss();
      this.a.this$0.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.DelAccountRunnable.2
 * JD-Core Version:    0.7.0.1
 */