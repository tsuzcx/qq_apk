package com.tencent.mobileqq.dinifly;

class LottieTask$1
  implements Runnable
{
  LottieTask$1(LottieTask paramLottieTask) {}
  
  public void run()
  {
    if (LottieTask.access$000(this.this$0) == null) {
      return;
    }
    LottieResult localLottieResult = LottieTask.access$000(this.this$0);
    if (localLottieResult.getValue() != null)
    {
      LottieTask.access$100(this.this$0, localLottieResult.getValue());
      return;
    }
    LottieTask.access$200(this.this$0, localLottieResult.getException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieTask.1
 * JD-Core Version:    0.7.0.1
 */