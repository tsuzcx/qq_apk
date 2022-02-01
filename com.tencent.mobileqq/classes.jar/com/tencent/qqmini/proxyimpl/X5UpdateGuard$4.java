package com.tencent.qqmini.proxyimpl;

import bksl;

public class X5UpdateGuard$4
  implements Runnable
{
  public X5UpdateGuard$4(bksl parambksl, int paramInt) {}
  
  public void run()
  {
    if (this.a == bksl.a()) {
      return;
    }
    if ((this.a == bksl.b()) || (this.a == bksl.c()))
    {
      bksl.a(this.this$0);
      return;
    }
    bksl.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.4
 * JD-Core Version:    0.7.0.1
 */