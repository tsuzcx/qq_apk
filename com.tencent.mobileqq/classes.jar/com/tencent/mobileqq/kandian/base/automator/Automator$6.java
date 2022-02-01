package com.tencent.mobileqq.kandian.base.automator;

class Automator$6
  implements Runnable
{
  Automator$6(Automator paramAutomator, BaseStep paramBaseStep) {}
  
  public void run()
  {
    this.a.f();
    StepGroup localStepGroup = this.a.e();
    if ((localStepGroup instanceof AsyncSteps))
    {
      ((AsyncSteps)localStepGroup).d();
      return;
    }
    if ((localStepGroup instanceof SyncSteps))
    {
      ((SyncSteps)localStepGroup).d();
      return;
    }
    Automator.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */