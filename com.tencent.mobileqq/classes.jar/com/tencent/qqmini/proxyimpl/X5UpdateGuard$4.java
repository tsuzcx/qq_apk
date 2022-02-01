package com.tencent.qqmini.proxyimpl;

import bjha;

public class X5UpdateGuard$4
  implements Runnable
{
  public X5UpdateGuard$4(bjha parambjha, int paramInt) {}
  
  public void run()
  {
    if (this.a == bjha.a()) {
      return;
    }
    if ((this.a == bjha.b()) || (this.a == bjha.c()))
    {
      bjha.a(this.this$0);
      return;
    }
    bjha.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.4
 * JD-Core Version:    0.7.0.1
 */