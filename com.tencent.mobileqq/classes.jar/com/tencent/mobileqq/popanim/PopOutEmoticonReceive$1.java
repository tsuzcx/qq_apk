package com.tencent.mobileqq.popanim;

class PopOutEmoticonReceive$1
  implements Runnable
{
  PopOutEmoticonReceive$1(PopOutEmoticonReceive paramPopOutEmoticonReceive) {}
  
  public void run()
  {
    if (PopOutEmoticonReceive.a(this.this$0))
    {
      PopOutEmoticonReceive.a(this.this$0).stopShakeAnimation();
      PopOutEmoticonReceive.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutEmoticonReceive.1
 * JD-Core Version:    0.7.0.1
 */