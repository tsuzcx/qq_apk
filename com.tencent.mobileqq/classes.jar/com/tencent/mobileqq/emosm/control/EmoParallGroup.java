package com.tencent.mobileqq.emosm.control;

public class EmoParallGroup
  extends EmoStepGroup
  implements IEmoResultListener
{
  protected int a;
  
  public void a(EmoAsyncStep paramEmoAsyncStep, int paramInt)
  {
    try
    {
      paramInt = this.a - 1;
      this.a = paramInt;
      if (paramInt == 0)
      {
        a(7);
        this.k = null;
      }
      this.f.a(this.k);
      return;
    }
    finally {}
  }
  
  protected int b()
  {
    this.a = this.n.length;
    for (;;)
    {
      EmoAsyncStep localEmoAsyncStep = c();
      if ((localEmoAsyncStep == null) || (this.d == 8)) {
        break;
      }
      localEmoAsyncStep.c = this;
      this.f.a(localEmoAsyncStep);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoParallGroup
 * JD-Core Version:    0.7.0.1
 */