package com.tencent.qqmini.proxyimpl;

class X5UpdateGuard$4
  implements Runnable
{
  X5UpdateGuard$4(X5UpdateGuard paramX5UpdateGuard, int paramInt) {}
  
  public void run()
  {
    if (this.a == X5UpdateGuard.b()) {
      return;
    }
    if ((this.a != X5UpdateGuard.c()) && (this.a != X5UpdateGuard.d()))
    {
      X5UpdateGuard.c(this.this$0);
      return;
    }
    X5UpdateGuard.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.4
 * JD-Core Version:    0.7.0.1
 */