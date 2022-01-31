package com.tencent.mobileqq.startup.step;

import ajws;
import awoz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

public class StartService
  extends Step
{
  public static boolean a;
  
  protected boolean doStep()
  {
    Object localObject = null;
    if (a) {
      return true;
    }
    a = true;
    if (BaseApplicationImpl.sProcessId != 4)
    {
      BaseApplicationImpl.sApplication.startService();
      localObject = BaseApplicationImpl.sApplication.waitAppRuntime(null);
    }
    label48:
    QQAppInterface localQQAppInterface;
    Automator localAutomator1;
    Automator localAutomator2;
    if (BaseApplicationImpl.sProcessId == 7)
    {
      awoz.a("com.tencent.mobileqq:tool");
      if (BaseApplicationImpl.sProcessId != 1) {
        break label129;
      }
      localQQAppInterface = (QQAppInterface)localObject;
      localQQAppInterface.onGuardEvent(6, 0L, 0L);
      if (!localQQAppInterface.e()) {
        break label137;
      }
      localAutomator1 = localQQAppInterface.a;
      localAutomator2 = localQQAppInterface.a;
      if (this.mId != 20) {
        break label131;
      }
    }
    label129:
    label131:
    for (localObject = "{[11,12,14],17,20,21,22108,}";; localObject = "{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,108,44,45,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}")
    {
      localAutomator1.a(ajws.a(localAutomator2, (String)localObject));
      localQQAppInterface.start(false);
      return true;
      if (BaseApplicationImpl.sProcessId != 11) {
        break label48;
      }
      awoz.a("com.tencent.mobileqq:miniapp");
      break label48;
      break;
    }
    label137:
    BaseApplicationImpl.appStartTime = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.StartService
 * JD-Core Version:    0.7.0.1
 */