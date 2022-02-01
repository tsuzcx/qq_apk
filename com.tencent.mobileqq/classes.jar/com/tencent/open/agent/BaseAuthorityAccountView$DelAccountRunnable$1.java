package com.tencent.open.agent;

import com.tencent.mobileqq.utils.QQCustomDialog;

class BaseAuthorityAccountView$DelAccountRunnable$1
  implements Runnable
{
  BaseAuthorityAccountView$DelAccountRunnable$1(BaseAuthorityAccountView.DelAccountRunnable paramDelAccountRunnable, String paramString) {}
  
  public void run()
  {
    if ((!this.b.this$0.a(this.a, false)) && ((this.b.this$0.c instanceof QuickLoginAuthorityActivity))) {
      ((QuickLoginAuthorityActivity)this.b.this$0.c).a(this.a, false);
    }
    if (this.b.this$0.h != null)
    {
      this.b.this$0.h.dismiss();
      this.b.this$0.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.DelAccountRunnable.1
 * JD-Core Version:    0.7.0.1
 */