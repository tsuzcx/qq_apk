package com.tencent.qqmini.proxyimpl;

class X5UpdateGuard$5
  implements Runnable
{
  X5UpdateGuard$5(X5UpdateGuard paramX5UpdateGuard, int paramInt) {}
  
  public void run()
  {
    if (this.a == X5UpdateGuard.a()) {
      return;
    }
    if ((this.a == X5UpdateGuard.b()) || (this.a == X5UpdateGuard.c()))
    {
      X5UpdateGuard.a(this.this$0);
      return;
    }
    X5UpdateGuard.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.5
 * JD-Core Version:    0.7.0.1
 */