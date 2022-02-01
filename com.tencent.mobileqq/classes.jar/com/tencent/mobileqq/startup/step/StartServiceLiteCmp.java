package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartServiceLiteCmp
  extends Step
{
  protected boolean doStep()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).isAccLoginSuccess()) {
        ((QQAppInterface)localObject).mAutomator.a(StepFactory.a(((QQAppInterface)localObject).mAutomator, StepFactory.b));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartServiceLiteCmp
 * JD-Core Version:    0.7.0.1
 */