package com.tencent.mobileqq.kandian.base.automator;

class Automator$6
  implements Runnable
{
  Automator$6(Automator paramAutomator, BaseStep paramBaseStep) {}
  
  public void run()
  {
    this.a.c();
    StepGroup localStepGroup = this.a.a();
    if ((localStepGroup instanceof AsyncSteps))
    {
      ((AsyncSteps)localStepGroup).b();
      return;
    }
    if ((localStepGroup instanceof SyncSteps))
    {
      ((SyncSteps)localStepGroup).b();
      return;
    }
    Automator.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */