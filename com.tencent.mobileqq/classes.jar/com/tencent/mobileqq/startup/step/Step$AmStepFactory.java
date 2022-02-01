package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.director.StartupDirector;

public class Step$AmStepFactory
  implements Step.IStepFactory
{
  private static Step.IStepFactory a;
  
  public static void a()
  {
    a = (Step.IStepFactory)BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.startup.step.Step$AfterDexStepFactory").newInstance();
  }
  
  public static Step b(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 13)
            {
              if (paramInt != 22)
              {
                if (paramInt != 49) {}
                switch (paramInt)
                {
                default: 
                  localObject = a;
                  Step localStep;
                  if (localObject != null) {
                    localStep = ((Step.IStepFactory)localObject).a(paramInt, paramStartupDirector, paramArrayOfInt);
                  } else {
                    localStep = null;
                  }
                  localObject = localStep;
                  if (localStep != null) {
                    break;
                  }
                  localObject = new Step();
                  break;
                case 9: 
                  localObject = new OldApplication();
                  break;
                case 8: 
                  localObject = new InitMemoryCache();
                  break;
                  localObject = new QCircleInitStep();
                  break;
                }
              }
              localObject = new StartService();
              break label193;
            }
            localObject = new Update();
            break label193;
          }
        }
        else
        {
          localObject = new CheckPermission();
          break label193;
        }
      }
      else
      {
        localObject = new SetSplash();
        break label193;
      }
    }
    Object localObject = new LoadDex();
    label193:
    ((Step)localObject).mId = paramInt;
    ((Step)localObject).mDirector = paramStartupDirector;
    if (paramInt == 0) {
      Step.access$002((Step)localObject, paramArrayOfInt);
    }
    return localObject;
  }
  
  public Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AmStepFactory
 * JD-Core Version:    0.7.0.1
 */