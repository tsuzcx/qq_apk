package com.tencent.mobileqq.emosm.control;

public class EmoLinearGroup
  extends EmoStepGroup
{
  protected int a()
  {
    while (this.a != 8)
    {
      EmoAsyncStep localEmoAsyncStep = a();
      if (localEmoAsyncStep == null) {
        break;
      }
      localEmoAsyncStep.run();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoLinearGroup
 * JD-Core Version:    0.7.0.1
 */