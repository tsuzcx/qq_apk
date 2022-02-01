package com.tencent.mobileqq.emosm.control;

public class EmoLinearGroup
  extends EmoStepGroup
{
  protected int b()
  {
    while (this.d != 8)
    {
      EmoAsyncStep localEmoAsyncStep = c();
      if (localEmoAsyncStep == null) {
        break;
      }
      localEmoAsyncStep.run();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoLinearGroup
 * JD-Core Version:    0.7.0.1
 */