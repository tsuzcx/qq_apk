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
    Object localObject;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    default: 
      if (a != null) {
        localObject = a.a(paramInt, paramStartupDirector, paramArrayOfInt);
      }
      break;
    }
    for (;;)
    {
      ((Step)localObject).c = paramInt;
      ((Step)localObject).a = paramStartupDirector;
      if (paramInt == 0) {
        Step.a((Step)localObject, paramArrayOfInt);
      }
      return localObject;
      localObject = new LoadDex();
      continue;
      localObject = new InitMemoryCache();
      continue;
      localObject = new OldApplication();
      continue;
      localObject = new SetSplash();
      continue;
      localObject = new Update();
      continue;
      localObject = new StartService();
      continue;
      localObject = new Step();
    }
  }
  
  public Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AmStepFactory
 * JD-Core Version:    0.7.0.1
 */