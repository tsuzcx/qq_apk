package com.tencent.mobileqq.emosm.control;

public class EmoCaptureAsyncStepFactory$CaptureEmoParallGroup
  extends EmoParallGroup
{
  public EmoAsyncStep c()
  {
    if (this.m < this.n.length)
    {
      this.k[this.m] = EmoCaptureAsyncStepFactory.a(this.f, this.n[this.m]);
      this.k[this.m].j = this.j;
      EmoAsyncStep[] arrayOfEmoAsyncStep = this.k;
      int i = this.m;
      this.m = (i + 1);
      return arrayOfEmoAsyncStep[i];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoCaptureAsyncStepFactory.CaptureEmoParallGroup
 * JD-Core Version:    0.7.0.1
 */