package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartService
  extends Step
{
  public static boolean a;
  
  protected boolean doStep()
  {
    if (a) {
      return true;
    }
    a = true;
    int i = BaseApplicationImpl.sProcessId;
    Object localObject = null;
    if (i != 4)
    {
      BaseApplicationImpl.sApplication.startService();
      localObject = BaseApplicationImpl.sApplication.waitAppRuntime(null);
    }
    if (BaseApplicationImpl.sProcessId == 7) {
      ProcessInfoUtil.a("com.tencent.mobileqq:tool");
    } else if (BaseApplicationImpl.sProcessId == 11) {
      ProcessInfoUtil.a("com.tencent.mobileqq:miniapp");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localQQAppInterface.onGuardEvent(6, 0L, 0L);
      if (localQQAppInterface.isAccLoginSuccess())
      {
        Automator localAutomator1 = localQQAppInterface.mAutomator;
        Automator localAutomator2 = localQQAppInterface.mAutomator;
        if (this.mId == 21) {
          localObject = "{[11,12,14],17,20,21,22108,}";
        } else {
          localObject = StepFactory.a;
        }
        localAutomator1.a(StepFactory.a(localAutomator2, (String)localObject));
        localQQAppInterface.start(false);
        return true;
      }
      BaseApplicationImpl.appStartTime = 0L;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */