package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartService
  extends Step
{
  public static boolean a;
  
  protected boolean a()
  {
    Object localObject = null;
    if (a) {}
    do
    {
      return true;
      a = true;
      if (BaseApplicationImpl.sProcessId != 4)
      {
        BaseApplicationImpl.sApplication.startService();
        localObject = BaseApplicationImpl.sApplication.waitAppRuntime(null);
      }
      if (BaseApplicationImpl.sProcessId == 7) {
        ProcessInfoUtil.a("com.tencent.mobileqq:tool");
      }
    } while (BaseApplicationImpl.sProcessId != 1);
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
    localQQAppInterface.onGuardEvent(6, 0L, 0L);
    if (localQQAppInterface.e())
    {
      Automator localAutomator1 = localQQAppInterface.a;
      Automator localAutomator2 = localQQAppInterface.a;
      if (this.c == 19) {}
      for (localObject = "{[11,12,14],17,20,21,22}";; localObject = "{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,44,45,[100,79,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103],57,95,105}")
      {
        localAutomator1.a(StepFactory.a(localAutomator2, (String)localObject));
        localQQAppInterface.start(false);
        return true;
      }
    }
    BaseApplicationImpl.appStartTime = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */