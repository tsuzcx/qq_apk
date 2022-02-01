package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.app.HardCodeUtil;

class X5UpdateGuard$6
  implements Runnable
{
  X5UpdateGuard$6(X5UpdateGuard paramX5UpdateGuard, int paramInt) {}
  
  public void run()
  {
    if ((X5UpdateGuard.f(this.this$0) != null) && (X5UpdateGuard.f(this.this$0).isShowing()))
    {
      X5UpdateGuard.LoadingDialog localLoadingDialog = X5UpdateGuard.f(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131903840));
      localStringBuilder.append(this.a);
      localStringBuilder.append("%");
      localLoadingDialog.a(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.6
 * JD-Core Version:    0.7.0.1
 */